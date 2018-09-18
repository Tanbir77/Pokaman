
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Pokaman {
	    
		PokamanPanel gamePanel;
	    int x,y,cX=10,lifeX=10,iX1=1280,iX2=2,iY1=0,iY2=733,iconX=10;
	    int dx=0,dy=0,dx1=0;
	    int totalLifes=2;
	    boolean isAlive=true;
	    Image hero;
	    static ArrayList<Knife> knifes;
	    int knifesLeft=20,knifeCountSignal=500;
	public Pokaman(PokamanPanel p){
		gamePanel=p;
		ImageIcon img=new ImageIcon("E:\\Pokaman\\Images\\hero5.gif");
		hero=img.getImage();
		knifes=new ArrayList<Knife>();
		x=30;
		y=460;
		
	}
	

	public void move(){
		if(y==280){
			dy=3;
		
		}
		else if(y==463){
			dy=0;
			dx=0;
			y=460;
		}
		iX1=iX1+dx1;
	    iX2=iX2+dx1;
	    if(cX<=10){
	    	cX=cX-dx1;
	    }
	    if(lifeX<=11){
	    	lifeX=lifeX-dx1;
	    }
	    if(iconX<=10){
	    	iconX=iconX-dx1;
	    }

	 
		x=x+dx;
		y=y+dy;
	
	}
	public void throwKnife(){
		if(knifesLeft>0){
			Knife k=new Knife(x+60,y+24);
			knifes.add(k);
			knifesLeft--;
		}
		

	}
	public static ArrayList<Knife> getKnifes(){
		return knifes;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	public int getiX1() {
		return iX1;
	}
	public void setiX1(int iX) {
		this.iX1 = iX;
	}


	public int getiY1() {
		return iY1;
	}


	public void setiY1(int iY) {
		this.iY1 = iY;
	}
    
	

	public int getiX2() {
		return iX2;
	}


	public void setiX2(int iX2) {
		this.iX2 = iX2;
	}


	public int getiY2() {
		return iY2;
	}


	public void setiY2(int iY2) {
		this.iY2 = iY2;
	}
	public Image getHero() {
		return hero;
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,hero.getWidth(null),hero.getHeight(null));
	}
    public void keyReleased(KeyEvent e){
    	int key=e.getKeyCode();
    	if(key==KeyEvent.VK_LEFT){
    		dx=0;
    	}
    	else if(key==KeyEvent.VK_RIGHT){
    		dx=0;
    		dx1=0;
    	}
    	if(key==KeyEvent.VK_SPACE){

	    }
    }
    public void keyPressed(KeyEvent e){
    	int key=e.getKeyCode();
    	if(key==KeyEvent.VK_LEFT){
    		if(isAlive){
    			ImageIcon img=new ImageIcon("E:\\Pokaman\\Images\\hero6.gif");
        		hero=img.getImage();
                dx=-3;
    		}
    		
    	}
    	else if(key==KeyEvent.VK_RIGHT){
    		if(isAlive){
    			ImageIcon img=new ImageIcon("E:\\Pokaman\\Images\\hero5.gif");
        		hero=img.getImage();
        		dx1=3;
        		if(y<460){
        	    	dx=1;
        	    } 
    		}
    	}
    
    	else if(key==KeyEvent.VK_SPACE){
    	    if(isAlive){
    	    	if(y>459){
        	    	dy=-3;
        	    } 
    	    }
  
    	}
    	else if(key==KeyEvent.VK_CONTROL){
    	    if(isAlive){
    	    	this.throwKnife();
        	    if(knifesLeft==0){
        	    	knifeCountSignal=1;
        	    	
        	    } 
    	    }
  
    	}
    }




	
    

}
