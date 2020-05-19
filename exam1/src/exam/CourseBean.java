// Item Bean

package exam;

import  java.sql.*;
import  java.util.*;

import  exam.*;

public class CourseBean
{
    private  String cname,ccode;


    public  void setCname(String cname)
    { this.cname = cname; }

    public String getCname()
    {  return cname; }

    public  void setCcode(String ccode)
    { this.ccode= ccode; }

    public String geCcode()
    {  return ccode; }


    public boolean add()
    {

     Connection con = null;
     PreparedStatement ps = null;
     try
     {
      con = DBUtil.getConnection();
      // get next itemid
      ps = con.prepareStatement("insert into courses  values (?,?)");
      ps.setString(1,ccode);
      ps.setString(2,cname);
      ps.executeUpdate();
      return true;
      }
      catch(Exception ex)
      {
       System.out.println(ex.getMessage());
       return false;
      }
      finally
      {
        DBUtil.clean(con,ps);
      }

   } // end of add

} // end of bean








