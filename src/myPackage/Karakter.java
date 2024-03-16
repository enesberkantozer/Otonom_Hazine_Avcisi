package myPackage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Karakter {
    private int ID;
    private String ad;
    private Lokasyon lokasyon;
    private BufferedImage image;
    private AltinAvcisi map;
    private int karakterWidth=1, karakterHeight=1;

    public Karakter(int ID, String ad, Lokasyon lokasyon, AltinAvcisi map) {
        this.ID = ID;
        this.ad = ad;
        this.lokasyon = lokasyon;
        this.map=map;
        try {
			this.image=ImageIO.read(new File("src/img/miner.png"));
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
    	g.drawImage(image, getLokasyon().getX()*AltinAvcisi.cellWidthSize, getLokasyon().getY()*AltinAvcisi.cellHeightSize, karakterWidth*AltinAvcisi.cellWidthSize, karakterHeight*AltinAvcisi.cellHeightSize, map);
    }
    
    public void hareketEt(int dx, int dy) {
        this.lokasyon.setX(this.lokasyon.getX() + dx);
        this.lokasyon.setY(this.lokasyon.getY() + dy);
    }
}