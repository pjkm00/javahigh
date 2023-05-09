package middle.read;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		HttpSession session = req.getSession();
		if(id != null && pwd != null) {
			if(id.equals("admin") && pwd.equals("1234")) {
				session.setAttribute("memId", id);
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, res);
		
	}
	
}
