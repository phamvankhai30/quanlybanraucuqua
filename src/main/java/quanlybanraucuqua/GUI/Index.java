package quanlybanraucuqua.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Index extends JFrame {

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
					Index frame = new Index();
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
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 5, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(83, 0, 435, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Bán Rau Củ Quả");
		lblNewLabel.setBounds(164, 12, 207, 59);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(90, 11, 64, 64);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(83, 87, 200, 275);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Bán Hàng");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\pay_bill_dollar_money_payment_icon_143261.png"));
		btnNewButton.setBounds(10, 11, 180, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Sản phẩm");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-food-and-restaurantorganicveganhealthy-fooddietvegetarianvegetablesvegetablefood-4394757_119510.png"));
		btnNewButton_3.setBounds(10, 156, 180, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Nhân Viên");
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\employee_icon-icons.com_66882.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(10, 226, 180, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("Danh Mục Sản Phẩm");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\category_icon-icons.com_71725.png"));
		btnNewButton_4.setBounds(10, 85, 180, 38);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(318, 87, 200, 275);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Khách Hàng");
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\customer_person_people_man_you_1625.png"));
		btnNewButton_5.setBounds(10, 85, 180, 36);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Báo Cáo");
		btnNewButton_7.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\1486564180-finance-financial-report_81493.png"));
		btnNewButton_7.setBounds(10, 228, 180, 36);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_2 = new JButton("Nhà Cung Cấp");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\purchasing_management_icon_149886.png"));
		btnNewButton_2.setBounds(10, 154, 180, 36);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Hoá Đơn");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\receipt_bill_invoice_price_payment_icon_187248.png"));
		btnNewButton_1.setBounds(10, 11, 180, 36);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
