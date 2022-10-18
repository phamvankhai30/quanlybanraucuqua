package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BUS.Category_BUS;
import BUS.Products_BUS;
import BUS.Providers_BUS;
import DTO.ClockThead;
import Entitys.Categorys;
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
	private JTextField textField_PathIMG;
	
	private JComboBox<Object> comboBox_MaLSP;
	private JComboBox<Object> comboBox_NhaCC;
	
	private JButton btnChonHinh;
	private JButton btnThem;
	private JButton btnQuayLai;
	
	private Category_BUS category_BUS = new Category_BUS();
	private Products_BUS products_BUS = new Products_BUS();
	private Providers_BUS providers_BUS = new Providers_BUS();

	public Add_Product_Form() {
		initComponents();
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
		setBounds(100, 100, 482, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 459, 37);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_ThemSP = new JLabel("Thêm Sản Phẩm");
		lbl_ThemSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemSP.setBounds(150, 11, 132, 14);
		panel.add(lbl_ThemSP);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(46, 37, 241, 285);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbl_MaLSP = new JLabel("Mã Loại Sản Phẩm");
		lbl_MaLSP.setBounds(10, 44, 83, 14);
		panel_1.add(lbl_MaLSP);

		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(10, 87, 84, 14);
		panel_1.add(lbl_TenSP);

		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(10, 128, 83, 14);
		panel_1.add(lbl_SoLuong);

		JLabel lbl_GiaTien = new JLabel("Giá tiền");
		lbl_GiaTien.setBounds(10, 162, 46, 14);
		panel_1.add(lbl_GiaTien);

		JLabel lbl_NhaCC = new JLabel("Mã Nhà Cung Cấp");
		lbl_NhaCC.setBounds(10, 195, 83, 14);
		panel_1.add(lbl_NhaCC);

		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(104, 84, 129, 20);
		panel_1.add(textField_TenSP);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(103, 125, 129, 20);
		panel_1.add(textField_SoLuong);

		JLabel lbl_MaSP = new JLabel("Mã Sản Phẩm\r\n");
		lbl_MaSP.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_MaSP);

		textField_MaSP = new JTextField();
		textField_MaSP.setColumns(10);
		textField_MaSP.setBounds(102, 8, 129, 20);
		panel_1.add(textField_MaSP);

		comboBox_NhaCC = new JComboBox<Object>();
		comboBox_NhaCC.setModel(new DefaultComboBoxModel<Object>(new String[] {"Chọn Mã Nhà Cung Cấp"}));
		comboBox_NhaCC.setBounds(104, 187, 128, 22);
		panel_1.add(comboBox_NhaCC);

		comboBox_MaLSP = new JComboBox<Object>();
		comboBox_MaLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		comboBox_MaLSP.setModel(new DefaultComboBoxModel<Object>(new String[] {"Chọn Mã Loại Sản Phẩm"}));
		comboBox_MaLSP.setBounds(103, 40, 128, 22);
		panel_1.add(comboBox_MaLSP);

		JLabel lbl_MoTa = new JLabel("Mô tả");
		lbl_MoTa.setBounds(10, 223, 84, 14);
		panel_1.add(lbl_MoTa);

		textField_GiaTien = new JTextField();
		textField_GiaTien.setColumns(10);
		textField_GiaTien.setBounds(104, 156, 129, 20);
		panel_1.add(textField_GiaTien);

		textField_MoTa = new JTextField();
		textField_MoTa.setColumns(10);
		textField_MoTa.setBounds(104, 220, 129, 20);
		panel_1.add(textField_MoTa);

		textField_ThoiGian = new JTextField();
		textField_ThoiGian.setBounds(104, 251, 129, 20);
		panel_1.add(textField_ThoiGian);
		textField_ThoiGian.setColumns(10);

		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 254, 84, 14);
		panel_1.add(lbl_ThoiGian);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 322, 459, 65);
		contentPane.add(panel_2);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(105, 11, 96, 31);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSanPham();
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnThem);

		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(252, 11, 96, 31);
		panel_2.add(btnQuayLai);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(296, 72, 163, 203);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBounds(10, 11, 139, 126);
		panel_3.add(lbl_HinhAnh);
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));

		btnChonHinh = new JButton("Hình Ảnh");
		btnChonHinh.setBounds(35, 148, 89, 23);
		panel_3.add(btnChonHinh);

		textField_PathIMG = new JTextField();
		textField_PathIMG.setBounds(11, 172, 138, 20);
		panel_3.add(textField_PathIMG);
		textField_PathIMG.setColumns(10);
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

	private void initClock() {
		ClockThead clock = new ClockThead(textField_ThoiGian);
		clock.start();
	}

	private void ResetTextField() {
		comboBox_MaLSP.setSelectedItem("Chọn Loại Sản Phẩm");
		comboBox_NhaCC.setSelectedItem("Chọn Nhà Cung Cấp");
		lbl_HinhAnh.setText("");
		textField_TenSP.setText("");
		textField_SoLuong.setText("");
		textField_GiaTien.setText("");
		textField_MoTa.setText("");
		lbl_HinhAnh.setIcon(null);
		textField_PathIMG.setText("");
		initClock();

	}

	@SuppressWarnings("unlikely-arg-type")
	private void ThemSanPham() {
		if (textField_TenSP.getText().equals("") || textField_SoLuong.getText().equals("")
				|| textField_GiaTien.getText().equals("") || comboBox_MaLSP.equals("Chọn Loại Sản Phẩm")
				|| comboBox_NhaCC.equals("Chọn Nhà Cung Cấp")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		} else {
			int maSP = (Integer) comboBox_MaLSP.getSelectedItem();
			int maLSP = (Integer) comboBox_NhaCC.getSelectedItem();
			String hinhAnh = textField_PathIMG.getText();
			String tenSP = textField_TenSP.getText();
			double giaSP = Double.parseDouble(textField_SoLuong.getText());
			double soLuong = Double.parseDouble(textField_GiaTien.getText());
			String moTa = textField_MoTa.getText();
			String thoiGian = textField_ThoiGian.getText();

			products_BUS.addProduct(maSP, maLSP, hinhAnh, tenSP, giaSP, soLuong, moTa, thoiGian);
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
		}
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
		Image hinhAnh = imageIcon.getImage().getScaledInstance(lbl_HinhAnh.getWidth(), lbl_HinhAnh.getHeight(), Image.SCALE_SMOOTH);
		lbl_HinhAnh.setIcon(new ImageIcon(hinhAnh));
		
		textField_PathIMG.setText(pathImg);
	}
}
