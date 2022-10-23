package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BUS.Category_BUS;
import DTO.DisplayNumberThread;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Add_Category_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TenLoaiSP;
	private JTextField textField_LoaiSP;
	private Category_BUS category_BUS = new Category_BUS();

	public Add_Category_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
		initComponents();
		initId();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Category_Form frame = new Add_Category_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 325, 37);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lbl_ThemLoaiSP = new JLabel("Thêm Loại Sản Phẩm");
		lbl_ThemLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemLoaiSP.setBounds(72, 0, 171, 37);
		panel.add(lbl_ThemLoaiSP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 59, 325, 100);
		panel_1.setLayout(null);
		contentPane.add(panel_1);
		
		JLabel lbl_TenLoaiSP = new JLabel("Tên Loại Sản Phẩm");
		lbl_TenLoaiSP.setBounds(21, 70, 129, 14);
		panel_1.add(lbl_TenLoaiSP);
		
		textField_TenLoaiSP = new JTextField();
		textField_TenLoaiSP.setColumns(10);
		textField_TenLoaiSP.setBounds(144, 67, 160, 20);
		panel_1.add(textField_TenLoaiSP);
		
		JLabel lbl_IdLoaiSP = new JLabel("Mã Loại Sản Phẩm\r\n");
		lbl_IdLoaiSP.setBounds(21, 21, 108, 14);
		panel_1.add(lbl_IdLoaiSP);
		
		textField_LoaiSP = new JTextField();
		textField_LoaiSP.setEnabled(false);
		textField_LoaiSP.setColumns(10);
		textField_LoaiSP.setBounds(144, 18, 160, 20);
		panel_1.add(textField_LoaiSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 170, 323, 64);
		panel_2.setLayout(null);
		contentPane.add(panel_2);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\Plus_36851.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemLoaiSanPham();	
			}
		});
		btnThem.setBounds(203, 11, 110, 42);
		panel_2.add(btnThem);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(10, 11, 120, 42);
		panel_2.add(btnQuayLai);
	}
	private void initId() {
		DisplayNumberThread id = new DisplayNumberThread(textField_LoaiSP);
		id.start();
	}
	private void ResetTextField() {
		textField_LoaiSP.setText("");
		textField_TenLoaiSP.setText("");
	}
	
	private void ThemLoaiSanPham() {
		if(textField_TenLoaiSP.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			
			category_BUS.addCategory(textField_TenLoaiSP.getText());
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			ResetTextField();
			
		} 
	}

}
