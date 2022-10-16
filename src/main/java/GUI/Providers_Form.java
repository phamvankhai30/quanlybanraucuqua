package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import BUS.Providers_BUS;
import Entitys.Providers;

import java.awt.event.ActionListener;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Providers_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField textField_TimKiem;
	JTable table_QLNCC;

	/**
	 * Launch the application.
	 */
	public Providers_Form() {
		initComponents();
		showProviders();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Providers_Form frame = new Providers_Form();
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
		setBounds(100, 100, 581, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(146, 0, 275, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_QLNCC = new JLabel("Quản Lý Nhà Cung Cấp");
		lbl_QLNCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLNCC.setBounds(39, 0, 206, 47);
		panel.add(lbl_QLNCC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 48, 565, 51);
		contentPane.add(panel_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Provider_Form add_Provider_Form  = new Add_Provider_Form ();
				add_Provider_Form.setLocationRelativeTo(null);
				add_Provider_Form.setVisible(true);
			}
		});
		btnThem.setBounds(270, 11, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_QLNCC.getSelectedRow();
				if(i <= -1) {
					JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
				}else {
					String id = table_QLNCC.getModel().getValueAt(i, 0)+"";
					String ten = table_QLNCC.getModel().getValueAt(i, 1)+"";
					String SDT = table_QLNCC.getModel().getValueAt(i, 2)+"";
					String DiaChi = table_QLNCC.getModel().getValueAt(i, 3)+"";
					Update_Provider_Form update_Provider_Form  = new Update_Provider_Form (id,ten,SDT,DiaChi);
					update_Provider_Form.setLocationRelativeTo(null);
					update_Provider_Form.setVisible(true);
				}
			}
		});
		btnSua.setBounds(369, 11, 89, 23);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_QLNCC.getSelectedRow();
				if(i <= -1) {
					JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
				}else {
					String id_Provider = table_QLNCC.getModel().getValueAt(i, 0).toString();
					int id = Integer.parseInt(id_Provider);

					Providers_BUS providers_BUS= new Providers_BUS();
					providers_BUS.deleteProviderById(id);
					JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
					showProviders();
				}
			}
		});
		btnXoa.setBounds(466, 11, 89, 23);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchProviderById();
			}
		});
		btnTimKiem.setBounds(171, 11, 89, 23);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(37, 11, 124, 22);
		panel_1.add(textField_TimKiem);
		
		
		
		table_QLNCC = new JTable();
		table_QLNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		table_QLNCC.setModel(new DefaultTableModel(
			new Object[][] {
				
				
			},
			new String[] {
					
			}
		));
		table_QLNCC.setBounds(154, 149, 1, 1);
		JScrollPane scrollPane_QLNCC = new JScrollPane(table_QLNCC);
		scrollPane_QLNCC.setBounds(0, 99, 565, 210);
		contentPane.add(scrollPane_QLNCC);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 146, 49);
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
		panel_1_1_1.setBounds(419, 0, 146, 49);
		contentPane.add(panel_1_1_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showProviders();
			}
		});
		btnReset.setBounds(27, 6, 94, 28);
		panel_1_1_1.add(btnReset);
		
	}
	
	
	
	public void showProviders () {

		 Providers_BUS providers_BUS = new Providers_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		
		 List<Providers> providers = providers_BUS.listProviders();
		 for(int i = 0; i < providers.size(); i++) {
			 model.addRow(new Object[] {
					 providers.get(i).getIdProvider(),
					 providers.get(i).getName(),
					 providers.get(i).getPhone(),
					 providers.get(i).getAddress()
					 
			 });
		 }
		 table_QLNCC.setModel(model);

	}

	
	private  void searchProviderById () {
		 Providers_BUS providers_BUS = new Providers_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		 if(textField_TimKiem.getText().equals("")) {
			 JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id cần tìm kiếm");
		 }else {
			 String id = textField_TimKiem.getText();
			 int id_Provider = Integer.parseInt(id);			
			 Providers providers = providers_BUS.getProvidersById(id_Provider);
		
			 model.addRow(new Object[] {
					 providers.getIdProvider(),
					 providers.getName(),
					 providers.getPhone(),
					providers.getAddress() 
			 });
			 table_QLNCC.setModel(model);
		 }
		 
	}
}
