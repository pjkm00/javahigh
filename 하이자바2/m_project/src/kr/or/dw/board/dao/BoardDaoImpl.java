package kr.or.dw.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.board.vo.BoardVO;
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



}
