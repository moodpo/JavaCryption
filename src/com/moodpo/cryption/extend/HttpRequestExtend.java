package com.moodpo.cryption.extend;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.moodpo.cryption.utils.AesUtil;

public class HttpRequestExtend extends HttpServletRequestWrapper {

	private Map<String, String[]> paramsMap = new HashMap<String, String[]>();

	public HttpRequestExtend(HttpServletRequest request) {
		super(request);
		String key = (String) request.getSession().getAttribute("key");
		String iv = (String) request.getSession().getAttribute("iv");
		String salt = (String) request.getSession().getAttribute("salt");

		AesUtil aesUtil = new AesUtil();

		String jCryption = request.getParameter("jCryption");
		if (jCryption == null || jCryption.equals("")) {
			return;
		}

		try {
			String req = aesUtil.decrypt(salt, iv, key, jCryption);
			String[] params = req.split("&");
			if (params.length == 0) {

				return;
			}
			for (String param : params) {
				String[] meters = param.split("=");
				if (meters.length < 2) {

					continue;
				}
				String name = meters[0];
				String value = meters[1];
				paramsMap.put(URLDecoder.decode(name, "UTF-8"),
						new String[] { URLDecoder.decode(value, "UTF-8") });
			}
		} catch (Exception e) {

		}
	}

	public String getParameter(String name) {
		if (paramsMap.get(name) == null) {
			return null;
		}
		return paramsMap.get(name)[0];
	}

	public Map<String, String[]> getParameterMap() {
		return paramsMap;
	}

	public String[] getParameterValues(String name) {
		return paramsMap.get(name);
	}

	public Map<String, String[]> getParamsMap() {
		return paramsMap;
	}

}
