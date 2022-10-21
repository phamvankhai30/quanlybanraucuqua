package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report_Sales_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_BaoCaoBH;
	private JTable table_BaoCaoBH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Sales_Form frame = new Report_Sales_Form();
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
	public Report_Sales_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(163, 0, 465, 50);
		contentPane.add(panel);
		
		JLabel lbl_BaoCaoBH = new JLabel("Báo Báo Doanh Số Bán Hàng");
		lbl_BaoCaoBH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_BaoCaoBH.setBounds(52, 0, 240, 50);
		panel.add(lbl_BaoCaoBH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 48, 628, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_BaoCaoBH = new JTextField();
		textField_BaoCaoBH.setBounds(84, 11, 118, 20);
		panel_1.add(textField_BaoCaoBH);
		textField_BaoCaoBH.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm\r\n");
		btnTimKiem.setBounds(212, 10, 89, 23);
		panel_1.add(btnTimKiem);
		
		JComboBox<Object> comboBox_Loc = new JComboBox<Object>();
		comboBox_Loc.setBounds(349, 10, 118, 22);
		panel_1.add(comboBox_Loc);
		
		JLabel lbl_Loc = new JLabel("Lọc");
		lbl_Loc.setBounds(324, 14, 46, 14);
		panel_1.add(lbl_Loc);
		

		
		table_BaoCaoBH = new JTable();
		table_BaoCaoBH.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Nh\u00E2n Vi\u00EAn", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n", "Th\u1EDDi Gian"
			}
		));
		JScrollPane scrollPane_BaoCaoBH = new JScrollPane(table_BaoCaoBH);
		scrollPane_BaoCaoBH.setBounds(0, 88, 628, 225);
		contentPane.add(scrollPane_BaoCaoBH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 163, 50);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
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
