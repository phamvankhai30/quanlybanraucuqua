package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reports_Form extends JFrame {

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
					Reports_Form frame = new Reports_Form();
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
	public Reports_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(144, 0, 332, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBaoCao = new JLabel("Báo Báo");
		lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBaoCao.setBounds(59, 0, 81, 47);
		panel.add(lblBaoCao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 51, 476, 117);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSanPhamBan = new JButton("Sản Phẩm Đã Bán");
		btnSanPhamBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Sales_Form report_Sales_Form = new Report_Sales_Form();
				report_Sales_Form.setLocationRelativeTo(null);
				report_Sales_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnSanPhamBan.setBounds(38, 28, 176, 45);
		panel_1.add(btnSanPhamBan);
		
		JButton btnSanPhamMua = new JButton("Sản Phẩm Đã Mua");
		btnSanPhamMua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Purchases_Form aeport_Purchases_Form = new Report_Purchases_Form ();
				aeport_Purchases_Form.setLocationRelativeTo(null);
				aeport_Purchases_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnSanPhamMua.setBounds(256, 28, 176, 45);
		panel_1.add(btnSanPhamMua);
		
		JPanel panel_1_1 = new JPanel();
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
		btnTrangChu.setBounds(20, 11, 101, 27);
		panel_1_1.add(btnTrangChu);
	}

}
