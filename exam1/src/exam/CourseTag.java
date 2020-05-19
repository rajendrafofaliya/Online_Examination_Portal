package exam;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import exam.*;

public class CourseTag extends TagSupport
{
  String ccode="";
  public  void setValue(String value)
  {
	   ccode = value;
  }

  public int doEndTag()
  {
	  Connection con = null;
	  PreparedStatement ps = null;
	  try
	  {
	    con = DBUtil.getConnection();
	    ps = con.prepareStatement("select ccode, cname from courses");
	    ResultSet rs = ps.executeQuery();
	    String st;

	    st  = "<select name=ccode><option value=none>Select Course</option>";
	    while ( rs.next())
	    {

		  st += "<option value=" + rs.getString("ccode");
		  if ( rs.getString("ccode").equals(ccode) )
		        st += " selected ";
		  st += ">" + rs.getString("cname") + "</option>";
        }

        st += "</select>";

        JspWriter out = pageContext.getOut();
        out.println(st);
      }
      catch(Exception ex)
	  {
	     System.out.println(ex.getMessage());
	  }
	  finally
	  {
	        DBUtil.clean(con,ps);
      }
   return EVAL_PAGE;
  } // end of doAfterBody
} // end of class