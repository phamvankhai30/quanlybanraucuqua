package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.Category_BUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Category_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TenLoaiSP;
	private JTextField textField_IdLoaiSP;
	
	private Category_BUS category_BUS = new Category_BUS();


	public Update_Category_Form(String maLoaiSP, String tenLoaiSP) {
		initComponents();
		textField_IdLoaiSP.setText(maLoaiSP);
		textField_TenLoaiSP.setText(tenLoaiSP);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Category_Form frame = new Update_Category_Form("","");
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
		setBounds(100, 100, 466, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 450, 37);
		contentPane.add(panel);
		
		JLabel lbl_SuaLoaiSP = new JLabel("Sửa Loại Sản Phẩm");
		lbl_SuaLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaLoaiSP.setBounds(127, 11, 181, 14);
		panel.add(lbl_SuaLoaiSP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(81, 36, 288, 141);
		contentPane.add(panel_1);
		
		JLabel lbl_TenLoaiSP = new JLabel("Tên Loại Sản Phẩm");
		lbl_TenLoaiSP.setBounds(0, 94, 129, 14);
		panel_1.add(lbl_TenLoaiSP);
		
		textField_TenLoaiSP = new JTextField();
		textField_TenLoaiSP.setColumns(10);
		textField_TenLoaiSP.setBounds(128, 91, 160, 20);
		panel_1.add(textField_TenLoaiSP);
		
		JLabel lbl_IdLoaiSP = new JLabel("ID Loại Sản Phẩm\r\n");
		lbl_IdLoaiSP.setBounds(0, 35, 108, 14);
		panel_1.add(lbl_IdLoaiSP);
		
		textField_IdLoaiSP = new JTextField();
		textField_IdLoaiSP.setColumns(10);
		textField_IdLoaiSP.setBounds(128, 32, 160, 20);
		panel_1.add(textField_IdLoaiSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 176, 450, 59);
		contentPane.add(panel_2);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaLoaiSanPham();
				
			}
		});
		btnSua.setBounds(83, 17, 96, 31);
		panel_2.add(btnSua);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
				
			}
		});
		btnQuayLai.setBounds(276, 17, 96, 31);
		panel_2.add(btnQuayLai);
	}
	private void ResetTextField() {
		textField_TenLoaiSP.setText("");
	}
	private void SuaLoaiSanPham() {
		if(textField_TenLoaiSP.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			category_BUS.updateCategory(textField_TenLoaiSP.getName());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
		} 
	}

}
