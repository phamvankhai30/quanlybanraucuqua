package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.OrderDetails_BUS;
import BUS.Orders_BUS;
import Entitys.Orderdetails;
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

public class Order_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLHD;
	private Orders_BUS orders_BUS = new  Orders_BUS();
	private OrderDetails_BUS orderDetails_BUS = new OrderDetails_BUS();
	
	/**
	 * Launch the application.
	 */
	public Order_Form() {
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
		setBounds(100, 100, 630, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 146, 39);
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
		btnTrangChu.setBounds(27, 6, 94, 28);
		panel_1_1.add(btnTrangChu);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(147, 0, 467, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_QLHD = new JLabel("Quản Lý Hoá Đơn");
		lbl_QLHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLHD.setBounds(128, 0, 172, 39);
		panel.add(lbl_QLHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 39, 614, 51);
		contentPane.add(panel_1);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaHoaDon();
			}
		});
		btnXoa.setBounds(376, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemHoaDon();
			}
		});
		btnTimKiem.setBounds(261, 11, 89, 23);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(127, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		JButton btnChiTietHD = new JButton("Chi Tiết Hoá Đơn");
		btnChiTietHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiTietHoaDon();
			}
		});
		btnChiTietHD.setBounds(475, 11, 129, 23);
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
		scrollPane_QLHD.setBounds(0, 89, 614, 256);
		contentPane.add(scrollPane_QLHD);
		
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
			List<Orderdetails> listOrderDetail = orderDetails_BUS.listAllOrderDetail();
			
			for(Orderdetails orderdetails : listOrderDetail) {
				int idHD = orderdetails.getIdOrder();
				if(maHD == idHD) {
					maHD = idHD;
					
					break;
				}
			}
			OrderDetail_Form orderDetail = new OrderDetail_Form(maHD);
			orderDetail.setLocationRelativeTo(null);
			orderDetail.setVisible(true);
			
			
		}
	}
	
}//end
