<html>
<body>

<jsp:useBean id="studentbean" class="exam.StudentBean" scope="session" />
<jsp:useBean id="exambean" class="exam.ExamBean" scope="session" />
<link rel="stylesheet" href="../style.css">

<%
  
  String action = request.getParameter("action");
  exam.Question q =null;
  
  if ( action == null)
  {
     exambean.setCcode( studentbean.getCcode());
     exambean.loadQuestions();
  }
  else
   if (action.equals("Cancel"))
   {
       response.sendRedirect("finishexam.jsp");
       return;
   }
   else     
    {
     String answer = request.getParameter("answer");
     exambean.setAnswer(answer);
     if ( exambean.isLastQuestion() )
     {
         response.sendRedirect("finishexam.jsp");
         return; 
     }
    }
    
   q  = exambean.nextQuestion();
     
%>     
        

<form action=takeexam.jsp method=post>
<h4>Questions :  <%= exambean.getQno() + 1 %>  /  <%=exambean.getTotal()%> </h4>

<table border=1>
<tr>
<td>Questions
<td><textarea name=question  cols=80 rows=5> <%=q.getQuestion()%> </textarea>
</tr>

<tr>
<td valign="top"><input type=radio name=answer value=1>
<td><textarea name=ans1  cols=80 rows=3><%=q.getAns1()%></textarea>
</tr>


<tr>
<td valign="top"><input type=radio name=answer value=2>
<td><textarea name=ans2  cols=80 rows=3><%=q.getAns2()%></textarea>
</tr>


<tr>
<td valign="top"><input type=radio name=answer value=3>
<td><textarea name=ans3  cols=80 rows=3><%=q.getAns3()%></textarea>
</tr>

</table>
<p>


<input type=submit value="Next"  name="action">
<input type=submit value="Cancel"  name="action">

</form>
</body>
</form>

