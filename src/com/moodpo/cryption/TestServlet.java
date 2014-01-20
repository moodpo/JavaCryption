package com.moodpo.cryption;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moodpo.cryption.extend.HttpRequestExtend;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpRequestExtend myRequest = new HttpRequestExtend(request);
		
		System.out.println("=====================");
		System.out.println("username = " + myRequest.getParameter("username"));
		
		System.out.println("password = " + myRequest.getParameter("password"));
		
	}

}
