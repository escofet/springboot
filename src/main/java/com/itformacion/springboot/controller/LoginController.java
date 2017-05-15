package com.itformacion.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletResponse response, 
		@RequestParam(value="username") String username,
		@RequestParam(value="password", required = false) String password
		) throws IOException {
		
		Map<String, String> messages = new HashMap<>();
		messages.put("username", username);
		messages.put("password", password);
		return new ModelAndView("login", messages);
	}
}
