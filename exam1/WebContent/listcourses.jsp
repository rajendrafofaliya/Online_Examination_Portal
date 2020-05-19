<%@page import="java.sql.*,exam.*"%>

<link rel="stylesheet" href="style.css"> 

<%
  
    Connection con = DBUtil.getConnection();
    PreparedStatement ps = con.prepareStatement("select ccode, cname from courses");
    ResultSet rs = ps.executeQuery();
 %>
 
 <center>
 <h2>Course Details </h2>
 <table border=1 cellpadding=2>
 <tr>
 <th>Course Code</th>
 <th>Course Name
 <th>&nbsp;
 </tr>
 
<%
   
    while(rs.next())
    {
%>

<tr>
<td><%= rs.getString("ccode")%>
<td><%= rs.getString("cname")%>
<td>
<a href=listbatches.jsp?ccode=<%=rs.getString("ccode")%>>Batches </a> &nbsp;
<a href=listquestions.jsp?ccode=<%=rs.getString("ccode")%>>Questions </a>
</tr>

<%
   }
   rs.close();
   ps.close();
   con.close();
%>

</table>
<p>
<a href="javascript:history.back()">Back </a> &nbsp;&nbsp; <a href="menu.html">Main Menu</a>

</body>
