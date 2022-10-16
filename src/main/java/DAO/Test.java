package DAO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) throws IOException {
		
		BufferedImage myPicture = ImageIO.read(new File("src/img/oi.jpg").getAbsoluteFile());
		ImageIO.write(myPicture, "jpg", new File("src/img/oi.jpg"));
		System.out.println(myPicture);
	}
}
