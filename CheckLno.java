import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import gld.*;

public class CheckLno extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException
	{
			PrintWriter out = response.getWriter();

			try
			{
			response.setContentType("text/html");

			String lcno = request.getParameter("lcno").toUpperCase();

            System.out.println(lcno);

			Connection con=null;
			ConnectionBean CBean=new ConnectionBean();
			con=CBean.getConnection();

            ResultSet rs = CBean.executeQuery("Select * from workorder where licno='" + lcno + "' ");

			if (!rs.next())
			{
    	    	out.println("Invalid License Number");
		    }


	}
		catch(Exception e)
		{
			out.println("error"+e.getMessage());
			}
	}

}
