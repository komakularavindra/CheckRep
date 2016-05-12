import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import gld.*;
import java.io.*;

public class DeleteLicense extends HttpServlet
{

 public void init(ServletConfig config) throws ServletException
 {
  super.init(config);
 }

 public void destroy() { }

 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
 {

  PrintWriter out=response.getWriter();
  RequestDispatcher rd=request.getRequestDispatcher("Deleted.jsp");
  response.setContentType("text/html");
  String lcno=request.getParameter("lcno").toUpperCase();

  System.out.println("ok printing");

  try
  {


    ConnectionBean CBean=new ConnectionBean();
	int inserted=CBean.executeUpdate("delete from  workorder  where licno='" + lcno + "' ");
	int deleted=CBean.executeUpdate("delete from  licrenewal  where licno='" + lcno + "' ");

    if(inserted==1)
    {
      rd.forward(request, response);

	}
  }catch(Exception ex)
  {
     out.println("Error"+ ex);
  }

  }



}