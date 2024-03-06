package myPackage;

import javax.swing.JFrame;

public class Merkez {

	public static void main(String[] args) {
	    int boyut = 200; // Harita boyutu

	    JFrame frame = new JFrame("Altin Avcisi Oyunu");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(boyut * 100, boyut * 100);
	    AltinAvcisi oyun = new AltinAvcisi(boyut);//hatalı
	    frame.getContentPane().add(oyun);
	    frame.setVisible(true);
	}
}
