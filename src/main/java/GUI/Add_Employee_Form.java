package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import BUS.Employees_BUS;
import DTO.DisplayNumberThread;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Add_Employee_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_IdNV;
	private JTextField textField_TenNV;

	private JButton btnThem;
	private JButton btnQuayLai;
	
	Employees_BUS employee_BUS = new Employees_BUS();
	
	public Add_Employee_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		initId();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Employee_Form frame = new Add_Employee_Form();
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
		setBounds(100, 100, 298, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 261, 37);
		contentPane.add(panel);
		
		JLabel lblThmNhnVin = new JLabel("Thêm Nhân Viên");
		lblThmNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThmNhnVin.setBounds(67, 11, 153, 14);
		panel.add(lblThmNhnVin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 59, 261, 133);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_1.setBounds(10, 42, 83, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Địa Chỉ");
		lblNewLabel_2.setBounds(9, 104, 84, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(120, 70, 131, 20);
		panel_1.add(textField_SDT);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(120, 101, 131, 20);
		panel_1.add(textField_DiaChi);
		
		JLabel lblNewLabel_6 = new JLabel("ID Nhân Viên\r\n");
		lblNewLabel_6.setBounds(10, 11, 84, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_IdNV = new JTextField();
		textField_IdNV.setEnabled(false);
		textField_IdNV.setColumns(10);
		textField_IdNV.setBounds(120, 8, 129, 20);
		panel_1.add(textField_IdNV);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1.setBounds(10, 73, 84, 14);
		panel_1.add(lblNewLabel_2_1);
		
		textField_TenNV = new JTextField();
		textField_TenNV.setColumns(10);
		textField_TenNV.setBounds(120, 39, 131, 20);
		panel_1.add(textField_TenNV);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 203, 261, 64);
		contentPane.add(panel_2);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNhanVien();
			}
		});
		btnThem.setBounds(155, 11, 96, 42);
		panel_2.add(btnThem);
		
		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 111, 42);
		panel_2.add(btnQuayLai);
	}
	
	private void initId() {
		DisplayNumberThread id = new DisplayNumberThread(textField_IdNV);
		id.start();
	}
	
	private void ResetTextField() {
		textField_IdNV.setText("");
		textField_TenNV.setText("");
		textField_SDT.setText("");
		textField_DiaChi.setText("");
	}
	
	private void ThemNhanVien() {
		if(textField_TenNV.getText().equals("") || textField_SDT.getText().equals("") ||textField_DiaChi.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			employee_BUS.addEmployee(textField_TenNV.getText(),textField_SDT.getText(),textField_DiaChi.getText());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
		} 
	}

}
