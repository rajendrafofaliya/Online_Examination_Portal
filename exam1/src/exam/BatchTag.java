package exam;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import exam.*;

public class BatchTag extends TagSupport
{
  String  bcode= "";

  public void  setValue(String bcode)
  {
	    this.bcode = bcode;
 }

  public int doEndTag()
  {
	  Connection con = null;
	  PreparedStatement ps = null;
	  try
	  {
	    con = DBUtil.getConnection();
	    ps = con.prepareStatement("select bcode, bcode || ':' || ccode || ':' || stdate batch from batches");
	    ResultSet rs = ps.executeQuery();
	    String st;

	    st  = "<select name=bcode><option value=none>Select Batch</option>";
	    while ( rs.next())
	    {
		  st += "<option value=" + rs.getString("bcode");
		  if  (  rs.getString("bcode").equals(bcode) )
		      st += " selected ";
		  st += ">" + rs.getString("batch") + "</option>";
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