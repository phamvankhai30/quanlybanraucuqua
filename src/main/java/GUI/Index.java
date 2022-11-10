package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane_Home;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 442);
		contentPane_Home = new JPanel();
		contentPane_Home.setBorder(new LineBorder(new Color(0, 255, 255), 2, true));

		setContentPane(contentPane_Home);
		contentPane_Home.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 12, 663, 64);
		contentPane_Home.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Bán Rau Củ Quả");
		lblNewLabel.setBounds(244, 1, 207, 63);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(170, 2, 64, 64);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, Color.GREEN));
		panel_1.setBounds(21, 87, 200, 224);
		contentPane_Home.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBanHang = new JButton("Bán Hàng");
		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment_UI payment_UI = new Payment_UI();
				payment_UI.setLocationRelativeTo(null);
				payment_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnBanHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanHang.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\shopping-basket-add256_24909.png"));
		btnBanHang.setBounds(10, 11, 180, 38);
		panel_1.add(btnBanHang);
		
		JButton btnSanPham = new JButton("Sản phẩm");
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products_UI products_UI = new Products_UI();
				products_UI.setLocationRelativeTo(null);
				products_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnSanPham.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-food-and-restaurantorganicveganhealthy-fooddietvegetarianvegetablesvegetablefood-4394757_119510.png"));
		btnSanPham.setBounds(10, 175, 180, 38);
		panel_1.add(btnSanPham);
		
		JButton btnDanhMucSP = new JButton("Danh Mục Sản Phẩm");
		btnDanhMucSP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDanhMucSP.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhMucSP.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\category_icon-icons.com_71725.png"));
		btnDanhMucSP.setBounds(10, 95, 180, 38);
		panel_1.add(btnDanhMucSP);
		btnDanhMucSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categorys_UI categorys_UI = new Categorys_UI();
				categorys_UI.setLocationRelativeTo(null);
				categorys_UI.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GREEN, Color.CYAN));
		panel_2.setBounds(241, 87, 200, 224);
		contentPane_Home.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers_UI customers_UI = new Customers_UI();
				customers_UI.setLocationRelativeTo(null);
				customers_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\customer_person_people_man_you_1625.png"));
		btnKhachHang.setBounds(10, 95, 180, 36);
		panel_2.add(btnKhachHang);
		
		JButton btnNhaCungCap = new JButton("Nhà Cung Cấp");
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\purchasing_management_icon_149886.png"));
		btnNhaCungCap.setBounds(10, 177, 180, 36);
		panel_2.add(btnNhaCungCap);
		
		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setBounds(10, 11, 180, 38);
		panel_2.add(btnNhanVien);
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\employee_icon-icons.com_66882.png"));
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employees_UI employees_UI = new Employees_UI();
				employees_UI.setLocationRelativeTo(null);
				employees_UI.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, Color.GREEN));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(458, 87, 200, 224);
		contentPane_Home.add(panel_2_1);
		
		JButton btnHonNhp = new JButton("Hoá Đơn Nhập Hàng");
		btnHonNhp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Import_Bill_UI import_Bill_UI = new Import_Bill_UI();
				import_Bill_UI.setLocationRelativeTo(null);
				import_Bill_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnHonNhp.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\bill_invoice_payment_receipt_billing_icon_191398.png"));
		btnHonNhp.setHorizontalAlignment(SwingConstants.LEFT);
		btnHonNhp.setBounds(10, 95, 180, 36);
		panel_2_1.add(btnHonNhp);
		
		JButton btnHoaDon = new JButton("Hoá Đơn Bán Hàng");
		btnHoaDon.setBounds(10, 11, 180, 36);
		panel_2_1.add(btnHoaDon);
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\receipt_bill_invoice_price_payment_icon_187248.png"));
		
		JButton btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.setBounds(10, 177, 180, 36);
		panel_2_1.add(btnBaoCao);
		btnBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports_UI reports_UI = new Reports_UI();
				reports_UI.setLocationRelativeTo(null);
				reports_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnBaoCao.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaoCao.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\1486564180-finance-financial-report_81493.png"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 328, 663, 64);
		contentPane_Home.add(panel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\32358avocado_98900.png"));
		lblNewLabel_1_1.setBounds(20, 0, 64, 64);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\artichokeicon_97037.png"));
		lblNewLabel_1_1_1.setBounds(154, 0, 64, 64);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("New label");
		lblNewLabel_1_1_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\pitahaya_123002.png"));
		lblNewLabel_1_1_2.setBounds(459, 0, 64, 64);
		panel_3.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("New label");
		lblNewLabel_1_1_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cabbage_vegetables_vegetable_food_agriculture_icon_220781.png"));
		lblNewLabel_1_1_3.setBounds(593, 0, 64, 64);
		panel_3.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\fruit_vegetable_pumpkin_1812.png"));
		lblNewLabel_1_1_1_1.setBounds(308, 0, 64, 64);
		panel_3.add(lblNewLabel_1_1_1_1);
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_UI order_UI = new Order_UI();
				order_UI.setLocationRelativeTo(null);
				order_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnNhaCungCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Providers_UI providers_UI = new Providers_UI();
				providers_UI.setLocationRelativeTo(null);
				providers_UI.setVisible(true);
				setVisible(false);
			}
		});
	}
}
