package com.github.hashd.interviewhq.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.hashd.interviewhq.utils.HttpUtils;
import com.google.common.collect.ImmutableMap;

@Controller
public class PagesController {
	
	private final String clientId = "951824676964-uqumkcr6uoqvqov4s7kcqcstvqh3hpg2.apps.googleusercontent.com";
	private final String clientSecret = "dEPIY0G2l0wBSEvMuI9hTG4K";
	private final String callbackUri = "http://localhost:8089/callback";
	private String accessToken = null;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/signin")
	public void signin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		StringBuilder oauthUrl = new StringBuilder().append("https://accounts.google.com/o/oauth2/auth")
				.append("?client_id=").append(clientId) 
				.append("&response_type=code")
				.append("&scope=openid%20email")
				.append("&redirect_uri=").append(callbackUri)
				.append("&state=this_can_be_anything_to_help_correlate_the_response%3Dlike_session_id")
				.append("&access_type=offline")
				.append("&approval_prompt=force");
				resp.sendRedirect(oauthUrl.toString());
	}
	
	@RequestMapping("/callback")
	public void callback(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpUtils httpUtil = new HttpUtils();
		// google returns a code that can be exchanged for a access token
		String code = req.getParameter("code");

		// get the access token by post to Google
		String body = httpUtil.post("https://accounts.google.com/o/oauth2/token", ImmutableMap.<String,String>builder()
				.put("code", code)
				.put("client_id", clientId)
				.put("client_secret", clientSecret)
				.put("redirect_uri", callbackUri)
				.put("grant_type", "authorization_code").build(),accessToken );

		JSONObject jsonObject = null;

		try {
			jsonObject = (JSONObject) new JSONParser().parse(body);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse json " + body);
		}

		// google tokens expire after an hour, but since we requested offline access we can get a new token without user involvement via the refresh token
		accessToken = (String) jsonObject.get("access_token");
		req.getSession().setAttribute("access_token", accessToken);

		// get some info about the user with the access token
		String json = httpUtil.get(new StringBuilder("https://www.googleapis.com/oauth2/v1/userinfo?access_token=").
				append(accessToken).toString(), accessToken);
		resp.sendRedirect("/rest/api/questions/1");
	}
	
}
