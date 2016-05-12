import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import gld.*;
import java.io.*;

public class UpdateLicenseRenewal extends HttpServlet
{

 public void init(ServletConfig config) throws ServletException
 {
  super.init(config);
 }

 public void destroy() { }

 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
 {

  PrintWriter out=response.getWriter();
  RequestDispatcher rd=request.getRequestDispatcher("Renewaled.jsp");
  response.setContentType("text/html");


  System.out.println("License No");
  String lcno=request.getParameter("lcno").toUpperCase();
  System.out.println("License No" +lcno);
  String wano=request.getParameter("wano");
  String wodated=request.getParameter("wodated");
  String rendate=request.getParameter("rendate");
  String wamt=request.getParameter("wamt");
  String rnchno=request.getParameter("rnchno");
  String renchdate=request.getParameter("renchdate");
  String renamt=request.getParameter("renamt");
  String dateofexp=request.getParameter("dateofexp");

  String rwbank=request.getParameter("rwbank");
  String rwdate=request.getParameter("rwdate");
  String rwamt=request.getParameter("rwamt");





  try
  {
    int  status=0;
    int updated=1;
    String stdate="";
    String enddate="";
    String dtofexp="";
    int LicRenUpdate=0;
    ResultSet rs=null;

    ConnectionBean CBean=new ConnectionBean();

    rs=CBean.executeQuery("select updated,to_char(stdate,'dd-Mon-yyyy'),to_char(enddate,'dd-Mon-yyyy'),to_char(dtofexp,'dd-Mon-yyyy') from licrenewal where licno='" + lcno + "' ");
    if(rs.next())
    {
	  status=rs.getInt(1);
	  System.out.println(status);
      stdate=rs.getString(2);
      enddate=rs.getString(3);
      dtofexp=rs.getString(4);
	}

	rs.close();


    if(status==0)
    {

        System.out.println("In Status 0");

        System.out.println("Update licrenewal set renwagrno='" +wano + "',renwodated='" + wodated + "',rendate='" + rendate +"',renchno='" + rnchno + "',renchdate='" + renchdate + "',renamt='" + renamt +"',dtofexp='" +dateofexp + "',updated=" + updated + ",rwbank='" + rwbank + "',rwdate='" + rwdate + "',rwamt='" + rwamt + "'  where licno='" +  lcno + "' ");


        System.out.println("Update workorder set dtofexp='" + dateofexp + "'   where licno='" +  lcno + "'  ");


	    LicRenUpdate=CBean.executeUpdate("Update licrenewal set renwagrno='" +wano + "',renwodated='" + wodated + "',rendate='" + rendate +"',renchno='" + rnchno + "',renchdate='" + renchdate + "',renamt='" + renamt +"',dtofexp='" +dateofexp + "',updated=" + updated + ",rwbank='" + rwbank + "',rwdate='" + rwdate + "',rwamt='" + rwamt + "'  where licno='" +  lcno + "' ");
        LicRenUpdate=CBean.executeUpdate("Update workorder set dtofexp='" + dateofexp + "'   where licno='" +  lcno + "' ");

    }else
    {

		System.out.println("Not ");

		System.out.println("Update licrenewal set renwagrno='" +wano + "',renwodated='" + wodated + "',rendate='" + rendate +"',renchno='" + rnchno + "',renchdate='" + renchdate + "',renamt='" + renamt +"',dtofexp='" +dateofexp + "',stdate='" + enddate + "',enddate='" + dtofexp + "',rwbank='" + rwbank + "',rwdate='" + rwdate + "',rwamt='" + rwamt + "'  where licno='" +  lcno + "'");

		System.out.println("Update workorder set dtofexp='" + dateofexp + "'   where licno='" +  lcno + "'");



       LicRenUpdate=CBean.executeUpdate("Update licrenewal set renwagrno='" +wano + "',renwodated='" + wodated + "',rendate='" + rendate +"',renchno='" + rnchno + "',renchdate='" + renchdate + "',renamt='" + renamt +"',dtofexp='" +dateofexp + "',stdate='" + enddate + "',enddate='" + dtofexp + "',rwbank='" + rwbank + "',rwdate='" + rwdate + "',rwamt='" + rwamt + "'  where licno='" +  lcno + "' ");
       LicRenUpdate=CBean.executeUpdate("Update workorder set dtofexp='" + dateofexp + "'   where licno='" +  lcno + "' ");
       System.out.println("Not ");
	}
    if(LicRenUpdate==1)
    {
      rd.forward(request, response);

	}
  }catch(Exception ex)
  {
     out.println("Error"+ ex);
  }

  }



}