

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regno = Integer.parseInt(request.getParameter("regno"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int year = Integer.parseInt(request.getParameter("year"));
		String sec = request.getParameter("sec");
		response.setContentType("text/html");
//	    PrintWriter printWriter = response.getWriter();
//	    printWriter.println(regno + " " + password + " " + name + " "+ email + " " + password + " " + year + " " + sec);
		RegisterBean b = new RegisterBean();
		b.setRegno(regno);
	    b.setName(name);
	    b.setEmail(email);
	    b.setPassword(password);
	    b.setYear(year);
	    b.setSec(sec);
	    DAO d = new DAO();
	    try {
			int i = d.StudentInsertion(b);
			if(i>0) {
		        RequestDispatcher rd = request.getRequestDispatcher("login.html");
		        rd.include(request, response);
		        
		      }
		      else {
		        RequestDispatcher rd = request.getRequestDispatcher("error.html");
		        rd.include(request, response);
		      }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
