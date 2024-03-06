package myPackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;

public class Engeller{
	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}

	public int boyut;
	private BufferedImage image;
	private Lokasyon lokasyon;

	 public Engeller(int boyut, String imagePath, Lokasyon lokasyon) {
	        this.boyut = boyut;
	        this.lokasyon = lokasyon;

	        try {
	            // Görüntüyü yükleyin
	            //this.image = ImageIO.read(new FileImageInputStream(new File(imagePath)));//hatalı
	            this.image = ImageIO.read(new File(imagePath));

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	 
	 public void ciz(Graphics g, int cellSize) {
	        // Görüntüyü çizin
	        g.drawImage(image, lokasyon.getX() * cellSize, lokasyon.getY() * cellSize, boyut * cellSize, boyut * cellSize, null);
	    }
}