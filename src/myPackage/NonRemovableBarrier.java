package myPackage;

import java.awt.Graphics;

public class NonRemovableBarrier extends Engeller {
	private static final long serialVersionUID = 1L;

	public NonRemovableBarrier(int width, int height, String imagePath, Lokasyon lokasyon) {
		super(width, height, imagePath, lokasyon,null);
	}
	
	@Override
	public void ciz(Graphics g, int cellWidthSize, int cellHeightSize) {
		g.drawImage(image, lokasyon.getX() * cellWidthSize, lokasyon.getY() * cellHeightSize, width * cellWidthSize, height * cellHeightSize,
				SetSizePanel.oyun);
	}
}
