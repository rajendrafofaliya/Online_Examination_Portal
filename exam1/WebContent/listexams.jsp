<%@page import="java.sql.*,exam.*"%>
<link rel="stylesheet" href="style.css"> 
<%
    Connection con = DBUtil.getConnection();
    PreparedStatement ps = con.prepareStatement("select b.ccode,b.bcode batch,rollno, DATE_FORMAT(dexam,'%e-%M-%Y') dexam, marks from exams e, batches b where e.bcode = b.bcode  order by dexam desc");
    ResultSet rs = ps.executeQuery();
 %>
 
 <center>
 <h2>List Of Exams</h2>
 <table border=1 cellpadding=2>
 <tr>
 <th>Course</th>
 <th>Batch
 <th>Rollno
 <th>Exam Date
 <th>Marks
 </tr>
 
<%
    while(rs.next())
    {
%>

<tr>
<td><%= rs.getString("ccode")%>
<td><%= rs.getString("batch")%>
<td><%= rs.getString("rollno")%>
<td><%= rs.getString("dexam")%>
<td><%= rs.getString("marks")%>

</tr>

<%
   }
   rs.close();
   ps.close();
   con.close();
%>

</table>
<p>
<a href="javascript:history.back()">Back </a> 
</body>
