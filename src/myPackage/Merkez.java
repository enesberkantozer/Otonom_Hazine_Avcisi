package myPackage;

import javax.swing.JFrame;

public class Merkez {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Altin Avcisi Oyunu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 350);
		
		SetSizePanel mainPanel=new SetSizePanel(frame);
		frame.getContentPane().add(mainPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
