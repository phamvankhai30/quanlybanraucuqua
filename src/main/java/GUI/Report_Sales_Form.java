package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BUS.Report_Sales_BUS;
import Entitys.Orderdetails;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Report_Sales_Form extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table_BaoCaoBH;
	private JComboBox<Object> comboBox_LocBaoCao;
	private Report_Sales_BUS report_Sales_BUS = new Report_Sales_BUS();

	public Report_Sales_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		HienThiBaoCao();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Sales_Form frame = new Report_Sales_Form();
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
		setBounds(100, 100, 644, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(183, 11, 435, 50);
		contentPane.add(panel);

		JLabel lbl_BaoCaoBH = new JLabel("Báo Báo Doanh Số Bán Hàng");
		lbl_BaoCaoBH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_BaoCaoBH.setBounds(52, 0, 240, 50);
		panel.add(lbl_BaoCaoBH);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 72, 608, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		comboBox_LocBaoCao = new JComboBox<Object>();
		comboBox_LocBaoCao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocBaoCao();
			}
		});

		comboBox_LocBaoCao.setModel(new DefaultComboBoxModel<Object>(new String[] { "Mã Hoá Đơn Tăng Dần",
				"Mã Hoá Đơn Giảm Dần", "Mã Sản Phẩm Tăng Dần", "Mã Sản Phẩm Giảm Dần", "Mã Nhân Viên Tăng Dần",
				"Mã Nhân Viên Giảm Dần", "Tổng Tiền Tăng Dần", "Tổng Tiền Giảm Dần" }));
		comboBox_LocBaoCao.setBounds(225, 12, 159, 22);
		panel_1.add(comboBox_LocBaoCao);

		JLabel lbl_Loc = new JLabel("Lọc");
		lbl_Loc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Loc.setBounds(173, 10, 46, 22);
		panel_1.add(lbl_Loc);

		table_BaoCaoBH = new JTable();
		table_BaoCaoBH.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Ho\u00E1 \u0110\u01A1n", "M\u00E3 S\u1EA3n Ph\u1EA9m",
						"M\u00E3 Nh\u00E2n Vi\u00EAn", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n",
						"Th\u1EDDi Gian" }));
		JScrollPane scrollPane_BaoCaoBH = new JScrollPane(table_BaoCaoBH);
		scrollPane_BaoCaoBH.setBounds(10, 127, 608, 175);
		contentPane.add(scrollPane_BaoCaoBH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 11, 163, 50);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports_Form reports_Form = new Reports_Form();
				reports_Form.setLocationRelativeTo(null);
				reports_Form.setVisible(true);
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(0, 0, 163, 50);
		panel_2.add(btnQuayLai);
	}

	private void HienThiBaoCao() {
		MaHoaDonTangDan();
		
	}

	private void LocBaoCao() {
		if(comboBox_LocBaoCao.getSelectedItem().equals("Mã Hoá Đơn Tăng Dần")) {
			MaHoaDonTangDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Mã Hoá Đơn Giảm Dần")) {
			MaHoaDonGiamDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Mã Sản Phẩm Tăng Dần")) {
			MaSanPhamTangDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Mã Sản Phẩm Giảm Dần")) {
			MaSanPhamGiamDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Mã Nhân Viên Tăng Dần")) {
			MaNhanVienTangDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Mã Nhân Viên Giảm Dần")) {
			MaNhanVienGiamDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Tổng Tiền Tăng Dần")) {
			TongTienTangDan();
		}else if(comboBox_LocBaoCao.getSelectedItem().equals("Tổng Tiền Giảm Dần")) {
			TongTienGiamDan();
		}else {
			MaHoaDonTangDan();
		}
	}

	private void MaHoaDonTangDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoMaHoaDonTangDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}

	private void MaHoaDonGiamDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoMaHoaDonGiamDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}

	private void MaSanPhamTangDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoMaSanPhamTangDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}
	
	private void MaSanPhamGiamDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoMaSanPhamGiamDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}
	
	private void MaNhanVienTangDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoMaNhanVienTangDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}
	
	private void MaNhanVienGiamDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoMaNhanVienGiamDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}
	
	private void TongTienTangDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoTienTangDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}
	
	private void TongTienGiamDan() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn", "Mã Sản Phẩm", "Mã Nhân Viên", "Số Lượng", "Tổng Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = report_Sales_BUS.SapXepTheoTienGiamDan();
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] { 
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(), 
					orderdetails.getQuatity(), 
					orderdetails.getPrice(),
					orderdetails.getIdorders().getDate() 
			});
		}
		table_BaoCaoBH.setModel(model);
	}
}// end
