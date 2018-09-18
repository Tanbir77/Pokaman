import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.*;
public class ScoreFrame extends JFrame{
    	long score;
    	static Font font=new Font("SanSerif",Font.BOLD,100);
    	Graphics2D g2d;
    	ScorePanel scrPanel;

	public ScoreFrame(long score1){
		super("POKAMAN");
		this.score=score1;
	    //this.setLocation(0, 0);
	    this.setSize(1280,735);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
	    scrPanel=new ScorePanel(this.score,this);
	    this.add(scrPanel);
	    scrPanel.updateScore();
	    
		
	}


}
