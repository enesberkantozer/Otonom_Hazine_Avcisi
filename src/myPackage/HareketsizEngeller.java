package myPackage;

import java.awt.Graphics;

class HareketsizEngeller extends Engeller {
	private static final long serialVersionUID = 1L;

	HareketsizEngeller(int width, int height, String imagePath, Lokasyon lokasyon, String treasureType) {
		super(width, height, imagePath, lokasyon,treasureType);
	}

	@Override
	public void ciz(Graphics g, int cellWidthSize, int cellHeightSize) {
		g.drawImage(image, lokasyon.getX() * cellWidthSize, lokasyon.getY() * cellHeightSize, width * cellWidthSize, height * cellHeightSize,
				SetSizePanel.oyun);
	}
}