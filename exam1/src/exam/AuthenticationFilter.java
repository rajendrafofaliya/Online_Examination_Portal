package exam;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


public class AuthenticationFilter implements Filter
{

 public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
 {

   HttpServletRequest  httprequest = (HttpServletRequest)  request;
   HttpServletResponse  httpresponse = (HttpServletResponse) response;


   // do this only when request is NOT for login.jsp

   if ( httprequest.getRequestURI().indexOf("login.jsp") == -1)
   {

      HttpSession  session = httprequest.getSession();
      String  logged =  (String) session.getAttribute("logged");

      if ( logged == null )
      {
         httpresponse.sendRedirect("mainpage.html");
         return;
      }
   }

   // procede if user is authenticated

   chain.doFilter(request, response);
 }


  public void init(FilterConfig filterConfig) throws ServletException
  { }

  public void destroy()
  { }

}