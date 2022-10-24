package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import BUS.Category_BUS;
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

public class Update_Category_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TenLoaiSP;
	private JTextField textField_IdLoaiSP;
	
	private Category_BUS category_BUS = new Category_BUS();


	public Update_Category_Form(String maLoaiSP, String tenLoaiSP) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\iconfinder-healthcare-and-medicalorganicvegansaladhealthy-foodavocadodietvegetarianfoodfruit-4394779_119506.png"));
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
		setBounds(100, 100, 359, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.CYAN));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(10, 11, 323, 37);
		contentPane.add(panel);
		
		JLabel lbl_SuaLoaiSP = new JLabel("Sửa Loại Sản Phẩm");
		lbl_SuaLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_SuaLoaiSP.setBounds(81, 0, 181, 37);
		panel.add(lbl_SuaLoaiSP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 59, 323, 106);
		contentPane.add(panel_1);
		
		JLabel lbl_TenLoaiSP = new JLabel("Tên Loại Sản Phẩm");
		lbl_TenLoaiSP.setBounds(10, 70, 119, 14);
		panel_1.add(lbl_TenLoaiSP);
		
		textField_TenLoaiSP = new JTextField();
		textField_TenLoaiSP.setColumns(10);
		textField_TenLoaiSP.setBounds(139, 67, 160, 20);
		panel_1.add(textField_TenLoaiSP);
		
		JLabel lbl_IdLoaiSP = new JLabel("Mã Loại Sản Phẩm\r\n");
		lbl_IdLoaiSP.setBounds(10, 25, 108, 14);
		panel_1.add(lbl_IdLoaiSP);
		
		textField_IdLoaiSP = new JTextField();
		textField_IdLoaiSP.setEnabled(false);
		textField_IdLoaiSP.setColumns(10);
		textField_IdLoaiSP.setBounds(139, 22, 160, 20);
		panel_1.add(textField_IdLoaiSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 175, 323, 59);
		contentPane.add(panel_2);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\cloudrefresh_icon-icons.com_54403.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaLoaiSanPham();
				
			}
		});
		btnSua.setBounds(185, 11, 128, 31);
		panel_2.add(btnSua);
		
		JButton btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\java\\images\\back_icon_155778.png"));
		btnQuayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toBack();
				setVisible(false);
				
			}
		});
		btnQuayLai.setBounds(10, 11, 135, 31);
		panel_2.add(btnQuayLai);
	}

	private void SuaLoaiSanPham() {
		if(textField_TenLoaiSP.getText().equals("")) {	
			JOptionPane.showMessageDialog(rootPane, "Bạn nhập còn thiếu");
		}else {
			int idLSP = Integer.parseInt(textField_IdLoaiSP.getText());
			String tenLoaiSP = textField_TenLoaiSP.getText();
			
			category_BUS.updateCategory(idLSP,tenLoaiSP);
			JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
			setVisible(false);
		} 
	}

}
