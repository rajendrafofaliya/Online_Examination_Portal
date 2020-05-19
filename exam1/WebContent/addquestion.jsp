<html>
<%@ taglib uri="/WEB-INF/tld/exam.tld" prefix="exam"%>

<link rel="stylesheet"  href="style.css">
<body>
<center>
<h2>Add Question</h2>
<form action="addquestion.jsp" method=post>
<table cellpadding=3>
<tr>
<td>
Course Code
<td>
<exam:courses  value='<%=request.getParameter("ccode")%>' /> 
&nbsp; <a href="menu.html">Back To Menu </a>
</tr>
<tr>
<td>
Questions
<td><textarea cols=50  rows=3 name=question></textarea>
</tr>

<tr>
<td>
Answer1
<td><textarea cols=50  rows=2 name=ans1></textarea>
</tr>

<tr>
<td>
Answer2
<td><textarea cols=50  rows=2 name=ans2></textarea>
</tr>


<tr>
<td>
Answer3
<td><textarea cols=50  rows=2 name=ans3></textarea>
</tr>


<tr>
<td>
Correct Answer
<td>
<input type=radio value=1 name=cans> Answer1
<input type=radio value=2 name=cans> Answer2
<input type=radio value=3 name=cans> Answer3
</tr>
</table>
<p>
<input type=submit value="Add Question">
<input type=submit value="Clear All">
<p>


<%
   if ( request.getParameter("ccode") == null)   return;
%>


<jsp:useBean id="question" class="exam.QuestionBean" scope="page" />
<jsp:setProperty name="question" property="*"/>

<h4>
<%

  
  if ( question.add() ) 
      out.println("Question Has Been Added Successfully.");
  else
      out.println("An Error Occured While Adding Question!");
 
%>
</h4>

</center>  
</body>
</html>
     
    
   
