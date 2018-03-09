package com.bankapp.user.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/successfull", method = RequestMethod.GET)
	public String printUser(ModelMap model, HttpServletRequest request) {

		System.out.println("=================================================");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName(); // get logged in username
		System.out.println("===============" + name);

		Principal principal = request.getUserPrincipal();
		System.out.println("===" + principal.getName());

		model.addAttribute("username", name);
		return "name";

	}
}
