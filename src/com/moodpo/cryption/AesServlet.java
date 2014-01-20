package com.moodpo.cryption;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moodpo.cryption.utils.AesUtil;
import com.moodpo.cryption.utils.RsaUtil;

@WebServlet("/AesServlet")
public class AesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// get key
		String key = request.getParameter("key");
		
		KeyPair keyPair = (KeyPair)request.getSession().getAttribute("KEYPAIR");
		// decrypt
		try {
			key = RsaUtil.decrypt(key, keyPair);
			request.getSession().setAttribute("key", key);
			System.out.println("2. Decrypt Key = " + key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AesUtil aesUtil = new AesUtil();
		String iv = (String)request.getSession().getAttribute("iv");
		String salt = (String)request.getSession().getAttribute("salt");
		
		String encrypt = aesUtil.encrypt(salt, iv, key, key);
		
		System.out.println("3. Aes Encrypt = " + encrypt);
		
		PrintWriter out = response.getWriter();
		out.print("{\"challenge\":\"" + encrypt + "\"}");
		
	}

}
