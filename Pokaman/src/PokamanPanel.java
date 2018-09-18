
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
public class PokamanPanel extends JPanel implements ActionListener  {
	   long score=0,scoreCount=0;
	   int counter=0;
	   int totalLife=2;
       Pokaman pMan;
       Graphics2D g2d;
       Image BackgroundImg,BottomImg,coinImg25,coinImg100,knifeIcon,lifeImgGIF,lifeIcon;
       boolean coin1=false,coin2=false,coin3=false,coin4=false,coin5=false,coin6=false;
       boolean coinFlag0=false,coinFlag2=false,coinFlag3=false,coinFlag4=false,coinFlag5=false,coinFlag6=false,coinFlag7=false;
       boolean KnifeFlag=false;
       boolean lifeVisible=false,lifeVisible2=false,lifeVisible1=false;
       boolean enemyCollison=false,enemyCollison1=false,knifeFlag=false,knifeVisibleFlag=true;
       int knifeSignal=0;
       PokamanEnemy enm1,enm2;
       TimeWatch watch;
       Timer time;
       PokamanFrame gameFrame;
 
       static Font font=new Font("SanSerif",Font.CENTER_BASELINE,20);
       
       
       public PokamanPanel(PokamanFrame f) {
    	  
	        
           pMan = new Pokaman(this);
           gameFrame=f;
           setFocusable(true);
           addKeyListener(new AL());
           ImageIcon bG = new ImageIcon("E:\\Pokaman\\Images\\gameBackground9.png");
           ImageIcon BackgoundBottom = new ImageIcon("E:\\Pokaman\\Images\\gameBackground10.png");
           ImageIcon knife= new ImageIcon("E:\\Pokaman\\Images\\knife0.png");
           ImageIcon coin1= new ImageIcon("E:\\Pokaman\\Images\\coin25.png");
           ImageIcon coin2= new ImageIcon("E:\\Pokaman\\Images\\coin100.png");
           ImageIcon life= new ImageIcon("E:\\Pokaman\\Images\\life1.gif");
           ImageIcon lifeIcn= new ImageIcon("E:\\Pokaman\\Images\\lifeIcon.png");
           BackgroundImg = bG.getImage();
           knifeIcon=knife.getImage();
           lifeImgGIF=life.getImage();
           lifeIcon=lifeIcn.getImage();
           coinImg25=coin1.getImage();
           coinImg100=coin2.getImage();
           BottomImg=BackgoundBottom.getImage();
           this.initEnemy();
           watch = TimeWatch.start();
           time = new Timer(1, this);
           time.start();
           
           
     }
      
      
  	   public void actionPerformed(ActionEvent e) {
   	   
  		  this.requestFocus();
          pMan.move();
          ArrayList<Knife> knifes=pMan.getKnifes();
          for(int i=0;i<knifes.size();i++){
       	   Knife k=knifes.get(i);
       	   if(k.getVisible()){
       		   k.move();
       	   }
       	   else
       		   knifes.remove(i);
          }

          repaint(); 
   	}

   		
   private void initEnemy() {
    	   
		  enm1=new PokamanEnemy(1290,400,"E:\\Pokaman\\Images\\enemy1.gif");
		  enm2=new PokamanEnemy(1290,400+5,"E:\\Pokaman\\Images\\enemy2.gif");
		
	}
	public void paintComponent(Graphics g) {

           g2d = (Graphics2D) g;
          
          
           g2d.drawImage(BackgroundImg,1280-pMan.getiX1(), 0,this.getWidth(),this.getHeight() ,null);
           g2d.drawImage(BottomImg,1280-pMan.getiX1(),0,this.getWidth(),this.getHeight(), null);
           
           g2d.drawImage(BackgroundImg,this.getWidth()-pMan.getiX2(), 0,this.getWidth(),this.getHeight() ,null);
        
           g2d.drawImage(BottomImg,this.getWidth()-pMan.getiX2(), 0,this.getWidth(),this.getHeight(), null);
           if(pMan.getiX2()>=1272){
        	  pMan.iX1=1280;
        	  pMan.iX2=2;
           }
           this.paintCoins();
           this.paintEnemy();
           this.paintlife();
           this.checkCollisions();
           if(pMan.isAlive){
        	  g2d.drawImage(pMan.getHero(),pMan.getX(), pMan.getY(), null);
           }
           else{
        	   gameFrame.setVisible(false);
        	   ScoreFrame f=new ScoreFrame(score);

           }
           ArrayList<Knife> knifes=pMan.getKnifes();
  
           for(int i=0;i<knifes.size();i++){
        	   Knife k=knifes.get(i);
        	   System.out.println("knife");
        	   g2d.drawImage(k.getImage(),k.getX(),k.getY(),null);
           }
           int x=0; //using for icreasing lifeCount position 
           for(int i=0;i<totalLife;i++){
        	   g2d.drawImage(lifeIcon,1090+x,65,null);
        	   x+=32;
           }
           if(totalLife<=0){
        	   pMan.isAlive=false;
           }
           g2d.drawImage(knifeIcon,1090,22,null);
           g2d.drawImage(BottomImg,1280-pMan.getiX1(),0,this.getWidth(),this.getHeight(), null);
           g2d.drawImage(BottomImg,this.getWidth()-pMan.getiX2(), 0,this.getWidth(),this.getHeight(), null);
           g2d.setFont(font);
           g2d.setColor(Color.white);
           g2d.drawString("Score:"+score, 1100, 20);
           if(pMan.knifeCountSignal>80){
        	   g2d.setFont(font);
               g2d.setColor(Color.white);
               g2d.drawString("0"+pMan.knifesLeft, 1155, 54);
               
           }
           this.drawKnifeIcon();
           
         
    }
	public void paintlife() {
		  System.out.println(scoreCount);
		  if(scoreCount>=1000&&scoreCount<1100&&lifeVisible1==false){
			  lifeVisible=true;
			  lifeVisible1=true;
			  pMan.lifeX=10;
		  }
			
		  else if(scoreCount>=100&&scoreCount<200&&lifeVisible1==false){
			  
			  lifeVisible=true;
			  lifeVisible1=true;
			  pMan.lifeX=10;
		  }
		  else if(scoreCount>=3000&&scoreCount<3100&&lifeVisible1==false){
			  lifeVisible=true;
			  lifeVisible1=true;
			  pMan.lifeX=10;
		  }
		  if(scoreCount>=1000&&scoreCount<1300&&lifeVisible==true){
			  g2d.drawImage(lifeImgGIF,1240+pMan.lifeX,470, null);
			  if(pMan.lifeX<-2300)
				  lifeVisible1=false;
		  }
		  
		  if((scoreCount>=100)&&(scoreCount<350)&&lifeVisible==true){
			  g2d.drawImage(lifeImgGIF,1240+pMan.lifeX,470, null);
			  if(pMan.lifeX<-2600)
				  lifeVisible1=false;
		  }
		  if(scoreCount>=3000&&scoreCount<3300&&lifeVisible==true){
			  g2d.drawImage(lifeImgGIF,1240+pMan.lifeX,420, null);
			  if(pMan.lifeX<-2300){
				  lifeVisible1=false;
				  scoreCount=-500;
			  }
				  
		  }
		  if(pMan.lifeX<-2300)
			  lifeVisible1=false;
		
	}


	public void drawKnifeIcon(){
		   if(pMan.knifesLeft==0&&pMan.knifeCountSignal==1){
			   TimeWatch watch = TimeWatch.start();
			   long passedTimeInMiliSeconds = watch.time();
			   Thread t=new Thread(new Runnable(){
				  public  void run(){
					  long passedTimeInMiliSeconds = watch.time();
					  while(passedTimeInMiliSeconds<2000){
						  ++pMan.knifeCountSignal;  
						  passedTimeInMiliSeconds = watch.time();
						 
				          try {
				        	  g2d.setFont(font);
					          g2d.setColor(Color.red);
					          g2d.drawString("0"+pMan.knifesLeft, 1155,54);
					          Thread.sleep(20);
					          
						
						  } catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						  }
				          
					  }
					  
					   
				   }
			   });
			   t.start();
			   
	    	   
	           
	           
		   }

	           
    }

    private void paintEnemy() {
    	
    	 if(enm1.Alive()&&score>400){
	        	 
		        enm1.move(2);
		        g2d.drawImage(enm1.getImage(),enm1.getX(), enm1.getY(), null);
	    }
       	 if(enm2.Alive()&&score>200){
        	 
		        enm2.move(2);
		        g2d.drawImage(enm2.getImage(),enm2.getX(), enm2.getY(), null);
	    }
    	if(enm1.getX()<-5000){
                enemyCollison1=false;
                
    		    enm1.x=1290;
    		    enm1.isAlive=true;
    	}
    	if(enm1.isAlive==false){
    		    enemyCollison=false;
    	        enm1.isAlive=true;
    	        enm1.x=3000;
    	        enm2.x=1290;
    		    enm2.isAlive=true;
    	}
    	else if(enm2.isAlive==false){
    		enemyCollison1=false;
	        enm2.isAlive=true;
	        enm2.x=3000;
	        enm1.x=1290;
		    enm1.isAlive=true;

	}
     	      

    	 
		
	}
	private void paintCoins() {
        
		  long passedTimeInSeconds = watch.time(TimeUnit.SECONDS);
	       if(passedTimeInSeconds==2){
	    	   pMan.cX=10;
	    	   coin1=true;
	    	   coin2=true;
	    	   coin3=true;
	    	   coin4=true;
	    	   coin5=true;
	    	   coinFlag4=true;
	       }

	       if(coinFlag0){
	    	   if(coin1)g2d.drawImage(coinImg100,1240+pMan.cX,470, null);
	    	   this.checkCollisions();
	    	   if(coin2)g2d.drawImage(coinImg25,1320+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(coin3)g2d.drawImage(coinImg25,1400+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(coin4)g2d.drawImage(coinImg100,1480+pMan.cX,470, null);
	    	   this.checkCollisions();
	    	   if(coin5)g2d.drawImage(coinImg25,1660+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(pMan.cX<-2200){
	    	   coinFlag0=false;
    		   coinFlag2=true;
    		   pMan.cX=10;
    		   coin1=true;
	    	   coin2=true;
	    	   coin3=true;
	    	   coin4=true;
	    	   coin5=true;
    	       }
	       }
	       else if(coinFlag2){
	    	   if(coin1)g2d.drawImage(coinImg100,1240+pMan.cX,470, null);
	    	   this.checkCollisions();
	    	   if(coin2)g2d.drawImage(coinImg25,1320+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   coin3=false;
	    	   if(coin4)g2d.drawImage(coinImg100,1490+pMan.cX,470, null);
	    	   this.checkCollisions();
	    	   coin5=false;
	    	   if(pMan.cX<-2200){
	    		   coinFlag2=false;
	    		   coinFlag3=true;
	    		   pMan.cX=10;
	    		   coin1=true;
		    	   coin2=true;
		    	   coin3=true;
		    	   coin4=true;
		    	   coin5=true;
	    	   }
	    	   
	       }
	       else if(coinFlag3){
	    	   coin1=false;
	    	   if(coin2)g2d.drawImage(coinImg25,1320+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(coin3)g2d.drawImage(coinImg25,1400+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   coin4=false;
	    	   if(coin5)g2d.drawImage(coinImg25,1660+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(pMan.cX<-2200){
	    		   coinFlag3=false;
	    		   coinFlag4=true;
	    		   pMan.cX=10;
	    		   coin1=true;
		    	   coin2=true;
		    	   coin3=true;
		    	   coin4=true;
		    	   coin5=true;
	    	   }
	       }
	       else if(coinFlag4){
	    	   if(coin1)g2d.drawImage(coinImg100,1240+pMan.cX,470-40, null);
	    	   this.checkHighCoinCollisions();
	    	   if(coin2)g2d.drawImage(coinImg25,1320+pMan.cX,465-100, null);
	    	   this.checkHighCoinCollisions();
	    	   if(coin3)g2d.drawImage(coinImg25,1400+pMan.cX,465-100, null);
	    	   this.checkHighCoinCollisions();
	    	   if(coin4)g2d.drawImage(coinImg100,1480+pMan.cX,470-40, null);
	    	   this.checkHighCoinCollisions();
	    	   coin5=false;
	    	   if(pMan.cX<-2200){
	    		   coinFlag4=false;
	    		   coinFlag5=true;
	    		   pMan.cX=10;
	    		   coin1=true;
		    	   coin2=true;
		    	   coin3=true;
		    	   coin4=true;
		    	   coin5=true;
	    	   }
	       }
	       else if(coinFlag5){
	    	   if(coin1)g2d.drawImage(coinImg100,1240+pMan.cX,470, null);
	    	   this.checkCollisions();
	    	   coin2=false;
	    	   if(coin3)g2d.drawImage(coinImg25,1400+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   coin4=false;
	    	   coin5=false;
	    	   
	    	   if(pMan.cX<-2200){
	    		   coinFlag5=false;
	    		   coinFlag6=true;
	    		   pMan.cX=10;
	    		   coin1=true;
		    	   coin2=true;
		    	   coin3=true;
		    	   coin4=true;
		    	   coin5=true;
	    	   }
	       }
	       else if(coinFlag6){
	    	   coin1=false;
	    	   if(coin2)g2d.drawImage(coinImg25,1320+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(coin3)g2d.drawImage(coinImg25,1400+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   coin4=false;
	    	   if(coin5)g2d.drawImage(coinImg25,1660+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(pMan.cX<-2200){
	    		   coinFlag6=false;
	    		   coinFlag7=true;
	    		   pMan.cX=10;
	    		   coin1=true;
		    	   coin2=true;
		    	   coin3=true;
		    	   coin4=true;
		    	   coin5=true;
	    	   }
	       }
	       else if(coinFlag7){
	    	   coin1=false;
	    	   if(coin2)g2d.drawImage(coinImg25,1320+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(coin3)g2d.drawImage(coinImg25,1400+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   coin4=false;
	    	   if(coin5)g2d.drawImage(coinImg25,1660+pMan.cX,465, null);
	    	   this.checkCollisions();
	    	   if(pMan.cX<-2200){
	    		   coinFlag7=false;
	    		   coinFlag0=true;
	    		   pMan.cX=10;
	    		   coin1=true;
		    	   coin2=true;
		    	   coin3=true;
		    	   coin4=true;
		    	   coin5=true;
	    	   }
	       }
		       

		       
	    	   
      
       
        
	}
	private void checkHighCoinCollisions() {
		PokamanMusic coinMusic=new PokamanMusic();
		Rectangle poka=new Rectangle(pMan.x,pMan.y,pMan.hero.getWidth(null),pMan.hero.getHeight(null));
		Rectangle c1=new Rectangle(1240+pMan.cX+65,470+100-40,coinImg100.getWidth(null)-100,coinImg100.getHeight(null));
        Rectangle c2=new Rectangle(1320+pMan.cX+65,470+100-300,coinImg25.getWidth(null)-100,coinImg25.getHeight(null));
        Rectangle c3=new Rectangle(1400+pMan.cX+65,470+100-300,coinImg25.getWidth(null)-100,coinImg25.getHeight(null));
        Rectangle c4=new Rectangle(1490+pMan.cX+65,470+100-40,coinImg100.getWidth(null)-100,coinImg100.getHeight(null));
        
        if(poka.intersects(c1)&&coin1==true){
        	coinMusic.playCoinMusic();
        	coin1=false;
        	score+=100;
        	scoreCount+=100;
        	
        }
        if(poka.intersects(c2)&&coin2==true){
        	coinMusic.playCoinMusic();
        	coin2=false;
        	score+=25;
        	scoreCount+=25;
        	
        }
        if(poka.intersects(c3)&&coin3==true){
        	coinMusic.playCoinMusic();
        	coin3=false;
        	score+=25;
        	scoreCount+=25;
        	
        }
        if(poka.intersects(c4)&&coin4==true){
        	coinMusic.playCoinMusic();
        	coin4=false;
        	score+=100;
        	scoreCount+=100;
        }
		
	}


	public void checkCollisions()
	{
		Rectangle enemy1 = enm1.getBounds();
		Rectangle enemy2 = enm2.getBounds();
        Rectangle poka= pMan.getBounds();

		if (poka.intersects(enemy1)&&enemyCollison1==false){
			enemyCollison1=true;
			if(enemyCollison){
				pMan.x-=5;
				totalLife--;
			}
			
		}
		if (poka.intersects(enemy2)&&enemyCollison==false){
			enemyCollison=true;
			if(enemyCollison){
				pMan.x-=5;
				totalLife--;
			}
			
		}
		ArrayList<Knife> knifes = Pokaman.getKnifes();
		for (int w = 0; w < knifes.size(); w++)
		{   Rectangle r1 = enm1.getBounds();
		    Rectangle r2 = enm2.getBounds(); 
			Knife m = knifes.get(w);
			Rectangle m1 = m.getBounds();
			if (r1.intersects(m1) && enm1.Alive())
			{
				enm1.isAlive = false;
				m.visible = false;
			}
			else if (r2.intersects(m1)&& enm2.Alive())
			{
				enm2.isAlive = false;
				m.visible = false;
			}
		}
		this.checkCoinCollisions();
		this.checkLifeCollison();
		
	}
	public void checkLifeCollison() {
		Rectangle l1=new Rectangle(1240+pMan.lifeX,470,lifeIcon.getWidth(null),lifeIcon.getHeight(null));
        Rectangle poka= pMan.getBounds();
		if (poka.intersects(l1)&&lifeVisible==true){
			
			lifeVisible=false;
			if(totalLife<3){
				totalLife++;
			}
			if(totalLife==0){
				pMan.isAlive=false;
			}
		
	    }

		
	}


	public void checkCoinCollisions(){
		PokamanMusic coinMusic=new PokamanMusic();
		Rectangle poka= pMan.getBounds();
		Rectangle c1=new Rectangle(1240+pMan.cX+65,470+100,coinImg100.getWidth(null)-100,coinImg100.getHeight(null));
        Rectangle c2=new Rectangle(1320+pMan.cX+65,470+100,coinImg25.getWidth(null)-100,coinImg25.getHeight(null));
        Rectangle c3=new Rectangle(1400+pMan.cX+65,470+100,coinImg25.getWidth(null)-100,coinImg25.getHeight(null));
        Rectangle c4=new Rectangle(1490+pMan.cX+65,470+100,coinImg100.getWidth(null)-100,coinImg100.getHeight(null));
        Rectangle c5=new Rectangle(1660+pMan.cX+65,470+100,coinImg25.getWidth(null)-100,coinImg25.getHeight(null));
        
        if(poka.intersects(c1)&&coin1==true){
        	coinMusic.playCoinMusic();
        	coin1=false;
        	score+=100;
        	scoreCount+=100;
        	
        }
        if(poka.intersects(c2)&&coin2==true){
        	coinMusic.playCoinMusic();
        	coin2=false;
        	score+=25;
        	scoreCount+=25;
        	
        }
        if(poka.intersects(c3)&&coin3==true){
        	coinMusic.playCoinMusic();
        	coin3=false;
        	score+=25;
        	scoreCount+=25;
        	
        }
        if(poka.intersects(c4)&&coin4==true){
        	coinMusic.playCoinMusic();
        	coin4=false;
        	score+=100;
        	scoreCount+=100;
        	
        }
        if(poka.intersects(c5)&&coin5==true){
        	coinMusic.playCoinMusic();
        	coin5=false;
        	score+=25;
        	scoreCount+=25;
        	
        }
    
	}


	private class AL extends KeyAdapter {


    	   public void keyReleased(KeyEvent e) {
               pMan.keyReleased(e);
           }
           public void keyPressed(KeyEvent e) {
               pMan.keyPressed(e);
           }

       }

     
      



	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
	
	
	
}	
