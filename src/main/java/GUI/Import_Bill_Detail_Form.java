package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.ImportBillDetails_BUS;
import Entitys.ImportBillDetails;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Import_Bill_Detail_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImportBillDetails_BUS importBillDetails_BUS = new ImportBillDetails_BUS();
	private JTable table_HDNH;

	public Import_Bill_Detail_Form(int maHDN) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		ChiTietHoaDonNhap(maHDN);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import_Bill_Detail_Form frame = new Import_Bill_Detail_Form(0);
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
		setBounds(100, 100, 630, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 594, 39);
		contentPane.add(panel);

		JLabel lbl_ChiTietHDN = new JLabel("Chi Tiết Hoá Đơn Nhập Hàng");
		lbl_ChiTietHDN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ChiTietHDN.setBounds(184, 0, 250, 39);
		panel.add(lbl_ChiTietHDN);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 214, 594, 61);
		contentPane.add(panel_1);

		JButton btn_QuayLai = new JButton("Quay Lại");
		btn_QuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_QuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btn_QuayLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btn_QuayLai.setBounds(444, 11, 140, 33);
		panel_1.add(btn_QuayLai);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 61, 594, 142);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table_HDNH = new JTable();
		table_HDNH.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table_HDNH);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(0, 0, 594, 143);
		panel_2.add(scrollPane);
	}

	private void ChiTietHoaDonNhap(int maHDN) {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Hoá Đơn Nhập", "Tên Sản Phẩm", "Mô Tả"};
		model.setColumnIdentifiers(columns);

		List<ImportBillDetails> importBillDetails = importBillDetails_BUS.ChiTietHoaDonNhap(maHDN);
		for (ImportBillDetails im : importBillDetails) {
			model.addRow(new Object[] { 
					im.getIDimportBill().getIdImport(), 
					im.getNameProduct(), 
					im.getDescription() });
			table_HDNH.setModel(model);
		}
	}
}
