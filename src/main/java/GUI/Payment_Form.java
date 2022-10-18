package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.Customers_BUS;
import BUS.Employees_BUS;
import BUS.Products_BUS;
import DTO.ClockThead;
import Entitys.Products;
import Entitys.Users;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Payment_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ThanhToanHD;
	private JTable table_HoaDon;
	private JComboBox<Object> comboBox_NhanVien;
	private JComboBox<Object> comboBox_KH;
	private JTextField textField_Time;
	private JTextField textField_MaSP;
	private JTextField textField_MaLSP;
	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_DonGia;
	private JLabel lbl_img;
	private Products_BUS products_BUS = new  Products_BUS();
	private Customers_BUS customer_BUS = new Customers_BUS();
	private Employees_BUS employees_BUS = new Employees_BUS();

	/**
	 * Launch the application.
	 */
	public Payment_Form() {
		initComponents();
		showProduct();
		showListCustomers();
		showListEmployees();
		initClock();
	}
	private void initClock() {
		ClockThead clock = new ClockThead(textField_Time);
		clock.start();
	}
	

	private void showProduct() {
		/* Cách 1
		Products_BUS products_BUS = new Products_BUS();
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền" };
		model.setColumnIdentifiers(columns);
		List<Products> product = products_BUS.ListProducts();
		for (int i = 0; i < product.size(); i++) {
			model.addRow(new Object[] { 
					product.get(i).getId_product(), 
					product.get(i).getIdCategory(), 
					product.get(i).getName(), 
					product.get(i).getQuatity(),
					product.get(i).getPrice()
			});
		}
		table_ThanhToanHD.setModel(model);
		*/
		
		DefaultTableModel model = (DefaultTableModel) table_ThanhToanHD.getModel();
		Object [] row = new Object[5];
		
		
		List<Products> product = products_BUS.ListProducts();
		for (int i = 0; i < product.size(); i++) {
			
			row[0]=product.get(i).getIdProduct();
			row[1]=product.get(i).getIdCategory(); 
			row[2]=product.get(i).getName();
			row[3]=product.get(i).getQuatity();
			row[4]=product.get(i).getPrice();
					
			model.addRow(row);
		
		}
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment_Form frame = new Payment_Form();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(145, 0, 403, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_ThanhToanHD = new JLabel("Thanh Toán Hoá Đơn");
		lbl_ThanhToanHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThanhToanHD.setBounds(126, 11, 177, 28);
		panel.add(lbl_ThanhToanHD);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 146, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(21, 11, 94, 27);
		panel_1.add(btnTrangChu);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(548, 0, 246, 393);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lbl_HoaDon = new JLabel("Hoá Đơn");
		lbl_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_HoaDon.setBounds(107, 11, 69, 20);
		panel_3.add(lbl_HoaDon);

		table_HoaDon = new JTable();
		table_HoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderTable();
			}
		});
		table_HoaDon.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 Ti\u1EC1n"
			}
		));
		JScrollPane scrollPane_HoaDon = new JScrollPane(table_HoaDon);
		scrollPane_HoaDon.setBounds(0, 106, 246, 153);
		panel_3.add(scrollPane_HoaDon);

		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 31, 69, 14);
		panel_3.add(lbl_ThoiGian);

		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng");
		lbl_TenKH.setBounds(10, 56, 104, 14);
		panel_3.add(lbl_TenKH);

		JLabel lbl_NVThuNgan = new JLabel("Nhân Viên Thu Ngân");
		lbl_NVThuNgan.setBounds(10, 81, 114, 14);
		panel_3.add(lbl_NVThuNgan);

		JLabel lblNewLabel_5 = new JLabel("Tổng tiền");
		lblNewLabel_5.setBounds(10, 270, 52, 14);
		panel_3.add(lblNewLabel_5);

		JButton btnNewButton_1 = new JButton("Thanh Toán");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(132, 343, 104, 37);
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Xoá");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItemTable();
				
			}
		});
		btnNewButton_3.setBounds(10, 343, 104, 37);
		panel_3.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Cập nhật");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateOrder();
			}
		});
		btnNewButton_4.setBounds(132, 295, 104, 37);
		panel_3.add(btnNewButton_4);

		comboBox_NhanVien = new JComboBox<Object>();
		comboBox_NhanVien.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Nhân Viên" }));
		comboBox_NhanVien.setBounds(134, 77, 102, 22);
		panel_3.add(comboBox_NhanVien);

		comboBox_KH = new JComboBox<Object>();
		comboBox_KH.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Khách Hàng" }));
		comboBox_KH.setBounds(132, 52, 102, 22);
		panel_3.add(comboBox_KH);

		textField_Time = new JTextField();
		textField_Time.setBounds(80, 28, 156, 20);
		panel_3.add(textField_Time);
		textField_Time.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(0, 51, 548, 165);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		table_ThanhToanHD = new JTable();
		table_ThanhToanHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductPayMentTable();
			}

			
		});
		table_ThanhToanHD.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền" }));
		JScrollPane scrollPane_ThanhToanHD = new JScrollPane(table_ThanhToanHD);
		scrollPane_ThanhToanHD.setBounds(0, 0, 548, 165);
		panel_4.add(scrollPane_ThanhToanHD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(47, 227, 441, 166);
		contentPane.add(panel_2);
		
		lbl_img = new JLabel("");
		lbl_img.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_img.setBounds(20, 11, 136, 103);
		panel_2.add(lbl_img);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1.setBounds(173, 11, 89, 14);
		panel_2.add(lblNewLabel_1);
		
		textField_MaSP = new JTextField();
		textField_MaSP.setColumns(10);
		textField_MaSP.setBounds(252, 8, 111, 20);
		panel_2.add(textField_MaSP);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Loại Sản Phẩm");
		lblNewLabel_2.setBounds(172, 36, 90, 14);
		panel_2.add(lblNewLabel_2);
		
		textField_MaLSP = new JTextField();
		textField_MaLSP.setColumns(10);
		textField_MaLSP.setBounds(262, 33, 111, 20);
		panel_2.add(textField_MaLSP);
		
		JLabel lblNewLabel_3 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_3.setBounds(171, 61, 91, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số Lượng");
		lblNewLabel_4.setBounds(173, 86, 74, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("Đơn Giá");
		lblNewLabel_5_1.setBounds(173, 111, 46, 14);
		panel_2.add(lblNewLabel_5_1);
		
		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(252, 61, 111, 20);
		panel_2.add(textField_TenSP);
		
		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(252, 86, 111, 20);
		panel_2.add(textField_SoLuong);
		
		textField_DonGia = new JTextField();
		textField_DonGia.setColumns(10);
		textField_DonGia.setBounds(252, 108, 111, 20);
		panel_2.add(textField_DonGia);
		
		JButton btn_Them = new JButton("Thêm");
		btn_Them.setBounds(173, 129, 104, 37);
		panel_2.add(btn_Them);
		btn_Them.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				Themsanphamvaohoadon();
						
		}
		});
				
		
	}

	private void showListEmployees() {
		
		List<Users> listEmployee = employees_BUS.listEmployee();
		for (Users employee : listEmployee) {
			comboBox_NhanVien.addItem(employee.getName());
		}
	}

	private void showListCustomers() {
		
		List<Users> listCustomer = customer_BUS.listCustomers();
		for (Users customer : listCustomer) {
			comboBox_KH.addItem(customer.getName());
		}
	}
	private void ProductPayMentTable() {
		int i = table_ThanhToanHD.getSelectedRow();
		int id_Product = (Integer) table_ThanhToanHD.getModel().getValueAt(i, 0);
		String id_Category = table_ThanhToanHD.getModel().getValueAt(i, 1).toString();
		String name = table_ThanhToanHD.getModel().getValueAt(i, 2).toString();
		String gia = table_ThanhToanHD.getModel().getValueAt(i, 4).toString();
		
		List<Products> product = products_BUS.ListProducts();
		String path = null;
		for(Products list : product) {
			int checkId = list.getIdProduct(); 
			if( checkId == id_Product) {
				path = list.getImg();	
				ImageIcon imageIcon = new ImageIcon(path);
				Image img = imageIcon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);	
				lbl_img.setIcon(new ImageIcon(img));
			}
		}
		
		textField_MaSP.setText(id_Product+"");
		textField_MaLSP.setText(id_Category);;
		textField_TenSP.setText(name);
		textField_SoLuong.setText(1+"");;
		textField_DonGia.setText(gia);
	
	}

	private void OrderTable() {
		int iOderTable = table_HoaDon.getSelectedRow();
		String id_Product =  table_HoaDon.getModel().getValueAt(iOderTable, 0).toString();
		String soluong = table_HoaDon.getModel().getValueAt(iOderTable, 2).toString();
		String GiaTien = table_HoaDon.getModel().getValueAt(iOderTable, 3).toString();
		
		int masp = Integer.parseInt(id_Product);
		List<Products> product = products_BUS.ListProducts();
		for(Products listproduct : product) {
			int checkId = listproduct.getIdProduct();
			if(masp == checkId) {
				String path = listproduct.getImg();
				int idLoaiSP = listproduct.getIdCategory();
				String nameProduct = listproduct.getName();
				
				ImageIcon imageIcon = new ImageIcon(path);
				Image img = imageIcon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
				
				lbl_img.setIcon(new ImageIcon(img));
				textField_MaSP.setText(id_Product);
				textField_MaLSP.setText(idLoaiSP+"");
				textField_TenSP.setText(nameProduct);
				
			}
			textField_SoLuong.setText(soluong);
			textField_DonGia.setText(GiaTien);	
		}
	
	}
	private void deleteItemTable() {
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		int index = table_HoaDon.getSelectedRow();
		if(table_HoaDon.getSelectedRowCount() == 1) {
			model.removeRow(index);
		}else if(table_HoaDon.getRowCount() ==0) {
			JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xoá");
			
		}else {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng xoá từng dòng");
		}
	}
	private void Themsanphamvaohoadon() {
		int i = table_ThanhToanHD.getSelectedRow();
		if(i<=-1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn sản phẩm cần thanh toán");
		}else {
			int idsp = Integer.parseInt(textField_MaSP.getText());
			String nameSP = textField_TenSP.getText();		
			double soluong = Double.parseDouble(textField_SoLuong.getText());
			double GiaTien = Double.parseDouble(textField_DonGia.getText());
			double TongTien = products_BUS.TongTienSP(soluong, GiaTien);
			DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
			Object row[] = new Object[4];
				row[0] = idsp;
				row[1] = nameSP;
				row[2] = soluong;
				row[3] = TongTien;
				
				model.addRow(row);
		}
	}
	
	private void UpdateOrder() {
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		
		if(table_HoaDon.getSelectedRowCount() == 1) {
			int idsp = Integer.parseInt(textField_MaSP.getText());
			String nameSP = textField_TenSP.getText();
			double soluong = Double.parseDouble(textField_SoLuong.getText());
			double GiaTien = Double.parseDouble(textField_DonGia.getText());
			double TongTien = products_BUS.TongTienSP(soluong, GiaTien);
			
			model.setValueAt(idsp, table_HoaDon.getSelectedRow(), 0);
			model.setValueAt(nameSP, table_HoaDon.getSelectedRow(), 1);
			model.setValueAt(soluong, table_HoaDon.getSelectedRow(), 2);
			model.setValueAt(TongTien, table_HoaDon.getSelectedRow(), 3);
			JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
			
		}else if(table_HoaDon.getRowCount() ==0) {
			JOptionPane.showMessageDialog(rootPane, "Không có thông để cập nhật");
			
		}
	}
}
