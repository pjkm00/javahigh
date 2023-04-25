package kr.or.dw.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest02 {
	//문제1) 사용자로부터 empno값을 입력받아 입력한 값보다 empno가 큰 자료들을 출력하시오.
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "민경", "java");
			
			String sql = "select * from emp";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.print("empno를 입력하세요");
			int inputempno = Integer.parseInt(sc.nextLine());
			while(rs.next()) {
				if(inputempno < rs.getInt("empno")) {
					System.out.println("empno : " + rs.getInt("empno"));
					System.out.println("ename : " + rs.getString("ename"));
					System.out.println("job : " + rs.getString("job"));
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn != null) try {conn.close();} catch(SQLException e2) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e2) {}
			if(rs != null) try {rs.close();} catch(SQLException e2) {}
		}
		
		
		
		
	}

}
