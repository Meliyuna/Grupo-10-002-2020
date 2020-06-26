package com.unla.TPObjetosII.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	
	
	
	@GetMapping("/")
	public String home(HttpServletRequest req){
//	    try {
//	    	UsernamePasswordAuthenticationToken token
//		      = new UsernamePasswordAuthenticationToken("Marcelo", "123");
//	        token.setDetails(new WebAuthenticationDetails(req));
//	        Authentication authentication = this.authManager.authenticate(token);
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	        HttpSession session = req.getSession(true);
//	        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
//	    } catch (Exception e) {
//	        SecurityContextHolder.getContext().setAuthentication(null);
//	    }
		return "/index";
	}
	
	@GetMapping("/estructura")
	public String bootstrap() {
		return "estructura/estructura";
	}
	
	@GetMapping("/blank")
	public String bootstrapBlank() {
		return "bootstrap/blank";
	}
	
}
