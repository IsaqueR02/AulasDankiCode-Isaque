package minizeldaclone;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {
	
	public static BufferedImage spritesheet;
	
	public static BufferedImage[] player_front;

	public static BufferedImage tileWall;
	public static BufferedImage[] inimigo_front;
	//13,232
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/aula05-spritesheet.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		inimigo_front = new BufferedImage[2];
		
		
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		
		inimigo_front[0] = Spritesheet.getSprite(35,232, 16, 16);
		inimigo_front[1] = Spritesheet.getSprite(139,217, 16, 16);
		
		tileWall = Spritesheet.getSprite(301,245,16,16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
		
	}
}
