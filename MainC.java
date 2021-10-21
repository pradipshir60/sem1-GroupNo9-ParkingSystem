import Parking.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainC implements ActionListener
{	
	
	JLabel bg;
	JFrame mf;
	JMenuBar mb;
	JMenu rvslot,rlslot,ablock,search;
	JMenuItem rvtwh,rvfwh,rltwh,rlfwh,serveh,nblock;
	MainC()
	{
		mf=new JFrame("Reserve Parking Slot Management");//Main frame name	
		mb=new JMenuBar();
		
		//set Background image
		ImageIcon img = new ImageIcon("jay.jpg"); 
		bg= new JLabel("",img,JLabel.CENTER);
		bg.setBounds(0,0,1900,1000);
		mf.add(bg);
		
		
		nblock=new JMenuItem("New Block");
		nblock.addActionListener(this);
		
		rvslot=new JMenu("Reserve Slot");
		rlslot=new JMenu("Release Slot");
		search=new JMenu("Search Vehicle");
		ablock=new JMenu("Add Block");
		ablock.add(nblock);
		
		rvtwh=new JMenuItem("Two Wheeler");
		rvtwh.addActionListener(this);
		rvfwh=new JMenuItem("Four Wheeler");
		rvfwh.addActionListener(this);
		
		rltwh=new JMenuItem("Two Wheeler");
		rltwh.addActionListener(this);
		rlfwh=new JMenuItem("Four Wheeler");
		rlfwh.addActionListener(this);
		
		serveh=new JMenuItem("Search Vehicle NO.");
		serveh.addActionListener(this);
		
		rvslot.add(rvtwh);
		rvslot.add(rvfwh);
		
		rlslot.add(rltwh);
		rlslot.add(rlfwh);
		
		search.add(serveh);
		
		mb.setBounds(0,0,500,100);
		mb.add(rvslot);
		mb.add(rlslot);
		mb.add(search);
		mb.add(ablock);

		mf.add(mb);
		mf.setJMenuBar(mb);
		
		
		mf.setSize(1900,1080);
		mf.setLayout(null);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==nblock)
		{
			//Add Parking Block frame
			Ablock.adblock();
			
		}
		if(ae.getSource()==rvtwh)
		{
		
			//Reserved 2 wheeler frame
			Reserve.Reservetwowheeler();
		}
		if(ae.getSource()==rvfwh)
		{
			
			//Reserved 4 wheeler frame
			Reservefw.Reservefourwheeler();
		}
		if(ae.getSource()==rltwh)
		{
			//Release 2 wheeler frame
			Releasetw.Releasetwowheeler();
			
		}
		if(ae.getSource()==rlfwh)
		{
			//Release 4 wheeler frame
			Releasefw.Releasefourwheeler();
			
		}
		if(ae.getSource()==serveh)		
		{
			//Search Vehicle Info Frame
			Searchv.Search();
		}	
	}
	public static void main(String[] args)
	{
		new MainC();
	}
}