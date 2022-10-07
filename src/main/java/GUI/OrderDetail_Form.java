package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderDetail_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ChiTietHD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetail_Form frame = new OrderDetail_Form();
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
	public OrderDetail_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 614, 39);
		contentPane.add(panel);
		
		JLabel lbl_ChiTietHD = new JLabel("Chi Tiết Hoá Đơn");
		lbl_ChiTietHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ChiTietHD.setBounds(219, 0, 172, 39);
		panel.add(lbl_ChiTietHD);
		
		
		
		table_ChiTietHD = new JTable();
		table_ChiTietHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, "", null},
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
				"ID Ho\u00E1 \u0110\u01A1n", "ID S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 Ti\u1EC1n"
			}
		));
		JScrollPane scrollPane_ChiTietHD = new JScrollPane(table_ChiTietHD);
		scrollPane_ChiTietHD.setBounds(0, 39, 614, 256);
		contentPane.add(scrollPane_ChiTietHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 296, 614, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btn_QuayLai.setBounds(499, 11, 105, 33);
		panel_1.add(btn_QuayLai);

	}

}
