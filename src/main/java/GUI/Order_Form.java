package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Order_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_Form frame = new Order_Form();
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
	public Order_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 146, 39);
		contentPane.add(panel_1_1);
		
		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(27, 6, 94, 28);
		panel_1_1.add(btnTrangChu);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(147, 0, 467, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_QLHD = new JLabel("Quản Lý Hoá Đơn");
		lbl_QLHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLHD.setBounds(128, 0, 172, 39);
		panel.add(lbl_QLHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 39, 614, 51);
		contentPane.add(panel_1);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(376, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBounds(261, 11, 89, 23);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(127, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		JButton btnChiTietHD = new JButton("Chi Tiết Hoá Đơn");
		btnChiTietHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetail_Form orderDetail = new OrderDetail_Form();
				orderDetail.setLocationRelativeTo(null);
				orderDetail.setVisible(true);
			}
		});
		btnChiTietHD.setBounds(475, 11, 129, 23);
		panel_1.add(btnChiTietHD);
		
		JTable table_QLHD = new JTable();
		table_QLHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Ho\u00E1 \u0110\u01A1n", "ID Nh\u00E2n Vi\u00EAn", "ID Kh\u00E1ch H\u00E0ng", "T\u1ED5ng Ti\u1EC1n", "Th\u1EDDi Gian"
			}
		));
		JScrollPane scrollPane_QLHD = new JScrollPane(table_QLHD);
		scrollPane_QLHD.setBounds(0, 89, 614, 256);
		contentPane.add(scrollPane_QLHD);
		

	}

}
