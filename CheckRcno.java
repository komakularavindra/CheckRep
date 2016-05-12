import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import gld.*;

public class CheckRcno extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException
	{
			PrintWriter out = response.getWriter();

			try
			{
			response.setContentType("text/html");

			String rcno = request.getParameter("rcno").toUpperCase();

			Connection con=null;
			ConnectionBean CBean=new ConnectionBean();
			con=CBean.getConnection();

            ResultSet rs = CBean.executeQuery("Select * from company_master where rcno='" + rcno + "' ");

			if (rs.next())
			{

               System.out.println("oktested");
		    	out.println("already exists");
		    }
		    
		    

	}
		catch(Exception e)
		{
			out.println("error"+e.getMessage());
			}
	}

}
