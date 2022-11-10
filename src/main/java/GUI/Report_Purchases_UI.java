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
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Report_Purchases_UI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_BaoCaoMH;
	private JComboBox<Object> comboBox_BaoCaoMH;
	private Locale locale = new Locale("vi", "VN");
	private JLabel lbl_ChiTieu;
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	private Report_Purchases_BUS report_Purchases_BUS = new Report_Purchases_BUS();

	public Report_Purchases_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		LocBaoBaoNhap();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Purchases_UI frame = new Report_Purchases_UI();
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
		setBounds(100, 100, 644, 405);
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
				new Object[][] {  },
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "M\u00E3 Lo\u1EA1i S\u1EA3n Ph\u1EA9m",
						"M\u00E3 Nh\u00E0 Cung C\u1EA5p", "S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n",
						"Th\u1EDDi Gian" }));
		JScrollPane scrollPane_BaoCaoMH = new JScrollPane(table_BaoCaoMH);
		scrollPane_BaoCaoMH.setBounds(10, 127, 608, 175);
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
				Reports_UI reports_UI = new Reports_UI();
				reports_UI.setLocationRelativeTo(null);
				reports_UI.setVisible(true);
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(0, 0, 163, 50);
		panel_2.add(btnQuayLai);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 313, 608, 44);
		contentPane.add(panel_1_1);
		
		JLabel lblTngChiTiu = new JLabel("Tổng Chi Tiêu :");
		lblTngChiTiu.setForeground(new Color(0, 191, 255));
		lblTngChiTiu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTngChiTiu.setBounds(286, 11, 125, 22);
		panel_1_1.add(lblTngChiTiu);
		
		lbl_ChiTieu = new JLabel("");
		lbl_ChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_ChiTieu.setBounds(420, 11, 131, 19);
		panel_1_1.add(lbl_ChiTieu);
	}

	private void HienThiBaoCaoNhapHang(List<ImportBills> importbill) {
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Sản Phẩm", "Mã Loại Sản Phâm", "Mã Nhà Cung Cấp", "Số Lượng", "Tổng Tiền",
				"Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<ImportBills> importBill = importbill;
		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getProductID().getIdProduct(), im.getIdCategory(), im.getIdProvider(),
					im.getQuatity(), decimalFormat.format(im.getPrice()), im.getDate() });
			table_BaoCaoMH.setModel(model);
		}
		TongChiTieu();
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
		}
	}
	
	private void MaSanPhamTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaSanPhamTang();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void MaSanPhamGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaSanPhamGiam();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	
	private void MaLoaiSanPhamTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaLoaiSanPhamTang();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void MaLoaiSanPhamGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaLoaiSanPhamGiam();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void MaNhaCungCapTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaNhaCungCapTang();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void MaNhaCungCapGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.MaNhaCungCapGiam();
		HienThiBaoCaoNhapHang(importBill);
	}

	private void SoLuongTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.SoLuongTang();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void SoLuongGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.SoLuongGiam();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void TienTangDan() {
		List<ImportBills> importBill = report_Purchases_BUS.TienTang();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void TienGiamDan() {
		List<ImportBills> importBill = report_Purchases_BUS.TienGiam();
		HienThiBaoCaoNhapHang(importBill);
	}
	
	private void TongChiTieu() {
		int countRow = table_BaoCaoMH.getRowCount();
		double sum = 0;
		if(countRow > 0) {
			for(int i = 0; i < countRow; i++) {
				
				sum = sum + Double.parseDouble(table_BaoCaoMH.getValueAt(i, 4).toString().replaceAll("\\D+",""));
			}
		}
	
		lbl_ChiTieu.setText(decimalFormat.format(sum));
	}
}
