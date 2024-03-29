package kr.or.dw.board.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.board.vo.ReplyVO;

public interface IBoardService {

	/**
	 * 게시판 목록을 가져오는 메서드
	 * @param paramMap rownum 의 시작과 끝값이 있는 map
	 * @return 게시판 목록 list
	 */
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap);

	/**
	 * 게시판 전체 레코드 수를 가져오는 메서드
	 * @return 전체 레코드 수
	 */
	public int SelectBoardCount();

	/**
	 * 게시글 작성 메서드
	 * @param boardVo
	 * @return 글 번호
	 */
	public int insertContent(BoardVO boardVo);

	/**
	 * 게시글 정보 가져오는 메서드
	 * @param bd_no (글 번호)
	 * @return boardVO 객체
	 */
	public BoardVO selectBoardView(int bd_no);

	/**
	 * 글 수정하는 메서드
	 * @param boardVo (글 객체)
	 * @return 결과값
	 */
	public int updateContent(BoardVO boardVo);

	/**
	 * 글 삭제하는 메서드
	 * @param bd_no (글번호)
	 * @return 삭제한 결과값
	 */
	public int deleteContent(int bd_no);

	/**
	 * 댓글 작성 메서드
	 * @param replyVo
	 * @return
	 */
	public int insertReply(ReplyVO replyVo);

	/**
	 * 댓글 조회
	 * @param re_no
	 * @return
	 */
	public ReplyVO selectReply(int re_no);

	/**
	 * 해당 게시글의 댓글 리스트 가져오기
	 * @param bd_no(게시글 번호)
	 * @return 댓글 리스트
	 */
	public List<ReplyVO> selectReplyList(int bd_no);

	/**
	 * 댓글 삭제 메서드
	 * @param re_no (댓글번호)
	 * @return 결과값
	 */
	public int deleteReply(int re_no);

	/**
	 * 댓글수정 메서드
	 * @param replyVo
	 * @return
	 */
	public int updateReply(ReplyVO replyVo);

}
