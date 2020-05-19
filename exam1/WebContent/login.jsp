<html>
<link rel="stylesheet" href="style.css">
<body>
<center>
<h3>Login </h3>
<form  action="login.jsp" method=post>

Enter Administrator's Password  <input type=password  size=20 name=pwd>
<p>
<input type=submit value="Login">

</form>

<%
  // skip it if first run
  if ( request.getParameter("pwd") == null) return;
   
%>
   
<jsp:useBean id="adminbean" class="exam.AdminBean" scope="session" />

<%
  if ( adminbean.login(request.getParameter("pwd")) )
  {
      session.setAttribute("logged","true");
      response.sendRedirect("menu.html");
   }
  else
    out.println("<h4>Invalid Login. Try again! </h4>");

%>

</center>
</body>
</html>    
    
