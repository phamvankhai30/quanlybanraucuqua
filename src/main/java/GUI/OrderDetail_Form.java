package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class OrderDetail_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ChiTietHD;
	private OrderDetails_BUS orderDetails_BUS = new OrderDetails_BUS();

	public OrderDetail_Form(int maHD) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		HienThiChiTietHoaDonTheoID(maHD);
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
		setBounds(100, 100, 630, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 594, 39);
		contentPane.add(panel);
		
		JLabel lbl_ChiTietHD = new JLabel("Chi Tiết Hoá Đơn");
		lbl_ChiTietHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ChiTietHD.setBounds(203, 0, 172, 39);
		panel.add(lbl_ChiTietHD);
		
		
		
		table_ChiTietHD = new JTable();
		table_ChiTietHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		JScrollPane scrollPane_ChiTietHD = new JScrollPane(table_ChiTietHD);
		scrollPane_ChiTietHD.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_ChiTietHD.setBounds(10, 61, 594, 163);
		contentPane.add(scrollPane_ChiTietHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 235, 594, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btn_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btn_QuayLai.setBounds(427, 11, 143, 33);
		panel_1.add(btn_QuayLai);
	}
	
	public void HienThiChiTietHoaDonTheoID(int maHD) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Mã Hoá Đơn","Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Tiền"};
		model.setColumnIdentifiers(columns);
	 
		List<Orderdetails> orderdetails =  orderDetails_BUS.listOrderDetailsByID(maHD);
		
		for(int i = 0; i<orderdetails.size(); i++) {
			model.addRow(new Object[] {
					orderdetails.get(i).getIdorders().getIdOrder(),
					orderdetails.get(i).getIdProduct(),
					orderdetails.get(i).getNameProduct(),
					orderdetails.get(i).getQuatity(),
					orderdetails.get(i).getPrice()
			});
		}
		table_ChiTietHD.setModel(model);
		  
	}

}//end
