package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.Customers_BUS;
import Entitys.Users;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Customers_UI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField textField_TimKiem;
	private JTable table_QLKH;

	private Customers_BUS customers_BUS = new Customers_BUS();

	public Customers_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		loadCustomer();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers_UI frame = new Customers_UI();
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
		setBounds(100, 100, 678, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 146, 51);
		contentPane.add(panel_1_1);

		JButton btnHome = new JButton("Trang Chủ");
		btnHome.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setBounds(0, 0, 146, 51);
		panel_1_1.add(btnHome);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(166, 11, 330, 51);
		contentPane.add(panel);

		JLabel lbl_QLKH = new JLabel("Quản Lý Khách Hàng");
		lbl_QLKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLKH.setBounds(89, 0, 174, 51);
		panel.add(lbl_QLKH);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 73, 642, 51);
		contentPane.add(panel_1);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_Customer_UI add_Customer_UI = new Add_Customer_UI();
				add_Customer_UI.setLocationRelativeTo(null);
				add_Customer_UI.setVisible(true);

			}
		});
		btnAdd.setBounds(271, 5, 112, 40);
		panel_1.add(btnAdd);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnUpdate();
			}
		});
		btnUpdate.setBounds(393, 5, 106, 40);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Xoá");
		btnDelete.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaKhachHang();
			}
		});
		btnDelete.setBounds(509, 5, 106, 40);
		panel_1.add(btnDelete);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemKHTheoId();
			}
		});
		btnSearch.setBounds(144, 5, 117, 40);
		panel_1.add(btnSearch);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(10, 11, 124, 22);
		panel_1.add(textField_TimKiem);

		table_QLKH = new JTable();
		table_QLKH.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] {
				"ID Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ"
		}));
		JScrollPane scrollPane_QLKH = new JScrollPane(table_QLKH);
		scrollPane_QLKH.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_QLKH.setBounds(10, 135, 642, 151);
		contentPane.add(scrollPane_QLKH);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(506, 11, 146, 51);
		contentPane.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btnReset = new JButton("Làm Mới");
		btnReset.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadCustomer();
			}
		});
		btnReset.setBounds(0, 0, 146, 51);
		panel_1_1_1.add(btnReset);
	}

private void btnUpdate(){
	int i = table_QLKH.getSelectedRow();
	if (i <= -1) {
		JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
	} else {
			String idKH = table_QLKH.getModel().getValueAt(i, 0) + "";
			String ten = table_QLKH.getModel().getValueAt(i, 1) + "";
			String SDT = table_QLKH.getModel().getValueAt(i, 2) + "";
			String DiaChi = table_QLKH.getModel().getValueAt(i, 3) + "";
			Update_Customer_UI update_Customer_UI = new Update_Customer_UI(idKH, ten, SDT, DiaChi);
			update_Customer_UI.setLocationRelativeTo(null);
			update_Customer_UI.setVisible(true);
	}
}
	private void XoaKhachHang() {
		int iRow = table_QLKH.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
		} else {
			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Chắc Chắn Xoá Không",
					"Thông Báo Xác Nhận Xoá", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);			
			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				String maKH = table_QLKH.getModel().getValueAt(iRow, 0).toString();
				int idKH = Integer.parseInt(maKH);
				customers_BUS.deleteCustomerById(idKH);
				JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
				loadCustomer();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Bạn Đã Huỷ Xoá");
			}
		}
	}

	private void loadCustomer() {
		DefaultTableModel model = (DefaultTableModel) table_QLKH.getModel();
		List<Users> listCustomers = customers_BUS.listCustomers();
		for (int i = 0; i < listCustomers.size(); i++) {
			model.addRow(new Object[] {
				listCustomers.get(i).getIdUser(), 
				listCustomers.get(i).getName(),
				listCustomers.get(i).getPhone(), 
				listCustomers.get(i).getAddress() });
		}
		table_QLKH.setModel(model);
	}

	private void TimKiemKHTheoId() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "ID Khách Hàng", "Tên Nhà Khách Hàng", "Số Điện Thoại", "Địa Chỉ" };
		model.setColumnIdentifiers(columns);

		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm Kiếm");
		} else {
			String maKH = textField_TimKiem.getText();
			int idKH = Integer.parseInt(maKH);
			List<Users> listCustomers = customers_BUS.searchCustomerById(idKH);
			for (int i = 0; i < listCustomers.size(); i++) {
				model.addRow(new Object[] { listCustomers.get(i).getIdUser(), listCustomers.get(i).getName(),
						listCustomers.get(i).getPhone(), });
			}
			table_QLKH.setModel(model);
		}
	}

}
