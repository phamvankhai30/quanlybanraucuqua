package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import BUS.ImportBills_BUS;
import Entitys.ImportBills;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Import_Bill_From extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_HDNH;
	private JTextField textField_TimKiem;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	private ImportBills_BUS importBills_BUS = new ImportBills_BUS();

	public Import_Bill_From() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		HienThiHoaDonNhap();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import_Bill_From frame = new Import_Bill_From();
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
		setBounds(100, 100, 627, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(166, 11, 279, 48);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_HoaDonMuaHang = new JLabel("Hoá Đơn Nhập Hàng");
		lbl_HoaDonMuaHang.setBounds(58, 0, 173, 48);
		lbl_HoaDonMuaHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lbl_HoaDonMuaHang);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 129, 591, 158);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		table_HDNH = new JTable();
		table_HDNH.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 Ho\u00E1 \u0110\u01A1n Nh\u1EADp H\u00E0ng", "M\u00E3 S\u1EA3n Ph\u1EA9m",
						"M\u00E3 Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "M\u00E3 Nh\u00E0 Cung C\u1EA5p",
						"S\u1ED1 L\u01B0\u1EE3ng", "T\u1ED5ng Ti\u1EC1n", "Th\u1EDDi Gian" }));
		table_HDNH.setBounds(20, 24, 1, 1);

		JScrollPane scrollPane = new JScrollPane(table_HDNH);
		scrollPane.setBounds(0, 0, 591, 157);
		panel_2.add(scrollPane);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 11, 146, 48);
		contentPane.add(panel_1_1);
		
		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnTrangChu.setBounds(0, 0, 146, 48);
		panel_1_1.add(btnTrangChu);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(455, 11, 146, 48);
		contentPane.add(panel_1_1_1);

		JButton btnReset = new JButton("Làm Mới");
		btnReset.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.setBounds(0, 0, 146, 48);
		panel_1_1_1.add(btnReset);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 70, 591, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaHoaDon();
			}
		});
		btnXoa.setBounds(294, 4, 112, 37);
		panel_1.add(btnXoa);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TimKiemHoaDonNhapTheoId();
			}
		});
		btnTimKiem.setBounds(163, 4, 124, 37);
		panel_1.add(btnTimKiem);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(29, 11, 124, 22);
		panel_1.add(textField_TimKiem);

		JButton btnChiTietHD = new JButton("Chi Tiết Hoá Đơn");
		btnChiTietHD.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\view_grid_detail_icon_154644.png"));
		btnChiTietHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChiTietHoaDonNhap();
			}
		});
		btnChiTietHD.setBounds(416, 4, 165, 37);
		panel_1.add(btnChiTietHD);

	}

	private void ChiTietHoaDonNhap() {
		int iRow = table_HDNH.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa Chọn Hoá Đơn Cần Xem");
		} else {
			int maHDN = (Integer) table_HDNH.getValueAt(iRow, 0);
			Import_Bill_Detail_Form import_Bill_Detail_Form = new Import_Bill_Detail_Form(maHDN);
			import_Bill_Detail_Form.setLocationRelativeTo(null);
			import_Bill_Detail_Form.setVisible(true);
		}

	}

	private void HienThiHoaDonNhap() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn Nhập", "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Mã Nhà Cung Cấp", "Số Lượng",
				"Giá Tiền", "Thời Gian" };
		model.setColumnIdentifiers(columns);

		List<ImportBills> importBill = importBills_BUS.listImportBill();
		for (ImportBills im : importBill) {
			model.addRow(new Object[] { im.getIdImport(), im.getProductID().getIdProduct(), im.getIdCategory(),
					im.getIdProvider(), im.getQuatity(), decimalFormat.format(im.getPrice()), im.getDate() });
			table_HDNH.setModel(model);
		}
	}

	private void XoaHoaDon() {
		int iRow = table_HDNH.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa Chọn Hoá Đơn Cần Xoá");
		} else {
			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Chắc Chắn Xoá Không",
					"Thông Báo Xác Nhận Xoá", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				int maHDN = (Integer) table_HDNH.getValueAt(iRow, 0);
				importBills_BUS.deleteImportBill(maHDN);
				JOptionPane.showMessageDialog(rootPane, "Xoá Thành Công");
				HienThiHoaDonNhap();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Bạn Đã Huỷ Xoá");
			}
		}

	}

	private void TimKiemHoaDonNhapTheoId() {
		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa Nhập ID Hoá Đơn Nhập");
		} else {
			int id = Integer.parseInt(textField_TimKiem.getText().toString());
			ImportBills importBills = importBills_BUS.searchImportBillById(id);
			if (importBills != null) {
				DefaultTableModel model = new DefaultTableModel();
				Object[] columns = { "Mã Hoá Đơn Nhập", "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Mã Nhà Cung Cấp",
						"Số Lượng", "Giá Tiền", "Thời Gian" };
				model.setColumnIdentifiers(columns);

				model.addRow(new Object[] { importBills.getIdImport(), importBills.getProductID().getIdProduct(),
						importBills.getIdCategory(), importBills.getIdProvider(), importBills.getQuatity(),
						decimalFormat.format(importBills.getPrice()), importBills.getDate() });
				table_HDNH.setModel(model);
			} else {
				JOptionPane.showMessageDialog(rootPane, "Không Tìm Thấy");
			}
		}

	}
}
