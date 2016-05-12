import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import gld.*;
import java.io.*;

public class UpdateLicenseDetails extends HttpServlet
{

 public void init(ServletConfig config) throws ServletException
 {
  super.init(config);
 }

 public void destroy() { }

 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
 {

  PrintWriter out=response.getWriter();
  RequestDispatcher rd=request.getRequestDispatcher("DetailsUpdated.jsp");
  response.setContentType("text/html");
  String lcno=request.getParameter("lcno").toUpperCase();
  String cadname=request.getParameter("cadname");
  String noworkers=request.getParameter("noworkers");
  String nowork=request.getParameter("nowork");
  String dtofwork=request.getParameter("dtofwork");
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
  String lisdate=request.getParameter("lisdate");
  String oldlicno=request.getParameter("orglcno").toUpperCase();
  String phno=request.getParameter("phno");
  System.out.println("ok printing");
  try
  {
    int renewaled=0;
    int Updated=0;

    ConnectionBean CBean=new ConnectionBean();
    ResultSet rs=CBean.executeQuery("Select updated from licrenewal where licno='" + oldlicno + "' ");

    if(rs.next())
    {
    	 renewaled=rs.getInt(1);
    	 System.out.println(renewaled + "ren wagr no");
	}
   rs.close();
   if(renewaled==1)
   {
       int LicUpdate=CBean.executeUpdate("Update licrenewal set licno='" + lcno + "' where licno='" +  oldlicno + "' ");
       Updated=CBean.executeUpdate("Update  workorder set	licno='" + lcno + "',addrs='" + cadname + "',noworkers='" + noworkers + "',nwork='" + nowork + "',workdt='" + dtofwork + "',rendt='" + rendt + "',schno='" + schno + "',sdate='" + sdate + "',samt='" + samt + "',wbank='" + wbank + "',wchno='" + wchno + "',wdate='" + wdate + "',wamt='" + wamt + "',worderagno='" + wano + "',wfamt='" + fp + "',wisdate='" + wodated + "',lisdate='" + lisdate + "',phno='" + phno + "' where licno='" +  oldlicno + "' ");
   }else
   {
       int LicUpdate=CBean.executeUpdate("Update licrenewal set licno='" + lcno + "',renwagrno='" + wano + "', stdate='" + dtofwork + "',enddate ='" + rendt + "' where licno='" +  oldlicno + "' ");
       Updated=CBean.executeUpdate("Update  workorder set	licno='" + lcno + "',addrs='" + cadname + "',noworkers='" + noworkers + "',nwork='" + nowork + "',workdt='" + dtofwork + "',rendt='" + rendt + "',schno='" + schno + "',sdate='" + sdate + "',samt='" + samt + "',wbank='" + wbank + "',wchno='" + wchno + "',wdate='" + wdate + "',wamt='" + wamt + "',worderagno='" + wano + "',wfamt='" + fp + "',wisdate='" + wodated + "',lisdate='" + lisdate + "',dtofexp='" + rendt + "',phno='" + phno + "' where licno='" +  oldlicno + "' ");
   }
   if(Updated==1)
   {
      rd.forward(request, response);
   }
   }catch(Exception ex)
   {
     out.println("Error"+ ex);
   }
  }
}