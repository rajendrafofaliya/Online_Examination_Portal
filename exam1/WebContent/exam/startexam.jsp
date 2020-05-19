<html>
<body>

<link rel="stylesheet" href="../style.css">

<h2>Welcome Page </h2>

<jsp:useBean id="studentbean" class="exam.StudentBean" scope="session" />


<h4>Welcome  <jsp:getProperty  name="studentbean" property="sname"/></h4>

<p>
The exam contains all objective type questions. You are NOT allowed to move back 
to previous questions. So please answer a question and then move to next question.

<p>


<a href="takeexam.jsp">Start Examination </a>