package kr.or.dw.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPCheckFilter implements Filter {

	private static Map<String, String> ipMap;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 허용 혹은 불허되는 IP 주소정보를 구성한다.
		ipMap = new HashMap<>();
//		ipMap.put("127.0.0.1", "Y");
		ipMap.put("0:0:0:0:0:0:0:1", "Y");
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String ip = request.getRemoteAddr();	//접속한 ip주소
		//0:0:0:0:0:0:0:1 ==> IPv6의 주소
		//IPv4로 보면 127.0.0.1 이 맞다.
		//이클립스에서 톰캣 실행시 자동으로 설정된 IP값을 가져오는데 default로 IPv6로 잡혀있기 때문
		System.out.println(ip);
		
		if(ip != null && ipMap.containsKey(ip)) {	//목록에 IP가 있으면
			if("Y".equals(ipMap.get(ip))) {		//허용되는지 여부 확인
				chain.doFilter(request, response);
			}else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<h2>접근이 거부된 IP입니다.<br>");
				out.println("관리자에게 문의하세요.</h2>");
			}
		}else {	//목록에 IP가 없으면
			//무조건 특정한 페이지로 이동시킨다.
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath() + "/ServletTest02.do");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
