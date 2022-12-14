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
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.util.List;
import java.util.Locale;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Report_Sales_UI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table_BaoCaoBH;
	private JLabel lbl_TongDoanhThu;
	private JComboBox<Object> comboBox_FilterReportSales;
	private Locale locale = new Locale("vi", "VN");
	private DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	private Report_Sales_BUS report_Sales_BUS = new Report_Sales_BUS();

	public Report_Sales_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		LocBaoCao();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Sales_UI frame = new Report_Sales_UI();
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
		setBounds(100, 100, 644, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(183, 11, 435, 50);
		contentPane.add(panel);

		JLabel lbl_BaoCaoBH = new JLabel("B??o B??o Doanh S??? B??n H??ng");
		lbl_BaoCaoBH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_BaoCaoBH.setBounds(52, 0, 240, 50);
		panel.add(lbl_BaoCaoBH);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 72, 608, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		comboBox_FilterReportSales = new JComboBox<Object>();
		comboBox_FilterReportSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocBaoCao();
			}
		});

		comboBox_FilterReportSales.setModel(new DefaultComboBoxModel<Object>(new String[] { "M?? Ho?? ????n T??ng D???n",
				"M?? Ho?? ????n Gi???m D???n", "M?? S???n Ph???m T??ng D???n", "M?? S???n Ph???m Gi???m D???n", "M?? Nh??n Vi??n T??ng D???n",
				"M?? Nh??n Vi??n Gi???m D???n", "T???ng Ti???n T??ng D???n", "T???ng Ti???n Gi???m D???n" }));
		comboBox_FilterReportSales.setBounds(225, 12, 159, 22);
		panel_1.add(comboBox_FilterReportSales);

		JLabel lbl_Loc = new JLabel("L???c");
		lbl_Loc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Loc.setBounds(173, 10, 46, 22);
		panel_1.add(lbl_Loc);

		table_BaoCaoBH = new JTable();
		table_BaoCaoBH.setModel(new DefaultTableModel(
				new Object[][] {  },
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

		JButton btnQuayLai = new JButton("Quay L???i");
		btnQuayLai.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
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
		
		JLabel lblNewLabel = new JLabel("T???ng Doanh Thu :");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(286, 11, 125, 22);
		panel_1_1.add(lblNewLabel);
		
		lbl_TongDoanhThu = new JLabel("");
		lbl_TongDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_TongDoanhThu.setBounds(420, 11, 131, 19);
		panel_1_1.add(lbl_TongDoanhThu);
	}

	private void loadReportSales(List<Object[]> listReport) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "M?? Ho?? ????n", "M?? S???n Ph???m", "M?? Nh??n Vi??n", "S??? L?????ng", "T???ng Ti???n", "Th???i Gian" };
		model.setColumnIdentifiers(columns);

		List<Object[]> list = listReport;
		
		for (Object[] obj : list) {
			Orderdetails orderdetails = (Orderdetails) obj[0];
			model.addRow(new Object[] {
					orderdetails.getIdorders().getIdOrder(), 
					orderdetails.getIdProduct(),
					orderdetails.getIdorders().getIdEmployee(),
					orderdetails.getQuatity(), 
					decimalFormat.format(orderdetails.getPrice()),
					orderdetails.getIdorders().getDate() });
		}
		table_BaoCaoBH.setModel(model);
		TongDoanhThu();
	}

	private void LocBaoCao() {
		if (comboBox_FilterReportSales.getSelectedItem().equals("M?? Ho?? ????n T??ng D???n")) {
			MaHoaDonTangDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("M?? Ho?? ????n Gi???m D???n")) {
			MaHoaDonGiamDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("M?? S???n Ph???m T??ng D???n")) {
			MaSanPhamTangDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("M?? S???n Ph???m Gi???m D???n")) {
			MaSanPhamGiamDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("M?? Nh??n Vi??n T??ng D???n")) {
			MaNhanVienTangDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("M?? Nh??n Vi??n Gi???m D???n")) {
			MaNhanVienGiamDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("T???ng Ti???n T??ng D???n")) {
			TongTienTangDan();
		} else if (comboBox_FilterReportSales.getSelectedItem().equals("T???ng Ti???n Gi???m D???n")) {
			TongTienGiamDan();
		}
	}

	private void MaHoaDonTangDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByIdOrderASC();
		loadReportSales(listReport);
	}

	private void MaHoaDonGiamDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByIdOrderDESC();
		loadReportSales(listReport);
	}

	private void MaSanPhamTangDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByIdProductASC();
		loadReportSales(listReport);
	}

	private void MaSanPhamGiamDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByIdProductDESC();
		loadReportSales(listReport);
	}

	private void MaNhanVienTangDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByIdEmployeeASC();
		loadReportSales(listReport);
	}

	private void MaNhanVienGiamDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByIdEmployeeDESC();
		loadReportSales(listReport);
	}

	private void TongTienTangDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByPriceASC();
		loadReportSales(listReport);
	}

	private void TongTienGiamDan() {
		List<Object[]> listReport = report_Sales_BUS.OrderByPriceDESC();
		loadReportSales(listReport);

	}
	
	private void TongDoanhThu() {
		int countRow = table_BaoCaoBH.getRowCount();
		double sum = 0;
		if(countRow > 0) {
			for(int i = 0; i < countRow; i++) {
				sum = sum + Double.parseDouble(table_BaoCaoBH.getValueAt(i, 4).toString().replaceAll("\\D+",""));
			}
		}
		lbl_TongDoanhThu.setText(decimalFormat.format(sum));
	}
}// end
