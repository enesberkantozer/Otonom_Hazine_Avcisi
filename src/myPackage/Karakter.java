package myPackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Karakter extends Rectangle {
	private static final long serialVersionUID = 1L;

	private int ID;
	private String ad;
	private Lokasyon lokasyon;
	private BufferedImage image;
	private AltinAvcisi map;
	private int charWidth, charHeight;

	public static ArrayList<Lokasyon> charLocations = new ArrayList<Lokasyon>();

	public Karakter(int width, int height, int ID, String ad, Lokasyon lokasyon, AltinAvcisi map) {
		super(lokasyon.getX(), lokasyon.getY(), width, height);
		this.charWidth = width;
		this.charHeight = height;
		this.ID = ID;
		this.ad = ad;
		this.lokasyon = lokasyon;
		this.charLocations.add(new Lokasyon(lokasyon.getX(), lokasyon.getY()));
		this.map = map;
		try {
			this.image = ImageIO.read(new File("src/img/miner.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getID() {
		return ID;
	}

	public String getAd() {
		return ad;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}

	public void enKisaYol(Lokasyon hedefLokasyon) {
	}

	public void ciz(Graphics g) {
		g.drawImage(image, getLokasyon().getX() * AltinAvcisi.cellWidthSize,
				getLokasyon().getY() * AltinAvcisi.cellHeightSize, charWidth * AltinAvcisi.cellWidthSize,
				charHeight * AltinAvcisi.cellHeightSize, map);
	}

	public void hareketEt(int dx, int dy) {
		this.lokasyon.setX(this.lokasyon.getX() + dx);
		this.lokasyon.setY(this.lokasyon.getY() + dy);
	}

	public int getCharWidth() {
		return charWidth;
	}

	public int getCharHeight() {
		return charHeight;
	}
}