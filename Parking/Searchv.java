package Parking;
import java.awt.event.*;
import java.awt.*;
import java.lang.String.*;
import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.sql.*;
public class Searchv extends JFrame
{
	
	static JFrame f;
	static JLabel bg,l2,disp;
	static JTextField t1;
	static JButton b1;

	
	public static void Search()
	{
		
		f=new JFrame("Search Vehicle");
		f.setLayout(null);
		f.setSize(740,480);
		
		//Enter Vehicle Number
		
		l2=new JLabel("Enter Vehicle Number ");
		l2.setBounds(250,10,350,30);
		l2.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l2);

		// Enter Text
		t1=new JTextField();
		t1.setBounds(250,70,300,40);
		f.add(t1);
		

		//Submit Button
		b1=new JButton("Submit");
		f.add(b1);
		b1.setBounds(320,150,100,40);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
						String Vno=null,Eid=null,Endate=null;
						String text=t1.getText();
						
						//Establish Connection
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con=DriverManager.getConnection("jdbc:odbc:Parking");
						
						
						//Insert Query
						String qry="Select * from Vehicle";
						Statement st=con.createStatement();
						Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

						//ResultSet
						ResultSet rs=st.executeQuery(qry);
	
						while(rs.next())
						{
							
							
							  Eid=rs.getString(1);
							  Vno=rs.getString(2);
							  Endate=rs.getString(3);
								
							//Matching Vehicle Number
							if(Vno.equals(text))
						{
						
JOptionPane.showMessageDialog(null,"Data Found\nEid : "+Eid+"\n Vehicle No : "+Vno+"\nEntry Date : "+Endate );
						}
						
							
						}

						
					}
					catch(Exception e){System.out.println("Exception ");}
					
					
				}
			});
		
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//end Search()		
	
	public static void main(String args[])throws Exception
	{
		Searchv.Search();
	}
}//end class