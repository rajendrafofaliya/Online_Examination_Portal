<%@page import="java.sql.*,exam.*"%>
<link rel="stylesheet" href="style.css"> 
<%
  
    String bcode = request.getParameter("bcode");
    String rollno = request.getParameter("rollno");
    Connection con = DBUtil.getConnection();
    PreparedStatement ps = con.prepareStatement("select examid, dexam, marks from exams where bcode = ? and rollno = ? order by dexam desc");
    ps.setString(1,bcode);
    ps.setString(2,rollno);
    ResultSet rs = ps.executeQuery();
 %>
 
 <center>
 <h2>Previous Examinations </h2>
 <table border=1 cellpadding=2>
 <tr>
 <th>Exam Id</th>
 <th>Date Of Exam
 <th>No. Of Marks
 </tr>
 
<%
   
    while(rs.next())
    {
%>

<tr>
<td><%= rs.getString("examid")%>
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
