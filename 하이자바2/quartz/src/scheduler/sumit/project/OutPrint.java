package scheduler.sumit.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OutPrint.do")
public class OutPrint extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter out = res.getWriter();
		out.println("<html><meta charset='utf-8'><head><title>쿼츠</title></head>");
		out.println("<body>");
		out.println("<h2>쿼츠 테스트</h2>");
		out.println("<script>alert('안녕')</script>");
		out.println("</body></html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
