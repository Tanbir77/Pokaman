
import java.awt.*;

import javax.swing.ImageIcon;

public class Knife {

	int x,y;
	Image img;
	boolean visible;
	
	public Knife(int startX, int startY)
	{
		x = startX;
		y = startY;
		
		ImageIcon newBullet = new ImageIcon("E:\\Pokaman\\Images\\knife4.png");
		img = newBullet.getImage();
		visible = true;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y, 31, 8);
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean getVisible()
	{
		return visible;
	}
	public Image getImage()
	{
		return img;
	}
	
	public void move()
	{
		x = x + 2;
		if ( x >1290)
			visible = false;
	}
	
	public void setVisible(boolean isVisible)
	{
		visible = isVisible;
	}
	

}
