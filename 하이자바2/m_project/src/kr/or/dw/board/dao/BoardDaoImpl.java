package kr.or.dw.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.board.vo.ReplyVO;
import kr.or.dw.user.vo.UserVO;
import kr.or.dw.util.BuildSqlMapClient;

public class BoardDaoImpl implements IBoardDao{

	private static BoardDaoImpl dao;
	
	private SqlMapClient client;
	
	private BoardDaoImpl() {
		client = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static BoardDaoImpl getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}

	@Override
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = client.queryForList("board.selectBoardList", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return boardList;
	}

	@Override
	public int selectBoardCount() {
		int totalCount = 0;
		try {
			totalCount = (int) client.queryForObject("board.selectBoardCount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public int insertContent(BoardVO boardVo) {
		int bd_no = 0;
		try {
			bd_no = (int) client.insert("board.insertContent", boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bd_no;
	}

	@Override
	public BoardVO selectBoardView(int bd_no) {
		BoardVO boardVo = null;
		int result = 0;
		
		try {
			boardVo = (BoardVO) client.queryForObject("board.selectBoardView", bd_no);
			result = client.update("board.hitBoard", bd_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return boardVo;
	}

	@Override
	public int updateContent(BoardVO boardVo) {
		int result = 0;
		try {
			result = client.update("board.updateContent", boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteContent(int bd_no) {
		int result = 0;
		try {
			result = client.update("board.deleteContent", bd_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int insertReply(ReplyVO replyVo) {
		int re_no = 0;
		try {
			re_no = (int) client.insert("board.insertReply", replyVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return re_no;
	}

	@Override
	public ReplyVO selectReply(int re_no) {
		ReplyVO replyVo = null;
		try {
			replyVo = (ReplyVO) client.queryForObject("board.selectReply", re_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return replyVo;
	}

	@Override
	public List<ReplyVO> selectReplyList(int bd_no) {
		List<ReplyVO> replyList = null;
		
		try {
			replyList = client.queryForList("board.selectReplyList", bd_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return replyList;
	}



}
