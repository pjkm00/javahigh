package middle.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.member.service.IMemberService;
import kr.or.dw.member.service.MemberServiceImpl;
import kr.or.dw.vo.MemberVO;

public class LectureListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		/*
		 * URL ==> http://localhost/servlet02/member/memberList.do
		 * URI ==> 				   /servlet02/member/memberList.do
		 * 요청 URI ==>						 /member/memberList.do
		 * ContextPath ==> 		   /servlet02
		 */
		
		//사용자의 요청정보 가져오기
		String uri = req.getRequestURI();
		
		System.out.println("uri = " + uri);
		
		String view = "";	//view페이지가 저장될 변수
		
		if(uri == null) {
			//반환할 uri 가 없으면 404에러 처리
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}else if("/member/memberList.do".equals(uri)) {
			ILectureService lecService = LectureServiceImpl.getInstance();
			List<LectureVO> memList = lecService.getAllMember();
		
			System.out.println(memList);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
