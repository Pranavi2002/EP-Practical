

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		HttpSession hs = request.getSession();
		hs.setAttribute("email",email);
		String password = request.getParameter("password");
		response.setContentType("text/html");
//	    PrintWriter printWriter = response.getWriter();
//	    printWriter.println(email + " " + password);
		RegisterBean b = new RegisterBean();
		b.setEmail(email);
		b.setPassword(password);
		DAO d = new DAO();
		try {
			String i = d.StudentLogin(b);
			PrintWriter printWriter = response.getWriter();
			if(i=="") {
				printWriter.println("Login unsuccessful");
				request.getRequestDispatcher("login.html").include(request,response);
			}
			else {
				printWriter.println("Welcome");
				request.getRequestDispatcher("Feedback.html").include(request,response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
