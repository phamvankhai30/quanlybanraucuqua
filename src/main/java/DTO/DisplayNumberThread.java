package DTO;

import javax.swing.JTextField;

public class DisplayNumberThread extends Thread {
	private JTextField jtextfield;
	
	public DisplayNumberThread(JTextField jtextField) {
		this.jtextfield = jtextField;
	}
	
	public void run() {
		int id = (int) this.getId();
		jtextfield.setText(id+"");
	}
}
