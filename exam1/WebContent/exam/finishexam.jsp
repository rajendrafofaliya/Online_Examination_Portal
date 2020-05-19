
<jsp:useBean id="studentbean" class="exam.StudentBean" scope="session" />
<jsp:useBean id="exambean" class="exam.ExamBean" scope="session" />
<link rel="stylesheet" href="../style.css">

<style>
td {font:700 11pt verdana}

</style>

<center>


<table border=1 cellpadding=5>
<tr>
<td style="color:white;background-color:red;font:14pt Arial" colspan=2>Examination Result </td>
</tr>

<tr>
<td>No. Of Questions 
<td><%= exambean.getTotal()%>
</tr>

<tr>
<td>No. of Questions Attempted 
<td><%= exambean.getQno() + 1 %> 
</tr>

<tr>
<td>No. Of Correct Answers 
<td><%= exambean.getNoCorrectAnswers()%>
</tr>

</table>

<p>

<a href="login.jsp">Continue...</a>


<%

  // insert exam details into EXAMS table
  // exambean.insert();  
%>    





