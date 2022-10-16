package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BUS.Category_BUS;
import BUS.Products_BUS;
import BUS.Providers_BUS;
import Entitys.Categorys;
import Entitys.Providers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.List;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;


public class Add_Product_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_IdSP;
	private JTextField textField_GiaTien;
	private JTextField textField_MoTa;
	private JTextField textField_ThoiGian;
	private JLabel lbl_Img;
	private JComboBox<Object> comboBox_LoaiSP;
	private JComboBox<Object> comboBox_NhaCC;

	/**
	 * Launch the application.
	 */
	public Add_Product_Form() {
		initComponents();
		showListCatagorys();
		showListProviders();
		showTime();
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

		JLabel lbl_LoaiSP = new JLabel("Loại Sản Phẩm");
		lbl_LoaiSP.setBounds(10, 44, 83, 14);
		panel_1.add(lbl_LoaiSP);

		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(10, 87, 84, 14);
		panel_1.add(lbl_TenSP);

		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(10, 128, 83, 14);
		panel_1.add(lbl_SoLuong);

		JLabel lbl_GiaTien = new JLabel("Giá tiền");
		lbl_GiaTien.setBounds(10, 162, 46, 14);
		panel_1.add(lbl_GiaTien);

		JLabel lbl_NhaCungCap = new JLabel("Nhà Cung Cấp");
		lbl_NhaCungCap.setBounds(10, 195, 83, 14);
		panel_1.add(lbl_NhaCungCap);

		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(104, 84, 129, 20);
		panel_1.add(textField_TenSP);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(103, 125, 129, 20);
		panel_1.add(textField_SoLuong);

		JLabel lbl_IdSP = new JLabel("ID Sản Phẩm\r\n");
		lbl_IdSP.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdSP);

		textField_IdSP = new JTextField();
		textField_IdSP.setColumns(10);
		textField_IdSP.setBounds(102, 8, 129, 20);
		panel_1.add(textField_IdSP);

		comboBox_NhaCC = new JComboBox<Object>();
		comboBox_NhaCC.setModel(new DefaultComboBoxModel<Object>(new String[] {"Chọn Nhà Cung Cấp"}));
		comboBox_NhaCC.setBounds(104, 187, 128, 22);
		panel_1.add(comboBox_NhaCC);

		comboBox_LoaiSP = new JComboBox<Object>();
		comboBox_LoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		comboBox_LoaiSP.setModel(new DefaultComboBoxModel<Object>(new String[] { "Chọn Loại Sản Phẩm" }));
		comboBox_LoaiSP.setBounds(103, 40, 128, 22);
		panel_1.add(comboBox_LoaiSP);

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

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(105, 11, 96, 31);
		btnThem.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unlikely-arg-type" })
			public void actionPerformed(ActionEvent e) {
				if (textField_TenSP.getText().equals("") || textField_SoLuong.getText().equals("")
						|| textField_GiaTien.getText().equals("") || comboBox_LoaiSP.equals("Chọn Loại Sản Phẩm")
						|| comboBox_NhaCC.equals("Chọn Nhà Cung Cấp")) {
					JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
				} else {

					Products_BUS products_BUS =  new Products_BUS();
					int id_category = (Integer) comboBox_LoaiSP.getSelectedItem();
					int id_provider = (Integer) comboBox_NhaCC.getSelectedItem();
					String img = lbl_Img.getText();
					String name = textField_TenSP.getText();
					double price = Double.parseDouble(textField_SoLuong.getText());
					double quatity = Double.parseDouble(textField_GiaTien.getText());
					String description = textField_MoTa.getText();
					String time = textField_ThoiGian.getText();
					

					products_BUS.addProduct(id_category, id_provider, img, name, price, quatity, description,time);
					JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
					ResetTextField();

				}

			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnThem);

		JButton btnQuaLai = new JButton("Quay Lại");
		btnQuaLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuaLai.setBounds(252, 11, 96, 31);
		panel_2.add(btnQuaLai);

		lbl_Img = new JLabel("");
		lbl_Img.setBounds(303, 96, 139, 126);
		contentPane.add(lbl_Img);
		lbl_Img.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btnNewButton = new JButton("Hình Ảnh");
		btnNewButton.setBounds(333, 233, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Hinh ảnh", "png", "jpg");
				filechooser.setFileFilter(imgFilter);
				filechooser.setMultiSelectionEnabled(false);
				int response = filechooser.showOpenDialog(null);

				if (response == JFileChooser.APPROVE_OPTION) {
					File imgFile = filechooser.getSelectedFile();
					lbl_Img.setIcon(new ImageIcon(imgFile.getAbsolutePath()));
					// System.out.println(imgFile.getAbsolutePath());
				}

			}
		});
	}

	private void showListCatagorys() {
		Category_BUS category_BUS = new Category_BUS();
		List<Categorys> listCategory = category_BUS.listCategorys();

		for (Categorys category : listCategory) {
			comboBox_LoaiSP.addItem(category.getIdCategor());
		}
	}

	private void showListProviders() {
		Providers_BUS providers_BUS = new Providers_BUS();
		List<Providers> listProvider = providers_BUS.listProviders();

		for (Providers provider : listProvider) {
			comboBox_NhaCC.addItem(provider.getIdProvider());
		}
	}
	private void showTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String localDateTime = LocalDateTime.now().format(dateTimeFormatter);
		
		textField_ThoiGian.setText(localDateTime);
	}
	private void ResetTextField() {
		comboBox_LoaiSP.setSelectedItem("Chọn Loại Sản Phẩm");
		comboBox_NhaCC.setSelectedItem("Chọn Nhà Cung Cấp");
		lbl_Img.setText("");
		textField_TenSP.setText("");
		textField_SoLuong.setText("");
		textField_GiaTien.setText("");
		textField_MoTa.setText("");
		showTime();
		
	}

}
