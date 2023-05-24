package kr.or.dw.board.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.util.PaginationUtil;
import kr.or.dw.web.IAction;

public class BoardMainAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IBoardService service = BoardServiceImpl.getInstance();
		
		//페이징처리
		Map<String, Integer> pagingConfigMap = null;
		PaginationUtil pagination = new PaginationUtil();
		String pageParam = req.getParameter("page");	//사용자가 선택한 페이지번호
		int page = (pageParam == null ? 1 : Integer.parseInt(pageParam));
		
		int totalCount = service.SelectBoardCount();
		
		pagination.setConfig(page, 10, 10, totalCount);
		pagingConfigMap = pagination.getConfig();
		
		//ibatis에서 받을 parameterMap을 만든다.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", pagingConfigMap.get("start"));
		paramMap.put("end", pagingConfigMap.get("end"));
		
		//게시판 목록을 가져온다.
		List<BoardVO> boardList = service.selectBoardList(paramMap);
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("pagingConfigMap", pagination);
		req.setAttribute("title_nm", "Board");
		
		return "/board/boardMain.jsp";
	}

}
