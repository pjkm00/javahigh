package kr.or.dw.user.service;

import kr.or.dw.user.dao.IUserDao;
import kr.or.dw.user.dao.UserDaoImpl;
import kr.or.dw.user.vo.UserVO;

public class UserServiceImpl implements IUserService{

	private IUserDao dao;
	private static UserServiceImpl service;
	
	public static UserServiceImpl getInstance() {
		if(service == null) {
			service = new UserServiceImpl();
		}
		return service;
	}

	private UserServiceImpl() {
		dao = UserDaoImpl.getInstance();
	}
	
	@Override
	public String getUserNick(String nick) {
		return dao.getUserNick(nick);
	}

	@Override
	public int insertUser(UserVO userVo) {
		return dao.insertUser(userVo);
	}

	@Override
	public UserVO loginUser(String email) {
		return dao.loginUser(email);
	}

	@Override
	public void updateUserPicPath(UserVO vo) {
		 dao.updateUserPicPath(vo);
		
	}
	
}
