package myPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Merkez {

	public static AltinAvcisi oyun;
	
	public static void main(String[] args) {
	    int boyut = 200; // Harita boyutu

	    JFrame frame = new JFrame("Altin Avcisi Oyunu");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 800);
	    oyun = new AltinAvcisi(boyut);
	    frame.getContentPane().add(oyun);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
}
