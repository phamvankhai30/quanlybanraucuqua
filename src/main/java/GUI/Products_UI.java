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

public class Products_UI extends JFrame {

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
	private JComboBox<Object> comboBox_filterProducts;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);

	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;

	private Products_BUS products_BUS = new Products_BUS();

	public Products_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		LocSanPham();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products_UI frame = new Products_UI();
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

		JLabel lbl_QLSP = new JLabel("Qu???n L?? S???n Ph???m");
		lbl_QLSP.setBounds(103, 0, 151, 51);
		lbl_QLSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lbl_QLSP);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 73, 636, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnAdd = new JButton("Th??m");
		btnAdd.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSanPham();
			}
		});
		btnAdd.setBounds(288, 9, 108, 33);
		panel_1.add(btnAdd);

		btnUpdate = new JButton("S???a");
		btnUpdate.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSanPham();
			}
		});
		btnUpdate.setBounds(406, 9, 100, 35);
		panel_1.add(btnUpdate);

		btnDelete = new JButton("Xo??");
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaSanPham();
			}
		});
		btnDelete.setBounds(516, 9, 100, 33);
		panel_1.add(btnDelete);

		JButton btnSearch = new JButton("T??m ki???m");
		btnSearch.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemSanPham();
			}
		});
		btnSearch.setBounds(144, 9, 129, 35);
		panel_1.add(btnSearch);

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
		table_QLSP.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
						"M\u00E3 Nh\u00E0 Cung C\u1EA5p", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng",
						"Gi\u00E1 Ti\u1EC1n", "M\u00F4 T\u1EA3", "Th\u1EDDi Gian" }));

		JScrollPane scrollPane_QLSP = new JScrollPane(table_QLSP);
		scrollPane_QLSP.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_QLSP.setBounds(10, 174, 636, 136);
		contentPane.add(scrollPane_QLSP);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 127, 51);
		contentPane.add(panel_1_1);

		JButton btnHome = new JButton("Trang Ch???");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHome.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setBounds(0, 0, 127, 51);
		
		panel_1_1.add(btnHome);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(519, 11, 127, 51);
		contentPane.add(panel_1_1_1);

		JButton btnReset = new JButton("L??m M???i");
		btnReset.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocSanPham();
			}
		});
		btnReset.setBounds(0, 0, 127, 51);
		panel_1_1_1.add(btnReset);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 333, 636, 168);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBounds(51, 39, 136, 103);
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(lbl_HinhAnh);

		JLabel lbl_MaSP = new JLabel("M?? S???n Ph???m");
		lbl_MaSP.setBounds(215, 14, 89, 14);
		panel_2.add(lbl_MaSP);

		textField_MaSP = new JTextField();
		textField_MaSP.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaSP.setBounds(357, 8, 143, 20);
		panel_2.add(textField_MaSP);
		textField_MaSP.setColumns(10);

		JLabel lbl_MaLSP = new JLabel("M?? Lo???i S???n Ph???m");
		lbl_MaLSP.setBounds(215, 42, 136, 14);
		panel_2.add(lbl_MaLSP);

		textField_MaLSP = new JTextField();
		textField_MaLSP.setColumns(10);
		textField_MaLSP.setBounds(357, 39, 143, 20);
		panel_2.add(textField_MaLSP);

		JLabel lbl_TenSP = new JLabel("T??n S???n Ph???m");
		lbl_TenSP.setBounds(215, 73, 91, 14);
		panel_2.add(lbl_TenSP);

		JLabel lbl_SoLuong = new JLabel("S??? L?????ng");
		lbl_SoLuong.setBounds(215, 111, 74, 14);
		panel_2.add(lbl_SoLuong);

		JLabel lbl_GiaTien = new JLabel("????n Gi??");
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

		comboBox_filterProducts = new JComboBox<Object>();
		comboBox_filterProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocSanPham();
			}
		});

		comboBox_filterProducts.setModel(new DefaultComboBoxModel<Object>(new String[] { "S??? L?????ng T??ng D???n",
				"S??? L?????ng Gi???m D???n", "M?? S???n Ph???m T??ng D???n", "M?? S???n Ph???m Gi???m D???n", "M?? Lo???i T??ng D???n",
				"M?? Lo???i Gi???m D???n", "Gi?? Ti???n T??ng D???n", "Gi?? Ti???n Gi???m D???n", "M?? S???n Nh?? Cung C???p T??ng D???n",
				"M?? S???n Nh?? Cung C???p Gi???m D???n", "S???p Theo T??n S???n Ph???m A-Z", "S???p Theo T??n S???n Ph???m Z-A" }));
		comboBox_filterProducts.setBounds(223, 135, 167, 28);
		contentPane.add(comboBox_filterProducts);

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
		Add_Product_UI add_Product_UI = new Add_Product_UI();
		add_Product_UI.setLocationRelativeTo(null);
		add_Product_UI.setVisible(true);
	}


	private void SuaSanPham() {
		int iRow = table_QLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a ch???n th??ng tin c???n s???a");
		} else {
			String maSP = table_QLSP.getModel().getValueAt(iRow, 0).toString();
			String maLSP = table_QLSP.getModel().getValueAt(iRow, 1).toString();
			String maNhaCC = table_QLSP.getModel().getValueAt(iRow, 2).toString();
			String tenSP = (String) table_QLSP.getModel().getValueAt(iRow, 3).toString();
			String soLuong = table_QLSP.getModel().getValueAt(iRow, 4).toString();
			String giaTien = table_QLSP.getModel().getValueAt(iRow, 5).toString().replaceAll("\\D+", "");
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
			Update_Product_UI update_Product_UI = new Update_Product_UI(maSP, maLSP, maNhaCC, tenSP, soLuong, giaTien,
					 moTa, img);
			update_Product_UI.setLocationRelativeTo(null);
			update_Product_UI.setVisible(true);
		}
	}

	private void XoaSanPham() {
		int iRow = table_QLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a ch???n th??ng tin c???n xo??");
		} else {

			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "B???n C?? Ch???c Ch???n Xo?? Kh??ng",
					"Th??ng B??o X??c Nh???n Xo??", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				String maSP = table_QLSP.getModel().getValueAt(iRow, 0).toString();
				int idSP = Integer.parseInt(maSP);
				products_BUS.deleteProductById(idSP);
				JOptionPane.showMessageDialog(rootPane, "Xo?? th??nh c??ng");
				LocSanPham();
			} else {
				JOptionPane.showMessageDialog(rootPane, "B???n ???? Hu??? Xo??");
			}
		}
	}

	private void TimKiemSanPham() {
		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a nh???p Id C???n T??m");
		} else {
			try {
				DefaultTableModel model = new DefaultTableModel();
				Object[] columns = { "M?? S???n Ph???m", "M?? Lo???i S???n Ph???m", "M?? Nh?? Cung C???p", "T??n S???n Ph???m", "S??? L?????ng",
						"Gi?? Ti???n", "M?? T???", "Th???i Gian" };
				model.setColumnIdentifiers(columns);

				int id = Integer.parseInt(textField_TimKiem.getText());
				Products products = products_BUS.searchProductById(id);
				if (products != null) {
					model.addRow(new Object[] { products.getIdProduct(), products.getIdCategory(),
							products.getIdProvider(), products.getName(), products.getQuatity(),
							decimalFormat.format(products.getPrice()), products.getDescription(), products.getDate() });
					table_QLSP.setModel(model);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Kh??ng T??m Th???y S???n Ph???m");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "Ch??? nh???p s???");
			}
		}
	}

	public void loadProduct(List<Products> listProduct) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "M?? S???n Ph???m", "M?? Lo???i S???n Ph???m", "M?? Nh?? Cung C???p", "T??n S???n Ph???m", "S??? L?????ng",
				"Gi?? Ti???n", "M?? T???", "Th???i Gian" };
		model.setColumnIdentifiers(columns);

		Object[] row = new Object[8];

		List<Products> products = listProduct;
		for (int i = 0; i < products.size(); i++) {
			row[0] = products.get(i).getIdProduct();
			row[1] = products.get(i).getIdCategory();
			row[2] = products.get(i).getIdProvider();
			row[3] = products.get(i).getName();
			row[4] = products.get(i).getQuatity();
			row[5] = decimalFormat.format(products.get(i).getPrice());
			row[6] = products.get(i).getDescription();
			row[7] = products.get(i).getDate();

			model.addRow(row);
		}
		table_QLSP.setModel(model);
		table_QLSP.setRowHeight(30);
	}

	private void LocSanPham() {
		if (comboBox_filterProducts.getSelectedItem().equals("S??? L?????ng T??ng D???n")) {
			SoLuongTangDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("S??? L?????ng Gi???m D???n")) {
			SoLuongGiamDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("M?? S???n Ph???m T??ng D???n")) {
			MaSanPhamTangDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("M?? S???n Ph???m Gi???m D???n")) {
			MaSanPhamGiamDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("M?? Lo???i T??ng D???n")) {
			MaLoaiTangDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("M?? Lo???i Gi???m D???n")) {
			MaLoaiGiamDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("Gi?? Ti???n T??ng D???n")) {
			GiaTienTangDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("Gi?? Ti???n Gi???m D???n")) {
			GiaTienGiamDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("M?? S???n Nh?? Cung C???p T??ng D???n")) {
			MaNhaCungCapTangDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("M?? S???n Nh?? Cung C???p Gi???m D???n")) {
			MaNhaCungCapGiamDan();
		} else if (comboBox_filterProducts.getSelectedItem().equals("S???p Theo T??n S???n Ph???m A-Z")) {
			TenSanPhamAZ();
		} else if (comboBox_filterProducts.getSelectedItem().equals("S???p Theo T??n S???n Ph???m Z-A")) {
			TenSanPhamZA();
		}
	}

	private void MaSanPhamTangDan() {
		List<Products> listProducts = products_BUS.ListProducts();
		loadProduct(listProducts);
	}

	private void MaSanPhamGiamDan() {
		List<Products> listProducts = products_BUS.orderByProductIdDESC();
		loadProduct(listProducts);
	}

	private void MaLoaiTangDan() {
		List<Products> listProducts = products_BUS.orderByCategoryASC();
		loadProduct(listProducts);
	}

	private void MaLoaiGiamDan() {
		List<Products> listProducts = products_BUS.orderByCategoryDESC();
		loadProduct(listProducts);
	}

	private void SoLuongTangDan() {
		List<Products> listProducts = products_BUS.orderByQuatityASC();
		loadProduct(listProducts);
	}

	private void SoLuongGiamDan() {
		List<Products> listProducts = products_BUS.orderByQuatityDESC();
		loadProduct(listProducts);
	}

	private void GiaTienTangDan() {
		List<Products> listProducts = products_BUS.orderByPriceASC();
		loadProduct(listProducts);
	}

	private void GiaTienGiamDan() {
		List<Products> listProducts = products_BUS.orderByPriceDESC();
		loadProduct(listProducts);
	}

	private void MaNhaCungCapTangDan() {
		List<Products> listProducts = products_BUS.orderByProviderASC();
		loadProduct(listProducts);
	}

	private void MaNhaCungCapGiamDan() {
		List<Products> listProducts = products_BUS.orderByProviderDESC();
		loadProduct(listProducts);
	}

	private void TenSanPhamAZ() {
		List<Products> listProducts = products_BUS.orderByNameProductAZ();
		loadProduct(listProducts);
	}

	private void TenSanPhamZA() {
		List<Products> listProducts = products_BUS.orderByNameProductZA();
		loadProduct(listProducts);
	}

}// end
