import Parking.*;
//package Parking;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
class Login extends JFrame //implements ActionListener
{
	static JTextField t1;
	static JPasswordField p;
	static JFrame f1;
	public static void main(String[] args)
	{
		f1=new JFrame("Log In");
		f1.setLayout(null);
		
		JLabel title=new JLabel("Reserved Parking System");
		title.setFont(new Font("Arail",Font.PLAIN,18));
		title.setBounds(150,10,300,30);
		f1.add(title);
		
		JLabel l1=new JLabel("Username");
		l1.setFont(new Font("Arail",Font.PLAIN,18));
		l1.setBounds(50,50,100,30);
		f1.add(l1);
		
		t1=new JTextField();
		t1.setFont(new Font("Arail",Font.PLAIN,18));
		t1.setBounds(200,50,200,30);
		f1.add(t1);
		
		JLabel l2=new JLabel("Password");
		l2.setFont(new Font("Arail",Font.PLAIN,18));
		l2.setBounds(50,100,100,30);
		f1.add(l2);
		
		p=new JPasswordField();
		p.setBounds(200,100,200,30);
		f1.add(p);
		
		JButton b=new JButton("Login");
		b.setBounds(200,200,100,30);
		f1.add(b);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				char[] pass=new char[]{'J','a','y'};
				String uname="Parking";
				if(Arrays.equals(p.getPassword(),pass)&&uname.equals(t1.getText()))
				{
					try
					{
						new MainC();
						
						f1.dispose();
					}
					catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Worng Username or Password","Alert",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		f1.setBounds(350,200,500,300);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setVisible(true);
	}//
}