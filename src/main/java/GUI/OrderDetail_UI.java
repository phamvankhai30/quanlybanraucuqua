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
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class OrderDetail_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_ChiTietHD;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	private OrderDetails_BUS orderDetails_BUS = new OrderDetails_BUS();

	public OrderDetail_UI(int maHD) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		loadOrderDetail(maHD);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetail_UI frame = new OrderDetail_UI(0);
					
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
		
		JLabel lbl_ChiTietHD = new JLabel("Chi Ti???t Ho?? ????n");
		lbl_ChiTietHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ChiTietHD.setBounds(203, 0, 172, 39);
		panel.add(lbl_ChiTietHD);
		
		
		
		table_ChiTietHD = new JTable();
		table_ChiTietHD.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"M?? Ho?? ????n","M?? S???n Ph???m", "T??n S???n Ph???m", "S??? L?????ng", "Gi?? Ti???n"
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
		
		JButton btnBack = new JButton("Quay L???i");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnBack.setBounds(427, 11, 143, 33);
		panel_1.add(btnBack);
	}
	
	private void loadOrderDetail(int maHD) {
		DefaultTableModel model = (DefaultTableModel) table_ChiTietHD.getModel();
		
		List<Orderdetails> orderdetails =  orderDetails_BUS.listOrderDetailsByID(maHD);
		
		for(int i = 0; i<orderdetails.size(); i++) {
			model.addRow(new Object[] {
					orderdetails.get(i).getIdorders().getIdOrder(),
					orderdetails.get(i).getIdProduct(),
					orderdetails.get(i).getNameProduct(),
					orderdetails.get(i).getQuatity(),
					decimalFormat.format(orderdetails.get(i).getPrice())
			});
		}
		table_ChiTietHD.setModel(model);
		  
	}

}//end
