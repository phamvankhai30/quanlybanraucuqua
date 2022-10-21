package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Import_Bill_From extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import_Bill_From frame = new Import_Bill_From();
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
	public Import_Bill_From() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 611, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_HoaDonMuaHang = new JLabel("Hoá Đơn Nhập Hàng");
		lbl_HoaDonMuaHang.setBounds(188, 0, 199, 40);
		lbl_HoaDonMuaHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lbl_HoaDonMuaHang);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 41, 611, 40);
		contentPane.add(panel_1);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setBounds(121, 11, 126, 20);
		panel_1.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBounds(257, 10, 89, 23);
		panel_1.add(btnTimKiem);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 92, 611, 187);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Ho\u00E1 \u0110\u01A1n Nh\u1EADp H\u00E0ng", "M\u00E3 Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n", "Th\u1EDDi Gian"
			}
		));
		table.setBounds(20, 24, 1, 1);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 611, 187);
		panel_2.add(scrollPane);
		
	}
}
