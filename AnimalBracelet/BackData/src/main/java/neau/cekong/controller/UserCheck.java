package neau.cekong.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neau.cekong.pojo.TableUser;

/**
 * Servlet Filter implementation class UserCheck
 */
@WebFilter("/*")
public class UserCheck implements Filter {

	ThreadLocal<TableUser> tl = new ThreadLocal<>();
	
	boolean flag = true;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		ServletContext context = session.getServletContext();

		if (flag) {
			TableUser tu = new TableUser();
			tu.setUserName("lyp");
			tu.setUserId(2L);
			context.setAttribute("555049DEBFB0EF776B7107DBDEA2D215", tu);
			flag = false;
		}

		String url = req.getRequestURI();
		if (url.contains("/data/save") || url.contains("/data/login") || url.contains("/data/regist")) {
			chain.doFilter(request, response);
			return;
		}

		try {
			String log = (String) req.getParameter("LOGSESSION");
			System.out.println("取出logsession");
			if (log != null)
				System.out.println(log);
			TableUser tu = (TableUser) context.getAttribute(log);
			if (tu != null) {
				System.out.println("有啦");
				tl.set(tu);//线程绑定
			} else {
				System.out.println("不存在啊");
				return;
			}
		} catch (Exception e) {
			System.out.println("不存在啊");
			return;
		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
