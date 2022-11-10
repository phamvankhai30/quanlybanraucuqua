package BUS;

public class Test {


	public static void main(String[] args) {

		
		String chuoi = "15";
		String regex = "[\\-][^…]+";
	
		String kq = chuoi.replaceAll(regex, "");
		System.out.println(kq);
		
	}
}
