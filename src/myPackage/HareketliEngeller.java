package myPackage;
public class HareketliEngeller extends Engeller {
	
	private char eksen;
	private int menzil;
	
	HareketliEngeller(int boyut, String imagePath, Lokasyon lokasyon, char eksen, int menzil) {
		super(boyut, imagePath, lokasyon);
		this.eksen = eksen;
		this.menzil = menzil;
		// TODO Auto-generated constructor stub
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