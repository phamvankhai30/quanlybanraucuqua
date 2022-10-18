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

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTable table_QLNV;

	private JTextField textField_TimKiem;
	
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTimKiem;
	
	private Customers_BUS customers_BUS= new Customers_BUS();
	private Employees_BUS employee_BUS = new Employees_BUS();
	
	
	public Employees_Form() {
		initComponents();
		HienThiNhanVien();
		
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
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNhanVien();
			}
		});
		btnThem.setBounds(323, 11, 89, 23);
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNhanVien();
			}
		});
		btnSua.setBounds(422, 11, 89, 23);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaNhanVien();
			}
		});
		btnXoa.setBounds(521, 11, 89, 23);
		panel_1.add(btnXoa);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemNVTheoId();
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
		
		JButton btnReset = new JButton("Làm Mới");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiNhanVien();
			}
		});
		btnReset.setBounds(27, 6, 94, 28);
		panel_1_1_1.add(btnReset);
	}
	
	private void ThemNhanVien() {
		Add_Employee_Form add_Employee_Form = new Add_Employee_Form ();
		add_Employee_Form.setLocationRelativeTo(null);
		add_Employee_Form.setVisible(true);
	}
	private void XoaNhanVien() {
		int i = table_QLNV.getSelectedRow();
		if(i <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
		}else {
			String maNV = table_QLNV.getModel().getValueAt(i, 0).toString();
			int idNV = Integer.parseInt(maNV);

			customers_BUS.deleteCustomerById(idNV);
			JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
			HienThiNhanVien();
		}
	}
	private void SuaNhanVien() {
		int i = table_QLNV.getSelectedRow();
		if(i <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
		}else {
			String maNV = table_QLNV.getModel().getValueAt(i, 0)+"";
			String tenNV = table_QLNV.getModel().getValueAt(i, 1)+"";
			String soDienThoai = table_QLNV.getModel().getValueAt(i, 2)+"";
			String diaChi = table_QLNV.getModel().getValueAt(i, 3)+"";
			
			Update_Employee_Form update_Employee_Form = new Update_Employee_Form(maNV,tenNV,soDienThoai,diaChi);
			update_Employee_Form.setLocationRelativeTo(null);
			update_Employee_Form.setVisible(true);
		}
	}
	
	private void HienThiNhanVien() {
		
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ"};
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
	
	private  void TimKiemNVTheoId () {
		Employees_BUS employee_BUS = new Employees_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Khân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		 
		 if(textField_TimKiem.getText().equals("")) {
			 JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm Kiếm");
		 }else {
			 String maNV = textField_TimKiem.getText();
			 int idNV = Integer.parseInt(maNV);			
			 List<Users> employee = employee_BUS.searchEmployeeById(idNV);

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
