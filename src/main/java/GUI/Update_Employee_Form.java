package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BUS.Employees_BUS;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Update_Employee_Form extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_MaNV;
	private JTextField textField_TenNV;

	private JButton btnSua;
	private JButton btnQuayLai;

	private Employees_BUS employees_BUS = new Employees_BUS();

	public Update_Employee_Form(String idNV, String TenNV, String SDT, String DiaChi) {
		initComponents();
		textField_MaNV.setText(idNV);
		textField_TenNV.setText(TenNV);
		textField_SDT.setText(SDT);
		textField_DiaChi.setText(DiaChi);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Employee_Form frame = new Update_Employee_Form("", "", "", "");
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
		setBounds(100, 100, 298, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 260, 37);
		contentPane.add(panel);

		JLabel lbl_SuaNV = new JLabel("Sửa Nhân Viên");
		lbl_SuaNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaNV.setBounds(58, 0, 124, 37);
		panel.add(lbl_SuaNV);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 59, 260, 132);
		contentPane.add(panel_1);

		JLabel lbl_TenV = new JLabel("Tên Nhân Viên");
		lbl_TenV.setBounds(9, 42, 83, 14);
		panel_1.add(lbl_TenV);

		JLabel lbl_DiaChi = new JLabel("Địa Chỉ");
		lbl_DiaChi.setBounds(9, 104, 84, 14);
		panel_1.add(lbl_DiaChi);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(121, 70, 129, 20);
		panel_1.add(textField_SDT);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(121, 101, 129, 20);
		panel_1.add(textField_DiaChi);

		JLabel lbl_IdNV = new JLabel("Mã Nhân Viên\r\n");
		lbl_IdNV.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdNV);

		textField_MaNV = new JTextField();
		textField_MaNV.setEnabled(false);
		textField_MaNV.setColumns(10);
		textField_MaNV.setBounds(121, 8, 129, 20);
		panel_1.add(textField_MaNV);

		JLabel lbl_SDT = new JLabel("Số Điện Thoại");
		lbl_SDT.setBounds(9, 73, 84, 14);
		panel_1.add(lbl_SDT);

		textField_TenNV = new JTextField();
		textField_TenNV.setColumns(10);
		textField_TenNV.setBounds(121, 39, 129, 20);
		panel_1.add(textField_TenNV);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 203, 262, 53);
		contentPane.add(panel_2);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaNhanVien();
			}
		});
		btnSua.setBounds(148, 11, 104, 31);
		panel_2.add(btnSua);

		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 116, 31);
		panel_2.add(btnQuayLai);
	}

	private void SuaNhanVien() {
		if (textField_TenNV.getText().equals("") || textField_SDT.getText().equals("")
				|| textField_DiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		} else {
			String tenNV = textField_TenNV.getText();
			String soDienThoai = textField_SDT.getText();
			String diaChi = textField_DiaChi.getText();

			if (checkPhone(soDienThoai)) {
				employees_BUS.updateEmployee(tenNV, soDienThoai, diaChi);
				JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
				setVisible(false);
			}

		}
	}

	private boolean checkPhone(String phone) {
		boolean check = true;
		boolean isNumeric = phone.matches("^[0-9]+$");
		char st1 = phone.charAt(0);

		if (isNumeric == false) {
			JOptionPane.showMessageDialog(rootPane, "SDT phải là số");
			check = false;
		} else if (phone.length() != 10) {
			JOptionPane.showMessageDialog(rootPane, "SDT phải 10 số");
			check = false;
		} else if (st1 != '0') {
			JOptionPane.showMessageDialog(rootPane, "SDT phải bắt đầu là số 0");
			check = false;
		}
		return check;

	}

}
