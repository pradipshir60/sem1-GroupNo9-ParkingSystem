import java.sql.*;
class NewS
{
	public static void main(String[] args)
	{
		try
		{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:Parking");
				
				String a="A",i="1";
				String qry="update Block set status='empty' where Bid=? and Sno=?";
				PreparedStatement ps1=cn.prepareStatement(qry);
				//Statement ps2=cn.createStatement();
					
					
					
					ps1.setString(1,a);
					ps1.setString(2,i);
				
				ps1.executeUpdate();
				//JOptionPane.showMessageDialog(null,"Successfully Released");
				//f.dispose();
					
					//JOptionPane.showMessageDialog(null,spid);
				cn.close();
				//JOptionPane.showMessageDialog(null,"HI");
		}catch(Exception ex)
		{
				//JOptionPane.showMessageDialog(null,"Repeated");
		}
		//cn.close();
	}
}