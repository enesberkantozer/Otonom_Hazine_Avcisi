package myPackage;

import java.awt.Graphics;

public class HareketliEngeller extends Engeller {
	private static final long serialVersionUID = 1L;
	
	private char eksen;
	private int xmenzil,ymenzil;
	private int width, height;
	private Lokasyon startLocation, lokasyon;
	
	HareketliEngeller(int width, int height, String imagePath, Lokasyon lokasyon, int xmenzil,int ymenzil) {
		super((xmenzil==1)? width: ((xmenzil*2)+width),(ymenzil==1)? height:((ymenzil*2)+height), imagePath, 
				(xmenzil==1)? (new Lokasyon(lokasyon.getX(),lokasyon.getY()-ymenzil+1)): (new Lokasyon(lokasyon.getX()-xmenzil+1,lokasyon.getY())),null);
		this.width=width;
		this.height=height;
		this.xmenzil = xmenzil;
		this.ymenzil=ymenzil;
		this.startLocation=new Lokasyon(lokasyon.getX(), lokasyon.getY());
		this.lokasyon=lokasyon;
	}

	public Lokasyon getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Lokasyon startLocation) {
		this.startLocation = startLocation;
	}

	public char getEksen() {
		return eksen;
	}

	public void setEksen(char eksen) {
		this.eksen = eksen;
	}

	public int getXmenzil() {
		return xmenzil;
	}

	public void setXmenzil(int xmenzil) {
		this.xmenzil = xmenzil;
	}

	public int getYmenzil() {
		return ymenzil;
	}

	public void setYmenzil(int ymenzil) {
		this.ymenzil = ymenzil;
	}
	
    public void hareketEt(int dx, int dy) {
        this.lokasyon.setX(this.lokasyon.getX() + dx);
        this.lokasyon.setY(this.lokasyon.getY() + dy);
    }

	@Override
	public void ciz(Graphics g, int cellWidthSize, int cellHeightSize) {
		g.drawImage(image, lokasyon.getX() * cellWidthSize, lokasyon.getY() * cellHeightSize, width * cellWidthSize, height * cellHeightSize,
				SetSizePanel.oyun);
	}
    
    
}