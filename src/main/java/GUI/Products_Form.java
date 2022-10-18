package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.Products_BUS;

import Entitys.Products;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Products_Form extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JLabel lbl_HinhAnh;
	
	private JTable table_QLSP;
	
	private JTextField textField_TimKiem;
	private JTextField textField_MaSP;
	private JTextField textField_MaLSP;
	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_GiaTien;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	
	private Products_BUS products_BUS = new Products_BUS();
	
	
	public Products_Form() {
		initComponents();
		HienThiSanPham();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products_Form frame = new Products_Form();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(147, 0, 363, 39);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_QLSP = new JLabel("Quản Lý Sản Phẩm");
		lbl_QLSP.setBounds(141, 11, 151, 20);
		lbl_QLSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lbl_QLSP);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 38, 659, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSanPham();
			}
		});
		btnThem.setBounds(323, 11, 89, 23);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSanPham();
			}
		});
		btnSua.setBounds(422, 11, 89, 23);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaSanPham();
			}
		});
		btnXoa.setBounds(521, 11, 89, 23);
		panel_1.add(btnXoa);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnTimKiem.setBounds(224, 11, 89, 23);
		panel_1.add(btnTimKiem);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setBounds(97, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);

		table_QLSP = new JTable();
		table_QLSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HienThiChiTietSanPham();
			}
		});
		table_QLSP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_QLSP.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { }));
		
		JScrollPane scrollPane_QLSP = new JScrollPane(table_QLSP);
		scrollPane_QLSP.setBounds(0, 89, 659, 192);
		contentPane.add(scrollPane_QLSP);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 146, 39);
		contentPane.add(panel_1_1);

		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(27, 6, 94, 28);
		panel_1_1.add(btnTrangChu);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(509, 0, 146, 39);
		contentPane.add(panel_1_1_1);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiSanPham();
			}
		});
		btnLamMoi.setBounds(27, 6, 94, 28);
		panel_1_1_1.add(btnLamMoi);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(153, 293, 441, 145);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBounds(20, 11, 136, 103);
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(lbl_HinhAnh);

		JLabel lbl_MaSP = new JLabel("Mã Sản Phẩm");
		lbl_MaSP.setBounds(173, 11, 89, 14);
		panel_2.add(lbl_MaSP);

		textField_MaSP = new JTextField();
		textField_MaSP.setBounds(252, 8, 111, 20);
		panel_2.add(textField_MaSP);
		textField_MaSP.setColumns(10);

		JLabel lbl_MaLSP = new JLabel("Mã Loại Sản Phẩm");
		lbl_MaLSP.setBounds(172, 36, 90, 14);
		panel_2.add(lbl_MaLSP);

		textField_MaLSP = new JTextField();
		textField_MaLSP.setColumns(10);
		textField_MaLSP.setBounds(262, 33, 111, 20);
		panel_2.add(textField_MaLSP);

		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(171, 61, 91, 14);
		panel_2.add(lbl_TenSP);

		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(173, 86, 74, 14);
		panel_2.add(lbl_SoLuong);

		JLabel lbl_GiaTien = new JLabel("Đơn Giá");
		lbl_GiaTien.setBounds(173, 111, 46, 14);
		panel_2.add(lbl_GiaTien);

		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(252, 61, 111, 20);
		panel_2.add(textField_TenSP);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(252, 86, 111, 20);
		panel_2.add(textField_SoLuong);

		textField_GiaTien = new JTextField();
		textField_GiaTien.setColumns(10);
		textField_GiaTien.setBounds(252, 108, 111, 20);
		panel_2.add(textField_GiaTien);

	}

	public void HienThiSanPham() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền",
				"Mã Nhà Cung Cấp", "Mô Tả", "Thời Gian" };
		model.setColumnIdentifiers(columns);

//		 DefaultTableModel model = (DefaultTableModel) table_QLSP.getModel();
		Object[] row = new Object[8];
		List<Products> products = products_BUS.ListProducts();
		for (int i = 0; i < products.size(); i++) {
			row[0] = products.get(i).getIdProduct();
			row[1] = products.get(i).getIdCategory();
			row[2] = products.get(i).getName();
			row[3] = products.get(i).getQuatity();
			row[4] = products.get(i).getPrice();
			row[5] = products.get(i).getIdProvider();
			row[6] = products.get(i).getDescription();
			row[7] = products.get(i).getDate();

			model.addRow(row);
		}
		table_QLSP.setModel(model);
		table_QLSP.setRowHeight(30);
	}

	private void HienThiChiTietSanPham() {
		int iRow = table_QLSP.getSelectedRow();
		
		int maSP = (Integer) table_QLSP.getModel().getValueAt(iRow, 0);
		String maLSP = table_QLSP.getModel().getValueAt(iRow, 1).toString();
		String tenSP = table_QLSP.getModel().getValueAt(iRow, 2).toString();
		String soLuong = table_QLSP.getModel().getValueAt(iRow, 3).toString();
		String giaTien = table_QLSP.getModel().getValueAt(iRow, 4).toString();

		List<Products> listProducts = products_BUS.ListProducts();
		String path = null;
		for (Products product : listProducts) {
			int checkMaSP = product.getIdProduct();
			if (checkMaSP == maSP) {
				path = product.getImg();
				
				ImageIcon imageIcon = new ImageIcon(path);
				Image hinhAnh = imageIcon.getImage().getScaledInstance(lbl_HinhAnh.getWidth(), lbl_HinhAnh.getHeight(),
						Image.SCALE_SMOOTH);
				
				lbl_HinhAnh.setIcon(new ImageIcon(hinhAnh));
			}
		}
		textField_MaSP.setText(maSP + "");
		textField_MaLSP.setText(maLSP);
		textField_TenSP.setText(tenSP);
		textField_SoLuong.setText(soLuong);
		textField_GiaTien.setText(giaTien);
	}

	private void ThemSanPham() {
		Add_Product_Form add_Product_Form = new Add_Product_Form();
		add_Product_Form.setLocationRelativeTo(null);
		add_Product_Form.setVisible(true);
	}

	private void SuaSanPham() {
		int iRow = table_QLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
		} else {
			String maSP = table_QLSP.getModel().getValueAt(iRow, 0).toString();
			String maLSP = table_QLSP.getModel().getValueAt(iRow, 1).toString();
			String tenSP = (String) table_QLSP.getModel().getValueAt(iRow, 2).toString();
			String soLuong = table_QLSP.getModel().getValueAt(iRow, 3).toString();
			String giaTien = table_QLSP.getModel().getValueAt(iRow, 4).toString();
			String maNhaCC = table_QLSP.getModel().getValueAt(iRow, 5).toString();
			String moTa = table_QLSP.getModel().getValueAt(iRow, 6).toString();
			//String thoiGian = table_QLSP.getModel().getValueAt(iRow, 7).toString();
			
			List<Products> listProducts = products_BUS.ListProducts();
			int idSP = Integer.parseInt(maSP);
			String img = null;
			
			for (Products product : listProducts) {
				int checkMaSP = product.getIdProduct();
				if (idSP == checkMaSP) {
					img = product.getImg();
				}
			}
			Update_Product_Form update_Product_Form = new Update_Product_Form(maSP, maLSP, img, tenSP, soLuong, giaTien, maNhaCC, moTa);
			update_Product_Form.setLocationRelativeTo(null);
			update_Product_Form.setVisible(true);
		}
	}

	private void XoaSanPham() {
		int iRow = table_QLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
		} else {
			String maSP = table_QLSP.getModel().getValueAt(iRow, 0).toString();
			int idSP = Integer.parseInt(maSP);
			products_BUS.deleteProductById(idSP);
			JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
			HienThiSanPham();
		}
	}
}
