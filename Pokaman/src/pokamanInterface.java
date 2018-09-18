import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class pokamanInterface implements ActionListener,MouseListener {
	
    PokamanFrame f;
    PokamanMusic m;

    
	public pokamanInterface(PokamanFrame pf,PokamanMusic pm){
		f=pf;
		m=pm;
		this.addLisToButton();
	
		
	
		
		
	}
	

    
	private void addLisToButton() {
		f.btnPlay.addMouseListener(new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
				
				
				
				
			}
			
			
			public void mousePressed(MouseEvent e) {
			
				
			}
			
			
			public void mouseExited(MouseEvent e) {
				  f.btnPlay.setBackground(Color.cyan);
				  m.puseBeep();
				
			}
			
			
			public void mouseEntered(MouseEvent e) {
				  f.btnPlay.setBackground(Color.red);
				  m.playBeep();
				 
				
			}
			
			
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		
		f.btnPlay.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				m.stopOpeningMusic();
				f.removeComponent();
			    f.setLayout(new BorderLayout());
			    PokamanPanel pokaPanel=new PokamanPanel(f);
				f.add(pokaPanel);
				m.playGamePlayMusic();
				//m.playCoinMusic();
				
	
			}  
		});
		
	
       f.btnHighscore.addMouseListener(new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
				
			}
			
			
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			
			public void mouseExited(MouseEvent e) {
				 f.btnHighscore.setBackground(Color.cyan);
				 m.puseBeep();
				
			}
			
			
			public void mouseEntered(MouseEvent e) {
				
				  f.btnHighscore.setBackground(Color.red);
			      m.playBeep();
				//m.puseBeep();
			}
			
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
       
       
       f.btnHighscore.addActionListener(new ActionListener() {
   		
   		
		   public void actionPerformed(ActionEvent arg1) {
			    m.stopOpeningMusic();
				f.setVisible(false);
				ScoreFrame f=new ScoreFrame(0);
				f.scrPanel.showScoreList();
				
		   }
		   
	    });
       
         
       f.btnInstruction.addMouseListener(new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			
			public void mousePressed(MouseEvent e) {
				
			}
			
			
			public void mouseExited(MouseEvent e) {
				  f.btnInstruction.setBackground(Color.cyan);
				  m.puseBeep();
			}
			
			
			public void mouseEntered(MouseEvent e) {
				  f.btnInstruction.setBackground(Color.red);
				  m.playBeep();
				//m.puseBeep();
			}
			
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});
       
       f.btnInstruction.addActionListener(new ActionListener() {
		
		
		   public void actionPerformed(ActionEvent arg1) {
			    m.stopOpeningMusic();
				f.removeComponent();
				BorderLayout bdr=new  BorderLayout();
     			f.setLayout(new BorderLayout());
     			JPanel pnl = new JPanel();
     			JLabel instructionlbl = new JLabel("INSTRUCTION"
     					+ "         1. to move forward press RIGHT KEY and to move backward press LEFT KEY"
     					+ "         2. to Jump press SPACE KEY"
     					+ "         3. to throw Knives press CTRL KEY");
     			instructionlbl.setFont(new Font("SanSerif", Font.BOLD, 15));
     						
     			pnl.add(instructionlbl);
     			
     			f.add(pnl);
     			
 
     	            
     	    }


		   
	    });

           
       
       f.btnExit.addMouseListener(new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			
			public void mousePressed(MouseEvent e) {
				
			}
			
			
			public void mouseExited(MouseEvent e) {
				  f.btnExit.setBackground(Color.cyan);
				  m.puseBeep();
			}
			
			
			public void mouseEntered(MouseEvent e) {
				  f.btnExit.setBackground(Color.red);
				  m.playBeep();
				  
				//m.puseBeep();
			}
			
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});
       
       f.btnExit.addActionListener(new ActionListener() {
   		
   		
		    public void actionPerformed(ActionEvent arg1) {
			     System.exit(0);
		    }
		   
	    });
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
	

	











}


