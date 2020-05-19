package exam;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changepasswd
 */
@WebServlet("/changepasswd")
public class changepasswd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	PreparedStatement getPass,cngPass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepasswd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		
     try
     {
      Class.forName("com.mysql.jdbc.Driver");	 
      cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");
     }
     catch(ClassNotFoundException e)
     {
      System.err.println("\ndriver not found -"+e.getCause()+"\n"); 	
     }
     catch(SQLException e)
     {
      System.err.println("\nSQL Alert[init] : "+e.getErrorCode()+"\n");
     }		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  PrintWriter pw=response.getWriter();
	  
	  String oldpas,newpas,cnfpas;
	  
	  oldpas=request.getParameter("oldpas");
	  newpas=request.getParameter("newpas");
	  cnfpas=request.getParameter("cnfpas");
	  
	  try
	  {
		  getPass=cn.prepareStatement("select pwd from password where adminid=?");
		  cngPass=cn.prepareStatement("update password set pwd=? where adminid='101'");
	   getPass.setString(1, "101"); 
	   ResultSet rs=getPass.executeQuery();
	   
	   boolean ok=true;
	   
	   if(rs.next())
	   {
		 ok=rs.getString("pwd").equals(oldpas);
	   }
	   else
	   {
		 ok=false;
	   }
	      
	   if(ok)
	   {
		 if(newpas.equals(cnfpas))
		  {
		   cngPass.setString(1, newpas);
		   cngPass.executeUpdate();
		   
		   String html="<html><head><title>Change Admin Password</title><style>body{margin:0px auto; background-color:#CCC;}.outer{margin:0px auto; width:1000px; background:#39F;}.header{width:1000px; height:150px; background:#039;}"+
		               ".mid{width:1000px; background-color:#09F; padding-top:10px;float:left;}.middata{width:600px; height:400px; margin:60px 0px 0px 180px;float:left;}.midboxtxt{width:100px; height:150px; margin:0px 0px 0px 80px; float:left;}"+
				       ".midboxinput{width:350px; height:400px; margin:0px 0px 0px 70px; float:left;}.royal{width:500px; height:50px; color:#FFF; font-size:30px; font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif; margin:0px 0px 20px 400px; padding-top:60px;}"+
		               ".footer{width:1000px; height:150px; background:#039;float:left;}.midtext{width:180px; height:20px; color:#FFF; font-size:23px; margin:20px 10px; float:left;}"+
				       ".loginform{width:280px; height:10px; color:#FFF; font-size:36px;font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif; margin:10px 0px 0px 450px; }.midinput{width:100px; height:20px; color:#FFF; margin:20px 70px;float:left;}.button{ width:50px; height:50px; margin:15px 0px 0px 70px; float:left;}"+
		               "</style></head><body><div class=\"outer\"><div class=\"header\"><div class=\"royal\">Change Password for admin</div> </div><!--header--><div class=\"mid\"><form action=\"changepasswd\" method=\"get\"><div class=\"loginform\">Change Password</div><br><br>"+
				       "<div class=\"button\" style=\" width:350px; height:0px; font-size:27px; color:red; margin-left:450px;\">Password Change Sucessfully..!</div><div class=\"middata\"><div class=\"midboxtxt\"><div class=\"midtext\">Old Password</div>"+
		               "<div class=\"midtext\">New Password</div><div class=\"midtext\">Confirm Password</div></div><div class=\"midboxinput\"><div class=\"midinput\"><input type=\"password\" name=\"oldpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div>"+
				       "<div class=\"midinput\"><input type=\"password\" name=\"newpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div><div class=\"midinput\"><input type=\"password\" name=\"cnfpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div>"+
		               "<div class=\"button\"><input type=\"submit\" name=\"cnfpass\" value=\"Submit\"/></form></div><div class=\"button\"><a href=\"menu.html\"><input type=\"button\"value=\"Back\"></a></div></div></div><div class=\"footer\"><div><marquee behavior=\"alternate\" style=\"margin-top:30px; color:#FFF;\">www.Change Admin Password.com</marquee>"+
				       "</div><div><!--footer--></div></div><!---outer--></body></html>";
		   
		   pw.println(html);
		  }
		 else
		 {
		  String html="<html><head><title>Change Admin Password</title><style>body{margin:0px auto; background-color:#CCC;}.outer{margin:0px auto; width:1000px; background:#39F;}.header{width:1000px; height:150px; background:#039;}"+
		               ".mid{width:1000px; background-color:#09F; padding-top:10px;float:left;}.middata{width:600px; height:400px; margin:60px 0px 0px 180px;float:left;}.midboxtxt{width:100px; height:150px; margin:0px 0px 0px 80px; float:left;}"+
				       ".midboxinput{width:350px; height:400px; margin:0px 0px 0px 70px; float:left;}.royal{width:500px; height:50px; color:#FFF; font-size:30px; font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif; margin:0px 0px 20px 400px; padding-top:60px;}"+
		               ".footer{width:1000px; height:150px; background:#039;float:left;}.midtext{width:180px; height:20px; color:#FFF; font-size:23px; margin:20px 10px; float:left;}"+
				       ".loginform{width:280px; height:10px; color:#FFF; font-size:36px;font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif; margin:10px 0px 0px 450px; }.midinput{width:100px; height:20px; color:#FFF; margin:20px 70px;float:left;}.button{ width:50px; height:50px; margin:15px 0px 0px 70px; float:left;}"+
		               "</style></head><body><div class=\"outer\"><div class=\"header\"><div class=\"royal\">Change Password for admin</div> </div><!--header--><div class=\"mid\"><form action=\"changepasswd\" method=\"get\"><div class=\"loginform\">Change Password</div><br><br>"+
				       "<div class=\"button\" style=\" width:350px; height:0px; font-size:27px; color:red; margin-left:450px;\">Confirm Password Not Match..!</div><div class=\"middata\"><div class=\"midboxtxt\"><div class=\"midtext\">Old Password</div>"+
		               "<div class=\"midtext\">New Password</div><div class=\"midtext\">Confirm Password</div></div><div class=\"midboxinput\"><div class=\"midinput\"><input type=\"password\" name=\"oldpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div>"+
				       "<div class=\"midinput\"><input type=\"password\" name=\"newpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div><div class=\"midinput\"><input type=\"password\" name=\"cnfpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div>"+
		               "<div class=\"button\"><input type=\"submit\" name=\"cnfpass\" value=\"Submit\"/></form></div><div class=\"button\"><a href=\"menu.html\"><input type=\"button\"value=\"Back\"></a></div></div></div><div class=\"footer\"><div><marquee behavior=\"alternate\" style=\"margin-top:30px; color:#FFF;\">www.Change Admin Password.com</marquee>"+
				       "</div><div><!--footer--></div></div><!---outer--></body></html>";
		   
		   pw.println(html);
		 }
	   }
	   else
	   {
		   String html="<html><head><title>Change Admin Password</title><style>body{margin:0px auto; background-color:#CCC;}.outer{margin:0px auto; width:1000px; background:#39F;}.header{width:1000px; height:150px; background:#039;}"+
	               ".mid{width:1000px; background-color:#09F; padding-top:10px;float:left;}.middata{width:600px; height:400px; margin:60px 0px 0px 180px;float:left;}.midboxtxt{width:100px; height:150px; margin:0px 0px 0px 80px; float:left;}"+
			       ".midboxinput{width:350px; height:400px; margin:0px 0px 0px 70px; float:left;}.royal{width:500px; height:50px; color:#FFF; font-size:30px; font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif; margin:0px 0px 20px 400px; padding-top:60px;}"+
	               ".footer{width:1000px; height:150px; background:#039;float:left;}.midtext{width:180px; height:20px; color:#FFF; font-size:23px; margin:20px 10px; float:left;}"+
			       ".loginform{width:280px; height:10px; color:#FFF; font-size:36px;font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif; margin:10px 0px 0px 450px; }.midinput{width:100px; height:20px; color:#FFF; margin:20px 70px;float:left;}.button{ width:50px; height:50px; margin:15px 0px 0px 70px; float:left;}"+
	               "</style></head><body><div class=\"outer\"><div class=\"header\"><div class=\"royal\">Change Password for admin</div> </div><!--header--><div class=\"mid\"><form action=\"changepasswd\" method=\"get\"><div class=\"loginform\">Change Password</div><br><br>"+
			       "<div class=\"button\" style=\" width:350px; height:0px; font-size:27px; color:red; margin-left:450px;\">Wrong Password ..!</div><div class=\"middata\"><div class=\"midboxtxt\"><div class=\"midtext\">Old Password</div>"+
	               "<div class=\"midtext\">New Password</div><div class=\"midtext\">Confirm Password</div></div><div class=\"midboxinput\"><div class=\"midinput\"><input type=\"password\" name=\"oldpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div>"+
			       "<div class=\"midinput\"><input type=\"password\" name=\"newpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div><div class=\"midinput\"><input type=\"password\" name=\"cnfpas\" style=\"width:200px; height:35px; font-size:20px;\" /></div>"+
	               "<div class=\"button\"><input type=\"submit\" name=\"cnfpass\" value=\"Submit\"/></form></div><div class=\"button\"><a href=\"menu.html\"><input type=\"button\"value=\"Back\"></a></div></div></div><div class=\"footer\"><div><marquee behavior=\"alternate\" style=\"margin-top:30px; color:#FFF;\">www.online-exam.com</marquee>"+
			       "</div><div><!--footer--></div></div><!---outer--></body></html>";
	   
	   pw.println(html);
	   }
	 }
	  catch(SQLException e)
	  {
	   pw.println("\nSQL Alert[1] "+e.getMessage()+"\n");  
		  
	  }
	  
	  
	  
	 
	 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
