package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BUS.Category_BUS;
import BUS.Products_BUS;
import BUS.Providers_BUS;
import DTO.ClockThread;
import Entitys.Categorys;
import Entitys.Providers;

import java.awt.Color;
import java.awt.Toolkit;

public class Update_Product_UI extends JFrame {

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
	private Providers_BUS providers_BUS = new Providers_BUS();
	private Category_BUS category_BUS = new Category_BUS();
	private Products_BUS products_BUS = new Products_BUS();


	public Update_Product_UI(String maSP, String maLSP, String maNhaCC, String tenSP, String soLuong,
			String giaTien, String moTa, String hinhAnh) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		initClock();
		textField_MaSP.setText(maSP);
		comboBox_MaLSP.addItem(maLSP);
		textField_PathIMG.setText(hinhAnh);
		textField_TenSP.setText(tenSP);
		textField_SoLuong.setText(soLuong);
		textField_GiaTien.setText(giaTien);	
		comboBox_NhaCC.addItem(maNhaCC);
		textField_MoTa.setText(moTa);
		ImageIcon imageIcon = new ImageIcon(hinhAnh);
		Image img1 = imageIcon.getImage().getScaledInstance(lbl_HinhAnh.getWidth(), lbl_HinhAnh.getHeight(), Image.SCALE_SMOOTH);	
		lbl_HinhAnh.setIcon(new ImageIcon(img1));
		DanhSachMLSP();
		HienThiMaNhaCC();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Product_UI frame = new Update_Product_UI("","","","","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponents()   {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 459, 37);
		contentPane.add(panel);
		
		JLabel lbl_SuaSP = new JLabel("Sửa Sản Phẩm");
		lbl_SuaSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaSP.setBounds(150, 0, 132, 37);
		panel.add(lbl_SuaSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(13, 363, 456, 53);
		contentPane.add(panel_2);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSanPham();
			}
		});
		btnSua.setBounds(292, 11, 123, 31);
		panel_2.add(btnSua);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(22, 11, 123, 31);
		panel_2.add(btnQuayLai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 59, 267, 293);
		contentPane.add(panel_1);
		
		JLabel lbl_MaLSP = new JLabel("Mã Loại Sản Phẩm");
		lbl_MaLSP.setBounds(10, 46, 108, 14);
		panel_1.add(lbl_MaLSP);
		
		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(9, 116, 84, 14);
		panel_1.add(lbl_TenSP);
		
		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(10, 152, 83, 14);
		panel_1.add(lbl_SoLuong);
		
		JLabel lbl_GiaTien = new JLabel("Giá tiền");
		lbl_GiaTien.setBounds(10, 190, 46, 14);
		panel_1.add(lbl_GiaTien);
		
		JLabel lbl_NhaCC = new JLabel("Nhà Cung Cấp");
		lbl_NhaCC.setBounds(10, 83, 83, 14);
		panel_1.add(lbl_NhaCC);
		
		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(128, 113, 129, 20);
		panel_1.add(textField_TenSP);
		
		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(128, 149, 129, 20);
		panel_1.add(textField_SoLuong);
		
		JLabel lbl_MaSP = new JLabel("Mã Sản Phẩm\r\n");
		lbl_MaSP.setBounds(10, 14, 84, 14);
		panel_1.add(lbl_MaSP);
		
		textField_MaSP = new JTextField();
		textField_MaSP.setColumns(10);
		textField_MaSP.setBounds(128, 11, 129, 20);
		panel_1.add(textField_MaSP);
		
		 comboBox_NhaCC = new JComboBox<Object>();
		comboBox_NhaCC.setBounds(129, 75, 128, 22);
		panel_1.add(comboBox_NhaCC);
		
		comboBox_MaLSP = new JComboBox<Object>();
		comboBox_MaLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox_MaLSP.setBounds(128, 42, 128, 22);
		panel_1.add(comboBox_MaLSP);
		
		JLabel lbl_MoTa = new JLabel("Mô tả");
		lbl_MoTa.setBounds(10, 234, 84, 14);
		panel_1.add(lbl_MoTa);
		
		textField_GiaTien = new JTextField();
		textField_GiaTien.setColumns(10);
		textField_GiaTien.setBounds(128, 187, 129, 20);
		panel_1.add(textField_GiaTien);
		
		textField_MoTa = new JTextField();
		textField_MoTa.setColumns(10);
		textField_MoTa.setBounds(128, 231, 129, 20);
		panel_1.add(textField_MoTa);
		
		textField_ThoiGian = new JTextField();
		textField_ThoiGian.setText("17-10-2022 21:22");
		textField_ThoiGian.setColumns(10);
		textField_ThoiGian.setBounds(128, 262, 129, 20);
		panel_1.add(textField_ThoiGian);
		
		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 265, 84, 14);
		panel_1.add(lbl_ThoiGian);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		panel_3.setBounds(287, 65, 182, 287);
		contentPane.add(panel_3);
		
		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_HinhAnh.setBounds(15, 21, 157, 138);
		panel_3.add(lbl_HinhAnh);
		
		JButton btnChonHinh = new JButton("Hình Ảnh");
		btnChonHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonHinh();
			}
		});
		btnChonHinh.setBounds(41, 182, 102, 33);
		panel_3.add(btnChonHinh);
		
		textField_PathIMG = new JTextField();
		textField_PathIMG.setEnabled(false);
		textField_PathIMG.setColumns(10);
		textField_PathIMG.setBounds(15, 234, 157, 20);
		panel_3.add(textField_PathIMG);
	}

	private void initClock() {
		ClockThread clock = new ClockThread(textField_ThoiGian);
		clock.start();
	}
	private void DanhSachMLSP() {
		List<Categorys> listCategorys = category_BUS.listCategorys();
		for (Categorys category : listCategorys) {
			comboBox_MaLSP.addItem(category.getIdCategor()+"-"+category.getName());
		}
	}
	private void HienThiMaNhaCC() {
		List<Providers> listProviders = providers_BUS.listProviders();
		for (Providers provider : listProviders) {
			comboBox_NhaCC.addItem(provider.getIdProvider()+"-"+provider.getName());
		}
	}
	private void SuaSanPham() {
		if (textField_TenSP.getText().equals("") || textField_SoLuong.getText().equals("")
				|| textField_GiaTien.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		} else {
			String soluong = textField_SoLuong.getText();
			String giasanpham = textField_GiaTien.getText();
			
			if (CheckNumber(soluong, giasanpham)) {
				double soLuong = Double.parseDouble(soluong);
				double giaSP = Double.parseDouble(giasanpham);
				int maLoaiSP = Integer.parseInt(comboBox_MaLSP.getSelectedItem().toString().replaceAll("[\\-][^…]+", ""));
				int maNhaCC = Integer.parseInt(comboBox_NhaCC.getSelectedItem().toString().replaceAll("[\\-][^…]+", ""));
				int idProduct = Integer.parseInt(textField_MaSP.getText());
				String hinhAnh = textField_PathIMG.getText();
				String tenSP = textField_TenSP.getText();
				String moTa = textField_MoTa.getText();
				String thoiGian = textField_ThoiGian.getText();
				
				products_BUS.updateProduct(idProduct, maLoaiSP, maNhaCC, hinhAnh, tenSP, soLuong, giaSP, moTa, thoiGian);
				JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
				setVisible(false);
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
		JFileChooser filechooser = new JFileChooser("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\hinhAnh");
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Hinh ảnh", "png", "jpg");
		filechooser.setFileFilter(imgFilter);
		
		filechooser.setMultiSelectionEnabled(false);
		
		filechooser.showOpenDialog(null);

		File file = filechooser.getSelectedFile();
		String pathIMG = file.toString();
		
		ImageIcon imageIcon = new ImageIcon(pathIMG);
		Image hinhAnh = imageIcon.getImage().getScaledInstance(lbl_HinhAnh.getWidth(), lbl_HinhAnh.getHeight(), Image.SCALE_SMOOTH);	
		lbl_HinhAnh.setIcon(new ImageIcon(hinhAnh));
		
		textField_PathIMG.setText(pathIMG);
	}
}
