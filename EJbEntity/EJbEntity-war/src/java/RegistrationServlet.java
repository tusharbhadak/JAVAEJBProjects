import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.*;
import javax.naming.InitialContext;
import javax.servlet.http.*;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;
import java.io.*;
import ejb.*;
import entity.*;

public class RegistrationServlet extends HttpServlet
{
	UserBeanRemote user=null;

	

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	try {	
        InitialContext ic = new InitialContext();
        user=(UserBeanRemote)ic.lookup(UserBeanRemote.class.getName());
        
		

		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML><HEAD><TITLE>User Registartion Status</TITLE></HEAD><BODY BGCOLOR='pink'>");

			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String aboutme = request.getParameter("aboutme");

			 user.addUser(firstname, lastname, email, username, 
                                 password, aboutme);

			 

			out.println("<CENTER><H1>User successfully registered.</H1><BR>Click <A HREF='login.html'> here </A> to login.</CENTER>");
			out.println("</BODY></HTML>");

			
		}
		catch (Exception e)
		{
			throw new ServletException(e);
		}
		finally
		{
			
		}
	}

	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
}
