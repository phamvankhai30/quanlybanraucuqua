package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.Customers_BUS;
import DTO.DisplayNumberThread;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class Add_Customer_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_MaKH;
	private JTextField textField_TenKH;
	
	private Customers_BUS customers_BUS = new Customers_BUS();
	
	public Add_Customer_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		initId();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Customer_Form frame = new Add_Customer_Form();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 262, 37);
		contentPane.add(panel);
		
		JLabel lbl_ThemKH = new JLabel("Thêm Khách Hàng");
		lbl_ThemKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemKH.setBounds(51, 0, 153, 37);
		panel.add(lbl_ThemKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 56, 262, 141);
		contentPane.add(panel_1);
		
		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng");
		lbl_TenKH.setBounds(10, 48, 83, 14);
		panel_1.add(lbl_TenKH);
		
		JLabel lbl_DiaChi = new JLabel("Địa Chỉ");
		lbl_DiaChi.setBounds(10, 104, 84, 14);
		panel_1.add(lbl_DiaChi);
		
		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(121, 70, 129, 20);
		panel_1.add(textField_SDT);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(121, 101, 129, 20);
		panel_1.add(textField_DiaChi);
		
		JLabel lbl_IdKhachHang = new JLabel("Mã Khách Hàng\r\n");
		lbl_IdKhachHang.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdKhachHang);
		
		textField_MaKH = new JTextField();
		textField_MaKH.setEnabled(false);
		textField_MaKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_MaKH.setEditable(false);
				textField_MaKH.setBackground(Color.LIGHT_GRAY);
			}
		});
		textField_MaKH.setColumns(10);
		textField_MaKH.setBounds(121, 8, 129, 20);
		panel_1.add(textField_MaKH);
		
		JLabel lbl_SDT = new JLabel("Số Điện Thoại");
		lbl_SDT.setBounds(10, 79, 84, 14);
		panel_1.add(lbl_SDT);
		
		textField_TenKH = new JTextField();
		textField_TenKH.setColumns(10);
		textField_TenKH.setBounds(121, 39, 129, 20);
		panel_1.add(textField_TenKH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 208, 262, 67);
		contentPane.add(panel_2);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ThemKhachHang();
			}
		});
		btnThem.setBounds(150, 11, 102, 45);
		panel_2.add(btnThem);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 111, 45);
		panel_2.add(btnQuayLai);
		
		
	}
	
	private void initId() {
		DisplayNumberThread id = new DisplayNumberThread(textField_MaKH);
		id.start();
	}
	
	private void ResetTextField() {
		textField_MaKH.setText("");
		textField_TenKH.setText("");
		textField_SDT.setText("");
		textField_DiaChi.setText("");
		
	}
	
	private void ThemKhachHang() {
		if(textField_TenKH.getText().equals("") || textField_SDT.getText().equals("") ||textField_DiaChi.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			customers_BUS.addCustomer(textField_TenKH.getText(),textField_SDT.getText(),textField_DiaChi.getText());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
		}
	}
	
}
