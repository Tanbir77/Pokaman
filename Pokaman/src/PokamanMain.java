






public class PokamanMain  {
    public static void main(String []args) throws Exception{
    	
    
         	PokamanFrame myGame=new PokamanFrame("POKAMAN");
         	System.out.print("WELCOME");
    	    myGame.setVisible(true);
    	    PokamanMusic gameMusic=new PokamanMusic();
    	    pokamanInterface i=new pokamanInterface(myGame, gameMusic);
		    gameMusic.playOpeningMusic();
			
			
    }
}
