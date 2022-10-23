package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

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
					frame.setLocationRelativeTo(null);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(166, 11, 295, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBaoCao = new JLabel("Báo Báo");
		lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBaoCao.setBounds(99, 0, 81, 47);
		panel.add(lblBaoCao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 71, 450, 92);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSanPhamBan = new JButton("Sản Phẩm Đã Bán");
		btnSanPhamBan.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\pay_bill_dollar_money_payment_icon_143261.png"));
		btnSanPhamBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Sales_Form report_Sales_Form = new Report_Sales_Form();
				report_Sales_Form.setLocationRelativeTo(null);
				report_Sales_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnSanPhamBan.setBounds(10, 28, 176, 45);
		panel_1.add(btnSanPhamBan);
		
		JButton btnSanPhamMua = new JButton("Sản Phẩm Đã Mua");
		btnSanPhamMua.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\shopping-basket-add256_24909.png"));
		btnSanPhamMua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Purchases_Form aeport_Purchases_Form = new Report_Purchases_Form ();
				aeport_Purchases_Form.setLocationRelativeTo(null);
				aeport_Purchases_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnSanPhamMua.setBounds(250, 28, 176, 45);
		panel_1.add(btnSanPhamMua);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 146, 49);
		contentPane.add(panel_1_1);
		
		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(0, 0, 146, 49);
		panel_1_1.add(btnTrangChu);
	}

}
