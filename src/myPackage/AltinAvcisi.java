package myPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AltinAvcisi extends JPanel implements ActionListener{
	
	Timer timer=new Timer(2000,this);
	
    private Karakter karakter;
    private ArrayList<Engeller> engeller;
    private ArrayList<HareketliEngeller> bees;
    private ArrayList<HareketliEngeller> eagles;

    private int boyut;
    private int cellSize;

    public AltinAvcisi(int boyut) {    	
        this.boyut = boyut;
        this.cellSize = 10;
        this.engeller = new ArrayList<>();
        this.bees=new ArrayList<>();
        this.eagles=new ArrayList<>();
        // Karakteri oluştur
        Lokasyon karakterLokasyon = new Lokasyon(0, 0);
        karakter = new Karakter(3, "Mario", karakterLokasyon);
       
        Random rand = new Random();
        int engelSayisi = rand.nextInt(boyut) + boyut /2; 

        for (int i = 0; i < engelSayisi; i++) {
            int x = rand.nextInt(boyut);
            int y = rand.nextInt(boyut);
            Lokasyon randomLokasyon = new Lokasyon(x, y);
            int randomBoy = rand.nextInt(4) + 2; // 2 ile 5 arası rastgele boyut
            int secim = rand.nextInt(8);
            HareketliEngeller kus = new HareketliEngeller(2, "src/img/bird.png", randomLokasyon, 'y', 5);
            HareketliEngeller ari = new HareketliEngeller(2, "src/img/bee.png", randomLokasyon, 'x', 3);

            HareketsizEngeller agac = new HareketsizEngeller(randomBoy, "src/img/tree.png", randomLokasyon);
            HareketsizEngeller dag = new HareketsizEngeller(9, "src/img/mountain.png", randomLokasyon);
            HareketsizEngeller duvar = new HareketsizEngeller(5, "src/img/wall.png", randomLokasyon);
            HareketsizEngeller kaya = new HareketsizEngeller(randomBoy, "src/img/rock.png", randomLokasyon);
            
            HareketsizEngeller altin = new HareketsizEngeller(3, "src/img/gold.png", randomLokasyon);
            HareketsizEngeller gumus = new HareketsizEngeller(3, "src/img/silver.png", randomLokasyon);
            
            
                        
            switch (secim) {
            
				case 0: engeller.add(kus); eagles.add(kus); break;
				case 1: engeller.add(ari); bees.add(ari); break;
				case 2: engeller.add(agac); break;
				case 3: engeller.add(dag); break;
				case 4: engeller.add(duvar); break;
				case 5: engeller.add(kaya); break;
				case 6: engeller.add(altin); break;
				case 7: engeller.add(gumus); break;	
            }
            
         }
        timer.start();
        
    }
    
    @Override
    public void paint(Graphics g) {
    	// TODO Auto-generated method stub
    	super.paint(g);
    	// Karelerin içeriğini çiz
        for (int i = 0; i < boyut; i++) {
            for (int j = 0; j < boyut; j++) {
                // Karelerin köşelerine yatay ve dikey çizgileri çiz
                g.setColor(Color.BLACK);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);

                // Dikey çizgiler
                if (j < boyut - 1) {
                    g.drawLine((j + 1) * cellSize, i * cellSize, (j + 1) * cellSize, (i + 1) * cellSize);
                }
                // Yatay çizgiler
                if (i < boyut - 1) {
                    g.drawLine(j * cellSize, (i + 1) * cellSize, (j + 1) * cellSize, (i + 1) * cellSize);
                }
            }
        }
        
        for (int j = 0; j < engeller.size(); j++) {
        	for(int k = 0; k<engeller.size(); k++) {
        		if(j==k) {
        			continue;
        		}
        		else if(new Rectangle(engeller.get(j).getLokasyon().getX(),engeller.get(j).getLokasyon().getY(),
        				engeller.get(j).boyut,engeller.get(j).boyut).intersects(new Rectangle(
        						engeller.get(k).getLokasyon().getX(),engeller.get(k).getLokasyon().getY(),
        						engeller.get(k).boyut,engeller.get(k).boyut))) {
        			engeller.remove(k);
        		}
        	}
		}

        // Engelleri çiz
        for (Engeller engel : engeller) {
            engel.ciz(g, cellSize);
        }
    }
    
    @Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}
    
    int beeMove=0;
    int beeFast=1;
    int eagleMove=0;
    int eagleFast=1;
    
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		for(HareketliEngeller bee:bees) {
//			bee.getLokasyon().setX(bee.getLokasyon().getX()+(beeFast * cellSize));
//			beeMove+=beeFast;
//			if(beeMove==3) {
//				beeFast*=-1;
//			}
//			else if(beeMove==-3) {
//				beeFast*=-1;
//			}
//			
//		}
//		for(HareketliEngeller eagle:eagles) {
//			eagle.getLokasyon().setY(eagle.getLokasyon().getY()+(eagleFast * cellSize));
//			eagleMove+=eagleFast;
//			if(eagleMove==5) {
//				eagleFast*=-1;
//			}
//			else if(eagleMove==-5) {
//				eagleFast*=-1;
//			}
//		}
//		
//		repaint();
//		
//	}
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(HareketliEngeller bee:bees) {
			if(beeMove==3 || beeMove==-3) {
				beeFast*=-1;
			}
			bee.getLokasyon().setX(bee.getLokasyon().getX()+(beeFast));
			beeMove+=beeFast;
		}
		
		for(HareketliEngeller eagle:eagles) {
			if(eagleMove==5 || eagleMove == -5) {
				eagleFast*=-1;
			}
			eagle.getLokasyon().setY(eagle.getLokasyon().getY()+(eagleFast));
			eagleMove+=eagleFast;
		}
		repaint();
	}

}