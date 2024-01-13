package com.homemekar.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.homemekar.entity.ApnaDtls;
import com.homemekar.entity.UserDtls;
import com.homemekar.repositroy.ApnaRepository;
import com.homemekar.repositroy.UserRepository;



@Controller
@RequestMapping("/user/")
public class ApnaGharController {
	
	
	
	@Autowired
	private ApnaRepository apnaRepo;
	@Autowired
	private UserRepository userRepo;
	
	
	
	@GetMapping("/")
	public String apnaGharHome() {
		return "user/home";
		}
	
	@PostMapping("/process-contact")
	public String processApanaGhar(@ModelAttribute ApnaDtls apna,@RequestParam MultipartFile image , Principal principal) {
	     
		String name  = principal.getName();
		
		
		
		UserDtls user = this.userRepo.findByNumber(name);
		apna.setStates("pending");
		apna.setImageUrl(image.getOriginalFilename());
		apna.setUser(user);
		
       ApnaDtls  uploading=apnaRepo.save(apna);
		user.getApna().add(apna);
		
       this.userRepo.save(user);
        
        if(uploading!=null) {
        	try {
        		File saveFile =new ClassPathResource("static/images").getFile();
        		Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+image.getOriginalFilename());
        		System.out.println(path);
        		Files.copy(image.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
        	}catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        
        System.out.println(apna);
		 
		return "user/home";
	}

}
