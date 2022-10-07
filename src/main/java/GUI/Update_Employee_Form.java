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

public class Update_Employee_Form extends JFrame {

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
					Update_Employee_Form frame = new Update_Employee_Form();
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
	public Update_Employee_Form() {
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
		
		JLabel lbl_SuaNV = new JLabel("Sửa Nhân Viên");
		lbl_SuaNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaNV.setBounds(158, 11, 153, 14);
		panel.add(lbl_SuaNV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(106, 36, 241, 174);
		contentPane.add(panel_1);
		
		JLabel lbl_TenV = new JLabel("Tên Nhân Viên");
		lbl_TenV.setBounds(10, 55, 83, 14);
		panel_1.add(lbl_TenV);
		
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
		
		JLabel lbl_IdNV = new JLabel("ID Nhân Viên\r\n");
		lbl_IdNV.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdNV);
		
		textField_IdNV = new JTextField();
		textField_IdNV.setColumns(10);
		textField_IdNV.setBounds(102, 8, 129, 20);
		panel_1.add(textField_IdNV);
		
		JLabel lbl_SDT = new JLabel("Số Điện Thoại");
		lbl_SDT.setBounds(10, 93, 84, 14);
		panel_1.add(lbl_SDT);
		
		textField_TenNV = new JTextField();
		textField_TenNV.setColumns(10);
		textField_TenNV.setBounds(103, 52, 129, 20);
		panel_1.add(textField_TenNV);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 209, 459, 53);
		contentPane.add(panel_2);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(105, 11, 96, 31);
		panel_2.add(btnSua);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(252, 11, 96, 31);
		panel_2.add(btnQuayLai);
	}

}
