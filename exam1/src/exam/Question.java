
package exam;


public class Question
{
    int qid;
    String question,ans1, ans2, ans3, cans, answer="";

    public Question(int qid, String question, String ans1, String ans2, String ans3, String cans)
    {
      this.qid = qid;
      this.question = question;
      this.ans1 = ans1;
      this.ans2 = ans2;
      this.ans3 = ans3;;
      this.cans = cans;
    }
    public String getQuestion()
    {  return question; }

    public String getAns1()
    {  return ans1; }

    public String getAns2()
    {  return ans2; }

    public String getAns3()
    {  return ans3; }

    public String getCans()
    {  return cans; }

    public String getAnswer()
	{  return answer; }

	public void setAnswer(String answer)
	{  this.answer = answer; }

	public boolean isCorrect()
	{
	  if ( answer != null )
	      return answer.equals(cans) ;
	  else
	      return false;
    }


} // end of Question