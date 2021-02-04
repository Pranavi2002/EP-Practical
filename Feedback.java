

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
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String email = (String) hs.getAttribute("email");
		String feedback=request.getParameter("feedback");
		response.setContentType("text/html");
		RegisterBean b = new RegisterBean();
		b.setEmail(email);
		b.setFeedback(feedback);
		DAO d = new DAO();
		try {
			int i = d.StudentFeedback(b);
			if(i>0) {
		        RequestDispatcher rd = request.getRequestDispatcher("Home.html");
		        rd.include(request, response);
		      }
		      else {
		    	  PrintWriter printWriter = response.getWriter();
		    	  printWriter.print("Enter the feedback correctly");
		      }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
