package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private JComboBox<Object> comboBox_LocSP;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);

	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;

	private Products_BUS products_BUS = new Products_BUS();

	public Products_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		LocSanPham();
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
		setBounds(100, 100, 681, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(153, 11, 356, 51);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_QLSP = new JLabel("Quản Lý Sản Phẩm");
		lbl_QLSP.setBounds(103, 0, 151, 51);
		lbl_QLSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lbl_QLSP);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 73, 636, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSanPham();
			}
		});
		btnThem.setBounds(288, 9, 108, 33);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSanPham();
			}
		});
		btnSua.setBounds(406, 9, 100, 35);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaSanPham();
			}
		});
		btnXoa.setBounds(516, 9, 100, 33);
		panel_1.add(btnXoa);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemSanPham();
			}
		});
		btnTimKiem.setBounds(144, 9, 129, 35);
		panel_1.add(btnTimKiem);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setBounds(10, 14, 124, 22);
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
		table_QLSP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền",
							"Mã Nhà Cung Cấp", "Mô Tả", "Thời Gian" 
			}
		));

		JScrollPane scrollPane_QLSP = new JScrollPane(table_QLSP);
		scrollPane_QLSP.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_QLSP.setBounds(10, 174, 636, 136);
		contentPane.add(scrollPane_QLSP);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 127, 51);
		contentPane.add(panel_1_1);

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
		btnTrangChu.setBounds(0, 0, 127, 51);
		panel_1_1.add(btnTrangChu);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(519, 11, 127, 51);
		contentPane.add(panel_1_1_1);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocSanPham();
			}
		});
		btnLamMoi.setBounds(0, 0, 127, 51);
		panel_1_1_1.add(btnLamMoi);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 333, 636, 168);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBounds(51, 39, 136, 103);
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(lbl_HinhAnh);

		JLabel lbl_MaSP = new JLabel("Mã Sản Phẩm");
		lbl_MaSP.setBounds(215, 14, 89, 14);
		panel_2.add(lbl_MaSP);

		textField_MaSP = new JTextField();
		textField_MaSP.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaSP.setBounds(357, 8, 143, 20);
		panel_2.add(textField_MaSP);
		textField_MaSP.setColumns(10);

		JLabel lbl_MaLSP = new JLabel("Mã Loại Sản Phẩm");
		lbl_MaLSP.setBounds(215, 42, 103, 14);
		panel_2.add(lbl_MaLSP);

		textField_MaLSP = new JTextField();
		textField_MaLSP.setColumns(10);
		textField_MaLSP.setBounds(357, 39, 143, 20);
		panel_2.add(textField_MaLSP);

		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(215, 73, 91, 14);
		panel_2.add(lbl_TenSP);

		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(215, 111, 74, 14);
		panel_2.add(lbl_SoLuong);

		JLabel lbl_GiaTien = new JLabel("Đơn Giá");
		lbl_GiaTien.setBounds(215, 140, 46, 14);
		panel_2.add(lbl_GiaTien);

		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(357, 70, 143, 20);
		panel_2.add(textField_TenSP);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(357, 108, 143, 20);
		panel_2.add(textField_SoLuong);

		textField_GiaTien = new JTextField();
		textField_GiaTien.setColumns(10);
		textField_GiaTien.setBounds(357, 137, 143, 20);
		panel_2.add(textField_GiaTien);

		comboBox_LocSP = new JComboBox<Object>();
		comboBox_LocSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocSanPham();
			}
		});

		comboBox_LocSP.setModel(new DefaultComboBoxModel<Object>(new String[] { "Mã Sản Phẩm Tăng Dần",
				"Mã Sản Phẩm Giảm Dần", "Mã Loại Tăng Dần", "Mã Loại Giảm Dần", "Số Lượng Tăng Dần",
				"Số Lượng Giảm Dần", "Giá Tiền Tăng Dần", "Giá Tiền Giảm Dần", "Mã Sản Nhà Cung Cấp Tăng Dần",
				"Mã Sản Nhà Cung Cấp Giảm Dần", "Sắp Theo Tên Sản Phẩm A-Z", "Sắp Theo Tên Sản Phẩm Z-A" }));
		comboBox_LocSP.setBounds(223, 135, 167, 28);
		contentPane.add(comboBox_LocSP);

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
			String giaTien = table_QLSP.getModel().getValueAt(iRow, 4).toString().replaceAll("\\D+","");
			String maNhaCC = table_QLSP.getModel().getValueAt(iRow, 5).toString();
			String moTa = table_QLSP.getModel().getValueAt(iRow, 6).toString();
			
			List<Products> listProducts = products_BUS.ListProducts();
			int idSP = Integer.parseInt(maSP);
			String img = null;

			for (Products product : listProducts) {
				int checkMaSP = product.getIdProduct();
				if (idSP == checkMaSP) {
					img = product.getImg();
				}
			}
			Update_Product_Form update_Product_Form = new Update_Product_Form(maSP, maLSP, img, tenSP, soLuong, giaTien,
					maNhaCC, moTa);
			update_Product_Form.setLocationRelativeTo(null);
			update_Product_Form.setVisible(true);
		}
	}

	private void XoaSanPham() {
		int iRow = table_QLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
		} else {

			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Chắc Chắn Xoá Không",
					"Thông Báo Xác Nhận Xoá", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				String maSP = table_QLSP.getModel().getValueAt(iRow, 0).toString();
				int idSP = Integer.parseInt(maSP);
				products_BUS.deleteProductById(idSP);
				JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
				LocSanPham();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Bạn Đã Huỷ Xoá");
			}
		}
	}

	private void TimKiemSanPham() {
		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm");
		} else {
			try {
				DefaultTableModel model = new DefaultTableModel();
				Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền",
						"Mã Nhà Cung Cấp", "Mô Tả", "Thời Gian" };
				model.setColumnIdentifiers(columns);

				int id = Integer.parseInt(textField_TimKiem.getText());
				Products products = products_BUS.searchProductById(id);
				if (products != null) {
					model.addRow(new Object[] { products.getIdProduct(), products.getIdCategory(), products.getName(),
							products.getQuatity(), decimalFormat.format(products.getPrice()), products.getIdProvider(), products.getDescription(),
							products.getDate() });
					table_QLSP.setModel(model);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Không Tìm Thấy Sản Phẩm");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "Chỉ nhập số");
			}
		}
	}

	public void HienThiSanPham(List<Products> listProduct) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền",
				"Mã Nhà Cung Cấp", "Mô Tả", "Thời Gian" };
		model.setColumnIdentifiers(columns);
		
		Object[] row = new Object[8];

		List<Products> products = listProduct;
		for (int i = 0; i < products.size(); i++) {
			row[0] = products.get(i).getIdProduct();
			row[1] = products.get(i).getIdCategory();
			row[2] = products.get(i).getName();
			row[3] = products.get(i).getQuatity();
			row[4] = decimalFormat.format(products.get(i).getPrice());
			row[5] = products.get(i).getIdProvider();
			row[6] = products.get(i).getDescription();
			row[7] = products.get(i).getDate();

			model.addRow(row);
		}
		table_QLSP.setModel(model);
		table_QLSP.setRowHeight(30);
	}

	private void LocSanPham() {
		if (comboBox_LocSP.getSelectedItem().equals("Mã Sản Phẩm Tăng Dần")) {
			MaSanPhamTangDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Mã Sản Phẩm Giảm Dần")) {
			MaSanPhamGiamDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Mã Loại Tăng Dần")) {
			MaLoaiTangDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Mã Loại Giảm Dần")) {
			MaLoaiGiamDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Số Lượng Tăng Dần")) {
			SoLuongTangDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Số Lượng Giảm Dần")) {
			SoLuongGiamDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Giá Tiền Tăng Dần")) {
			GiaTienTangDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Giá Tiền Giảm Dần")) {
			GiaTienGiamDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Mã Sản Nhà Cung Cấp Tăng Dần")) {
			MaNhaCungCapTangDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Mã Sản Nhà Cung Cấp Giảm Dần")) {
			MaNhaCungCapGiamDan();
		} else if (comboBox_LocSP.getSelectedItem().equals("Sắp Theo Tên Sản Phẩm A-Z")) {
			TenSanPhamAZ();
		} else if (comboBox_LocSP.getSelectedItem().equals("Sắp Theo Tên Sản Phẩm Z-A")) {
			TenSanPhamZA();
		}
	}

	private void MaSanPhamTangDan() {
		List<Products> listProducts = products_BUS.ListProducts();
		HienThiSanPham(listProducts);
	}

	private void MaSanPhamGiamDan() {
		List<Products> listProducts = products_BUS.MaSanPhamGiam();
		HienThiSanPham(listProducts);
	}

	private void MaLoaiTangDan() {
		List<Products> listProducts = products_BUS.MaLoaiSanPhamTang();
		HienThiSanPham(listProducts);
	}

	private void MaLoaiGiamDan() {
		List<Products> listProducts = products_BUS.MaLoaiSanPhamGiam();
		HienThiSanPham(listProducts);
	}

	private void SoLuongTangDan() {
		List<Products> listProducts = products_BUS.SoLuongTang();
		HienThiSanPham(listProducts);
	}

	private void SoLuongGiamDan() {
		List<Products> listProducts = products_BUS.SoLuongGiam();
		HienThiSanPham(listProducts);
	}

	private void GiaTienTangDan() {
		List<Products> listProducts = products_BUS.GiaTienTang();
		HienThiSanPham(listProducts);
	}

	private void GiaTienGiamDan() {
		List<Products> listProducts = products_BUS.GiaTienGiam();
		HienThiSanPham(listProducts);
	}

	private void MaNhaCungCapTangDan() {
		List<Products> listProducts = products_BUS.MaNhaCungCapTang();
		HienThiSanPham(listProducts);
	}

	private void MaNhaCungCapGiamDan() {
		List<Products> listProducts = products_BUS.MaNhaCungCapGiam();
		HienThiSanPham(listProducts);
	}

	private void TenSanPhamAZ() {
		List<Products> listProducts = products_BUS.SapXepTenSanPhamAZ();
		HienThiSanPham(listProducts);
	}

	private void TenSanPhamZA() {
		List<Products> listProducts = products_BUS.SapXepTenSanPhamZA();
		HienThiSanPham(listProducts);
	}

}// end
