import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PokamanFrame extends JFrame{ 
	
	
	JButton btnPlay,btnOption,btnHighscore,btnInstruction,btnExit;
	JLabel background;
	
  
	
	public PokamanFrame(String s1) {
	
		    super(s1);
		    this.setLocation(0, 0);
		    this.setSize(1280,735);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
		    setLayout(new FlowLayout());
			
            this.setLocationRelativeTo(null);
//            this.add(new PokamanPanel());

			
			
	        background=new JLabel(new ImageIcon("E:\\Pokaman\\Images\\cover3.png"));
	        background.setLayout(new GridBagLayout());
	        add(background);
	        
	        
	        this.initButton();
	        this.btnDesign();
	        this.addButtonToLebel(background);	
//	          
//	         
//		
		    //PokamanPanel panel= new PokamanPanel();
		 
		 
		
		 
		 
    }
	public void removeComponent(){
		this.background.setFocusable(false);
	    this.background.setVisible(false);
	}
	public void initButton (){
		
		
		btnPlay=new JButton(" Play ");
		btnOption=new JButton("Option");
		btnHighscore=new JButton("High Score");
		btnInstruction=new JButton("Instruction");
		btnExit=new JButton("Exit");
    }
    public void btnDesign(){
    	
    	
    	btnPlay.setFont(new Font("name  ", Font.ITALIC, 38));
    	
    	btnPlay.setBackground(Color.CYAN);
    	btnPlay.setForeground(Color.black);
    	
    	btnOption.setFont(new Font("name  ", Font.ITALIC, 38));
    	btnOption.setBackground(Color.CYAN);
    	btnOption.setForeground(Color.black);
    	
        btnHighscore.setFont(new Font("name  ", Font.ITALIC, 38));
    	btnHighscore.setBackground(Color.CYAN);
    	btnHighscore.setForeground(Color.black);
    	
    	btnInstruction.setFont(new Font("name  ", Font.ITALIC, 38));
    	btnInstruction.setBackground(Color.CYAN);
    	btnInstruction.setForeground(Color.black);
    	
    	btnExit.setFont(new Font("name  ", Font.ITALIC, 38));
    	btnExit.setBackground(Color.CYAN);
    	btnExit.setForeground(Color.black);
    	
    }
   public void addButtonToLebel(JLabel background){
		
		GridBagConstraints p = new GridBagConstraints();
		p.fill = GridBagConstraints.HORIZONTAL;

		p.gridx =1;
		p.gridy =10;
		background.add(btnPlay,p);
		
		

		p.fill=GridBagConstraints.HORIZONTAL;
		
		p.gridx=1;
		p.gridy=20;
		background.add(btnOption, p);
		
		
		p.fill=GridBagConstraints.HORIZONTAL;
		
		p.gridx=1;
		p.gridy=50;
		background.add(btnHighscore, p);
		
		
		p.fill=GridBagConstraints.HORIZONTAL;
			
		p.gridx=1;
		p.gridy=110;
		background.add(btnInstruction,p);
		
		
		
		p.fill=GridBagConstraints.HORIZONTAL;
			
		p.gridx=1;
		p.gridy=160;
		background.add(btnExit,p);
		
		
		
	}
	
	
	
}
	
	 


