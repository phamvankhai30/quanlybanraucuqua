package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Category_Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TenLoaiSP;
	private JTextField textField_LoaiSP;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Add_Category_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 459, 37);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lbl_ThemLoaiSP = new JLabel("Thêm Loại Sản Phẩm");
		lbl_ThemLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_ThemLoaiSP.setBounds(127, 11, 181, 14);
		panel.add(lbl_ThemLoaiSP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(83, 39, 288, 137);
		panel_1.setLayout(null);
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
		
		textField_LoaiSP = new JTextField();
		textField_LoaiSP.setColumns(10);
		textField_LoaiSP.setBounds(128, 32, 160, 20);
		panel_1.add(textField_LoaiSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 176, 448, 59);
		panel_2.setLayout(null);
		contentPane.add(panel_2);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(86, 17, 96, 31);
		panel_2.add(btnThem);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
			}
		});
		btnQuayLai.setBounds(274, 17, 96, 31);
		panel_2.add(btnQuayLai);
	}

}
