<html>
<link rel="stylesheet" href="../style.css">
<body>
<center>
<h3>Login </h3>
<form  action="login.jsp" method=post>
<table cellpadding=3>
<tr>
<td>Enter Batch Code
<td><input type=text name=bcode size=10>
</tr>
<tr>
<td>Enter Rollno  
<td><input type=text name=rollno size=10>
</tr>
<tr>
<td> Enter Password 
<td> <input type=password  size=10 name=pwd>
</tr>
</table>
<p>
<input type=submit value="Login">

</form>

<%
  // skip it if first run
  if ( request.getParameter("bcode") == null) return;
   
%>
   
<jsp:useBean id="studentbean" class="exam.StudentBean" scope="session" />
<jsp:setProperty name="studentbean" property="*" />

<%
  if ( studentbean.login() )
  {
     response.sendRedirect("startexam.jsp");
   }
  else
    out.println("<h4>Invalid Login. Try again! </h4>");

%>

</center>
</body>
</html>    
    
