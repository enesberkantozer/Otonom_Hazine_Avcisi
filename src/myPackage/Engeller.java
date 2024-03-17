package myPackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Engeller extends Rectangle{
	private static final long serialVersionUID = 1L;
	public int width;
	public int height;
	private String treasureType;
	protected BufferedImage image;
	protected Lokasyon lokasyon;

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}

	public Engeller(int width, int height, String imagePath, Lokasyon lokasyon, String treasureType) {
		super(lokasyon.getX(),lokasyon.getY(),width,height);
		this.width=width;
		this.height=height;
		this.treasureType=treasureType;
		this.lokasyon = lokasyon;

		try {
			this.image = ImageIO.read(new File(imagePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void ciz(Graphics g, int cellWidthSize, int cellHeightSize);

	public String getTreasureType() {
		return treasureType;
	}
}