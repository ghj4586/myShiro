package com.atguigu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/shiro")
@Controller
public class ShiroHandler {

	@Autowired
	private ShiroService shiroService;
	
	
	
	@ExceptionHandler(UnauthorizedException.class)
	public String  doUnauthorizedException(Exception ex){
		
		
		
		return "redirect:/unauthorized.jsp";
	}
	
	@RequestMapping("/testannotation")
	public String testAnnotation(){
		
		shiroService.doMyjob();
		
		return "redirect:/success.jsp";
	}
	
	
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		 Subject currentUser = SecurityUtils.getSubject();
		 if (!currentUser.isAuthenticated()) {
	        	// 把用户名和密码封装为 UsernamePasswordToken 对象. 
	            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	            token.setRememberMe(true);
	            try {
	                currentUser.login(token);
	            } 
	            catch (AuthenticationException ae) {
	            }
	      }

		

		return "redirect:/success.jsp";
	}

}
