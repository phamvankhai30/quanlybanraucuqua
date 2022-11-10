package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.Customers_BUS;
import BUS.Employees_BUS;
import BUS.OrderDetails_BUS;
import BUS.Orders_BUS;
import BUS.Products_BUS;
import DTO.ClockThread;
import Entitys.Orders;
import Entitys.Products;
import Entitys.Users;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Payment_UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ThanhToanHD;
	private JTable table_HoaDon;
	private JComboBox<Object> comboBox_NhanVien;
	private JComboBox<Object> comboBox_KH;
	private JTextField textField_ThoiGian;
	private JTextField textField_MaSP;
	private JTextField textField_MaLSP;
	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_DonGia;
	private JLabel lbl_img;
	private JLabel lbl_TongTien;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	private Products_BUS products_BUS = new Products_BUS();
	private Customers_BUS customer_BUS = new Customers_BUS();
	private Employees_BUS employees_BUS = new Employees_BUS();
	private Orders_BUS orders_BUS = new Orders_BUS();
	private OrderDetails_BUS orderDetails_BUS = new OrderDetails_BUS();
	private JTextField textField_TimKiem;

	/**
	 * Launch the application.
	 */
	public Payment_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		loadProduct();
		loadCustomer();
		loadEmployee();
		initClock();

	}

	private void initClock() {
		ClockThread clock = new ClockThread(textField_ThoiGian);
		clock.start();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment_UI frame = new Payment_UI();
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
		setBounds(100, 100, 854, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(166, 11, 216, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_ThanhToanHD = new JLabel("Thanh Toán Hoá Đơn");
		lbl_ThanhToanHD.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ThanhToanHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThanhToanHD.setBounds(0, 11, 216, 27);
		panel.add(lbl_ThanhToanHD);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 146, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(0, 0, 156, 49);
		panel_1.add(btnTrangChu);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(548, 11, 279, 433);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lbl_HoaDon = new JLabel("Hoá Đơn");
		lbl_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_HoaDon.setBounds(83, 11, 69, 20);
		panel_3.add(lbl_HoaDon);

		table_HoaDon = new JTable();
		table_HoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XemChiTietHoaDon();
			}
		});
		table_HoaDon.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền" }));
		JScrollPane scrollPane_HoaDon = new JScrollPane(table_HoaDon);
		scrollPane_HoaDon.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_HoaDon.setBounds(10, 145, 259, 181);
		panel_3.add(scrollPane_HoaDon);

		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 45, 69, 14);
		panel_3.add(lbl_ThoiGian);

		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng");
		lbl_TenKH.setBounds(10, 81, 104, 14);
		panel_3.add(lbl_TenKH);

		JLabel lbl_NVThuNgan = new JLabel("Nhân Viên Thu Ngân");
		lbl_NVThuNgan.setBounds(10, 120, 114, 14);
		panel_3.add(lbl_NVThuNgan);

		JLabel lblNewLabel_5 = new JLabel("Tổng tiền");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 360, 69, 14);
		panel_3.add(lblNewLabel_5);

		JButton btnPay = new JButton("Thanh Toán");
		btnPay.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThanhToanHoaDon();
			}
		});
		btnPay.setBounds(140, 385, 129, 37);
		panel_3.add(btnPay);

		JButton btnDelete = new JButton("Xoá");
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete();

			}
		});
		btnDelete.setBounds(10, 385, 120, 37);
		panel_3.add(btnDelete);

		comboBox_NhanVien = new JComboBox<Object>();
		comboBox_NhanVien.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Mã Nhân Viên" }));
		comboBox_NhanVien.setBounds(134, 112, 135, 22);
		panel_3.add(comboBox_NhanVien);

		comboBox_KH = new JComboBox<Object>();
		comboBox_KH.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Mã Khách Hàng" }));
		comboBox_KH.setBounds(132, 77, 137, 22);
		panel_3.add(comboBox_KH);

		textField_ThoiGian = new JTextField();
		textField_ThoiGian.setHorizontalAlignment(SwingConstants.CENTER);
		textField_ThoiGian.setEnabled(false);
		textField_ThoiGian.setBounds(132, 42, 137, 20);
		panel_3.add(textField_ThoiGian);
		textField_ThoiGian.setColumns(10);

		lbl_TongTien = new JLabel("");
		lbl_TongTien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_TongTien.setBounds(83, 359, 186, 15);
		// lbl_TongTien.setBorder(null);
		panel_3.add(lbl_TongTien);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 131, 528, 117);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		table_ThanhToanHD = new JTable();
		table_ThanhToanHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XemChiTietSanPham();
			}
		});
		table_ThanhToanHD.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
						"T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 Ti\u1EC1n" }));
		JScrollPane scrollPane_ThanhToanHD = new JScrollPane(table_ThanhToanHD);
		scrollPane_ThanhToanHD.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_ThanhToanHD.setBounds(0, 0, 528, 117);
		panel_4.add(scrollPane_ThanhToanHD);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 259, 528, 185);
		contentPane.add(panel_2);

		lbl_img = new JLabel("");
		lbl_img.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_img.setBounds(26, 11, 136, 114);
		panel_2.add(lbl_img);

		JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1.setBounds(172, 11, 89, 14);
		panel_2.add(lblNewLabel_1);

		textField_MaSP = new JTextField();
		textField_MaSP.setEnabled(false);

		textField_MaSP.setColumns(10);
		textField_MaSP.setBounds(290, 8, 149, 20);
		panel_2.add(textField_MaSP);

		JLabel lblNewLabel_2 = new JLabel("Mã Loại Sản Phẩm");
		lblNewLabel_2.setBounds(172, 36, 90, 14);
		panel_2.add(lblNewLabel_2);

		textField_MaLSP = new JTextField();
		textField_MaLSP.setEnabled(false);
		textField_MaLSP.setColumns(10);
		textField_MaLSP.setBounds(290, 33, 149, 20);
		panel_2.add(textField_MaLSP);

		JLabel lblNewLabel_3 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_3.setBounds(173, 61, 91, 14);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Số Lượng");
		lblNewLabel_4.setBounds(173, 86, 74, 14);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5_1 = new JLabel("Đơn Giá");
		lblNewLabel_5_1.setBounds(173, 111, 46, 14);
		panel_2.add(lblNewLabel_5_1);

		textField_TenSP = new JTextField();
		textField_TenSP.setEnabled(false);
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(290, 58, 149, 20);
		panel_2.add(textField_TenSP);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(290, 83, 149, 20);
		panel_2.add(textField_SoLuong);

		textField_DonGia = new JTextField();
		textField_DonGia.setForeground(new Color(0, 0, 0));
		textField_DonGia.setEnabled(false);
		textField_DonGia.setColumns(10);
		textField_DonGia.setBounds(290, 108, 149, 20);
		panel_2.add(textField_DonGia);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnAdd.setBounds(200, 137, 104, 37);
		panel_2.add(btnAdd);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(10, 71, 528, 49);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setBounds(182, 11, 120, 27);
		panel_5.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);

		JButton btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemSanPham();
			}
		});
		btnSearch.setBounds(312, 5, 128, 38);
		panel_5.add(btnSearch);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(392, 11, 146, 49);
		contentPane.add(panel_1_1);

		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadProduct();
			}
		});
		btnLmMi.setBounds(0, 0, 146, 49);
		panel_1_1.add(btnLmMi);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd();
				TongTienHoaDon();
			}
		});
	}

	private void btnAdd() {
		int irow = table_ThanhToanHD.getSelectedRow();
		if (irow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn sản phẩm cần thanh toán");
		} else {
			int masp = Integer.parseInt(textField_MaSP.getText());
			String tenSP = textField_TenSP.getText();
			double soLuong = Double.parseDouble(textField_SoLuong.getText());
			double giaTien = Double.parseDouble(textField_DonGia.getText().replaceAll("\\D+", ""));
			
			int iRow = table_ThanhToanHD.getSelectedRow(); 
			double tongSLSP = (Double) table_ThanhToanHD.getValueAt(iRow, 3);
			if(tongSLSP <=0) {
				JOptionPane.showMessageDialog(rootPane, "Sản Phẩm Đã Hết");
			}else {
				ThemSanPhamVaoHoaDon(masp, tenSP, soLuong, giaTien);
				CapNhatSLSP(soLuong);
			}
		}
	}

	private void ThemSanPhamVaoHoaDon(int masp, String tenSP, double soLuong, double giaTien) {
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		Object row[] = new Object[4];
		double TongTien = soLuong*giaTien;
		int checkrowCount = table_HoaDon.getRowCount();
		boolean flag = false;
		if (checkrowCount == 0) {
			row[0] = masp;
			row[1] = tenSP;
			row[2] = soLuong;
			row[3] = decimalFormat.format(TongTien);
		} else {
			for (int i = 0; i < checkrowCount; i++) {
				int idsp = (Integer) table_HoaDon.getValueAt(i, 0);
				if (masp == idsp) {
					double soLuongBangHoaDon = (Double) table_HoaDon.getValueAt(i, 2);
					double tongSoLuong = soLuong + soLuongBangHoaDon;
					table_HoaDon.setValueAt(tongSoLuong, i, 2);
					table_HoaDon.setValueAt(decimalFormat.format(giaTien * tongSoLuong), i, 3);
					flag = true;
					break;
				} else {
					row[0] = masp;
					row[1] = tenSP;
					row[2] = soLuong;
					row[3] = decimalFormat.format(TongTien);
				}
			}
		}
		if (flag == false) {
			model.addRow(row);
		}
	}

	private void CapNhatSLSP(double soLuong) {
		int iRow = table_ThanhToanHD.getSelectedRow();
		double soLuongSP = (Double) table_ThanhToanHD.getValueAt(iRow, 3);
		table_ThanhToanHD.setValueAt(soLuongSP - soLuong, iRow, 3);
	}

	private void loadEmployee() {
		List<Users> listEmployee = employees_BUS.listEmployee();
		for (Users employee : listEmployee) {
			comboBox_NhanVien.addItem(employee.getIdUser()+"-"+employee.getName());
		}
	}

	private void loadCustomer() {

		List<Users> listCustomer = customer_BUS.listCustomers();
		for (Users customer : listCustomer) {
			comboBox_KH.addItem(customer.getIdUser()+"-"+customer.getName());
		}
	}

	private void XemChiTietSanPham() {
		int i = table_ThanhToanHD.getSelectedRow();
		int id_Product = (Integer) table_ThanhToanHD.getModel().getValueAt(i, 0);
		String id_Category = table_ThanhToanHD.getModel().getValueAt(i, 1).toString();
		String name = table_ThanhToanHD.getModel().getValueAt(i, 2).toString();
		String gia = table_ThanhToanHD.getModel().getValueAt(i, 4).toString();

		List<Products> product = products_BUS.ListProducts();
		String path = null;
		for (Products list : product) {
			int checkId = list.getIdProduct();
			if (checkId == id_Product) {
				path = list.getImg();
				ImageIcon imageIcon = new ImageIcon(path);
				Image img = imageIcon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(),
						Image.SCALE_SMOOTH);
				lbl_img.setIcon(new ImageIcon(img));
			}
		}

		textField_MaSP.setText(id_Product + "");
		textField_MaLSP.setText(id_Category);
		textField_TenSP.setText(name);
		textField_SoLuong.setText(1 + "");
		textField_DonGia.setText(gia);

	}

	private void XemChiTietHoaDon() {
		int iOderTable = table_HoaDon.getSelectedRow();
		String id_Product = table_HoaDon.getModel().getValueAt(iOderTable, 0).toString();
		String soluong = table_HoaDon.getModel().getValueAt(iOderTable, 2).toString();
		String GiaTien = table_HoaDon.getModel().getValueAt(iOderTable, 3).toString();
		int masp = Integer.parseInt(id_Product);
		List<Products> product = products_BUS.ListProducts();
		for (Products listproduct : product) {
			int checkId = listproduct.getIdProduct();
			if (masp == checkId) {
				String path = listproduct.getImg();
				int idLoaiSP = listproduct.getIdCategory();
				String nameProduct = listproduct.getName();
				ImageIcon imageIcon = new ImageIcon(path);
				Image img = imageIcon.getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(),
						Image.SCALE_SMOOTH);
				lbl_img.setIcon(new ImageIcon(img));
				textField_MaSP.setText(id_Product);
				textField_MaLSP.setText(idLoaiSP + "");
				textField_TenSP.setText(nameProduct);
			}
			textField_SoLuong.setText(soluong);
			textField_SoLuong.setEnabled(false);
			textField_DonGia.setText(GiaTien);
		}
	}

	private void btnDelete() {
		DefaultTableModel model = (DefaultTableModel) table_HoaDon.getModel();
		int RowHD = table_HoaDon.getSelectedRow();
		if (table_HoaDon.getSelectedRowCount() == 1) {
			
			int idSP = (Integer) table_HoaDon.getValueAt(RowHD, 0);
			double soLuong = (Double) table_HoaDon.getValueAt(RowHD, 2);
			
			int RowTT = table_ThanhToanHD.getRowCount();
			for(int i=0;i < RowTT;i++) {
				int masp = (Integer) table_ThanhToanHD.getValueAt(i, 0);
				if(idSP == masp) {
					double soLuong_BangTT = (Double) table_ThanhToanHD.getValueAt(i, 3);
					
					table_ThanhToanHD.setValueAt(soLuong_BangTT+soLuong, i, 3);
					model.removeRow(RowHD);
					
				}
			}	
			TongTienHoaDon();
			
		} else if (table_HoaDon.getRowCount() == 0) {
			JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xoá");

		} else {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn một hàng bạn muốn xoá dòng");
		}
	}

	private void TongTienHoaDon() {
		double tongTien = 0;
		int rows = table_HoaDon.getRowCount();
		for (int i = 0; i < rows; i++) {
			tongTien = tongTien + Double.parseDouble(table_HoaDon.getValueAt(i, 3).toString().replaceAll("\\D+", ""));
		}
		lbl_TongTien.setText(decimalFormat.format(tongTien));
	}

	private void ThanhToanHoaDon() {
		int countRow = table_HoaDon.getRowCount();
		if (comboBox_KH.getSelectedItem().equals("Chọn Mã Khách Hàng")
				|| comboBox_NhanVien.getSelectedItem().equals("Chọn Mã Nhân Viên")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa Chọn Thông Tin Nhân Hoặc Khách Hàng");
		} else if (countRow <= 0) {
			JOptionPane.showMessageDialog(rootPane, "Không Có Sản Phẩm Cần Thanh Toán");
		} else {
			try {
				String thoiGian = textField_ThoiGian.getText().toString();
				int maKH = Integer.parseInt(comboBox_KH.getSelectedItem().toString().replaceAll("[\\-][^…]+", ""));
				int maNV = Integer.parseInt(comboBox_NhanVien.getSelectedItem().toString().replaceAll("[\\-][^…]+", ""));
				
				double tongTien = Double.parseDouble(lbl_TongTien.getText().toString().replaceAll("\\D+", ""));
				Orders idorder = orders_BUS.addOrder(maKH, maNV, tongTien, thoiGian); // insert table order
				

				for (int i = 0; i < countRow; i++) {
					int maSP = Integer.parseInt(table_HoaDon.getValueAt(i, 0).toString());
					String tenSP = (String) table_HoaDon.getValueAt(i, 1);
					double soLuong = Double.parseDouble(table_HoaDon.getValueAt(i, 2).toString());
					double giaTien = Double.parseDouble(table_HoaDon.getValueAt(i, 3).toString().replaceAll("\\D+", ""));
					orderDetails_BUS.addOrderDetail(idorder, maSP, tenSP, soLuong, giaTien); // insert table order detail
					CapNhatSoLuongSauKhiThanhToan(maSP);
				}
				JOptionPane.showMessageDialog(rootPane, "Thanh Toán Thành Công");
				ResetText();
			} catch (Exception  e) {
				JOptionPane.showMessageDialog(rootPane, "Lỗi !!! Thanh Toán Không Thất Bại ");
			}
		}
	}
	private void CapNhatSoLuongSauKhiThanhToan(int maSP) {
		int Row = table_ThanhToanHD.getRowCount();
		for(int i=0;i<Row;i++) {
			int idSP = (Integer) table_ThanhToanHD.getValueAt(i, 0);
			if(maSP == idSP) {
				double soLuong = (Double) table_ThanhToanHD.getValueAt(i, 3);
				products_BUS.updateQuatityProduct(maSP, soLuong);
			}
		}
		
	}

	private void TimKiemSanPham() {
		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm");
		} else {
			try {
				DefaultTableModel model = new DefaultTableModel();
				Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền" };
				model.setColumnIdentifiers(columns);

				int id = Integer.parseInt(textField_TimKiem.getText());
				Products products = products_BUS.searchProductById(id);
				if (products != null) {
					model.addRow(new Object[] { products.getIdProduct(), products.getIdCategory(), products.getName(),
							products.getQuatity(), decimalFormat.format(products.getPrice()) });
					table_ThanhToanHD.setModel(model);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Không Tìm Thấy Sản Phẩm");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "Chỉ nhập số");
			}
		}
	}

	private void ResetText() {
		comboBox_KH.setSelectedItem("Chọn Mã Khách Hàng");
		comboBox_NhanVien.setSelectedItem("Chọn Mã Nhân Viên");
		lbl_TongTien.setText("");
		table_HoaDon.setModel(
				new DefaultTableModel(null, new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền" }));
	}

	private void loadProduct() {
		DefaultTableModel model = (DefaultTableModel) table_ThanhToanHD.getModel();
		Object[] row = new Object[5];
		List<Products> product = products_BUS.ListProducts();
		for (int i = 0; i < product.size(); i++) {
			row[0] = product.get(i).getIdProduct();
			row[1] = product.get(i).getIdCategory();
			row[2] = product.get(i).getName();
			row[3] = product.get(i).getQuatity();
			row[4] = decimalFormat.format(product.get(i).getPrice());
			model.addRow(row);
		}
	}
}
