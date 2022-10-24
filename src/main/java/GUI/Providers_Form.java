package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Providers_Form extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLNCC;
	
	private Providers_BUS providers_BUS = new Providers_BUS();

	public Providers_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		HienThiNhaCungCap();
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

	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(166, 11, 330, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_QLNCC = new JLabel("Quản Lý Nhà Cung Cấp");
		lbl_QLNCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLNCC.setBounds(72, 0, 206, 47);
		panel.add(lbl_QLNCC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 71, 642, 51);
		contentPane.add(panel_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Provider_Form add_Provider_Form  = new Add_Provider_Form ();
				add_Provider_Form.setLocationRelativeTo(null);
				add_Provider_Form.setVisible(true);
			}
		});
		btnThem.setBounds(285, 6, 107, 32);
		panel_1.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
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
		btnSua.setBounds(402, 6, 107, 32);
		panel_1.add(btnSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaNhaCungCap();
			}
		});
		btnXoa.setBounds(525, 6, 107, 32);
		panel_1.add(btnXoa);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemNhaCCTheoId();
			}
		});
		btnTimKiem.setBounds(144, 6, 131, 32);
		panel_1.add(btnTimKiem);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(10, 11, 124, 22);
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
		scrollPane_QLNCC.setBounds(10, 133, 642, 194);
		contentPane.add(scrollPane_QLNCC);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 146, 49);
		contentPane.add(panel_1_1);
		
		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(0, 0, 146, 49);
		panel_1_1.add(btnTrangChu);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(506, 11, 146, 49);
		contentPane.add(panel_1_1_1);
		
		JButton btnReset = new JButton("Làm Mới");
		btnReset.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiNhaCungCap();
			}
		});
		btnReset.setBounds(0, 0, 146, 49);
		panel_1_1_1.add(btnReset);
		
	}
	
	
	
	private void HienThiNhaCungCap () {
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

	
	private  void TimKiemNhaCCTheoId () {
		 Providers_BUS providers_BUS = new Providers_BUS();
		 DefaultTableModel model = new DefaultTableModel();
		 Object[] columns = {"ID Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Địa Chỉ"};
		 model.setColumnIdentifiers(columns);
		 if(textField_TimKiem.getText().equals("")) {
			 JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id cần tìm kiếm");
		 }else {
			 String id = textField_TimKiem.getText();
			 int id_Provider = Integer.parseInt(id);			
			 Providers providers = providers_BUS.searchProvidersById(id_Provider);
		
			 model.addRow(new Object[] {
					 providers.getIdProvider(),
					 providers.getName(),
					 providers.getPhone(),
					providers.getAddress() 
			 });
			 table_QLNCC.setModel(model);
		 } 
	}
	
	private void XoaNhaCungCap() {
		int iRow = table_QLNCC.getSelectedRow();
		if(iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
		}else {
			
			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Chắc Chắn Xoá Không",
					"Thông Báo Xác Nhận Xoá", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				String id_Provider = table_QLNCC.getModel().getValueAt(iRow, 0).toString();
				int id = Integer.parseInt(id_Provider);
				
				providers_BUS.deleteProviderById(id);
				JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
				HienThiNhaCungCap();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Bạn Đã Huỷ Xoá");
			}
		}
	}
}
