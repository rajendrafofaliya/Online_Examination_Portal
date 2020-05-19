<%@page import="java.sql.*,exam.*"%>

<link rel="stylesheet" href="style.css"> 

<%
    String ccode  = request.getParameter("ccode");
    Connection con = DBUtil.getConnection();
    PreparedStatement ps = con.prepareStatement("select qid,question,ans1,ans2,ans3,cans from questions where ccode = ?");
    ps.setString(1,ccode);
    ResultSet rs = ps.executeQuery();
 %>
 
 
 <h2>Questions For Course [ <%=ccode%> ] </h2>
 <table border=1 cellpadding=2>
 
<%
   
    while(rs.next())
    {
%>

<table border=1  width=100%>
<tr> <td width=10%>Qid <td><%= rs.getString("qid")%> </tr>
<tr> <td>Questions <td> <%=  rs.getString("question")  %> </tr>
<tr> <td>Ans1<td> <%=  rs.getString("ans1")  %> </tr>  
<tr> <td>Ans2<td> <%=  rs.getString("ans2")  %> </tr>  
<tr> <td>Ans3<td> <%=  rs.getString("ans3")  %> </tr>  
<tr> <td>CAns<td> <%=  rs.getString("cans")  %> </tr>  
</table>
<p>

<%
   }
   rs.close();
   ps.close();
   con.close();
%>

</table>

<a href="javascript:history.back()">Back </a> &nbsp;&nbsp; <a href="menu.html">Main Menu</a>
</body>
