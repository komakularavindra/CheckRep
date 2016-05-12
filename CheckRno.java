import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import gld.*;

public class CheckRno extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException
	{
			PrintWriter out = response.getWriter();

			try
			{
			response.setContentType("text/html");

			String rcno = request.getParameter("rcno").toUpperCase();

            System.out.println(rcno);

			Connection con=null;
			ConnectionBean CBean=new ConnectionBean();
			con=CBean.getConnection();

            ResultSet rs = CBean.executeQuery("Select * from company_master where rcno='" + rcno + "' ");

			if (!rs.next())
			{
    	    	out.println("Invalid Registration Number");
		    }


	}
		catch(Exception e)
		{
			out.println("error"+e.getMessage());
			}
	}

}
