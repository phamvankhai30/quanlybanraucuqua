package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Employees_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTable table_QLNV;

	private JTextField textField_TimKiem;
	
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTimKiem;
	
	
	private Employees_BUS employee_BUS = new Employees_BUS();
	
	
	public Employees_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		loadEmployees();
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees_UI frame = new Employees_UI();
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
		setBounds(100, 100, 680, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(166, 11, 333, 48);
		contentPane.add(panel);
		
		JLabel lbl_QLNV = new JLabel("Qu???n L?? Nh??n Vi??n\r\n");
		lbl_QLNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLNV.setBounds(101, 0, 159, 48);
		panel.add(lbl_QLNV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 70, 642, 48);
		contentPane.add(panel_1);
		
		btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemNhanVien();
			}
		});
		btnThem.setBounds(278, 4, 116, 37);
		panel_1.add(btnThem);
		
		btnSua = new JButton("S???a");
		btnSua.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNhanVien();
			}
		});
		btnSua.setBounds(404, 4, 110, 37);
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xo??");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaNhanVien();
			}
		});
		btnXoa.setBounds(524, 4, 108, 37);
		panel_1.add(btnXoa);
		
		btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemNVTheoId();
			}
		});
		btnTimKiem.setBounds(144, 4, 124, 37);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(10, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		table_QLNV = new JTable();
		table_QLNV.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"M?? Nh??n Vi??n", "T??n Nh??n Vi??n", "S??? ??i???n Tho???i", "?????a Ch???"
			}
		));
		JScrollPane scrollPane_QLNV = new JScrollPane(table_QLNV);
		scrollPane_QLNV.setBounds(10, 129, 642, 157);
		contentPane.add(scrollPane_QLNV);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 146, 48);
		contentPane.add(panel_1_1);
		
		JButton btnTrangChu = new JButton("Trang Ch???");
		btnTrangChu.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(0, 0, 146, 48);
		panel_1_1.add(btnTrangChu);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(509, 11, 143, 48);
		contentPane.add(panel_1_1_1);
		
		JButton btnReset = new JButton("L??m M???i");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadEmployees();
			}
		});
		btnReset.setBounds(0, 0, 143, 48);
		panel_1_1_1.add(btnReset);
	}
	
	private void ThemNhanVien() {
		Add_Employee_UI add_Employee_UI = new Add_Employee_UI ();
		add_Employee_UI.setLocationRelativeTo(null);
		add_Employee_UI.setVisible(true);
	}
	private void XoaNhanVien() {
		int i = table_QLNV.getSelectedRow();
		if(i <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a ch???n th??ng tin c???n xo??");
		}else {
			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "B???n C?? Ch???c Ch???n Xo?? Kh??ng",
					"Th??ng B??o X??c Nh???n Xo??", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				String maNV = table_QLNV.getModel().getValueAt(i, 0).toString();
				int idNV = Integer.parseInt(maNV);
				employee_BUS.deleteEmployeeById(idNV);
				JOptionPane.showMessageDialog(rootPane, "Xo?? th??nh c??ng");
				loadEmployees();
			} else {
				JOptionPane.showMessageDialog(rootPane, "B???n ???? Hu??? Xo??");
			}
		}
	}
	private void SuaNhanVien() {
		int i = table_QLNV.getSelectedRow();
		if(i <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Ch??a ch???n th??ng tin c???n s???a");
		}else {
			String maNV = table_QLNV.getModel().getValueAt(i, 0)+"";
			String tenNV = table_QLNV.getModel().getValueAt(i, 1)+"";
			String soDienThoai = table_QLNV.getModel().getValueAt(i, 2)+"";
			String diaChi = table_QLNV.getModel().getValueAt(i, 3)+"";
			
			Update_Employee_UI update_Employee_UI = new Update_Employee_UI(maNV,tenNV,soDienThoai,diaChi);
			update_Employee_UI.setLocationRelativeTo(null);
			update_Employee_UI.setVisible(true);
		}
	}
	
	private void loadEmployees() {
		 DefaultTableModel model = (DefaultTableModel) table_QLNV.getModel();	
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
		 if(textField_TimKiem.getText().equals("")) {
			 JOptionPane.showMessageDialog(rootPane, "Ch??a nh???p Id C???n T??m Ki???m");
		 }else {
			try {
				 int idNV = Integer.parseInt(textField_TimKiem.getText());			
				 List<Users> employee = employee_BUS.searchEmployeeById(idNV);	 
				 if(employee != null) {
					 DefaultTableModel model = new DefaultTableModel();
					 Object[] columns = {"ID Kh??n Vi??n", "T??n Nh??n Vi??n", "S??? ??i???n Tho???i", "?????a Ch???"};
					 model.setColumnIdentifiers(columns);
					 for(int i = 0; i < employee.size(); i++) {
						 model.addRow(new Object[] {
								 employee.get(i).getIdUser(),
								 employee.get(i).getName(),
								 employee.get(i).getPhone(),
								 employee.get(i).getAddress()
						 });
					 }
					 table_QLNV.setModel(model); 
				 }else {
					 JOptionPane.showMessageDialog(rootPane, "Kh??ng t??m th???y");
				 }
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "Ch??? ???????c nh???p s???");
			}

		 }
		 
	}
}
