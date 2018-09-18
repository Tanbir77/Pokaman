import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import javax.swing.*;

public class ScorePanel extends JPanel implements ActionListener{
	long score;
	Image BackgroundImg;
	static Font font=new Font("SanSerif",Font.BOLD,100);
	static Font font1=new Font("SanSerif",Font.BOLD,40);
	static Font fontTable=new Font("SanSerif",Font.BOLD,20);
	Graphics2D g2d;
	JButton btnEnter;
	JTextField txtName;
	static String s6;
	ScoreFrame frame;
      public ScorePanel(long score2,ScoreFrame frm){
    	  frame=frm;
    	  this.score=score2;
    	  ImageIcon bG = new ImageIcon("E:\\Pokaman\\Images\\gameBackground6.png");
          BackgroundImg = bG.getImage();
 
          
      }

		public void paintComponent(Graphics g) {
      		
            g2d = (Graphics2D) g;
            g2d.drawImage(BackgroundImg,0, 0,this.getWidth(),this.getHeight() ,null);
            g2d.setFont(font);
            g2d.setColor(Color.black);
            g2d.drawString("Game Over",400,350);
            g2d.setFont(font1);
            g2d.setColor(Color.BLUE);
            g2d.drawString("Score: "+score,580,400);

        }

      public void updateScore(){
    	  this.dataBase();
      }
  	
  	public void dataBase() {
  		this.setLayout(null);
  		JLabel lblName=new JLabel("Name");
  		lblName.setBounds(450, 40,100,30);
  		lblName.setFont(new Font("name  ", Font.ITALIC, 24));
  		lblName.setForeground(Color.BLACK);
  		txtName=new JTextField(8);
  		txtName.setBounds(560, 40, 100,30);
  		String s1="";
  		String s2="Score :";
  		s1=s2+String.valueOf(score);
  		JLabel lblScr=new JLabel(s1);
  		lblScr.setBounds(680, 40, 200,30);
  		lblScr.setFont(new Font("name  ", Font.ITALIC, 24));
  		lblScr.setForeground(Color.BLACK);
  		btnEnter=new JButton("Enter");
  		btnEnter.setFont(new Font("name  ", Font.ITALIC, 24));
  		btnEnter.setForeground(Color.BLACK);
  		btnEnter.setBackground(Color.CYAN);
  		btnEnter.setBounds(560, 100,100,30);
  		btnEnter.addActionListener(this);
  		
  		
  	    int minValue=0;
  
  	    String url = "jdbc:mysql://localhost:3306/pokamandb";
  	    String username = "root";
  	    String password = "";

  	    Connection connection=null;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    Statement stmt=null;

  	    try {

  	        stmt = connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	    	try {
				stmt.execute("SELECT MIN(Score) FROM HighScore");
	  	    	ResultSet rs2 = stmt.getResultSet(); // 
	  	    	if ( rs2.next() ){
	  	    	  minValue = rs2.getInt(1);
	  	    	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    

  	    	
  	    
  	    if(score>minValue){
  	    	this.add(lblName);
  	  		this.add(txtName);
  	  		this.add(lblScr);
  	  		this.add(btnEnter);

  	  		
  	    }
		
	}
    
  	public void actionPerformed(ActionEvent e) {
		
		s6=txtName.getText();
		System.out.println(s6);
		  int minValue=0;
		  
	  	    String url = "jdbc:mysql://localhost:3306/pokamandb";
	  	    String username = "root";
	  	    String password = "";

	  	    Connection connection=null;
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
	  	    Statement stmt=null;

	  	    try {

	  	        stmt = connection.createStatement();
	  	    	stmt.execute("SELECT MIN(Score) FROM HighScore");    
	  	    	ResultSet rs2 = stmt.getResultSet(); // 
	  	    	if ( rs2.next() ){
	  	    	  minValue = rs2.getInt(1);
	  	    	}
	  	    	
				
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
	  	    
	  	    
	  	    
	  	    	
	  	  		System.out.println(s6);
	  	  		
	  	  	String sql="UPDATE HighScore SET Name='"+s6+"',Score='"+score+"' WHERE Score = '"+minValue+"'";
	  	  		try {
					Statement pst=connection.prepareStatement(sql);
					
					pst.execute(sql);
					ScoreFrame frm=new ScoreFrame(0);
					frm.scrPanel.showScoreList();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
	  	    
		
	}

  	public void showScoreList() {
  		this.removeAll();
  		this.showAllScore();
  		
  	}
	public void showAllScore() {

		ImageIcon bG = new ImageIcon("E:\\Pokaman\\Images\\ga.png");
        BackgroundImg = bG.getImage();
        repaint();
		ArrayList<String> columnNames = new ArrayList<String>();
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        String url = "jdbc:mysql://localhost:3306/pokamandb";
        String userid = "root";
        String password = "";
        String sql = "SELECT * FROM HighScore ORDER BY Score DESC";

      try (Connection connection = DriverManager.getConnection( url, userid, password );
          Statement stmt = connection.createStatement();
          ResultSet rs = stmt.executeQuery( sql ))
      {
          ResultSetMetaData md = rs.getMetaData();
          int columns = md.getColumnCount();

         
          for (int i = 1; i <= columns; i++)
          {
              columnNames.add( md.getColumnName(i) );
          }

          //  Get row data
          while (rs.next())
          {
              ArrayList<Object> row = new ArrayList<Object>(columns);

              for (int i = 1; i <= columns; i++)
              {
                  row.add( rs.getObject(i) );
              }

              data.add( row );
          }
      }
      catch (SQLException e)
      {
          System.out.println( e.getMessage() );
      }


      Vector<String> columnNamesVector = new Vector<String>();
      Vector<Vector> dataVector = new Vector<Vector>();

      for (int i = 0; i < data.size(); i++)
      {
          ArrayList subArray = data.get(i);
          Vector subVector = new Vector();
          for (int j = 0; j < subArray.size(); j++)
          {
              subVector.add(subArray.get(j));
          }
          dataVector.add(subVector);
      }

      for (int i = 0; i < columnNames.size(); i++ )
          columnNamesVector.add(columnNames.get(i));


      JTable table = new JTable(dataVector, columnNamesVector)
      {
          public Class getColumnClass(int column)
          {
              for (int row = 0; row < getRowCount(); row++)
              {
                  Object o = getValueAt(row, column);

                  if (o != null)
                  {
                      return o.getClass();
                  }
              }

              return Object.class;
          }
      };

      JScrollPane scrollPane = new JScrollPane( table );
      //scrollPane.setBackground(Color.CYAN);
      this.setLayout(new BorderLayout());
      scrollPane.setPreferredSize(getMaximumSize());
      
      table.setRowHeight(44);
      
      table.setForeground(Color.magenta);
      table.setFont(fontTable);
      scrollPane.getViewport().setBackground(Color.DARK_GRAY);
      
      this.add( scrollPane, BorderLayout.CENTER );
      this.add( new JLabel( "my label" ), BorderLayout.SOUTH );
		
	}
	




}
