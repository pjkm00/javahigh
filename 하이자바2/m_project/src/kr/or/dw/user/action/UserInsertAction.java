package kr.or.dw.user.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.dw.user.service.IUserService;
import kr.or.dw.user.service.UserServiceImpl;
import kr.or.dw.user.vo.UserVO;
import kr.or.dw.util.CryptoUtil;
import kr.or.dw.web.IAction;

public class UserInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserVO userVo = new UserVO();
		
//		String email = req.getParameter("email");
//		String pass = req.getParameter("pass");
//		String nick = req.getParameter("nick");
//		String name = req.getParameter("name");
//		String bir = req.getParameter("bir");
//		String gender = req.getParameter("gender");
		
		
//		userVo.setEmail(email);
//		userVo.setPass(pass);
//		userVo.setNick(nick);
//		userVo.setName(email);
//		userVo.setBir(bir);
//		userVo.setGender(email);
		
		BeanUtils bean = new BeanUtils();
		try {
			bean.populate(userVo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//비밀번호 암호화
		String user_pass = req.getParameter("pass");
		try {
			user_pass = CryptoUtil.sha512(user_pass);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setPass(user_pass);
		
		IUserService service = UserServiceImpl.getInstance();
		int user_no = service.insertUser(userVo);
		System.out.println(user_no);
		
		req.setAttribute("user_no", user_no);
		
		return "/user/joinSuccess.jsp";
	}

}
