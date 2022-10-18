package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;

public class ClockThead extends Thread{
	private JTextField jtextfield;

	
	public ClockThead(JTextField jtextField) {
		this.jtextfield = jtextField;
	}

	
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	public void run() {
		
		while(true) {
			String localDateTime = LocalDateTime.now().format(dateTimeFormatter);
			jtextfield.setText(localDateTime);

			try {
				Thread.sleep(1000); //1s
			}catch(InterruptedException e) {
				
			}
		}
		
	}
}
