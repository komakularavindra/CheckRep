import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import gld.*;


public class LoginCheck extends HttpServlet
{

 public void init(ServletConfig config) throws ServletException
 {
  super.init(config);
 }

 public void destroy() { }

 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
 {


  RequestDispatcher rd=null;
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  try
  {

    String username = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	Connection con=null;
    ConnectionBean CBean=new ConnectionBean();
    ResultSet user_rs=CBean.executeQuery("select * from login where userid='" + username + "' and pwd='" + pwd + "'");
    if(user_rs.next())
    {
         rd=request.getRequestDispatcher("MemberArea.jsp");
    }else
    {
        rd=request.getRequestDispatcher("Login.jsp");
	}
    rd.forward(request, response);
  }catch(Exception ex)
  {
     out.println("Error while processing"+ex);
  }

  }



}