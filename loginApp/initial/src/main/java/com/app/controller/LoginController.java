package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpSession;

import com.app.model.LoginVO;
import com.app.service.UserService;

@Controller
public class LoginController {

	@Autowired
  	UserService userService;

	@RequestMapping("/loginApp")  
	public String display()  
	{  
		return "login";  
	}

	@RequestMapping("/registration")  
	public String registration()  
	{  
		return "register";  
	}

	@RequestMapping("/register")  
	public String register(HttpServletRequest req,HttpSession session,Model m)  
	{  
		 String user=req.getParameter("user");
		 String name=req.getParameter("name");   
         String pass=req.getParameter("pass");  
		 String cpass=req.getParameter("cpass"); 
		 String role=req.getParameter("role"); 

		 if (!pass.equals(cpass)){ 
			 String msg="Password and Confirmed Password does not Match";  
             m.addAttribute("message", msg); 
			 return "register";
		 }else{
			 if (userService.checkUser(user)){
				String msg="User Already Exist";  
				m.addAttribute("message", msg);
				return "register";
			 }else{
				userService.registerUser(user,name,pass,role);
				String msg="Register Successfully Please Login";  
				m.addAttribute("message", msg);
				return "login";
			 }
			
		 }
		 
		 
		 
		
	}   

	@RequestMapping("/login")  
	public String login(HttpServletRequest req,HttpSession session,Model m)  
	{  
		 String user=req.getParameter("user");  
         String pass=req.getParameter("pass");  

		 if (user==null || pass==null){
			 return "login";
		 }
		 
		 LoginVO loginvo=userService.validateUser(user,pass);
		 
		 if(loginvo!=null)  
        {  
			session.setAttribute("loginvo", loginvo);
			m.addAttribute("name", loginvo.getName()); 
			m.addAttribute("username", loginvo.getUsername()); 
			m.addAttribute("role", loginvo.getRole()); 
            return "welcome";  
        }  
        else  
        {  
            String msg="Invalid userid or password";  
            m.addAttribute("message", msg);  
            return "login";  
        }     
	} 

	@RequestMapping("/welcome")  
	public String welcome(HttpSession session,Model m ) {
		LoginVO loginvo=(LoginVO)session.getAttribute("loginvo");

		if (loginvo==null){
			return "login";  
		}
		else{
			m.addAttribute("name", loginvo.getName()); 
			m.addAttribute("username", loginvo.getUsername()); 
			m.addAttribute("role", loginvo.getRole()); 
		}

		return "welcome";
	}

	@RequestMapping("/restricted")  
	public String restricted(HttpSession session,Model m ) {
		LoginVO loginvo=(LoginVO)session.getAttribute("loginvo");

		if (loginvo==null){
			return "login";  
		}
		
		if (!loginvo.getRole().equals("Manager")){
			m.addAttribute("name", loginvo.getName()); 
			m.addAttribute("username", loginvo.getUsername()); 
			m.addAttribute("role", loginvo.getRole());
			m.addAttribute("message", "Invalid Access"); 
			return "welcome";
		}
		else{
			m.addAttribute("role", loginvo.getRole()); 
			return "restricted";
		}

		
	}

	@RequestMapping("/logout")  
	public String logout(HttpSession session ) {
		session.invalidate();
		return "login";
	}
} 

