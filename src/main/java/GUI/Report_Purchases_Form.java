package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.Report_Purchases_BUS;
import Entitys.ImportBills;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Report_Purchases_Form extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_BaoCaoMH;
	private JComboBox<Object> comboBox_BaoCaoMH;
	private Report_Purchases_BUS report_Purchases_BUS = new Report_Purchases_BUS();

	public Report_Purchases_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		HienThiBaoCaoNhapHang();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Purchases_Form frame = new Report_Purchases_Form();
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
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(183, 10, 435, 51);
		contentPane.add(panel);

		JLabel lbl_BaoCaoMH = new JLabel("Báo Báo Mua Hàng");
		lbl_BaoCaoMH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_BaoCaoMH.setBounds(85, 0, 174, 51);
		panel.add(lbl_BaoCaoMH);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 72, 608, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		comboBox_BaoCaoMH = new JComboBox<Object>();
		comboBox_BaoCaoMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocBaoBaoNhap();
			}
		});
		comboBox_BaoCaoMH.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Mã Sản Phẩm Tăng Dần", "Mã Sản Phẩm Giảm Dần",
						"Mã Loại Sản Phẩm Tăng Dần", "Mã Loại Sản Phẩm Giảm Dần", "Mã Nhà Cung Cấp Tăng Dần",
						"Mã Nhà Cung Cấp Giảm Dần",
						"Số Lượng Giảm Dần", "Số Lượng Tăng Dần", "Tổng Tiền Giảm Dần", "Tổng Tiền Tăng Dần" }));
		comboBox_BaoCaoMH.setBounds(242, 10, 155, 22);
		panel_1.add(comboBox_BaoCaoMH);

		JLabel lbl_Loc = new JLabel("Lọc");
		lbl_Loc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Loc.setBounds(186, 8, 46, 22);
		panel_1.add(lbl_Loc);

		table_BaoCaoMH = new JTable();
		table_BaoCaoMH.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
						"M\u00E3 Nh\u00E0 Cung C\u1EA5p", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n",
						"Th\u1EDDi Gian" }));
		JScrollPane scrollPane_BaoCaoMH = new JScrollPane(table_BaoCaoMH);
		scrollPane_BaoCaoMH.setBounds(0, 127, 628, 175);
		contentPane.add(scrollPane_BaoCaoMH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 11, 163, 50);
		contentPane.add(panel_2);

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

	private void HienThiBaoCaoNhapHang() {
		MaSanPhamTangDan();
	}

	private void LocBaoBaoNhap() {
		if(comboBox_BaoCaoMH.getSelectedItem().equals("Mã Sản Phẩm Tăng Dần")) {
			MaSanPhamTangDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Mã Sản Phẩm Giảm Dần")) {
			MaSanPhamGiamDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Mã Loại Sản Phẩm Tăng Dần")) {
			MaLoaiSanPhamTangDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Mã Loại Sản Phẩm Giảm Dần")) {
			MaLoaiSanPhamGiamDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Mã Nhà Cung Cấp Tăng Dần")) {
			MaNhaCungCapTangDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Mã Nhà Cung Cấp Giảm Dần")) {
			MaNhaCungCapGiamDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Số Lượng Tăng Dần")) {
			SoLuongTangDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Số Lượng Giảm Dần")) {
			SoLuongGiamDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Tổng Tiền Tăng Dần")) {
			TienTangDan();
		}else if(comboBox_BaoCaoMH.getSelectedItem().equals("Tổng Tiền Giảm Dần")) {
			TienGiamDan();
		}else {
			MaSanPhamTangDan();
		}
	}
	
	private void MaSanPhamTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaSanPhamTang();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void MaSanPhamGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaSanPhamGiam();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	
	private void MaLoaiSanPhamTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaLoaiSanPhamTang();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void MaLoaiSanPhamGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaLoaiSanPhamGiam();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void MaNhaCungCapTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaNhaCungCapTang();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void MaNhaCungCapGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaNhaCungCapGiam();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}

	private void SoLuongTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.SoLuongTang();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void SoLuongGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.SoLuongGiam();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void TienTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.TienTang();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
	private void TienGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.TienGiam();

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), im.getPrice(), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
	}
	
}
