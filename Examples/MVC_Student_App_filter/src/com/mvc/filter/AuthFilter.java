package com.mvc.filter;

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

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(servletNames= {"addstudent", "editstudent", "showstudent", "showcollege", "showallcollege"})
public class AuthFilter implements Filter {
	private ServletContext context;
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; 
		HttpServletResponse res = (HttpServletResponse) response; 
		HttpSession session = req.getSession();
		System.out.println("Inside do filter");
		if(session == null) {
			this.context.log("Unauthorized access to resource");
			res.sendRedirect("views/login.html");
		} else {
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("Authentication filter initialized");
		System.out.println("filter initialized");
	}

}
