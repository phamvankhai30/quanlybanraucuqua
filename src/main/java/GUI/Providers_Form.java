package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Providers_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLNCC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Providers_Form frame = new Providers_Form();
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
	public Providers_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 419, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_QLNCC = new JLabel("Quản Lý Nhà Cung Cấp");
		lbl_QLNCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLNCC.setBounds(87, 0, 204, 47);
		panel.add(lbl_QLNCC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 48, 565, 51);
		contentPane.add(panel_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Provider_Form add_Provider_Form  = new Add_Provider_Form ();
				add_Provider_Form.setLocationRelativeTo(null);
				add_Provider_Form.setVisible(true);
			}
		});
		btnThem.setBounds(270, 11, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Provider_Form update_Provider_Form  = new Update_Provider_Form ();
				update_Provider_Form.setLocationRelativeTo(null);
				update_Provider_Form.setVisible(true);
			}
		});
		btnSua.setBounds(369, 11, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBounds(466, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(171, 11, 89, 23);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(37, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		
		
		table_QLNCC = new JTable();
		table_QLNCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID Nh\u00E0 Cung C\u1EA5p", "T\u00EAn Nh\u00E0 Cung C\u1EA5p", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9"
			}
		));
		table_QLNCC.setBounds(154, 149, 1, 1);
		JScrollPane scrollPane_QLNCC = new JScrollPane(table_QLNCC);
		scrollPane_QLNCC.setBounds(0, 99, 565, 210);
		contentPane.add(scrollPane_QLNCC);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 146, 49);
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
		
	}

}
