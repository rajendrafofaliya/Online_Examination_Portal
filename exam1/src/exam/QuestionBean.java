// Item Bean

package exam;

import  java.sql.*;
import  java.util.*;

import  exam.*;

public class QuestionBean
{
    private  String ccode,question,ans1,ans2,ans3,cans;


    public  void setCcode(String ccode)
    { this.ccode = ccode; }

    public String getCcode()
    {  return ccode; }

    public  void setQuestion(String question)
    { this.question = question; }

    public String getQuestion()
    {  return question; }


    public  void setAns1(String ans1)
    { this.ans1 = ans1; }

    public String getAns1()
    {  return ans1; }


    public  void setAns2(String ans2)
    { this.ans2 = ans2; }

    public String getAns2()
    {  return ans2; }

    public  void setAns3(String ans3)
	{ this.ans3 = ans3; }

    public String getAns3()
    {  return ans3; }


    public  void setCans(String cans)
	{ this.cans = cans; }

    public String getCans()
    {  return cans; }

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

} // end of bean








