package middle.read;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		HttpSession session = req.getSession();
		res.setCharacterEncoding("UTF-8");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "민경", "java");
			
			String sql = "select * from students where stuId = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(id));
			
			//SQL문의 물음표(?)자리에 들어갈 데이터를 세팅한다.
			//형식) pstmt.set자료형이름(물음표순번, 데이터)
			rs = pstmt.executeQuery();
			
			if(id != null && pwd != null) {
				if(Integer.parseInt(id) == rs.getInt("stuId") && pwd.equals(rs.getString("stuPass"))) {
					session.setAttribute("stuId", id);
					String view = "/lecture/LectureMain.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(view);
					rd.forward(req, res);
					
				}else {
					res.setContentType("text/html; charset=utf-8");
					PrintWriter out = res.getWriter();
					out.println("<script>alert('아이디나 비밀번호가 틀렸습니다.')</script>");
					String view = "/lecture/login.jsp";
					RequestDispatcher rd = req.getRequestDispatcher(view);
					rd.forward(req, res);
				}
				
			}
			
	
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn != null) try {conn.close();} catch(SQLException e2) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e2) {}
			if(rs != null) try {rs.close();} catch(SQLException e2) {}
		}
		
		
		
		
	}
	
}
