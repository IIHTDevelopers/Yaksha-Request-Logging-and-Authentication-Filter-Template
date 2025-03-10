package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.yaksha.assignment.utils.CustomParser;

public class ProductControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCustomLoggingFilterAnnotation() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/filter/CustomLoggingFilter.java";

		// Check if the class has the @WebFilter annotation with the correct value
		// (urlPatterns = "/user/*")
		boolean hasWebFilterAnnotation = CustomParser.checkClassAnnotationWithValue(filePath, "WebFilter",
				"urlPatterns = \"/user/*\"");

		// Verify if annotation is present with the correct value
		yakshaAssert(currentTest(), hasWebFilterAnnotation, businessTestFile);
	}

	@Test
	public void testCustomLoggingFilterUsesGetRequestURL() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/filter/CustomLoggingFilter.java";

		// Check if getRequestURL() is used inside the doFilter() method
		boolean usesGetRequestURL = CustomParser.checkMethodCalledInMethods(filePath, "CustomLoggingFilter",
				"getRequestURL");

		// Verify if the method is used
		yakshaAssert(currentTest(), usesGetRequestURL, businessTestFile);
	}

	@Test
	public void testCustomLoggingFilterUsesDoFilerMethod() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/filter/CustomLoggingFilter.java";

		// Check if getMethod() is used inside the doFilter() method
		boolean usesGetMethod = CustomParser.checkMethodExists(filePath, "doFilter");

		// Verify if the method is used
		yakshaAssert(currentTest(), usesGetMethod, businessTestFile);
	}

	@Test
	public void testCustomLoggingFilterUsesGetRemoteAddr() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/filter/CustomLoggingFilter.java";

		// Check if getRemoteAddr() is used inside the doFilter() method
		boolean usesGetRemoteAddr = CustomParser.checkMethodCalledInMethods(filePath, "CustomLoggingFilter",
				"getRemoteAddr");

		// Verify if the method is used
		yakshaAssert(currentTest(), usesGetRemoteAddr, businessTestFile);
	}
}
