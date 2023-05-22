package kr.or.dw.user.dao;

import kr.or.dw.user.vo.UserVO;

public interface IUserDao {
	
	public String getUserNick(String nick);	//닉네임을 조회하는 메서드

	/**
	 * 회원정보 등록하는 메서드
	 * @param userVo (유저 객체)
	 * @return	결과값
	 */
	public int insertUser(UserVO userVo);

	/**
	 * 회원정보를 조회하는 메서드
	 * @param email (회원 이메일)
	 * @return 
	 */
	public UserVO loginUser(String email);
}
