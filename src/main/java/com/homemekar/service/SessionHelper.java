package com.homemekar.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
  
	public void removeMessageFromSession() {
		try {
			
		HttpSession session =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.removeAttribute("msg");	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
