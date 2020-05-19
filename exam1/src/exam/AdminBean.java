// Member Bean
package exam;

import java.sql.*;
import exam.*;

public class AdminBean
{

    public boolean login( String pwd)
    {
     Connection con = null;
     PreparedStatement ps = null;
     boolean logged = false;
     try
     {
      con = DBUtil.getConnection();
      ps = con.prepareStatement("select pwd  from password");
      ResultSet rs = ps.executeQuery();
      rs.next();
      String actualpwd = rs.getString(1);
      if ( pwd.equals(actualpwd))
        return true;
      else
        return false;
     }
     catch(Exception ex)
     {
         System.out.println( ex.getMessage());
         return false;
     }
     finally
     {
       DBUtil.clean(con,ps);
     }

 } // end of login

 public boolean updatePassword(String newpwd)
 {
   Connection con = null;
   PreparedStatement ps= null;

   try
   {
     con = DBUtil.getConnection();
     String cmd = "update password set pwd = ?";
     ps = con.prepareStatement(cmd);
     ps.setString(1,newpwd);
     int cnt = ps.executeUpdate();
     if ( cnt==1 )
        return true;
     else
        return false;
   }
   catch(Exception ex)
   {
      System.out.println( "Error : " + ex.getMessage());
      return false;
   }
   finally
   {
       DBUtil.clean(con,ps);
   }

} // end of updatePassword


public  void clean(Connection con, PreparedStatement ps)
{
   try
   { if ( ps != null )  ps.close();
     if ( con != null) con.close();
   }
    catch(Exception ex)
   { System.out.println(ex.getMessage()); }
 }

 public static Connection  getConnection() throws Exception
 {
   Class.forName("oracle.jdbc.driver.OracleDriver");
   // connect using Thin driver
   Connection con =   DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle8i",
		"exam","exam");
   return con;
 }

} // end of bean








