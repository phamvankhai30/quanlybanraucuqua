package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.Customers_BUS;
import BUS.Employees_BUS;
import Entitys.Users;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Employees_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLNV;

	/**
	 * Launch the application.
	 */
	public Employees_Form() {
		initComponents();
		showEmployees();
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees_Form frame = new Employees_Form();
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(147, 0, 362, 39);
		contentPane.add(panel);
		
		JLabel lbl_QLNV = new JLabel("Quản Lý Nhân Viên\r\n");
		lbl_QLNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLNV.setBounds(101, 11, 174, 20);
		panel.add(lbl_QLNV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 41, 655, 48);
		contentPane.add(panel_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Employee_Form add_Employee_Form = new Add_Employee_Form ();
				add_Employee_Form.setLocationRelativeTo(null);
				add_Employee_Form.setVisible(true);
				
				
			}
		});
		btnThem.setBounds(323, 11, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_QLNV.getSelectedRow();
				if(i <= -1) {
					JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
				}else {
					String id = table_QLNV.getModel().getValueAt(i, 0)+"";
					String ten = table_QLNV.getModel().getValueAt(i, 1)+"";
					String SDT = table_QLNV.getModel().getValueAt(i, 2)+"";
					String DiaChi = table_QLNV.getModel().getValueAt(i, 3)+"";
					Update_Employee_Form update_Employee_Form = new Update_Employee_Form(id,ten,SDT,DiaChi);
					update_Employee_Form.setLocationRelativeTo(null);
					update_Employee_Form.setVisible(true);
				}
				
			}
		});
		btnSua.setBounds(422, 11, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_QLNV.getSelectedRow();
				if(i <= -1) {
					JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
				}else {
					String id_Customer = table_QLNV.getModel().getValueAt(i, 0).toString();
					int id = Integer.parseInt(id_Customer);

					Customers_BUS customers_BUS= new Customers_BUS();
					customers_BUS.deleteCustomerById(id);
					JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
					showEmployees();
				}
			}
		});
		btnXoa.setBounds(521, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEmployeeById();
			}
		});
		btnTimKiem.setBounds(224, 11, 89, 23);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(97, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		table_QLNV = new JTable();
		table_QLNV.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				
			}
		));
		JScrollPane scrollPane_QLNV = new JScrollPane(table_QLNV);
		scrollPane_QLNV.setBounds(0, 89, 659, 304);
		contentPane.add(scrollPane_QLNV);
		
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
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(509, 0, 146, 39);
		contentPane.add(panel_1_1_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEmployees();
			}
		});
		btnReset.setBounds(27, 6, 94, 28);
		panel_1_1_1.add(btnReset);
	}
	
	public void showEmployees() {

		Employees_BUS employee_BUS = new Employees_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		
		 List<Users> employee = employee_BUS.listEmployee();
		 for(int i = 0; i < employee.size(); i++) {
			 model.addRow(new Object[] {
					 employee.get(i).getIdUser(),
					 employee.get(i).getName(),
					 employee.get(i).getPhone(),
					 employee.get(i).getAddress()
			 });
		 }
		 table_QLNV.setModel(model);

	}
	
	public  void searchEmployeeById () {
		Employees_BUS employee_BUS = new Employees_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Khân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		 if(textField_TimKiem.getText().equals("")) {
			 JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm Kiếm");
		 }else {
			 String id = textField_TimKiem.getText();
			 int id_Employee = Integer.parseInt(id);			
			 List<Users> employee = employee_BUS.searchEmployeeById(id_Employee);
		
			 for(int i = 0; i < employee.size(); i++) {
				 model.addRow(new Object[] {
						 employee.get(i).getIdUser(),
						 employee.get(i).getName(),
						 employee.get(i).getPhone(),
						 employee.get(i).getAddress()
				 });
			 }
			 table_QLNV.setModel(model);

		 }
		 
	}
}
