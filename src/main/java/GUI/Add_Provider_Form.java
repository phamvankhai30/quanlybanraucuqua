package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.Providers_BUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add_Provider_Form extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_IdNhaCC;
	private JTextField textField_TenNhaCC;
	private Providers_BUS provider_BUS = new Providers_BUS();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Provider_Form frame = new Add_Provider_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Add_Provider_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 459, 37);
		contentPane.add(panel);
		
		JLabel lbl_ThemNhaCC = new JLabel("Thêm Nhà Cung Cấp");
		lbl_ThemNhaCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemNhaCC.setBounds(124, 11, 179, 14);
		panel.add(lbl_ThemNhaCC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(74, 37, 269, 152);
		contentPane.add(panel_1);
		
		JLabel lbl_TenNhaCC = new JLabel("Tên Nhà Cung Cấp");
		lbl_TenNhaCC.setBounds(10, 50, 110, 14);
		panel_1.add(lbl_TenNhaCC);
		
		JLabel lbl_DiaChi = new JLabel("Địa Chỉ");
		lbl_DiaChi.setBounds(10, 125, 84, 14);
		panel_1.add(lbl_DiaChi);
		
		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(130, 89, 129, 20);
		panel_1.add(textField_SDT);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(130, 122, 129, 20);
		panel_1.add(textField_DiaChi);
		
		JLabel lbl_IdNhaCC = new JLabel("ID Nhà Cung Cấp");
		lbl_IdNhaCC.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdNhaCC);
		
		textField_IdNhaCC = new JTextField();
		textField_IdNhaCC.setEnabled(false);
		textField_IdNhaCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_IdNhaCC.setEditable(false);
				textField_IdNhaCC.setBackground(Color.LIGHT_GRAY);
			}
		});
		textField_IdNhaCC.setColumns(10);
		textField_IdNhaCC.setBounds(130, 8, 129, 20);
		panel_1.add(textField_IdNhaCC);
		
		JLabel lbl_SoDienThoai = new JLabel("Số Điện Thoại");
		lbl_SoDienThoai.setBounds(10, 92, 84, 14);
		panel_1.add(lbl_SoDienThoai);
		
		textField_TenNhaCC = new JTextField();
		textField_TenNhaCC.setColumns(10);
		textField_TenNhaCC.setBounds(130, 47, 129, 20);
		panel_1.add(textField_TenNhaCC);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 193, 459, 65);
		contentPane.add(panel_2);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNhaCungCap(); 
			}
		});
		btnThem.setBounds(77, 11, 96, 31);
		panel_2.add(btnThem);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(242, 11, 96, 31);
		panel_2.add(btnQuayLai);
		
		
	}
	private void ResetTextField() {
		textField_TenNhaCC.setText("");
		textField_SDT.setText("");
		textField_DiaChi.setText("");
		
	}
	
	private void ThemNhaCungCap() {
		if(textField_TenNhaCC.getText().equals("") || textField_SDT.getText().equals("") ||textField_DiaChi.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			provider_BUS.addProvider(textField_TenNhaCC.getText(),textField_SDT.getText(),textField_DiaChi.getText());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
			
		}
	}
	
}
