package com.homemekar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homemekar.entity.UserDtls;
import com.homemekar.repositroy.UserRepository;
import com.homemekar.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller

public class HomeController {
	

	@GetMapping("/price")
public String price() {
	return "price";
}
	
	
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title","Home-Smart Employee Manager");
		return "home";
	}
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
		}
	
	
	
	
	
	@GetMapping("/contractorHome")
	public String contractorHome() {
		
		return "/contractor/contractorHome";
	}
	
	
	@GetMapping("/apnaGharRegister")
	public String apnaGharRegister() {
		  return "/user/apnaGharRegister";
	}
	@GetMapping("/contractorRegister")
	public String contractorRegister() {
		  return "/contractor/contractorRegister";
	}
	

	
	
	@PostMapping("/apnaGhar_cerateUser")
	public String createUser1(@ModelAttribute UserDtls user ,HttpSession session) {
		 System.out.println(user);
		 UserDtls userDtls =userService.createData1(user);
		if(userDtls!=null) {
			
			session.setAttribute("msg","Register Sucessfuly" );
			System.out.println("Register Sucessfuly");
		}else {
			session.setAttribute("msg","Some thing error in the server" );
			System.out.println("Some thing error in the server");
		}
		 
	
		return "redirect:/apnaGharRegister";
		}
	@PostMapping("/contractor_cerateUser")
	public String createUser2(@ModelAttribute UserDtls user ,HttpSession session) {
		 System.out.println(user);
		 
		 UserDtls userDtls =userService.createData2(user);
		if(userDtls!=null) {
			
			session.setAttribute("msg","Register Sucessfuly" );
			System.out.println("Register Sucessfuly");
		}else {
			session.setAttribute("msg","Some thing error in the server" );
			System.out.println("Some thing error in the server");
		}
		 
	
		return "redirect:/contractorRegister";
		}
	
	
	
	
	
	@GetMapping("/loadForgetPassword")
	public String loadForgetPassword() {
		return "forget_password";
	}
	
	
	@GetMapping("/loadResetPassword/{id}")
	public String loadesetPassword(@PathVariable int id , Model m) {
		System.out.println(id);
		m.addAttribute("id",id);
		return "reset_password";
	}
	
    
	@PostMapping("/forgetPassword")
	public String forgetPassword(@RequestParam String number ,HttpSession session) {
		
		UserDtls user =userRepo.findByNumber(number);
		
		
		if(user!=null) {
			return "redirect:/loadResetPassword/"+ user.getId();
		}else {
			
			session.setAttribute("msg", "invalid number  !!");
			return "forget_password";
		}
		
	}
	
	@PostMapping("/changePassword")
	public String resetPassword(@RequestParam String psw, @RequestParam Integer id, HttpSession session ) {
		
		UserDtls user = userRepo.findById(id).get();
		
		String encryptPws = passwordEncoder.encode(psw);
		user.setPassword(encryptPws);
		
	UserDtls updateUser=	userRepo.save(user);
	
	if(updateUser!=null) {
		session.setAttribute("msg", "Password Change Successfully");
	}
	   
		return "redirect:/loadForgetPassword";
		
	}
	
	

}
