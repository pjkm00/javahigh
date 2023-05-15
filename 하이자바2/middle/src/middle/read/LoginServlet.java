package middle.read;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
		UserDB ud = new UserDB();
		req.setCharacterEncoding("utf-8");
		ud.userDB(req, res);
		res.setCharacterEncoding("utf-8");
		List<LectureList> lectureList = (List<LectureList>) req.getAttribute("lectureList");
		if(lectureList.size() != 0) {
			for(LectureList l : lectureList) {
				System.out.println(l.lecname);
			}
		}else {
			System.out.println("없음");
		}
		
		
	}
	
}
