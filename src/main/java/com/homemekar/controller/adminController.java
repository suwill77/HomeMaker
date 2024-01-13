package com.homemekar.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.homemekar.entity.ApnaDtls;
import com.homemekar.entity.ConDtls;
import com.homemekar.entity.UserDtls;
import com.homemekar.repositroy.ApnaRepository;
import com.homemekar.repositroy.ContRepository;
import com.homemekar.repositroy.UserRepository;
import com.homemekar.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class adminController {

	@Autowired
	private ApnaRepository repo;
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private ContRepository contRepo;

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String home(Model m) {
		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);
		List<UserDtls> user = this.userRepo.findByRoles("ROLE_ADMIN");
		m.addAttribute("user", user);

		return "admin/dashboard";
	}

	@GetMapping("/admin_index")
	public String index(Model m) {

		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);
		List<UserDtls> user = this.userRepo.findByRoles("ROLE_ADMIN");
		

		m.addAttribute("user", user);
		return "admin/dashboard";
	}

	@GetMapping("/user_profile")
	public String profile() {
		return "admin/user";
	}

	@GetMapping("/maped")
	public String map() {
		return "admin/map";
	}

	@GetMapping("/profile")
	public String profile_page() {
		return "admin/profile";
	}



	// Show contacts handler
	@GetMapping("/show-contacts")
	public String showContacts(Model m) {
		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);

		List<ApnaDtls> apna = this.repo.findAllByStates("pending");

		m.addAttribute("apna", apna);
		return "admin/view";
	}

	@GetMapping("/show-contractor")
	public String showContractor(Model m) {
		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);

		List<ConDtls> apna = this.contRepo.findAllByStates("pending");

		m.addAttribute("apna", apna);

		return "admin/cont_view";
	}
	
	
	
	
	
	
	
	@GetMapping("/admin_register")
	public String admin_register(Model m) {

		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);

		return "sign-up";
	}

	@PostMapping("/admin_cerateUser")
	public String createUser(@ModelAttribute UserDtls user ,HttpSession session) {
		 System.out.println(user);
		 UserDtls userDtls =userService.createData(user);
		if(userDtls!=null) {
			
			session.setAttribute("msg","Register Sucessfuly" );
			System.out.println("Register Sucessfuly");
		}else {
			session.setAttribute("msg","Some thing error in the server" );
			System.out.println("Some thing error in the server");
		}
		 
	
		return "redirect:/admin/admin_register";
		}
	

	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model m) {
	    
		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);
		
		ApnaDtls apna = repo.findById(id);	    
	    m.addAttribute("user", apna);
	    return "admin/update_project";
	}
	
	
	
	@PostMapping("/update")
	public String updateUser( @ModelAttribute ApnaDtls apna,  Model model) {
	
	        
	   repo.save(apna);
	    
	 
	    return "redirect:/admin/show-contacts";
	}
	
	
	
	
	
	@GetMapping("/cont_edit/{id}")
	public String showUpdate(@PathVariable("id") long id, Model m) {
	    
		long count = this.repo.count();
		long counts = this.contRepo.count();

		long completeCount = this.repo.countByStates("complete");
		long completeCount1 = this.contRepo.countByStates("complete");

		long complete = completeCount + completeCount1;
		m.addAttribute("complete", complete);

		long pendingCount = this.repo.countByStates("pending");
		long pendingCount1 = this.contRepo.countByStates("pending");

		long pending = pendingCount + pendingCount1;
		m.addAttribute("pending", pending);

		System.out.println(pending);

		long all = count + counts;

		System.out.println(all);
		m.addAttribute("all", all);

		long apnaCount = this.userRepo.countByRole("ROLE_APNAGHAR");

		long contConut = this.userRepo.countByRole("ROLE_CONTRACTOR");
		long allUser = apnaCount + contConut;
		m.addAttribute("allUser", allUser);
		
		
		ConDtls con = contRepo.findById(id);	    
	    m.addAttribute("user", con);
	    return "admin/cont_update";
	}
	@PostMapping("/save")
	public String updateUser( @ModelAttribute ConDtls con,@RequestParam MultipartFile image,  Model model) {
	
	        
		ConDtls uploading =contRepo.save(con);
		
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
	    return "redirect:/admin/show-contractor";
	}
}
