<%@page import="java.sql.*,exam.*"%>

<link rel="stylesheet" href="style.css"> 

<%
    String bcode  = request.getParameter("bcode");
    Connection con = DBUtil.getConnection();
    PreparedStatement ps = con.prepareStatement("select rollno, sname from students where bcode = ?");
    ps.setString(1,bcode);
    ResultSet rs = ps.executeQuery();
 %>
 
 <center>
 <h2>Students Of Batche  [ <%=bcode%> ] </h2>
 <table border=1 cellpadding=2>
 <tr>
 <th>Roll No.</th>
 <th>Student Name
 <th>&nbsp;
 </tr>
 
<%
   
    while(rs.next())
    {
%>

<tr>
<td><%= rs.getString("rollno")%>
<td><%= rs.getString("sname")%>
<td>
<a href=previousexams.jsp?bcode=<%=bcode%>&rollno=<%=rs.getString("rollno")%>>Exams</a>
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
