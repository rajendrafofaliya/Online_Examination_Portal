<html>
<link rel="stylesheet"  href="style.css">
<body>
<center>
<h2>Add New Course</h2>

<form action="addcourse.jsp" method=post>

<table cellpadding=3>
<tr>
<td>
Course Code
<td>
<input type=text name=ccode size=10>
</tr>

<tr>
<td>
Course Name
<td>
<input type=text name=cname size=20>
</tr>
</table>
<p>
<input type=submit value="Add Course">
<input type=submit value="Clear All">
<p>
<a href="menu.html">Back To Menu </a>

<%
   if ( request.getParameter("ccode") == null)   return;
%>


<jsp:useBean id="course" class="exam.CourseBean" scope="page" />
<jsp:setProperty name="course" property="*"/>

<h4>
<%

  
  if ( course.add() ) 
      out.println("Course Has Been  Added Successfully.");
  else
      out.println("An Error Occured While Adding Course!");
 
%>
</h4>

</center>  
</body>
</html>
     
    
   
