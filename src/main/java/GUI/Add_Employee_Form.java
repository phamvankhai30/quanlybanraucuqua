package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Employee_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_IdNV;
	private JTextField textField_TenNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Employee_Form frame = new Add_Employee_Form();
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
	public Add_Employee_Form() {
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
		
		JLabel lblThmNhnVin = new JLabel("Thêm Nhân Viên");
		lblThmNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThmNhnVin.setBounds(150, 11, 153, 14);
		panel.add(lblThmNhnVin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(104, 37, 241, 162);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_1.setBounds(10, 55, 83, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Địa Chỉ");
		lblNewLabel_2.setBounds(10, 134, 84, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(104, 90, 129, 20);
		panel_1.add(textField_SDT);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(104, 131, 129, 20);
		panel_1.add(textField_DiaChi);
		
		JLabel lblNewLabel_6 = new JLabel("ID Nhân Viên\r\n");
		lblNewLabel_6.setBounds(10, 11, 84, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_IdNV = new JTextField();
		textField_IdNV.setColumns(10);
		textField_IdNV.setBounds(102, 8, 129, 20);
		panel_1.add(textField_IdNV);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1.setBounds(10, 93, 84, 14);
		panel_1.add(lblNewLabel_2_1);
		
		textField_TenNV = new JTextField();
		textField_TenNV.setColumns(10);
		textField_TenNV.setBounds(103, 52, 129, 20);
		panel_1.add(textField_TenNV);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 208, 459, 53);
		contentPane.add(panel_2);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(103, 11, 96, 31);
		panel_2.add(btnNewButton);
		
		JButton btnQuayLi = new JButton("Quay Lại");
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLi.setBounds(255, 11, 96, 31);
		panel_2.add(btnQuayLi);
	}

}