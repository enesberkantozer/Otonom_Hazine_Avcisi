package myPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AltinAvcisi extends JPanel implements ActionListener,KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	public Timer timer = new Timer(500 , this);
	
	private Random rand = new Random();
	private ArrayList<Engeller> treasures = new ArrayList<Engeller>();
	private Karakter karakter;
	private ArrayList<Engeller> engeller;
	private ArrayList<HareketliEngeller> bees;
	private ArrayList<HareketliEngeller> eagles;

	private int widthSize, heightSize;
	public static int cellWidthSize;
	public static int cellHeightSize;
	BufferedImage leftRight;
	BufferedImage upBottom;
	
	private boolean isContinueWay;
	private Engeller currentTarget;

	public AltinAvcisi(int widthSize,int heightSize) {
		timer.start();
		this.isContinueWay=false;
		this.widthSize=widthSize;
		this.heightSize=heightSize;
		this.cellWidthSize = 20;
		this.cellHeightSize = 20;
		setPreferredSize(new Dimension(widthSize*cellWidthSize,heightSize*cellHeightSize));
		this.engeller = new ArrayList<>();
		this.bees = new ArrayList<>();
		this.eagles = new ArrayList<>();
		// Karakteri oluştur
		Lokasyon karakterLokasyon = new Lokasyon(rand.nextInt(widthSize), rand.nextInt(heightSize));
		karakter = new Karakter(3, "Mario", karakterLokasyon,this);

		int engelSayisi = rand.nextInt(widthSize) + widthSize / 2;

		for (int i = 0; i < engelSayisi; i++) {
			int x = rand.nextInt(widthSize);
			int y = rand.nextInt(heightSize);
			Lokasyon randomLokasyon = new Lokasyon(x, y);
			int randomBoy = rand.nextInt(4) + 2;
			int secim = rand.nextInt(10);
			HareketliEngeller kus = new HareketliEngeller(2,2, "src/img/bird.png", randomLokasyon, 1, 5);
			HareketliEngeller ari = new HareketliEngeller(2,2, "src/img/bee.png", randomLokasyon, 3, 1);

			HareketsizEngeller dag;
			HareketsizEngeller agac;
			if(randomLokasyon.getX()>(widthSize/2)) {
				dag = new HareketsizEngeller(9,9, "src/img/summerMountain.png", randomLokasyon,null);
				agac = new HareketsizEngeller(randomBoy,randomBoy, "src/img/summerTree.png", randomLokasyon,null);
			}
			else {
				dag = new HareketsizEngeller(9,9, "src/img/winterMountain.png", randomLokasyon,null);
				agac = new HareketsizEngeller(randomBoy,randomBoy, "src/img/winterTree.png", randomLokasyon,null);
			}
			HareketsizEngeller duvar = new HareketsizEngeller(5,5, "src/img/wall.png", randomLokasyon,null);
			HareketsizEngeller kaya = new HareketsizEngeller(randomBoy,randomBoy, "src/img/rock.png", randomLokasyon,null);

			HareketsizEngeller altin = new HareketsizEngeller(1,1, "src/img/gold.png", randomLokasyon,"A");
			HareketsizEngeller gumus = new HareketsizEngeller(1,1, "src/img/silver.png", randomLokasyon,"G");
			HareketsizEngeller zümrüt = new HareketsizEngeller(1, 1, "src/img/zumrut.png", randomLokasyon,"Z");
			HareketsizEngeller bakir= new HareketsizEngeller(1, 1, "src/img/bakir.png", randomLokasyon,"B");

			boolean isIntersects=false;
			
			switch (secim) {

			case 0:
				for(Engeller engel:engeller) {
					if(engel.intersects(kus)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(kus);
				eagles.add(kus);
				break;
			case 1:
				for(Engeller engel:engeller) {
					if(engel.intersects(ari)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(ari);
				bees.add(ari);
				break;
			case 2:
				for(Engeller engel:engeller) {
					if(engel.intersects(agac)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(agac);
				break;
			case 3:
				for(Engeller engel:engeller) {
					if(engel.intersects(dag)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(dag);
				break;
			case 4:
				for(Engeller engel:engeller) {
					if(engel.intersects(duvar)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(duvar);
				break;
			case 5:
				for(Engeller engel:engeller) {
					if(engel.intersects(kaya)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(kaya);
				break;
			case 6:
				for(Engeller engel:engeller) {
					if(engel.intersects(altin)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(altin);
				treasures.add(altin);
				break;
			case 7:
				for(Engeller engel:engeller) {
					if(engel.intersects(gumus)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(gumus);
				treasures.add(gumus);
				break;
			case 8:
				for(Engeller engel:engeller) {
					if(engel.intersects(zümrüt)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(zümrüt);
				treasures.add(zümrüt);
				break;
			case 9:
				for(Engeller engel:engeller) {
					if(engel.intersects(bakir)) {
						isIntersects=true;
					}
				}
				if(isIntersects)
					break;
				engeller.add(bakir);
				treasures.add(bakir);
				break;
			}

		}
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);

		for (int i = 1; i < widthSize; i++) {
			g.setColor(Color.black);
			g.drawLine(i * cellWidthSize, 0, i * cellWidthSize, heightSize * cellHeightSize);
		}
		for (int i = 1; i < heightSize; i++) {
			g.setColor(Color.black);
			g.drawLine(0, i * cellHeightSize, widthSize * cellWidthSize, i * cellHeightSize);
		}

		try {
			leftRight = ImageIO.read(new File("src/img/leftRight.png"));
			upBottom=ImageIO.read(new File("src/img/upBottom.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Engeller engel : engeller) {
			if (engel instanceof HareketliEngeller) {
				int menzil;
				if(((HareketliEngeller) engel).getXmenzil()!=1) {
					menzil=((HareketliEngeller) engel).getXmenzil();
				}
				else {
					menzil=((HareketliEngeller) engel).getYmenzil();
				}
				for (int i = -1*menzil+1; i <= menzil+2; i++) {
					if(((HareketliEngeller) engel).getXmenzil()==3) {
						g.drawImage(leftRight, (((HareketliEngeller) engel)
								.getStartLocation().getX() + i) * cellWidthSize,
								((HareketliEngeller) engel).getStartLocation().getY() * cellHeightSize,
								cellWidthSize, cellHeightSize, this);
						g.drawImage(leftRight, (((HareketliEngeller) engel).getStartLocation().getX() + i) * cellWidthSize,
								(((HareketliEngeller) engel).getStartLocation().getY()+1) * cellHeightSize,
								cellWidthSize, cellHeightSize, this);
					} else if(((HareketliEngeller) engel).getYmenzil()==5) {
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
		greenWayDraw(g);
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
			bee.hareketEt(beeFast, 0);
		}
		if (beeMove == 3 || beeMove == -3) {
			beeFast *= -1;
		}
		beeMove += beeFast;
		for (HareketliEngeller eagle : eagles) {
			eagle.hareketEt(0, eagleFast);
		}
		if (eagleMove == 5 || eagleMove == -5) {
			eagleFast *= -1;
		}
		eagleMove += eagleFast;
		goToTreasure(karakter);
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	int enBasGumus=0;
	int enBasZumrut=0;
	int enBasBakir=0;
	int distance=0;
	public int totalDistance=0;
	boolean xDone=false;
	boolean yDone=false;
	int x_y_Random;
	private void goToTreasure(Karakter miner) {
		if(isContinueWay) {
			if(!(xDone && yDone)) {
				if(!(xDone || yDone)) {
					x_y_Random=rand.nextInt(2);
				}
				else if(xDone) {
					x_y_Random=1;
				}
				else if(yDone) {
					x_y_Random=0;
				}
				if(x_y_Random==0) {

					if(currentTarget.getLokasyon().getX()>karakter.getLokasyon().getX()) {
						miner.hareketEt(1, 0);
					}
					else if(currentTarget.getLokasyon().getX()==karakter.getLokasyon().getX()) {
						xDone=true;
					}
					else {
						miner.hareketEt(-1, 0);
					}
				}
				else if(x_y_Random==1) {
					if(currentTarget.getLokasyon().getY()>karakter.getLokasyon().getY()) {
						miner.hareketEt(0, 1);
					}
					else if(currentTarget.getLokasyon().getY()==karakter.getLokasyon().getY()) {
						yDone=true;
					}
					else {
						miner.hareketEt(0, -1);
					}
				}
				Karakter.charLocations.add(new Lokasyon(miner.getLokasyon().getX(),miner.getLokasyon().getY()));
				distance--;
				totalDistance++;
				GameDialog.totalDistanceLabel.setText("Toplam Adım Sayısı: "+totalDistance);
			}
			else {
				int addPlaceOnList=0;
				String listMessage=new String();
				if(currentTarget.getTreasureType().equals("A")) {
					listMessage="Altın toplandı! (";
					addPlaceOnList=0;
					enBasGumus++;
					enBasZumrut++;
					enBasBakir++;
				} else if(currentTarget.getTreasureType().equals("G")){
					listMessage="Gümüş toplandı! (";
					addPlaceOnList=enBasGumus;
					enBasZumrut++;
					enBasBakir++;
				} else if(currentTarget.getTreasureType().equals("Z")){
					listMessage="Zümrüt toplandı! (";
					addPlaceOnList=enBasZumrut;
					enBasBakir++;
				} else if(currentTarget.getTreasureType().equals("B")){
					listMessage="Bakır toplandı! (";
					addPlaceOnList=enBasBakir;
				}
				GameDialog.list.add(addPlaceOnList,listMessage+currentTarget.getLokasyon().getX()+" - "+currentTarget.getLokasyon().getY()+") konumunda bulundu.");
				xDone=false; yDone=false;
				isContinueWay=false;
				treasures.remove(currentTarget);
				engeller.remove(currentTarget);
				if(treasures.size()==0) {
					timer.stop();
					JOptionPane.showMessageDialog(this, "Tüm hazineler bulundu!");
				}
			}
		}
		else {
			int minDistance=3000;
			for (Engeller treasure : treasures) {
				distance=Math.abs(treasure.getLokasyon().getX()-karakter.getLokasyon().getX());
				distance+=Math.abs(treasure.getLokasyon().getY()-karakter.getLokasyon().getY());
				if(distance<minDistance) {
					minDistance=distance;
					currentTarget=treasure;
				}
			}
			isContinueWay=true;
		}
	}
	
	public void greenWayDraw(Graphics g) {
		try {
			for (Lokasyon location:Karakter.charLocations) {
				g.drawImage(ImageIO.read(new File("src/img/charMove.png")), location.getX()*cellWidthSize, location.getY()*cellHeightSize, cellWidthSize, cellHeightSize, this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}