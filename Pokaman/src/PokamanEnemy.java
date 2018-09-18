import java.awt.*;

import javax.swing.ImageIcon;

public class PokamanEnemy {

	Image img;
	int x, y;
	public boolean isAlive =true;


	public PokamanEnemy(int startX, int startY, String location)
	{
		x = startX;
		y = startY;
		ImageIcon l = new ImageIcon(location);
		img = l.getImage();
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean Alive()
	{
		return isAlive;
	}
	public Image getImage()
	{
		return img;
	}
	
	public void move(int dx)
	{
		this.x=(this.x-dx);
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x+200,y,this.img.getWidth(null),this.img.getHeight(null));
	}
}