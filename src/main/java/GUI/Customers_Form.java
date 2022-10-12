package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Customers_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLKH;

	/**
	 * Launch the application.
	 */
	public Customers_Form() {
		initComponents();
		showCustomers();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers_Form frame = new Customers_Form();
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
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 431);
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
		panel.setLayout(null);
		panel.setBounds(144, 0, 356, 39);
		contentPane.add(panel);
		
		JLabel lbl_QLKH = new JLabel("Quản Lý Khách Hàng");
		lbl_QLKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLKH.setBounds(101, 11, 174, 20);
		panel.add(lbl_QLKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 36, 659, 51);
		contentPane.add(panel_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Customer_Form add_Customer_Form = new Add_Customer_Form();
				add_Customer_Form.setLocationRelativeTo(null);
				add_Customer_Form.setVisible(true);
				
			}
		});
		btnThem.setBounds(323, 11, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table_QLKH.getSelectedRow();
				if(i <= -1) {
					JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
				}else {
					String id = table_QLKH.getModel().getValueAt(i, 0)+"";
					String ten = table_QLKH.getModel().getValueAt(i, 1)+"";
					String SDT = table_QLKH.getModel().getValueAt(i, 2)+"";
					String DiaChi = table_QLKH.getModel().getValueAt(i, 3)+"";
					Update_Customer_Form update_Customer_Form  = new Update_Customer_Form (id,ten,SDT,DiaChi);
					update_Customer_Form.setLocationRelativeTo(null);
					update_Customer_Form.setVisible(true);
				}
				
			}
		});
		btnSua.setBounds(422, 11, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_QLKH.getSelectedRow();
				if(i <= -1) {
					JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
				}else {
					String id_Customer = table_QLKH.getModel().getValueAt(i, 0).toString();
					int id = Integer.parseInt(id_Customer);

					Customers_BUS customers_BUS= new Customers_BUS();
					customers_BUS.deleteCustomerById(id);
					JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
					showCustomers();
				}
			}
		});
		btnXoa.setBounds(521, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCustomerById();
			}
		});
		btnTimKiem.setBounds(224, 11, 89, 23);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(97, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		
		
		table_QLKH = new JTable();
		table_QLKH.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				
			}
		));
		JScrollPane scrollPane_QLKH = new JScrollPane(table_QLKH);
		scrollPane_QLKH.setBounds(0, 88, 659, 304);
		contentPane.add(scrollPane_QLKH);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(499, 0, 160, 39);
		contentPane.add(panel_1_1_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCustomers();
			}
		});
		btnReset.setBounds(27, 6, 94, 28);
		panel_1_1_1.add(btnReset);
	}
	
	public void showCustomers() {

		 Customers_BUS customers_BUS = new Customers_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		
		 List<Users> customer = customers_BUS.showCustomers();
		 for(int i = 0; i < customer.size(); i++) {
			 model.addRow(new Object[] {
					 customer.get(i).getIdUser(),
					 customer.get(i).getName(),
					 customer.get(i).getPhone(),
					 customer.get(i).getAddress()
			 });
		 }
		 table_QLKH.setModel(model);

	}
	
	public  void searchCustomerById () {
		 Customers_BUS customers_BUS = new Customers_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Khách Hàng", "Tên Nhà Khách Hàng", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		 if(textField_TimKiem.getText().equals("")) {
			 JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm Kiếm");
		 }else {
			 String id = textField_TimKiem.getText();
			 int id_Customer = Integer.parseInt(id);			
			 Users customer = customers_BUS.getCustomerById(id_Customer);
		
			 model.addRow(new Object[] {
					 customer.getIdUser(),
					 customer.getName(),
					 customer.getPhone(),
					 customer.getAddress() 
			 });
			 table_QLKH.setModel(model);
		 }
		 
	}

}
