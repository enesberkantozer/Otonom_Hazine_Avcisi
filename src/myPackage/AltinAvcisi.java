package myPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AltinAvcisi extends JPanel implements ActionListener,KeyListener {
	
	private static final long serialVersionUID = 1L;

	Timer timer = new Timer(500, this);
	
	private ArrayList<Lokasyon> coordinates;
	private Karakter karakter;
	private ArrayList<Engeller> engeller;
	private ArrayList<HareketliEngeller> bees;
	private ArrayList<HareketliEngeller> eagles;

	private int widthSize, heightSize;
	public static int cellWidthSize;
	public static int cellHeightSize;
	BufferedImage leftRight;
	BufferedImage upBottom;

	public AltinAvcisi(int widthSize,int heightSize) {
		timer.start();
		this.widthSize=widthSize;
		this.heightSize=heightSize;
		this.cellWidthSize = 20;
		this.cellHeightSize = 20;
		setPreferredSize(new Dimension(widthSize*cellWidthSize,heightSize*cellHeightSize));
		this.engeller = new ArrayList<>();
		this.bees = new ArrayList<>();
		this.eagles = new ArrayList<>();
		// Karakteri oluştur
		Lokasyon karakterLokasyon = new Lokasyon(0, 0);
		karakter = new Karakter(3, "Mario", karakterLokasyon,this);

		Random rand = new Random();
		int engelSayisi = rand.nextInt(widthSize) + widthSize / 2;

		for (int i = 0; i < engelSayisi; i++) {
			int x = rand.nextInt(widthSize);
			int y = rand.nextInt(heightSize);
			Lokasyon randomLokasyon = new Lokasyon(x, y);
			int randomBoy = rand.nextInt(4) + 2;
			int secim = rand.nextInt(8);
			HareketliEngeller kus = new HareketliEngeller(2, "src/img/bird.png", randomLokasyon, 'y', 5);
			HareketliEngeller ari = new HareketliEngeller(2, "src/img/bee.png", randomLokasyon, 'x', 3);

			HareketsizEngeller dag;
			HareketsizEngeller agac;
			if(randomLokasyon.getX()<=(widthSize/2)) {
				dag = new HareketsizEngeller(9, "src/img/summerMountain.png", randomLokasyon);
				agac = new HareketsizEngeller(randomBoy, "src/img/summerTree.png", randomLokasyon);
			}
			else {
				dag = new HareketsizEngeller(9, "src/img/winterMountain.png", randomLokasyon);
				agac = new HareketsizEngeller(randomBoy, "src/img/winterTree.png", randomLokasyon);
			}
			HareketsizEngeller duvar = new HareketsizEngeller(5, "src/img/wall.png", randomLokasyon);
			HareketsizEngeller kaya = new HareketsizEngeller(randomBoy, "src/img/rock.png", randomLokasyon);

			HareketsizEngeller altin = new HareketsizEngeller(3, "src/img/gold.png", randomLokasyon);
			HareketsizEngeller gumus = new HareketsizEngeller(3, "src/img/silver.png", randomLokasyon);

			switch (secim) {

			case 0:
				engeller.add(kus);
				eagles.add(kus);
				break;
			case 1:
				engeller.add(ari);
				bees.add(ari);
				break;
			case 2:
				engeller.add(agac);
				break;
			case 3:
				engeller.add(dag);
				break;
			case 4:
				engeller.add(duvar);
				break;
			case 5:
				engeller.add(kaya);
				break;
			case 6:
				engeller.add(altin);
				coordinates.add(randomLokasyon);
				break;
			case 7:
				engeller.add(gumus);
				coordinates.add(randomLokasyon);
				break;
			}

		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (int i = 1; i < widthSize; i++) {
			g.setColor(Color.black);
			g.drawLine(i * cellWidthSize, 0, i * cellWidthSize, heightSize * cellHeightSize);
		}
		for (int i = 1; i < heightSize; i++) {
			g.setColor(Color.black);
			g.drawLine(0, i * cellHeightSize, widthSize * cellWidthSize, i * cellHeightSize);
		}

		for (int j = 0; j < engeller.size(); j++) {
			for (int k = 0; k < engeller.size(); k++) {
				if (j == k) {
					continue;
				}
				else if(engeller.get(j) instanceof HareketliEngeller || engeller.get(k) instanceof HareketliEngeller) {
					if (new Rectangle(engeller.get(j).getLokasyon().getX(), engeller.get(j).getLokasyon().getY(),
							engeller.get(j).boyut, engeller.get(j).boyut)
							.intersects(new Rectangle(engeller.get(k).getLokasyon().getX(),
									engeller.get(k).getLokasyon().getY(), engeller.get(k).boyut, engeller.get(k).boyut))) {
							engeller.remove(k);
					}
				}
				else if (new Rectangle(engeller.get(j).getLokasyon().getX(), engeller.get(j).getLokasyon().getY(),
						engeller.get(j).boyut, engeller.get(j).boyut)
						.intersects(new Rectangle(engeller.get(k).getLokasyon().getX(),
								engeller.get(k).getLokasyon().getY(), engeller.get(k).boyut, engeller.get(k).boyut))) {
						engeller.remove(k);
				}
			}
		}

		try {
			leftRight = ImageIO.read(new File("src/img/leftRight.png"));
			upBottom=ImageIO.read(new File("src/img/upBottom.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Engeller engel : engeller) {
			if (engel instanceof HareketliEngeller) {
				for (int i = -1*((HareketliEngeller) engel).getMenzil()+1; i <= ((HareketliEngeller) engel).getMenzil()+2; i++) {
					if(((HareketliEngeller) engel).getMenzil()==3) {
						g.drawImage(leftRight, (((HareketliEngeller) engel)
								.getStartLocation().getX() + i) * cellWidthSize,
								((HareketliEngeller) engel).getStartLocation().getY() * cellHeightSize,
								cellWidthSize, cellHeightSize, this);
						g.drawImage(leftRight, (((HareketliEngeller) engel).getStartLocation().getX() + i) * cellWidthSize,
								(((HareketliEngeller) engel).getStartLocation().getY()+1) * cellHeightSize,
								cellWidthSize, cellHeightSize, this);
					} else if(((HareketliEngeller) engel).getMenzil()==5) {
						g.drawImage(upBottom, ((HareketliEngeller) engel).getStartLocation().getX() * cellWidthSize,
								(((HareketliEngeller) engel).getStartLocation().getY()+i) * cellHeightSize,
								cellWidthSize, cellHeightSize, this);
						g.drawImage(upBottom, (((HareketliEngeller) engel).getStartLocation().getX()+1) * cellWidthSize,
								(((HareketliEngeller) engel).getStartLocation().getY()+i) * cellHeightSize,
								cellWidthSize, cellHeightSize, this);
					}
				}
			}
			 
			engel.ciz(g, cellWidthSize, cellHeightSize);
		}
		karakter.ciz(g);
	}

	@Override
	public void repaint() {
		super.repaint();
	}

	int beeMove = 0;
	int beeFast = 1;
	int eagleMove = 0;
	int eagleFast = 1;

	@Override
	public void actionPerformed(ActionEvent e) {
		for (HareketliEngeller bee : bees) {
			bee.getLokasyon().setX(bee.getLokasyon().getX() + (beeFast));
		}
		if (beeMove == 3 || beeMove == -3) {
			beeFast *= -1;
		}
		beeMove += beeFast;
		for (HareketliEngeller eagle : eagles) {
			eagle.getLokasyon().setY(eagle.getLokasyon().getY() + (eagleFast));
		}
		if (eagleMove == 5 || eagleMove == -5) {
			eagleFast *= -1;
		}
		eagleMove += eagleFast;
		repaint();
	}

	public int getCellWidthSize() {
		return cellWidthSize;
	}

	public int getCellHeightSize() {
		return cellHeightSize;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c=e.getKeyCode();
		
		if(c==KeyEvent.VK_W)
			karakter.hareketEt(0, -1);
		else if(c==KeyEvent.VK_A)
			karakter.hareketEt(-1, 0);
		else if(c==KeyEvent.VK_S)
			karakter.hareketEt(0, 1);
		else if(c==KeyEvent.VK_D)
			karakter.hareketEt(1, 0);
		else if(c==KeyEvent.VK_K)
			System.out.println("K tuşuna tıkladın");
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}