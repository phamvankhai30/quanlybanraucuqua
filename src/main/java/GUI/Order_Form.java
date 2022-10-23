package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.Orders_BUS;
import Entitys.Orders;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Order_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLHD;
	private Orders_BUS orders_BUS = new  Orders_BUS();
	
	public Order_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		HienThiHoaDon();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_Form frame = new Order_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 10, 146, 51);
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
		btnTrangChu.setBounds(0, 0, 146, 51);
		panel_1_1.add(btnTrangChu);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(166, 10, 283, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_QLHD = new JLabel("Quản Lý Hoá Đơn");
		lbl_QLHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLHD.setBounds(69, 0, 172, 51);
		panel.add(lbl_QLHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 72, 594, 51);
		contentPane.add(panel_1);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaHoaDon();
			}
		});
		btnXoa.setBounds(307, 11, 97, 31);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemHoaDon();
			}
		});
		btnTimKiem.setBounds(173, 11, 124, 31);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(39, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		JButton btnChiTietHD = new JButton("Chi Tiết Hoá Đơn");
		btnChiTietHD.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\view_grid_detail_icon_154644.png"));
		btnChiTietHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiTietHoaDon();
			}
		});
		btnChiTietHD.setBounds(414, 11, 149, 31);
		panel_1.add(btnChiTietHD);
		
		table_QLHD = new JTable();
		table_QLHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Hoá Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Tổng Tiền", "Thời Gian"
			}
		));
		JScrollPane scrollPane_QLHD = new JScrollPane(table_QLHD);
		scrollPane_QLHD.setBounds(10, 134, 594, 181);
		contentPane.add(scrollPane_QLHD);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(459, 10, 145, 51);
		contentPane.add(panel_1_1_1);
		
		JButton btnReset = new JButton("Làm Mới");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HienThiHoaDon();
			}
		});
		btnReset.setBounds(0, 0, 145, 51);
		panel_1_1_1.add(btnReset);
		
	}
	
	private void HienThiHoaDon() {
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"Mã Hoá Đơn","Mã Khách Hàng", "Mã Nhân Viên", "Tổng Tiền", "Thời Gian"};
		 model.setColumnIdentifiers(columns);
		
		 List<Orders> listOrders = orders_BUS.listOrder();
		 Object[] row = new Object[5];
		 for(int i = 0; i < listOrders.size(); i++) {
			 	row[0] = listOrders.get(i).getIdOrder();
				row[1] = listOrders.get(i).getIdCustommer();
				row[2] = listOrders.get(i).getIdEmployee();
				row[3] = listOrders.get(i).getTotal();
				row[4] = listOrders.get(i).getDate();
				
				model.addRow(row);
			 
		 }
		 table_QLHD.setModel(model);
	}

	private void XoaHoaDon() {
		int iRow = table_QLHD.getSelectedRow();
		if(iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa Chọn Thông Tin Để Xoá");
		}else {
			int idHD = Integer.parseInt(table_QLHD.getValueAt(iRow, 0).toString());
			orders_BUS.deleteOrder(idHD);
			JOptionPane.showMessageDialog(rootPane, "Xoá Thành Công");
			HienThiHoaDon();
			
		}
	}

	private void TimKiemHoaDon() {
		if(textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm");
		}else {
			DefaultTableModel model = new DefaultTableModel();
			Object[] columns = { "Mã Hoá Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Tổng Tiền", "Thời Gian"};
			model.setColumnIdentifiers(columns);
			
			int id = Integer.parseInt(textField_TimKiem.getText());
			Orders order = orders_BUS.searchOrderById(id);
			
			model.addRow(new Object[] {
					order.getIdOrder(),
					order.getIdEmployee(),
					order.getIdCustommer(),
					order.getTotal(),
					order.getDate()
			 });
			 table_QLHD.setModel(model);
		}
	}
	
	private void ChiTietHoaDon() {
		int iRow = table_QLHD.getSelectedRow();
		if(iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa Chọn Hoá Đơn");
		}else {
			int maHD = Integer.parseInt(table_QLHD.getValueAt(iRow, 0).toString());	
			
			OrderDetail_Form orderDetail = new OrderDetail_Form(maHD);
			orderDetail.setLocationRelativeTo(null);
			orderDetail.setVisible(true);
			
			
		}
	}
	
}//end
