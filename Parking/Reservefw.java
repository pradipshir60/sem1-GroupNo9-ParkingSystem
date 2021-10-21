package Parking;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.Date;

public class Reservefw extends JFrame
{
	static JFrame f=new JFrame("Reserve  Slot 4- Wheeler");
	static JLabel l2,l1,l3,l4,l6,fee;
	static JLabel date;
	static ResultSet rs,rs1;
	static int pid,eid=0;
	static String bpid,spid;
	static JTextField t1,t2,t3,ft;
	static JTextArea r1;
	static JLabel title;
	static Date tdate;
	public static void Reservefourwheeler()
	{
		
		//DataBase
	
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:Parking");
		
		String qry="select * from Vehicle";
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(qry);
		
		while(rs.next())
		{
			eid=Integer.parseInt(rs.getString(1));
		}
		
		
		String qry1="select Bid,Sno from Block where Btype='Four Wheeler' and status='empty' ";
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs1=st.executeQuery(qry1);
		if(rs1.next())
		{
			bpid=rs1.getString(1);
			spid=rs1.getString(2);


		//Title 4-Wheeler Details
		title=new JLabel("Enter Four Wheeler Details");
		title.setBounds(250,10,350,30);
		title.setFont(new Font("Arial",Font.BOLD,20));
		f.add(title);


		 //Receipt id
		l1=new JLabel("Receipt id");
		l1.setBounds(30,70,300,40);
		f.add(l1);
		l1.setFont(new Font("Arial",Font.BOLD,17));
		
		//Receipt id
		l6=new JLabel(Integer.toString(++eid));
		l6.setBounds(250,70,300,40);
		l6.setFont(new Font("Arial",Font.BOLD,17));
		f.add(l6);
		
		 //Parking id
		l4=new JLabel("Parking id : ");
		l4.setBounds(30,200,300,40);
		f.add(l4);
		l4.setFont(new Font("Arial",Font.BOLD,17));
		
		//Parking ID
		t2=new JTextField(bpid);
		t2.setBounds(250,200,300,40);
		t2.setEditable(false);
		t2.setText(t2.getText()+""+spid);
		//t2.setEditable(false);
		f.add(t2);
		
		
		
		//Enter Four Wheeler Number
		l3=new JLabel("Enter 4-Wheeler Number : ");
		l3.setBounds(30,130,300,40);
		f.add(l1);
		l3.setFont(new Font("Arial",Font.BOLD,17));
		
		
		//TextField
		t1=new JTextField();
		t1.setBounds(250,120,300,40);
		f.add(t1);
	
	
		//Date
		date=new JLabel("Date : ");
		f.add(date);
		date.setBounds(30,300,100,40);
		date.setFont(new Font("Arial",Font.BOLD,17));
		
		//TextField
		t3=new JTextField();
		f.add(t3);
		t3.setBounds(250,300,300,40);
		tdate=new Date();
		t3.setEditable(false);
		t3.setText(DateFormat.getDateInstance().format(tdate));
		t3.setFont(new Font("Arial",Font.BOLD,17));
		
		//Fee
		fee=new JLabel("Four Wheeler Fee : ");		
		f.add(fee);
		fee.setBounds(30,350,300,40);
		fee.setFont(new Font("Arial",Font.BOLD,16));
		
		
		//Fee TextField
		ft=new JTextField();
		f.add(ft);
		ft.setBounds(250,350,100,40);
		ft.setEditable(false);
		ft.setText("30");
		ft.setFont(new Font("Arial",Font.BOLD,17));
		
		
		//Recipt TextField
		r1=new JTextArea();
		f.add(r1);
		r1.setBounds(600,70,600,400);
		r1.setFont(new Font("Arial",Font.BOLD,29));
		
		
		//Button
		JButton b1;
		b1=new JButton("Submit");
		f.add(b1);
		b1.setBounds(300,500,100,40);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection cn=DriverManager.getConnection("jdbc:odbc:Parking");
					
					String qry="insert into Vehicle values(?,?,?,?,?,?)";
					String qry2="update Block set status='Reserved' where Bid=? and Sno=?";
					PreparedStatement ps1=cn.prepareStatement(qry);
					PreparedStatement ps2=cn.prepareStatement(qry2);
					
					ps1.setInt(1,eid);
					ps1.setString(2,t1.getText());
					ps1.setString(3,t3.getText());
					ps1.setString(4,t3.getText());
					ps1.setString(5,t2.getText());
					ps1.setString(6,ft.getText());
					ps2.setString(1,bpid);
					ps2.setString(2,spid);
					
					
					ps1.executeUpdate();
					ps2.executeUpdate();
					
					
					//Print Receipt
					
					r1.setText("\n********************************************************\n");
					r1.setText(r1.getText()+"                             Receipt  \n\n");
					r1.setText(r1.getText()+"                 Receipt id : "+eid+"\n");
					r1.setText(r1.getText()+"                 Vehicle NO : "+t1.getText()+"\n");
					r1.setText(r1.getText()+"                 Entry Date : "+t3.getText()+"\n");
					r1.setText(r1.getText()+"                 Parking id : "+t2.getText()+"\n");
					r1.setText(r1.getText()+"                 Fees       : 30\n");
					r1.setText(r1.getText()+"********************************************************\n");
					
					r1.print();
				
				//Close Database Connecion	
					cn.close();
					
				
					
					
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Repeated");
				}
			}
		});
		
		f.setSize(1500,800);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"No Slot Available");
		}
		}catch(Exception ex){}
	}
	public static void main(String args[])
	{
		Reservefw.Reservefourwheeler();
	}
}