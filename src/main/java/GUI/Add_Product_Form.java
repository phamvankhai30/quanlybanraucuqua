package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Product_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_HinhAnh;
	private JTextField textField_TenSP;
	private JTextField textField_SoLuong;
	private JTextField textField_IdSP;
	private JTextField textField_GiaTien;
	private JTextField textField_MoTa;
	private JTextField textField_ThoiGian;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Add_Product_Form() {
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
		panel_1.setBounds(104, 38, 241, 285);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_LoaiSP = new JLabel("Loại Sản Phẩm");
		lbl_LoaiSP.setBounds(10, 44, 83, 14);
		panel_1.add(lbl_LoaiSP);
		
		JLabel lbl_TenSP = new JLabel("Tên Sản Phẩm");
		lbl_TenSP.setBounds(9, 103, 84, 14);
		panel_1.add(lbl_TenSP);
		
		JLabel lbl_SoLuong = new JLabel("Số Lượng");
		lbl_SoLuong.setBounds(10, 134, 83, 14);
		panel_1.add(lbl_SoLuong);
		
		JLabel lbl_GiaTien = new JLabel("Giá tiền");
		lbl_GiaTien.setBounds(10, 162, 46, 14);
		panel_1.add(lbl_GiaTien);
		
		JLabel lbl_NhaCungCap = new JLabel("Nhà Cung Cấp");
		lbl_NhaCungCap.setBounds(10, 195, 83, 14);
		panel_1.add(lbl_NhaCungCap);
		
		textField_HinhAnh = new JTextField();
		textField_HinhAnh.setBounds(104, 69, 129, 20);
		panel_1.add(textField_HinhAnh);
		textField_HinhAnh.setColumns(10);
		
		textField_TenSP = new JTextField();
		textField_TenSP.setColumns(10);
		textField_TenSP.setBounds(104, 100, 129, 20);
		panel_1.add(textField_TenSP);
		
		textField_SoLuong = new JTextField();
		textField_SoLuong.setColumns(10);
		textField_SoLuong.setBounds(104, 131, 129, 20);
		panel_1.add(textField_SoLuong);
		
		JLabel lbl_IdSP = new JLabel("ID Sản Phẩm\r\n");
		lbl_IdSP.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdSP);
		
		textField_IdSP = new JTextField();
		textField_IdSP.setColumns(10);
		textField_IdSP.setBounds(102, 8, 129, 20);
		panel_1.add(textField_IdSP);
		
		JComboBox<Object> comboBox_NhaCC = new JComboBox<Object>();
		comboBox_NhaCC.setBounds(104, 187, 128, 22);
		panel_1.add(comboBox_NhaCC);
		
		JComboBox<Object> comboBox_LoaiSP = new JComboBox<Object>();
		comboBox_LoaiSP.setBounds(103, 36, 128, 22);
		panel_1.add(comboBox_LoaiSP);
		
		JLabel lbl_HinhAnh = new JLabel("Hình ảnh");
		lbl_HinhAnh.setBounds(9, 72, 84, 14);
		panel_1.add(lbl_HinhAnh);
		
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
			public void actionPerformed(ActionEvent e) {
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
	}
}
