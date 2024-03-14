package myPackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Engeller {
	public int boyut;
	private BufferedImage image;
	private Lokasyon lokasyon;

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}

	public Engeller(int boyut, String imagePath, Lokasyon lokasyon) {
		this.boyut = boyut;
		this.lokasyon = lokasyon;

		try {
			this.image = ImageIO.read(new File(imagePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ciz(Graphics g, int cellWidthSize, int cellHeightSize) {
		g.drawImage(image, lokasyon.getX() * cellWidthSize, lokasyon.getY() * cellHeightSize, boyut * cellWidthSize, boyut * cellHeightSize,
				SetSizePanel.oyun);
	}
}