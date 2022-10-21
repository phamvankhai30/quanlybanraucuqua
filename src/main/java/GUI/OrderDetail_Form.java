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
import BUS.OrderDetails_BUS;
import Entitys.Orderdetails;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class OrderDetail_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ChiTietHD;
	private OrderDetails_BUS orderDetails_BUS = new OrderDetails_BUS();

	public OrderDetail_Form(int idHD) {
		initComponents();
		HienThiChiTietHoaDonTheoID(idHD);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetail_Form frame = new OrderDetail_Form(0);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void initComponents()  {
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
		
			},
			new String[] {
				"Mã Ho\u00E1 \u0110\u01A1n", "Mã S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 Ti\u1EC1n"
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
	
	public void HienThiChiTietHoaDonTheoID(int idHD) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Mã Hoá Đơn","Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền"};
		model.setColumnIdentifiers(columns);
	 
		List<Orderdetails> orderdetails =  orderDetails_BUS.listOrderDetailsByID(idHD);
		for(int i = 0; i<orderdetails.size(); i++) {
			model.addRow(new Object[] {
					orderdetails.get(i).getIdOrder(),
					orderdetails.get(i).getIdProduct(),
					orderdetails.get(i).getNameProduct(),
					orderdetails.get(i).getQuatity(),
					orderdetails.get(i).getPrice()
			});
		}
		table_ChiTietHD.setModel(model);
		  
	}

}//end
