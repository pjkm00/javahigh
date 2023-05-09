package middle.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ScoreRead {
	
	public static void main(String[] args) {
		
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "민경", "java");
			
			int inputempno = Integer.parseInt(sc.nextLine());
			
			String sql = "select * from students where name in ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputempno);
			//SQL문의 물음표(?)자리에 들어갈 데이터를 세팅한다.
			//형식) pstmt.set자료형이름(물음표순번, 데이터)
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("empno : " + rs.getInt("empno"));
				System.out.println("ename : " + rs.getString("ename"));
				System.out.println("job : " + rs.getString("job"));
				
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
