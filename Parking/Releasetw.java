package Parking;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class Releasetw extends JFrame
{
	
	static JLabel l1,l2,l3;
	static JTextField t1,t2;
	static JButton b1;
	static JFrame f=new JFrame("Two Wheeler Release Parking Slot");
	
	
	public static void Releasetwowheeler()
	{

		
		
		l2=new JLabel("Release 2-Wheeler Parking Slot");
		l2.setBounds(250,10,350,30);
		l2.setFont(new Font("Arial",Font.BOLD,20));
		f.add(l2);

		//Enter Bid 
		l1=new JLabel("Enter Bid:");
		l1.setBounds(16,100,250,40);
		f.add(l1);
		l1.setFont(new Font("Arial",Font.BOLD,16));
		
		// Enter Text
		t1=new JTextField();
		t1.setBounds(250,100,300,40);
		f.add(t1);


		//Enter Sid 
		l3=new JLabel("Enter SNo:");
		l3.setBounds(16,150,250,40);
		f.add(l3);
		l3.setFont(new Font("Arial",Font.BOLD,16));
		
		// Enter Text
		t2=new JTextField();
		t2.setBounds(250,150,300,40);
		f.add(t2);		
		
		
		
		
		
		//Submit Button
		b1=new JButton("Submit");
		f.add(b1);
		b1.setBounds(320,280,100,40);
		b1.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent ae)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection cn=DriverManager.getConnection("jdbc:odbc:Parking");
					
					String blk=t1.getText();
					String srno=t2.getText();
					String qry="update Block set status='empty' where Bid=? and Sno=? and Btype='Two Wheeler'";
					PreparedStatement ps1=cn.prepareStatement(qry);
					//Statement ps2=cn.createStatement();
					
					
					
					ps1.setString(1,blk);
					ps1.setString(2,srno);
					
					ps1.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Released");
					f.dispose();
					
					//JOptionPane.showMessageDialog(null,spid);
					cn.close();

				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Already Free..");
				}
			}});
		
		
		
		f.setSize(800,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String args[])
	{
		Releasetw.Releasetwowheeler();
	}
}