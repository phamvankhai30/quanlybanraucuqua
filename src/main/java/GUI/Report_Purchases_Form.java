package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report_Purchases_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Purchases_Form frame = new Report_Purchases_Form();
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
	public Report_Purchases_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(164, 0, 464, 51);
		contentPane.add(panel);
		
		JLabel lbl_BaoCaoMH = new JLabel("Báo Báo Mua Hàng");
		lbl_BaoCaoMH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_BaoCaoMH.setBounds(85, 0, 174, 51);
		panel.add(lbl_BaoCaoMH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 50, 628, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField textField_TimKiem = new JTextField();
		textField_TimKiem.setBounds(84, 11, 118, 20);
		panel_1.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm\r\n");
		btnTimKiem.setBounds(212, 10, 89, 23);
		panel_1.add(btnTimKiem);
		
		JComboBox<Object> comboBox_BaoCaoMH = new JComboBox<Object>();
		comboBox_BaoCaoMH.setBounds(349, 10, 118, 22);
		panel_1.add(comboBox_BaoCaoMH);
		
		JLabel lbl_Loc = new JLabel("Lọc");
		lbl_Loc.setBounds(324, 14, 46, 14);
		panel_1.add(lbl_Loc);
		

		
		JTable table_BaoCaoMH = new JTable();
		table_BaoCaoMH.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID B\u00E1o B\u00E1o", "ID S\u1EA3n Ph\u1EA9m", "ID Nh\u00E0 Cung C\u1EA5p", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n", "Th\u1EDDi Gian"
			}
		));
		JScrollPane scrollPane_BaoCaoMH = new JScrollPane(table_BaoCaoMH);
		scrollPane_BaoCaoMH.setBounds(0, 94, 628, 219);
		contentPane.add(scrollPane_BaoCaoMH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 163, 50);
		contentPane.add(panel_2);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports_Form reports_Form = new Reports_Form();
				reports_Form.setLocationRelativeTo(null);
				reports_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(26, 11, 94, 28);
		panel_2.add(btnQuayLai);
	}

}
