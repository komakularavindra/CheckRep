import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import gld.*;
import java.io.*;

public class LicenseRegister extends HttpServlet
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
  String distcode=request.getParameter("distcode");
  String rcno=request.getParameter("rcno").toUpperCase();
  String padname=request.getParameter("padname");
  String noworkers=request.getParameter("noworkers");
  String nwork=request.getParameter("nwork");
  String fpaid=request.getParameter("fpaid");
  String vchno=request.getParameter("vchno");
  String pdate=request.getParameter("pdate");
  String bname=request.getParameter("bname");
  String wdate=request.getParameter("wdate");
  String phno=request.getParameter("phno");


  System.out.println(wdate);


  try
  {


    ConnectionBean CBean=new ConnectionBean();
	int inserted=CBean.executeUpdate("insert into company_master values(" + distcode + ",'" + rcno + "','" + padname + "','" + noworkers + "','" + nwork + "','" + fpaid + "','" + vchno + "','" + pdate + "','" + bname + "','" + wdate + "','" + phno + "')");

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