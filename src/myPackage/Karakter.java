package myPackage;
public class Karakter {
    private int ID;
    private String ad;
    private Lokasyon lokasyon;

    public Karakter(int ID, String ad, Lokasyon lokasyon) {
        this.ID = ID;
        this.ad = ad;
        this.lokasyon = lokasyon;
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

    public void EnKisaYol(Lokasyon hedefLokasyon) {
        // En kısa yolu hesaplayan kod
    }
    void hareketEt(int dx, int dy) {
        this.lokasyon.setX(this.lokasyon.getX() + dx);
        this.lokasyon.setY(this.lokasyon.getX() + dy);
    }
}