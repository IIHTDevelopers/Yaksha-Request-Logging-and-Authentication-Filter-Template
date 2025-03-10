package com.yaksha.assignment.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import com.yaksha.assignment.filter.CustomLoggingFilter;

public class FilterConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Register the CustomLoggingFilter
		FilterRegistration.Dynamic loggingFilter = servletContext.addFilter("customLoggingFilter",
				new CustomLoggingFilter());

		// Set the URL pattern where the filter will be applied
		loggingFilter.addMappingForUrlPatterns(null, false, "/user/*"); // Apply to all URLs under /user/
	}
}
