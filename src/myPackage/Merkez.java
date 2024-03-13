package myPackage;

import javax.swing.JFrame;

public class Merkez {

	public static AltinAvcisi oyun;

	public static void main(String[] args) {
		int boyut = 200;

		JFrame frame = new JFrame("Altin Avcisi Oyunu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		oyun = new AltinAvcisi(boyut);
		frame.getContentPane().add(oyun);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
