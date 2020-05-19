// Item Bean

package exam;

import  java.sql.*;
import  java.util.*;
import  exam.*;

public class ExamBean
{
    private  String ccode,question,ans1,ans2,ans3,cans;
    Vector  questions = new Vector();
    int qno;
    final int TOTAL = 5;

    public int getQno()
    {
		return qno;
    }

    public int getTotal()
    {
		 return TOTAL;
    }
    public void setCcode( String ccode)
    {
		  this.ccode = ccode;
    }

    public Question nextQuestion()
    {
		if ( qno < TOTAL )
		{
		     qno ++;
		     return (Question) questions.get(qno);
	    }
	    else
	         return null;
    }

    public boolean isLastQuestion()
    {
		  return (qno == TOTAL - 1);
    }

    public void setAnswer(String answer)
    {
		 // get current question
		 Question q = (Question) questions.get(qno);
	     q.setAnswer(answer);
    }

    public void loadQuestions()
    {
		Vector  qids = new Vector();
		Connection con = null;;
		PreparedStatement ps = null;
		qno = -1;
		try
		{

		// load questions for the given subject
		con = DBUtil.getConnection();
		ps = con.prepareStatement("select qid, question, ans1, ans2, ans3, cans from questions where ccode = ?");
		ps.setString(1,ccode);
		ResultSet rs  = ps.executeQuery();

        // copy question ids into vector

        while ( rs.next())
        {
             qids.add( rs.getString(1));
             System.out.println( rs.getString(1));
	 }

        rs.close();


        int noquestions = qids.size();

        Vector selqids = new Vector();
		// get 5 random numbers
		Random  r = new Random();
		String qid;
		int pos;
		for ( int i = 0 ; i < 5 ; )
		{
			 pos =  Math.abs( r.nextInt() % noquestions);
			 // get question id from that position in vector
			 qid = (String) qids.get(pos);
			 if ( ! selqids.contains(qid) )
			 {
			      selqids.add(qid);
			      i ++;
		     } // end of if
	    } // end of for


	    // load questions with the given ids into vector

	    rs  = ps.executeQuery();

        questions.clear();

        Question q;

	    while ( rs.next() )
	    {
			 if ( selqids.contains( rs.getString(1)) )
			 {
				  // get question details
				 int id = rs.getInt(1);
				 String question = rs.getString(2);
 				 String ans1 = rs.getString(3);
				 String ans2 = rs.getString(4);
				 String ans3 = rs.getString(5);
				 String cans = rs.getString(6);

				 q = new Question(id,question,ans1,ans2,ans3,cans);

				 questions.add(q);

				 System.out.println(id);
				 System.out.println(question);
		     } // end of if

	    }  // end of while
	    rs.close();
     }
     catch(Exception ex)
     {
  	     System.out.println(ex.getMessage());
     }
     finally
     {
		 DBUtil.clean(con,ps);
	 }

   }  // end of Bean

   public int getNoCorrectAnswers()
   {
      int cnt =0;
      Question q;
	  for ( int i = 0 ; i < TOTAL ; i ++)
	  {
		  q = (Question) questions.get(i);
		  if ( q.isCorrect()) cnt ++;
      }
      return cnt;
   }


/*

    public boolean add()
    {

     Connection con = null;
     PreparedStatement ps = null;
     try
     {
      con = DBUtil.getConnection();
      // get next question id
      Statement st = con.createStatement();
      ResultSet rs= st.executeQuery("select nvl(max(qid),0) + 1 from questions");
      rs.next();
      int qid = rs.getInt(1);
      rs.close();
      st.close();

      // get next itemid
      ps = con.prepareStatement("insert into questions  values (?,?,?,?,?,?,?)");
      ps.setInt(1,qid);
      ps.setString(2,ccode);
      ps.setString(3,question);
      ps.setString(4,ans1);
      ps.setString(5,ans2);
      ps.setString(6,ans3);
      ps.setString(7,cans);
      ps.executeUpdate();
      return true;
      }
      catch(Exception ex)
      {
       System.out.println(ex.getMessage());
       return false;
      }
      finally
      {
        DBUtil.clean(con,ps);
      }

   } // end of add

   */

} // end of bean








