package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.Customers_BUS;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Add_Customer_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_MaKH;
	private JTextField textField_TenKH;
	
	private Customers_BUS customers_BUS = new Customers_BUS();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Customer_Form frame = new Add_Customer_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Add_Customer_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 459, 37);
		contentPane.add(panel);
		
		JLabel lbl_ThemKH = new JLabel("Thêm Khách Hàng");
		lbl_ThemKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemKH.setBounds(150, 11, 153, 14);
		panel.add(lbl_ThemKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(102, 35, 241, 172);
		contentPane.add(panel_1);
		
		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng");
		lbl_TenKH.setBounds(10, 55, 83, 14);
		panel_1.add(lbl_TenKH);
		
		JLabel lbl_DiaChi = new JLabel("Địa Chỉ");
		lbl_DiaChi.setBounds(10, 134, 84, 14);
		panel_1.add(lbl_DiaChi);
		
		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(104, 90, 129, 20);
		panel_1.add(textField_SDT);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(104, 131, 129, 20);
		panel_1.add(textField_DiaChi);
		
		JLabel lbl_IdKhachHang = new JLabel("Mã Khách Hàng\r\n");
		lbl_IdKhachHang.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdKhachHang);
		
		textField_MaKH = new JTextField();
		textField_MaKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_MaKH.setEditable(false);
				textField_MaKH.setBackground(Color.LIGHT_GRAY);
			}
		});
		textField_MaKH.setColumns(10);
		textField_MaKH.setBounds(102, 8, 129, 20);
		panel_1.add(textField_MaKH);
		
		JLabel lbl_SDT = new JLabel("Số Điện Thoại");
		lbl_SDT.setBounds(10, 93, 84, 14);
		panel_1.add(lbl_SDT);
		
		textField_TenKH = new JTextField();
		textField_TenKH.setColumns(10);
		textField_TenKH.setBounds(103, 52, 129, 20);
		panel_1.add(textField_TenKH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 208, 459, 53);
		contentPane.add(panel_2);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ThemKhachHang();
			}
		});
		btnThem.setBounds(101, 11, 96, 31);
		panel_2.add(btnThem);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(245, 11, 96, 31);
		panel_2.add(btnQuayLai);
		
		
	}
	private void ResetTextField() {
		textField_TenKH.setText("");
		textField_SDT.setText("");
		textField_DiaChi.setText("");
		
	}
	
	private void ThemKhachHang() {
		if(textField_TenKH.getText().equals("") || textField_SDT.getText().equals("") ||textField_DiaChi.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			customers_BUS.addCustomer(textField_TenKH.getText(),textField_SDT.getText(),textField_DiaChi.getText());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
		}
	}
	
}
