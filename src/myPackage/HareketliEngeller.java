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
}