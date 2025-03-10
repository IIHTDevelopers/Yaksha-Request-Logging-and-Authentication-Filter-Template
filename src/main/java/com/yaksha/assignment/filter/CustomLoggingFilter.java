package com.yaksha.assignment.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/user/*") // This filter will intercept all requests starting with /user/
public class CustomLoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Filter initialization logic (if needed)
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// Log the request details using System.out.println
		System.out.println("Request URL: " + httpRequest.getRequestURL());
		System.out.println("Request Method: " + httpRequest.getMethod());
		System.out.println("Request Remote Address: " + httpRequest.getRemoteAddr());

		// You can add authentication check here (for example)
		if (!isAuthenticated(httpRequest)) {
			System.out.println("Unauthorized access attempt detected");
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"You are not authorized to access this resource");
			return; // Stop the chain if unauthorized
		}

		// Continue processing the request
		chain.doFilter(request, response);
	}

	private boolean isAuthenticated(HttpServletRequest request) {
		// For demo purposes, assume authentication is always successful
		// Replace this with actual logic like session or token-based authentication
		return true; // Assume the user is authenticated for now
	}

	@Override
	public void destroy() {
		// Filter destruction logic (if needed)
	}
}
