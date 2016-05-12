import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import gld.*;
import java.io.*;

public class WorkOrderRegister extends HttpServlet
{

 public void init(ServletConfig config) throws ServletException
 {
  super.init(config);
 }

 public void destroy() { }

 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
 {

  PrintWriter out=response.getWriter();

  RequestDispatcher rd=request.getRequestDispatcher("DetailsInserted.jsp");
  response.setContentType("text/html");
  String lcno=request.getParameter("lcno").toUpperCase();
  String cadname=request.getParameter("cadname");
  String noworkers=request.getParameter("noworkers");
  String nowork=request.getParameter("nowork");
  String dtofwork=request.getParameter("dtofwork");
  String rcno=request.getParameter("rcno").toUpperCase();
  String rendt=request.getParameter("rendt");
  String schno=request.getParameter("schno");
  String sdate=request.getParameter("sdate");
  String samt=request.getParameter("samt");
  String wbank=request.getParameter("wbank");
  String wchno=request.getParameter("wchno");
  String wdate=request.getParameter("wdate");
  String wamt=request.getParameter("wamt");
  String wano=request.getParameter("wano");
  String fp=request.getParameter("fp");
  String wodated=request.getParameter("wodated");
  String islicdate=request.getParameter("islicdate");
  String phno=request.getParameter("phno");
  System.out.println("ok printing");
  int update=0;
  try
  {
    ResultSet rs=null;

    ConnectionBean CBean=new ConnectionBean();

	int inserted=CBean.executeUpdate("insert into workorder values('" + lcno + "','" + cadname + "','" + noworkers + "','" + nowork + "','" + dtofwork + "', '" + rendt + "','" + rcno + "','" + schno + "','" + sdate + "','" + samt + "' ,'" + wbank + "','" + wchno + "','" + wdate + "','" + wamt + "','" + wano + "','" + fp + "','" + wodated + "','" + islicdate + "','"+ rendt + "','" + phno + "' )");

    int licinserted=CBean.executeUpdate("insert into licrenewal values('" + lcno + "','" + wano + "',null,null,null,null,null,null,'" + dtofwork + "','" + rendt + "'," + update + ",null,null,null) ");





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