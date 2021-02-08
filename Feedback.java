

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
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String listQ1 = request.getParameter("listQ1");
		String listQ2 = request.getParameter("listQ2");
		String listQ3 = request.getParameter("listQ3");
		String listQ4 = request.getParameter("listQ4");
		String listQ5 = request.getParameter("listQ5");
		String remark = request.getParameter("remark");
		response.setContentType("text/html");
		FeedbackBean b = new FeedbackBean();
		b.setEmail(email);
		b.setQ1(listQ1);
		b.setQ2(listQ2);
		b.setQ3(listQ3);
		b.setQ4(listQ4);
		b.setQ5(listQ5);
		b.setRemark(remark);
		DAO d = new DAO();
		try {
			int i = d.StudentFeedback(b);
			if(i>0) {
				 PrintWriter printWriter = response.getWriter();
		    	  printWriter.print(email+" "+listQ1+" "+listQ2+" "+listQ3+" "+listQ4+" "+listQ5+" "+remark);
//		    	  printWriter.print(listQ1);
//		    	  printWriter.print(listQ2);
//		    	  printWriter.print(listQ3);
//		    	  printWriter.print(listQ4);
//		    	  printWriter.print(listQ5);
//		    	  printWriter.print(remark);
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
