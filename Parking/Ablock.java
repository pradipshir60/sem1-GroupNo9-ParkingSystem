package Parking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Ablock extends JFrame
{
	static JTextField t1,t2;
	static JLabel title,l1,l2;
	static JButton b;
	static JFrame f=new JFrame("Hello");
	static JComboBox cbox;
	public static void adblock()
	{
		f.setLayout(null);
		title=new JLabel("Enter Block Details");
		title.setBounds(335,35,250,20);
		title.setFont(new Font("Arial",Font.BOLD,25));
		f.add(title);
		
		l1=new JLabel("Enter Block Letter :");
		l1.setBounds(150,98,300,30);
		f.add(l1);
		
		t1=new JTextField();
		t1.setBounds(280,100,300,30);
		f.add(t1);
		
		l2=new JLabel("Enter How Many Slots :");
		l2.setBounds(140,150,300,30);
		f.add(l2);
		
		t2=new JTextField();
		t2.setBounds(280,150,300,30);
		f.add(t2);
		
		String[] str={"Two Wheeler","Four Wheeler"};
		cbox=new JComboBox(str);
		cbox.setBounds(360,300,100,30);
		f.add(cbox);
		
		b=new JButton("Submit");
		b.setSize(100,30);
		b.setLocation(360,400);
		f.add(b);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con=DriverManager.getConnection("jdbc:odbc:Parking");
					String bid=t1.getText();
					int tsno=Integer.parseInt(t2.getText());//type casting
					String btype=(String)cbox.getSelectedItem();//type casting
					String qry="insert into Block values(?,?,?,?)";
					for(int i=1;i<=tsno;i++)
					{
						PreparedStatement ps1=con.prepareStatement(qry);
						ps1.setString(1,bid);	
						ps1.setString(2,Integer.toString(i));
						ps1.setString(3,btype);
						ps1.setString(4,"empty");
						ps1.executeUpdate();
					}
					JOptionPane.showMessageDialog(null,"Success");
					
					con.close();
				
				}catch(Exception ex){ex.printStackTrace();}
			}
		});
		
		f.setBounds(100,100,1000,600);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		Ablock.adblock();
	}
}
