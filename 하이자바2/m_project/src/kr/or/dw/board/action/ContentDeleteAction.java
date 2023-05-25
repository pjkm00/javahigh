package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.web.IAction;

public class ContentDeleteAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bd_no = Integer.parseInt(req.getParameter("bd_no"));
		int result = 0;
		IBoardService service = BoardServiceImpl.getInstance();
		result = service.deleteContent(bd_no);
		
		req.setAttribute("result", result);
		
		return "/board/deleteContentResult.do?result=" + result;
	}

}
