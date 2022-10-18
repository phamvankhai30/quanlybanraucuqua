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
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import BUS.Products_BUS;
import DTO.ClockThead;

import java.awt.Color;

public class Update_Product_Form extends JFrame {

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
	
	private Products_BUS products_BUS = new Products_BUS();


	public Update_Product_Form(String maSP, String maLSP, String hinhAnh, String tenSP, String soLuong,
			String giaTien, String maNhaCC, String moTa) {
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
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Product_Form frame = new Update_Product_Form("","","","","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponents()   {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 459, 37);
		contentPane.add(panel);
		
		JLabel lbl_SuaSP = new JLabel("Sửa Sản Phẩm");
		lbl_SuaSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaSP.setBounds(150, 0, 132, 37);
		panel.add(lbl_SuaSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 326, 446, 53);
		contentPane.add(panel_2);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaSanPham();
			}
		});
		btnSua.setBounds(102, 11, 96, 31);
		panel_2.add(btnSua);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(248, 11, 96, 31);
		panel_2.add(btnQuayLai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(36, 36, 241, 285);
		contentPane.add(panel_1);
		
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
		
		JLabel lbl_NhaCC = new JLabel("Nhà Cung Cấp");
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
		comboBox_NhaCC.setBounds(104, 187, 128, 22);
		panel_1.add(comboBox_NhaCC);
		
		comboBox_MaLSP = new JComboBox<Object>();
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
		textField_ThoiGian.setText("17-10-2022 21:22");
		textField_ThoiGian.setColumns(10);
		textField_ThoiGian.setBounds(104, 251, 129, 20);
		panel_1.add(textField_ThoiGian);
		
		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 254, 84, 14);
		panel_1.add(lbl_ThoiGian);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(287, 65, 163, 203);
		contentPane.add(panel_3);
		
		lbl_HinhAnh = new JLabel("");
		lbl_HinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_HinhAnh.setBounds(10, 11, 139, 126);
		panel_3.add(lbl_HinhAnh);
		
		JButton btnChonHinh = new JButton("Hình Ảnh");
		btnChonHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonHinh();
			}
		});
		btnChonHinh.setBounds(35, 148, 89, 23);
		panel_3.add(btnChonHinh);
		
		textField_PathIMG = new JTextField();
		textField_PathIMG.setColumns(10);
		textField_PathIMG.setBounds(11, 172, 138, 20);
		panel_3.add(textField_PathIMG);
	}

	private void initClock() {
		ClockThead clock = new ClockThead(textField_ThoiGian);
		clock.start();
	}
	
	private void SuaSanPham() {
		if (textField_TenSP.getText().equals("") || textField_SoLuong.getText().equals("")
				|| textField_GiaTien.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		} else {

			int maLoaiSP = Integer.parseInt((String) comboBox_MaLSP.getSelectedItem());
			int maNhaCC = Integer.parseInt((String) comboBox_NhaCC.getSelectedItem());
			String hinhAnh = textField_PathIMG.getText();
			String tenSP = textField_TenSP.getText();
			double giaTien = Double.parseDouble(textField_SoLuong.getText());
			double soLuong = Double.parseDouble(textField_GiaTien.getText());
			String moTa = textField_MoTa.getText();
			String thoiGian = textField_ThoiGian.getText();
			
			products_BUS.updateProduct(maLoaiSP, maNhaCC, hinhAnh, tenSP, giaTien, soLuong, moTa, thoiGian);
			JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
		}
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
