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
		
		JButton btnBanHang = new JButton("Bán Hàng");
		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment_Form payment_Form = new Payment_Form();
				payment_Form.setLocationRelativeTo(null);
				payment_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnBanHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanHang.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\pay_bill_dollar_money_payment_icon_143261.png"));
		btnBanHang.setBounds(10, 11, 180, 38);
		panel_1.add(btnBanHang);
		
		JButton btnSanPham = new JButton("Sản phẩm");
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products_Form products_Form = new Products_Form();
				products_Form.setLocationRelativeTo(null);
				products_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPham.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-food-and-restaurantorganicveganhealthy-fooddietvegetarianvegetablesvegetablefood-4394757_119510.png"));
		btnSanPham.setBounds(10, 156, 180, 38);
		panel_1.add(btnSanPham);
		
		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\employee_icon-icons.com_66882.png"));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employees_Form employees_Form = new Employees_Form();
				employees_Form.setLocationRelativeTo(null);
				employees_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnNhanVien.setBounds(10, 226, 180, 38);
		panel_1.add(btnNhanVien);
		
		JButton btnDanhMucSP = new JButton("Danh Mục Sản Phẩm");
		btnDanhMucSP.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhMucSP.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\category_icon-icons.com_71725.png"));
		btnDanhMucSP.setBounds(10, 85, 180, 38);
		panel_1.add(btnDanhMucSP);
		btnDanhMucSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categorys_Form categorys_Form = new Categorys_Form();
				categorys_Form.setLocationRelativeTo(null);
				categorys_Form.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(318, 87, 200, 275);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers_Form customers_Form = new Customers_Form();
				customers_Form.setLocationRelativeTo(null);
				customers_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\customer_person_people_man_you_1625.png"));
		btnKhachHang.setBounds(10, 85, 180, 36);
		panel_2.add(btnKhachHang);
		
		JButton btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports_Form reports_Form = new Reports_Form();
				reports_Form.setLocationRelativeTo(null);
				reports_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnBaoCao.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaoCao.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\1486564180-finance-financial-report_81493.png"));
		btnBaoCao.setBounds(10, 228, 180, 36);
		panel_2.add(btnBaoCao);
		
		JButton btnNhaCungCap = new JButton("Nhà Cung Cấp");
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\purchasing_management_icon_149886.png"));
		btnNhaCungCap.setBounds(10, 154, 180, 36);
		panel_2.add(btnNhaCungCap);
		
		JButton btnHoaDon = new JButton("Hoá Đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\receipt_bill_invoice_price_payment_icon_187248.png"));
		btnHoaDon.setBounds(10, 11, 180, 36);
		panel_2.add(btnHoaDon);
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_Form order_Form = new Order_Form();
				order_Form.setLocationRelativeTo(null);
				order_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnNhaCungCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Providers_Form providers_Form = new Providers_Form();
				providers_Form.setLocationRelativeTo(null);
				providers_Form.setVisible(true);
				setVisible(false);
			}
		});
	}
}
