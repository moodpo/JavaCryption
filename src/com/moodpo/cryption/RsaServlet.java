package com.moodpo.cryption;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyPair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moodpo.cryption.utils.RsaUtil;

@WebServlet("/RsaServlet")
public class RsaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			RsaUtil util = new RsaUtil();
			KeyPair keyPair = util.generateKeypair();
			
			request.getSession().setAttribute("KEYPAIR", keyPair);
			String publicKey = RsaUtil.getKeyString(keyPair.getPublic());
			
			System.out.println("1. Get PublicKey = " + publicKey);
			
			String iv = "F27D5C9927726BCEFE7510B1BDD3D137";
			String salt = "3FF2EC019C627B945225DEBAD71A01B6985FE84C95A70EB132882F88C0A59A55";
			
			request.getSession().setAttribute("iv", iv);
			request.getSession().setAttribute("salt", salt);
			
			PrintWriter out = response.getWriter();
			out.print("{\"publickey\":\"" + publicKey 
					+ "\",\"iv\":\"" + iv + "\",\"salt\":\""
					+ salt +"\"}");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
