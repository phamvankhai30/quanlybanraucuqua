package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BUS.Category_BUS;
import BUS.ImportBillDetails_BUS;
import BUS.ImportBills_BUS;
import BUS.Products_BUS;
import BUS.Providers_BUS;
import DTO.ClockThread;
import DTO.DisplayNumberThread;
import Entitys.Categorys;
import Entitys.ImportBills;
import Entitys.Products;
import Entitys.Providers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.List;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Add_Product_Form extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JLabel lbl_HinhAnh;

	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_MaSP;
	private JTextField textField_GiaTien;
	private JTextField textField_MoTa;
	private JTextField textField_ThoiGian;
	private JTextField txtUrl;

	private JComboBox<Object> comboBox_MaLSP;
	private JComboBox<Object> comboBox_NhaCC;

	private JButton btnChonHinh;
	private JButton btnThem;
	private JButton btnQuayLai;

	private Category_BUS category_BUS = new Category_BUS();
	private Products_BUS products_BUS = new Products_BUS();
	private Providers_BUS providers_BUS = new Providers_BUS();
	private ImportBills_BUS importBills_BUS = new ImportBills_BUS();
	private ImportBillDetails_BUS importBillDetails_BUS = new ImportBillDetails_BUS();

	public Add_Product_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		initId();
		HienThiMaLSP();
		HienThiMaNhaCC();
		initClock();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product_Form frame = new Add_Product_Form();
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
		setBounds(100, 100, 495, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 458, 37);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_ThemSP = new JLabel("Thêm Sản Phẩm");
		lbl_ThemSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemSP.setBounds(150, 11, 132, 14);
		panel.add(lbl_ThemSP);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 59, 270, 260);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_MaLSP = new JLabel("Mã Loại Sản Phẩm");
		lbl_MaLSP.setBounds(10, 44, 111, 14);
		panel_1.add(lbl_MaLSP);

		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(9, 76, 84, 14);
		panel_1.add(lbl_TenSP);

		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(10, 107, 63, 14);
		panel_1.add(lbl_SoLuong);

		JLabel lbl_GiaTien = new JLabel("Giá tiền");
		lbl_GiaTien.setBounds(10, 138, 63, 14);
		panel_1.add(lbl_GiaTien);

		JLabel lbl_NhaCC = new JLabel("Mã Nhà Cung Cấp");
		lbl_NhaCC.setBounds(10, 170, 111, 18);
		panel_1.add(lbl_NhaCC);

		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(131, 73, 129, 20);
		panel_1.add(textField_TenSP);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(131, 104, 129, 20);
		panel_1.add(textField_SoLuong);

		JLabel lbl_MaSP = new JLabel("Mã Sản Phẩm\r\n");
		lbl_MaSP.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_MaSP);

		textField_MaSP = new JTextField();
		textField_MaSP.setEnabled(false);
		textField_MaSP.setColumns(10);
		textField_MaSP.setBounds(131, 8, 129, 20);
		panel_1.add(textField_MaSP);

		comboBox_NhaCC = new JComboBox<Object>();
		comboBox_NhaCC.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Mã Nhà Cung Cấp" }));
		comboBox_NhaCC.setBounds(131, 166, 128, 22);
		panel_1.add(comboBox_NhaCC);

		comboBox_MaLSP = new JComboBox<Object>();
		comboBox_MaLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		comboBox_MaLSP.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Mã Loại Sản Phẩm" }));
		comboBox_MaLSP.setBounds(131, 40, 128, 22);
		panel_1.add(comboBox_MaLSP);

		JLabel lbl_MoTa = new JLabel("Mô tả");
		lbl_MoTa.setBounds(10, 205, 84, 14);
		panel_1.add(lbl_MoTa);

		textField_GiaTien = new JTextField();
		textField_GiaTien.setColumns(10);
		textField_GiaTien.setBounds(131, 135, 129, 20);
		panel_1.add(textField_GiaTien);

		textField_MoTa = new JTextField();
		textField_MoTa.setColumns(10);
		textField_MoTa.setBounds(131, 199, 129, 20);
		panel_1.add(textField_MoTa);

		textField_ThoiGian = new JTextField();
		textField_ThoiGian.setBounds(131, 230, 129, 20);
		panel_1.add(textField_ThoiGian);
		textField_ThoiGian.setColumns(10);

		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 233, 84, 14);
		panel_1.add(lbl_ThoiGian);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 330, 458, 65);
		contentPane.add(panel_2);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.setBounds(313, 11, 119, 43);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSanPham();
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnThem);

		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 135, 43);
		panel_2.add(btnQuayLai);

		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("");
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(290, 59, 178, 260);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBounds(11, 22, 157, 138);
		panel_3.add(lbl_HinhAnh);
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnChonHinh = new JButton("Hình Ảnh");
		btnChonHinh.setBounds(41, 171, 91, 32);
		panel_3.add(btnChonHinh);

		txtUrl = new JTextField();
		txtUrl.setEnabled(false);
		txtUrl.setBounds(11, 214, 157, 20);
		panel_3.add(txtUrl);
		txtUrl.setColumns(10);
		btnChonHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonHinh();
			}
		});
	}

	private void HienThiMaLSP() {
		List<Categorys> listCategorys = category_BUS.listCategorys();
		for (Categorys category : listCategorys) {
			comboBox_MaLSP.addItem(category.getIdCategor());
		}
	}

	private void HienThiMaNhaCC() {
		List<Providers> listProviders = providers_BUS.listProviders();
		for (Providers provider : listProviders) {
			comboBox_NhaCC.addItem(provider.getIdProvider());
		}
	}

	private void initId() {
		DisplayNumberThread id = new DisplayNumberThread(textField_MaSP);
		id.start();
	}

	private void initClock() {
		ClockThread clock = new ClockThread(textField_ThoiGian);
		clock.start();
	}

	private void ResetTextField() {
		comboBox_MaLSP.setSelectedItem("Chọn Mã Loại Sản Phẩm");
		comboBox_NhaCC.setSelectedItem("Chọn Mã Nhà Cung Cấp");
		lbl_HinhAnh.setText("");
		textField_MaSP.setText("");
		initId();
		textField_TenSP.setText("");
		textField_SoLuong.setText("");
		textField_GiaTien.setText("");
		textField_MoTa.setText("");
		lbl_HinhAnh.setIcon(null);
		txtUrl.setText("");
		initClock();

	}

	@SuppressWarnings("unlikely-arg-type")
	private void ThemSanPham() {
		if (textField_TenSP.getText().equals("") || textField_SoLuong.getText().equals("")
				|| textField_GiaTien.getText().equals("") || comboBox_MaLSP.equals("Chọn Loại Sản Phẩm")
				|| comboBox_NhaCC.equals("Chọn Nhà Cung Cấp")||txtUrl.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		} else {
			int maLSP = (Integer) comboBox_MaLSP.getSelectedItem();
			int maNCC = (Integer) comboBox_NhaCC.getSelectedItem();
			String hinhAnh = txtUrl.getText();
			String tenSP = textField_TenSP.getText();
			String soluong = textField_SoLuong.getText();
			String giasanpham = textField_GiaTien.getText();
			String moTa = textField_MoTa.getText();
			String thoiGian = textField_ThoiGian.getText();

			if (CheckNumber(soluong, giasanpham)) {
				double soLuong = Double.parseDouble(soluong);
				double giaSP = Double.parseDouble(giasanpham);

				Products product = products_BUS.addProduct(maLSP, maNCC, hinhAnh, tenSP, soLuong, giaSP, moTa,
						thoiGian);
				ImportBills importBill = importBills_BUS.addImportBill(product, maLSP, maNCC, soLuong, giaSP, thoiGian);
				importBillDetails_BUS.addImportBillDetails(importBill, tenSP, moTa);

				JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
				ResetTextField();
			}
		}
	}

	private boolean CheckNumber(String soLuong, String giaSP) {
		boolean check = true;
		boolean soluong = soLuong.matches("^[0-9]+(.|)[0-9]+$");
		boolean giasanpham = soLuong.matches("^[0-9]+(.|)[0-9]+$");
		if (soluong == false) {
			JOptionPane.showMessageDialog(rootPane, "Không được nhập chữ vào số lượng");
			check = false;
		} else if (giasanpham == false) {
			JOptionPane.showMessageDialog(rootPane, "Không được nhập chữ vào giá");
			check = false;
		}
		return check;
	}

	private void ChonHinh() {
		JFileChooser filechooser = new JFileChooser("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\img");
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Hinh ảnh", "png", "jpg");
		filechooser.setFileFilter(imgFilter);

		filechooser.setMultiSelectionEnabled(false);

		filechooser.showOpenDialog(null);

		File file = filechooser.getSelectedFile();
		String pathImg = file.toString();

		ImageIcon imageIcon = new ImageIcon(pathImg);
		Image hinhAnh = imageIcon.getImage().getScaledInstance(lbl_HinhAnh.getWidth(), lbl_HinhAnh.getHeight(),
				Image.SCALE_SMOOTH);
		lbl_HinhAnh.setIcon(new ImageIcon(hinhAnh));

		txtUrl.setText(pathImg);
	}
}
