package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import BUS.Category_BUS;
import Entitys.Categorys;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Categorys_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimKiem;
	private JTable table_QLLSP;

	private Category_BUS category_BUS = new Category_BUS();

	public Categorys_Form() {
		initComponents();
		HienThiLoaiSanPham();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorys_Form frame = new Categorys_Form();
					frame.setLocationRelativeTo(null);
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
		setBounds(100, 100, 670, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(166, 11, 317, 51);
		contentPane.add(panel);

		JLabel lbl_QLLoaiSP = new JLabel("Quản Lý Loại Sản Phẩm");
		lbl_QLLoaiSP.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_QLLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_QLLoaiSP.setBounds(0, 0, 317, 51);
		panel.add(lbl_QLLoaiSP);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 73, 637, 43);
		contentPane.add(panel_1);

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemLoaiSanPham();
			}
		});
		btnThem.setBounds(278, 5, 111, 34);
		panel_1.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaLoaiSanPham();
			}
		});
		btnSua.setBounds(403, 5, 99, 34);
		panel_1.add(btnSua);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\vcsconflicting_93497.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaLoaiSanPham();

			}
		});
		btnXoa.setBounds(512, 5, 115, 34);
		panel_1.add(btnXoa);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-documents07-1622836_121949.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimKiemLoaiSPTheoId();
			}
		});
		btnTimKiem.setBounds(144, 5, 124, 34);
		panel_1.add(btnTimKiem);

		textField_TimKiem = new JTextField();
		textField_TimKiem.setColumns(10);
		textField_TimKiem.setBounds(10, 11, 124, 22);
		panel_1.add(textField_TimKiem);

		table_QLLSP = new JTable();
		table_QLLSP.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m" }));
		JScrollPane scrollPane_QLLSP = new JScrollPane(table_QLLSP);
		scrollPane_QLLSP.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_QLLSP.setBounds(10, 127, 637, 232);
		contentPane.add(scrollPane_QLLSP);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 11, 146, 51);
		contentPane.add(panel_1_1);

		JButton btnTrangChu = new JButton("Trang Chủ");
		btnTrangChu.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\home_house_10811 (1).png"));
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setLocationRelativeTo(null);
				index.setVisible(true);
				setVisible(false);
			}
		});
		btnTrangChu.setBounds(0, 0, 146, 51);
		panel_1_1.add(btnTrangChu);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(501, 11, 146, 51);
		contentPane.add(panel_1_1_1);

		JButton btnReset = new JButton("Làm Mới");
		btnReset.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\power_reset_1847.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HienThiLoaiSanPham();
			}
		});
		btnReset.setBounds(0, 0, 146, 51);
		panel_1_1_1.add(btnReset);
	}

	private void HienThiLoaiSanPham() {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = { "Mã Loại Sản Phẩm", "Tên Sản Phẩm" };
		model.setColumnIdentifiers(columns);

		List<Categorys> listCategorys = category_BUS.listCategorys();
		for (int i = 0; i < listCategorys.size(); i++) {
			model.addRow(new Object[] { listCategorys.get(i).getIdCategor(), listCategorys.get(i).getName() });
		}
		table_QLLSP.setModel(model);
	}

	private void TimKiemLoaiSPTheoId() {

		if (textField_TimKiem.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Chưa nhập Id Cần Tìm Kiếm");
		} else {
			DefaultTableModel model = new DefaultTableModel();
			Object[] columns = { "Mã Loại Sản Phẩm", "Tên Loại Sản Phẩm" };
			model.setColumnIdentifiers(columns);

			String maLoaiSP = textField_TimKiem.getText();
			int idLoaiSP = Integer.parseInt(maLoaiSP);

			Categorys category = category_BUS.searchCategoryById(idLoaiSP);
			model.addRow(new Object[] { category.getIdCategor(), category.getName() });

			table_QLLSP.setModel(model);
		}
	}

	private void ThemLoaiSanPham() {
		Add_Category_Form add_Category_Form = new Add_Category_Form();
		add_Category_Form.setLocationRelativeTo(null);
		add_Category_Form.setVisible(true);
	}

	private void SuaLoaiSanPham() {
		int iRow = table_QLLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần sửa");
		} else {
			String maLoaiSP = table_QLLSP.getModel().getValueAt(iRow, 0) + "";
			String tenLoaiSP = table_QLLSP.getModel().getValueAt(iRow, 1) + "";

			Update_Category_Form update_Category = new Update_Category_Form(maLoaiSP, tenLoaiSP);
			update_Category.setLocationRelativeTo(null);
			update_Category.setVisible(true);
		}
	}

	private void XoaLoaiSanPham() {
		int iRow = table_QLLSP.getSelectedRow();
		if (iRow <= -1) {
			JOptionPane.showMessageDialog(rootPane, "Chưa chọn thông tin cần xoá");
		} else {

			int xacnhanxoa = JOptionPane.showConfirmDialog(rootPane, "Bạn Có Chắc Chắn Xoá Không",
					"Thông Báo Xác Nhận Xoá", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (xacnhanxoa == JOptionPane.YES_OPTION) {
				String maLoaiSP = table_QLLSP.getModel().getValueAt(iRow, 0) + "";
				int idLoaiSP = Integer.parseInt(maLoaiSP);
				category_BUS.deleteCategoryById(idLoaiSP);
				JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
				HienThiLoaiSanPham();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Bạn Đã Huỷ Xoá");
			}

		}
	}
}
