package myPackage;
public class HareketliEngeller extends Engeller {
	
	private char eksen;
	private int menzil;
	private Lokasyon startLocation;
	
	HareketliEngeller(int boyut, String imagePath, Lokasyon lokasyon, char eksen, int menzil) {
		super(boyut, imagePath, lokasyon);
		this.eksen = eksen;
		this.menzil = menzil;
		this.startLocation=new Lokasyon(lokasyon.getX(), lokasyon.getY());
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

	public int getMenzil() {
		return menzil;
	}

	public void setMenzil(int menzil) {
		this.menzil = menzil;
	}
}