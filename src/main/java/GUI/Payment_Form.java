package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Payment_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ThanhToanHD;
	private JTable table_HoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment_Form frame = new Payment_Form();
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
	public Payment_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(145, 0, 403, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ThanhToanHD = new JLabel("Thanh Toán Hoá Đơn");
		lbl_ThanhToanHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThanhToanHD.setBounds(126, 11, 177, 28);
		panel.add(lbl_ThanhToanHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 146, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(21, 11, 94, 27);
		panel_1.add(btnTrangChu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(548, 0, 246, 393);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_HoaDon = new JLabel("Hoá Đơn");
		lbl_HoaDon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_HoaDon.setBounds(107, 11, 69, 20);
		panel_3.add(lbl_HoaDon);
		
		
		
		table_HoaDon = new JTable();
		table_HoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên Sản Phẩm", "Số Lượng", "Giá Tiền"
			}
		));
		JScrollPane scrollPane_HoaDon = new JScrollPane(table_HoaDon);
		scrollPane_HoaDon.setBounds(0, 106, 246, 153);
		panel_3.add(scrollPane_HoaDon);
		
		JLabel lbl_ThoiGian = new JLabel("Thời Gian");
		lbl_ThoiGian.setBounds(10, 31, 69, 14);
		panel_3.add(lbl_ThoiGian);
		
		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng");
		lbl_TenKH.setBounds(10, 56, 104, 14);
		panel_3.add(lbl_TenKH);
		
		JLabel lbl_NVThuNgan = new JLabel("Nhân Viên Thu Ngân");
		lbl_NVThuNgan.setBounds(10, 81, 114, 14);
		panel_3.add(lbl_NVThuNgan);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng tiền");
		lblNewLabel_5.setBounds(10, 270, 52, 14);
		panel_3.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Thanh Toán");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(132, 343, 104, 37);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBounds(10, 295, 104, 37);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Xoá");
		btnNewButton_3.setBounds(10, 343, 104, 37);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cập nhật");
		btnNewButton_4.setBounds(132, 295, 104, 37);
		panel_3.add(btnNewButton_4);

		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(0, 51, 548, 342);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		table_ThanhToanHD = new JTable();
		table_ThanhToanHD.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID Sản Phẩm", "ID Loại Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền"
			}
		));
		JScrollPane scrollPane_ThanhToanHD = new JScrollPane(table_ThanhToanHD);
		scrollPane_ThanhToanHD.setBounds(0, 0, 548, 342);
		panel_4.add(scrollPane_ThanhToanHD);
		
		

	}
}
