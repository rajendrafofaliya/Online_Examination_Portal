<html>
<script language="javascript">

function check()
{

  if ( f1.bcode.value == "none" )
  {
     alert("Please select a batch first!")
     f1.bcode.focus()
     return false;
  }
  
  return true;

}

</script>


<%@ taglib uri="/WEB-INF/tld/exam.tld" prefix="exam"%>

<link rel="stylesheet"  href="style.css">
<body>
<center>
<h2>Add Students To Batch</h2>

<form name="f1" action="addstudents.jsp" method=post onsubmit="return check()">

Select Batch : 
<exam:batches />

<p>
<table>
<tr>
<th>Student Name
<th>Password 
</tr>

<%
  for (int i = 0 ;  i < 5 ; i ++)
  {
%>

<tr>
<td>
<input type=text  name=sname size=30>
<td>
<input type=text name=pwd size=10>
</tr>

<%
  }
%>
</table>
<p>
<input type=submit value="Add Students">
<input type=submit value="Clear All">
<p>
<a href="menu.html">Back To Menu </a>


<jsp:useBean id="student" class="exam.StudentBean" scope="page" />

<p>

<%
   String bcode = request.getParameter("bcode");
   if ( bcode == null )   return;
   
   String names[] = request.getParameterValues("sname");
   String pwds[] =   request.getParameterValues("pwd");
   int cnt = student.add( Integer.parseInt(bcode),names,pwds);
   out.println( cnt + " No. of students added to batch!");
   
%>

</center>  
</body>
</html>
     
    
   
