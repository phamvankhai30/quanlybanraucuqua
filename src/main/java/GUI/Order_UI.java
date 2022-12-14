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
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Order_UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLHD;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	private Orders_BUS orders_BUS = new Orders_BUS();

	public Order_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		loadOrder();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_UI frame = new Order_UI();
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

		JButton btnTrangChu = new JButton("Trang Ch???");
		btnTrangChu.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
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

		JLabel lbl_QLHD = new JLabel("Qu???n L?? Ho?? ????n");
		lbl_QLHD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLHD.setBounds(69, 0, 172, 51);
		panel.add(lbl_QLHD);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 72, 594, 51);
		contentPane.add(panel_1);

		JButton btnXoa = new JButton("Xo??");
		btnXoa.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaHoaDon();
			}
		});
		btnXoa.setBounds(307, 11, 97, 31);
		panel_1.add(btnXoa);

		JButton btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
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

		JButton btnChiTietHD = new JButton("Chi Ti???t Ho?? ????n");
		btnChiTietHD.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\view_grid_detail_icon_154644.png"));
		btnChiTietHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiTietHoaDon();
			}
		});
		btnChiTietHD.setBounds(414, 11, 149, 31);
		panel_1.add(btnChiTietHD);

		table_QLHD = new JTable();
		table_QLHD.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M?? Ho?? ????n", "M?? Nh??n Vi??n", "M?? Kh??ch H??ng", "T???ng Ti???n", "Th???i Gian" }));
		JScrollPane scrollPane_QLHD = new JScrollPane(table_QLHD);
		scrollPane_QLHD.setBounds(10, 134, 594, 181);
		contentPane.add(scrollPane_QLHD);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(459, 10, 145, 51);
		contentPane.add(panel_1_1_1);

		JButton btnReset = new JButton("L??m M???i");
		btnReset.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadOrder();
			}
		});
		btnReset.setBounds(0, 0, 145, 51);
		panel_1_1_1.add(btnReset);

	}

	private void loadOrder() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "M?? Ho?? ????n", "M?? Kh??ch H??ng", "M?? Nh??n Vi??n", "T???ng Ti???n", "Th???i Gian" };
		model.setColumnIdentifiers(columns);

		List<Orders> listOrders = orders_BUS.listOrder();
		Object[] row = new Object[5];
		for (int i = 0; i < listOrders.size(); i++) {
			row[0] = listOrders.get(i).getIdOrder();
			row[1] = listOrders.get(i).getIdCustommer();
			row[2] = listOrders.get(i).getIdEmployee();
			row[3] = decimalFormat.format(listOrders.get(i).getTotal());
			row[4] = listOrders.get(i).getDate();

			model.addRow(row);

		}
		table_QLHD.setModel(model);
	}

	private void XoaHoaDon() {
		int iRow = table_QLHD.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a Ch???n Th??ng Tin ????? Xo??");
		} else {

			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "B???n C?? Ch???c Ch???n Xo?? Kh??ng",
					"Th??ng B??o X??c Nh???n Xo??", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				int idHD = Integer.parseInt(table_QLHD.getValueAt(iRow, 0).toString());
				orders_BUS.deleteOrder(idHD);
				JOptionPane.showMessageDialog(rootPane, "Xo?? Th??nh C??ng");
				loadOrder();
			} else {
				JOptionPane.showMessageDialog(rootPane, "B???n ???? Hu??? Xo??");
			}

		}
	}

	private void TimKiemHoaDon() {
		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a nh???p Id C???n T??m");
		} else {
			try {
				int id = Integer.parseInt(textField_TimKiem.getText());
				Orders order = orders_BUS.searchOrderById(id);
				if (order != null) {
					DefaultTableModel model = new DefaultTableModel();
					Object[] columns = { "M?? Ho?? ????n", "M?? Nh??n Vi??n", "M?? Kh??ch H??ng", "T???ng Ti???n", "Th???i Gian" };
					model.setColumnIdentifiers(columns);
					model.addRow(new Object[] { order.getIdOrder(), order.getIdEmployee(), order.getIdCustommer(),
							decimalFormat.format(order.getTotal()), order.getDate() });
					table_QLHD.setModel(model);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Kh??ng t??m th???y");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "Ch??? Nh???p S???");
			}
		}
	}

	private void ChiTietHoaDon() {
		int iRow = table_QLHD.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a Ch???n Ho?? ????n");
		} else {
			int maHD = Integer.parseInt(table_QLHD.getValueAt(iRow, 0).toString());

			OrderDetail_UI orderDetail = new OrderDetail_UI(maHD);
			orderDetail.setLocationRelativeTo(null);
			orderDetail.setVisible(true);
		}
	}

}// end
