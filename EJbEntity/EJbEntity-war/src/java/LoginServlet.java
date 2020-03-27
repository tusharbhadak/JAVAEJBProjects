import javax.servlet.*;
import javax.servlet.http.*;
import javax.persistence.*;
import java.io.*;
import java.util.*; 
import ejb.*;
import entity.*;
import javax.naming.InitialContext;


public class LoginServlet extends HttpServlet
{
	UserBeanRemote user=null;

	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
            try
         {
            
            InitialContext ic = new InitialContext();
        user=(UserBeanRemote)ic.lookup(UserBeanRemote.class.getName());
		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML><HEAD><TITLE>Login Successful</TITLE></HEAD><BODY BGCOLOR='pink'>");

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Usermaster um = user.checkLogin(username, password);

			if (um != null )
			{
				out.println("<H1 ALIGN='center'>Welcome " + username + "</H1>");
				out.println("<HR>");
				out.println("Following is the information captured by us: ");
				out.println("<TABLE ALIGN='left' BORDER='1' BORDERCOLOR='SKYBLUE' CELLPADDING='2' CELLSPACING='1' NAME='tblFirstChild' WIDTH='70%'>");
					out.println("<TR>");
						out.println("<TD ALIGN='right' WIDTH='25%'><B>First Name:</B></TD>");
						out.println("<TD ALIGN='left'>");
							out.println(um.getFirstname());
						out.println("</TD>");
					out.println("</TR>");
					out.println("<TR>");
						out.println("<TD ALIGN='right' WIDTH='25%'><B>Last Name:</B></TD>");
						out.println("<TD ALIGN='left'>");
							out.println(um.getLastname());
						out.println("</TD>");
					out.println("</TR>");
					out.println("<TR>");
						out.println("<TD ALIGN='right' WIDTH='25%'><B>Email Address:</B></TD>");
						out.println("<TD ALIGN='left'>");
							out.println(um.getEmail());
						out.println("</TD>");
					out.println("</TR>");
					out.println("<TR>");
						out.println("<TD ALIGN='right' WIDTH='25%'><B>User Name:</B></TD>");
						out.println("<TD ALIGN='left'>");
							out.println(um.getUsername());
						out.println("</TD>");
					out.println("</TR>");
					out.println("<TR>");
						out.println("<TD ALIGN='right' WIDTH='25%'><B>Password:</B></TD>");
						out.println("<TD ALIGN='left'>");
							out.println(um.getPassword());
						out.println("</TD>");
					out.println("</TR>");
					out.println("<TR>");
						out.println("<TD ALIGN='right' WIDTH='25%'><B>About Me:</B></TD>");
						out.println("<TD ALIGN='left'>");
							out.println(um.getAboutme());
						out.println("</TD>");
					out.println("</TR>");
				out.println("</TABLE>");
			}
			else
			{
				out.println("Incorrect user name or password.");
			}
			out.println("</BODY></HTML>");
		}
	catch (Exception e)
        {
            e.printStackTrace();
        }
            finally
		{
		
		}
	}

	public void  init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
}