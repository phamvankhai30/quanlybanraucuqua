package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import BUS.Customers_BUS;
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
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Update_Customer_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_IdKH;
	private JTextField textField_TenKH;
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;

	private Customers_BUS customers_BUS = new Customers_BUS();

	public Update_Customer_Form(String maKH, String TenKH, String SDT, String DiaChi) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		textField_IdKH.setText(maKH);
		textField_TenKH.setText(TenKH);
		textField_SDT.setText(SDT);
		textField_DiaChi.setText(DiaChi);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Customer_Form frame = new Update_Customer_Form("", "", "", "");
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
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 262, 37);
		contentPane.add(panel);

		JLabel lbl_SuaKH = new JLabel("Sửa Khách Hàng");
		lbl_SuaKH.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaKH.setBounds(61, 0, 153, 37);
		panel.add(lbl_SuaKH);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 57, 262, 134);
		contentPane.add(panel_1);

		JLabel lbl_TenKH = new JLabel("Tên Khách Hàng");
		lbl_TenKH.setBounds(10, 42, 83, 14);
		panel_1.add(lbl_TenKH);

		JLabel lbl_DiaChi = new JLabel("Địa Chỉ");
		lbl_DiaChi.setBounds(9, 103, 84, 17);
		panel_1.add(lbl_DiaChi);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(123, 70, 129, 20);
		panel_1.add(textField_SDT);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(123, 101, 129, 20);
		panel_1.add(textField_DiaChi);

		JLabel lbl_IdKH = new JLabel("ID Khách Hàng\r\n");
		lbl_IdKH.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdKH);

		textField_IdKH = new JTextField();
		textField_IdKH.setEnabled(false);
		textField_IdKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textField_IdKH.setEditable(false);
				textField_IdKH.setBackground(Color.LIGHT_GRAY);
			}
		});
		textField_IdKH.setColumns(10);
		textField_IdKH.setBounds(123, 8, 129, 20);
		panel_1.add(textField_IdKH);

		JLabel lbl_SDT = new JLabel("Số Điện Thoại");
		lbl_SDT.setBounds(10, 78, 84, 14);
		panel_1.add(lbl_SDT);

		textField_TenKH = new JTextField();
		textField_TenKH.setColumns(10);
		textField_TenKH.setBounds(123, 39, 129, 20);
		panel_1.add(textField_TenKH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 202, 263, 53);
		contentPane.add(panel_2);

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaKhachHang();
			}
		});
		btnSua.setBounds(146, 11, 107, 31);
		panel_2.add(btnSua);

		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 113, 31);
		panel_2.add(btnQuayLai);
	}

	private void SuaKhachHang() {
		if (textField_TenKH.getText().equals("") || textField_SDT.getText().equals("")
				|| textField_DiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được bỏ trống");
		} else {
			int idCustomer = Integer.parseInt(textField_IdKH.getText());
			String tenKH = textField_TenKH.getText();
			String soDienThoai = textField_SDT.getText();
			String diaChi = textField_DiaChi.getText();
			if (checkPhone(soDienThoai)) {
				customers_BUS.updateCustomer(idCustomer,tenKH, soDienThoai, diaChi);
				JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
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
