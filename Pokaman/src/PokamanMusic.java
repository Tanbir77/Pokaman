import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import javazoom.jl.player.Player;

public class PokamanMusic {

	Player openingMusic,beep,gamePlay,coin;
	
	public PokamanMusic(){
		
		
		
	}
	
	public void playOpeningMusic(){
		try{
			String openingMusicFile="E:\\Pokaman\\Music\\Cover.mp3";
	        FileInputStream fis     = new FileInputStream(openingMusicFile);
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        openingMusic = new Player(bis);
			openingMusic.play();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void playBeep(){
		try{
			String beepFile="E:\\Pokaman\\Music\\beep1.mp3";
	        FileInputStream fis     = new FileInputStream(beepFile);
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        beep = new Player(bis);
			beep.play();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void playGamePlayMusic(){
		Thread t = new Thread(new Runnable() {

			public void run() {
				TimeWatch watch = TimeWatch.start();
			    
				while(true){
					long passedTimeInSeconds = watch.time(TimeUnit.SECONDS);
	                if(passedTimeInSeconds==0||passedTimeInSeconds==136){
	                	watch = TimeWatch.start();
	                	
	                	try{
	            			String beepFile="E:\\Pokaman\\Music\\gamePlay.mp3";
	            	        FileInputStream fis= new FileInputStream(beepFile);
	            	        BufferedInputStream bis = new BufferedInputStream(fis);
	            	        gamePlay = new Player(bis);
	            			gamePlay.play();
	            		}catch (Exception e) {
	            			System.out.println(e);
	            		}
	                }
						
				}
			}
			
		});
		t.start();
	
	}
	public void playCoinMusic(){
		
		Thread t = new Thread(new Runnable() {

			public void run() {
					try{
						String beepFile="E:\\Pokaman\\Music\\coin1.mp3";
				        FileInputStream fis     = new FileInputStream(beepFile);
				        BufferedInputStream bis = new BufferedInputStream(fis);
				        coin = new Player(bis);
						coin.play();
					}catch (Exception e) {
						System.out.println(e);
					}
				
			    
				
			}
			
		});
		t.start();
		
	}
	public void stopOpeningMusic(){
		openingMusic.close();
	}
	public void puseBeep() {
		 try{
			 beep.close(); 
		 }catch(Exception e){
			 
		 }
		  
	}
	public void puseGamePlayMusic() {
		  gamePlay.close();
	}
    
	


    
 
	
	
   

}
