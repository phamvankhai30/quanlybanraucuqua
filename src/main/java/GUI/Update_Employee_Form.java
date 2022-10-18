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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 459, 37);
		contentPane.add(panel);

		JLabel lbl_SuaNV = new JLabel("Sửa Nhân Viên");
		lbl_SuaNV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaNV.setBounds(158, 11, 153, 14);
		panel.add(lbl_SuaNV);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(106, 36, 241, 174);
		contentPane.add(panel_1);

		JLabel lbl_TenV = new JLabel("Tên Nhân Viên");
		lbl_TenV.setBounds(10, 55, 83, 14);
		panel_1.add(lbl_TenV);

		JLabel lbl_DiaChi = new JLabel("Địa Chỉ");
		lbl_DiaChi.setBounds(10, 134, 84, 14);
		panel_1.add(lbl_DiaChi);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(104, 90, 129, 20);
		panel_1.add(textField_SDT);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(104, 131, 129, 20);
		panel_1.add(textField_DiaChi);

		JLabel lbl_IdNV = new JLabel("Mã Nhân Viên\r\n");
		lbl_IdNV.setBounds(10, 11, 84, 14);
		panel_1.add(lbl_IdNV);

		textField_MaNV = new JTextField();
		textField_MaNV.setColumns(10);
		textField_MaNV.setBounds(102, 8, 129, 20);
		panel_1.add(textField_MaNV);

		JLabel lbl_SDT = new JLabel("Số Điện Thoại");
		lbl_SDT.setBounds(10, 93, 84, 14);
		panel_1.add(lbl_SDT);

		textField_TenNV = new JTextField();
		textField_TenNV.setColumns(10);
		textField_TenNV.setBounds(103, 52, 129, 20);
		panel_1.add(textField_TenNV);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 209, 459, 53);
		contentPane.add(panel_2);

		btnSua = new JButton("Sửa");
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SuaNhanVien();
			}
		});
		btnSua.setBounds(105, 11, 96, 31);
		panel_2.add(btnSua);

		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(252, 11, 96, 31);
		panel_2.add(btnQuayLai);
	}

	private void SuaNhanVien() {
		if (textField_TenNV.getText().equals("") || textField_SDT.getText().equals("")
				|| textField_DiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		} else {

			employees_BUS.updateEmployee(textField_TenNV.getText(), textField_SDT.getText(),
					textField_DiaChi.getText());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
		}
	}

	private void ResetTextField() {
		textField_MaNV.setText("");
		textField_SDT.setText("");
		textField_DiaChi.setText("");
		textField_TenNV.setText("");
	}

}
