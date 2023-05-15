package middle.read;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LecDB {
	
	
	public void lecDB(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "민경", "java");
			
			
			String sql = "select * from ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "lecture" + req.getParameter("id"));

			
			//SQL문의 물음표(?)자리에 들어갈 데이터를 세팅한다.
			//형식) pstmt.set자료형이름(물음표순번, 데이터)
			rs = pstmt.executeQuery();
			
			List<LectureList> lectureList = new ArrayList<>(); 
			while(rs.next()) {
				LectureList lecture = new LectureList(rs.getInt("lecno"), rs.getString("lecname"), rs.getString("lecprofessor"), 
						rs.getString("lecloc"), rs.getInt("lecscore"), rs.getInt("leccredit"), rs.getString("lecdiv"), rs.getInt("lecyear"));
				
				lectureList.add(lecture);
			}
			
			req.setAttribute("lectureList", lectureList);
			res.setCharacterEncoding("utf-8");
			String view = "/lecture/lectureList.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, res);
			
			
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
