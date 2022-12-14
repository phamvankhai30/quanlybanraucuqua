package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BUS.Providers_BUS;

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

public class Update_Provider_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MaNhaCC;
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private JTextField textField_TenNhaCC;

	private Providers_BUS provider_BUS = new Providers_BUS();

	public Update_Provider_UI(String idncc, String TenNCC, String SDT, String DiaChi) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		textField_MaNhaCC.setText(idncc);
		textField_TenNhaCC.setText(TenNCC);
		textField_SDT.setText(SDT);
		textField_DiaChi.setText(DiaChi);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Provider_UI frame = new Update_Provider_UI("", "", "", "");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 262, 37);
		contentPane.add(panel);

		JLabel lbl_SuaNhaCC = new JLabel("S???a Nh?? Cung C???p");
		lbl_SuaNhaCC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaNhaCC.setBounds(56, 0, 179, 37);
		panel.add(lbl_SuaNhaCC);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 59, 262, 131);
		contentPane.add(panel_1);

		JLabel lbl_TenNhaCC = new JLabel("T??n Nh?? Cung C???p");
		lbl_TenNhaCC.setBounds(10, 42, 110, 14);
		panel_1.add(lbl_TenNhaCC);

		JLabel lbl_DiaChi = new JLabel("?????a Ch???");
		lbl_DiaChi.setBounds(10, 104, 84, 14);
		panel_1.add(lbl_DiaChi);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(123, 70, 129, 20);
		panel_1.add(textField_SDT);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(123, 101, 129, 20);
		panel_1.add(textField_DiaChi);

		JLabel lbl_IdNhaCC = new JLabel("M?? Nh?? Cung C???p");
		lbl_IdNhaCC.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdNhaCC);

		textField_MaNhaCC = new JTextField();
		textField_MaNhaCC.setEnabled(false);
		textField_MaNhaCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_MaNhaCC.setEditable(false);
				textField_MaNhaCC.setBackground(Color.LIGHT_GRAY);
			}
		});
		textField_MaNhaCC.setColumns(10);
		textField_MaNhaCC.setBounds(123, 8, 129, 20);
		panel_1.add(textField_MaNhaCC);

		JLabel lbl_SDT = new JLabel("S??? ??i???n Tho???i");
		lbl_SDT.setBounds(10, 73, 84, 14);
		panel_1.add(lbl_SDT);

		textField_TenNhaCC = new JTextField();
		textField_TenNhaCC.setColumns(10);
		textField_TenNhaCC.setBounds(123, 39, 129, 20);
		panel_1.add(textField_TenNhaCC);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 201, 262, 57);
		contentPane.add(panel_2);

		JButton btnSua = new JButton("S???a");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaNhaCungCap();
			}
		});
		btnSua.setBounds(143, 11, 109, 31);
		panel_2.add(btnSua);

		JButton btnQuayLai = new JButton("Quay L???i");
		btnQuayLai.setIcon(new ImageIcon(
				"C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 123, 31);
		panel_2.add(btnQuayLai);

	}

	private void SuaNhaCungCap() {
		if (textField_TenNhaCC.getText().equals("") || textField_SDT.getText().equals("")
				|| textField_DiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "B???n kh??ng ???????c b??? tr???ng");
		} else {
			String soDienThoai = textField_SDT.getText();
			if (checkPhone(soDienThoai)) {
				int idProvider = Integer.parseInt(textField_MaNhaCC.getText());
				String tenNCC = textField_TenNhaCC.getText();
				String diaChi = textField_DiaChi.getText();			
				provider_BUS.updateProvider(idProvider, tenNCC, soDienThoai, diaChi);
				JOptionPane.showMessageDialog(rootPane, "C???p nh???t th??nh c??ng");
				setVisible(false);
			}
		}
	}

	private boolean checkPhone(String phone) {
		boolean check = true;
		boolean isNumeric = phone.matches("^[0-9]+$");
		char st1 = phone.charAt(0);
		if (isNumeric == false) {
			JOptionPane.showMessageDialog(rootPane, "SDT ph???i l?? s???");
			check = false;
		} else if (phone.length() != 10) {
			JOptionPane.showMessageDialog(rootPane, "SDT ph???i 10 s???");
			check = false;
		} else if (st1 != '0') {
			JOptionPane.showMessageDialog(rootPane, "SDT ph???i b???t ?????u l?? s??? 0");
			check = false;
		}
		return check;
	}

}
