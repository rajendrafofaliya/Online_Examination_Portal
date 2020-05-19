<%@page import="java.sql.*,exam.*"%>

<link rel="stylesheet" href="style.css">  

<%
    String ccode  = request.getParameter("ccode");
    Connection con = DBUtil.getConnection();
    PreparedStatement ps = con.prepareStatement("select bcode, stdate from batches where ccode = ?");
    ps.setString(1,ccode);
    ResultSet rs = ps.executeQuery();
 %>
 
 <center>
 <h2>Batches For Course [ <%=ccode%> ] </h2>
 <table border=1 cellpadding=2>
 <tr>
 <th>Batch Code</th>
 <th>Starting Date
 <th>&nbsp;
 </tr>
 
<%
   
    while(rs.next())
    {
%>

<tr>
<td><%= rs.getString("bcode")%>
<td><%= rs.getString("stdate")%>
<td>
<a href=liststudents.jsp?bcode=<%=rs.getString("bcode")%>>Students</a> &nbsp;
</tr>

<%
   }
   rs.close();
   ps.close();
   con.close();
%>

</table>

<a href="javascript:history.back()">Back </a> &nbsp;&nbsp; <a href="menu.html">Main Menu</a>
</body>
