package quanlybanraucuqua.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Payment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(145, 0, 403, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thanh Toán Hoá Đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(126, 11, 177, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 146, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Trang Chủ");
		btnNewButton.setBounds(27, 11, 83, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(548, 0, 246, 393);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Hoá Đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(107, 11, 69, 20);
		panel_3.add(lblNewLabel_1);
		
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Sản Phẩm", "Số Lượng", "Giá Tiền"
			}
		));
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(0, 106, 246, 153);
		panel_3.add(scrollPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thời Gian");
		lblNewLabel_2.setBounds(10, 31, 52, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tên Khách Hàng");
		lblNewLabel_3.setBounds(10, 56, 83, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nhân Viên Thu Ngân");
		lblNewLabel_4.setBounds(10, 81, 97, 14);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng tiền");
		lblNewLabel_5.setBounds(107, 270, 52, 14);
		panel_3.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Thanh Toán");
		btnNewButton_1.setBounds(147, 359, 89, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBounds(10, 325, 89, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Xoá");
		btnNewButton_3.setBounds(10, 359, 89, 23);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cập nhật");
		btnNewButton_4.setBounds(147, 325, 89, 23);
		panel_3.add(btnNewButton_4);

		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 51, 548, 39);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 93, 548, 299);
		contentPane.add(scrollPane);
		
		

	}
}
