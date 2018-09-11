package com.example.alikaraca.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.example.alikaraca.model.User;
import com.example.alikaraca.repository.UserRepository;
import com.example.alikaraca.service.UserService;

@Controller
@RequestMapping(path="/")
public class AnaController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	/*@GetMapping(path="/ekle")
	public @ResponseBody String addNewUser(@RequestParam String ad,@RequestParam String email) {
		User user=new User();
		user.setAd(ad);
		user.setEmail(email);
		userRepository.save(user);
		return "Eklendi";
	}*/
	@RequestMapping(value="/ekle", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("ekle");
		return modelAndView;
	}
	@RequestMapping(value = "/ekle", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		Optional<User> idExists=userService.findUserById(user.getId());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"Bu e-mail veya id bir kullanıcı tarafından kullanılmaktadır.");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("ekle");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Kullanıcı ekleme başarılı.");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("ekle");
			
		}
		return modelAndView;
	}
	/*@RequestMapping(value = "/sil", method = RequestMethod.POST)
	public ModelAndView deleteUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView=new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		int id=user.getId();
		if (userExists == null) {
			bindingResult
					.rejectValue("id", "error.user",
							"Böyle bir kullanıcı bulunmamaktadır.");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("sil");
		} else {
			
			userService.deleteUser(id);
			modelAndView.addObject("successMessage", "Kullanıcı silme başarılı.");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("sil");
		}
		return modelAndView;
	}*/
	/*@RequestMapping(value = "/sil", method = RequestMethod.POST)
	public String sil(Model model, @ModelAttribute("user") User user) {
		int userId =user.getId();
		System.out.println("MusteriId=" + userId);
		userService.deleteUser(userId);
		
		model.addAttribute("user", user);
		return "sil";
	}*/
	@RequestMapping("/sil/{id}")
	public String sil(@PathVariable String id ,Model model,User user) {
		int userId =user.getId();
		userService.deleteUser(userId);
		model.addAttribute("user", user);
        return "redirect:/duzenle";
	}
	 @RequestMapping(value= {"/guncelle/{id}","/guncelle"}, method = RequestMethod.GET)
	    public String notesEditForm(Model model, @PathVariable(required = false, name = "id") Integer id) {
	        if (null != id) {
	            model.addAttribute("user", userService.findUserById(id));
	        } else {
	            model.addAttribute("user", new User());
	        }
	        return "guncelle";
	    }
	@RequestMapping(value= {"/guncelle"},method = RequestMethod.POST)
	public String guncelle(Model model,User user,BindingResult bindingResult) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if(userExists!=null) {
			bindingResult.rejectValue("email", "error.user",
							"Bu e-mail veya id bir kullanıcı tarafından kullanılmaktadır.");
		}
		if (bindingResult.hasErrors()) {
			
		} else {
			userService.saveUser(user);
			model.addAttribute("user", userService.userList());
			model.addAttribute("successMessage", "Kullanıcı Güncelleme Başarılı");
		}
		return "redirect:/duzenle";
	}
	@GetMapping(path="/api/getir")
	public @ResponseBody Iterable<User> getAllUser() {
		return userRepository.findAll();
	}
	@GetMapping(value = "/listele")
	public String liste(Model model) {
		model.addAttribute("user", userService.userList());
		return "listele";
	}
	@RequestMapping("/duzenle")
	public String duzenle(Model model) {
		model.addAttribute("user", userService.userList());
		return "duzenle";
	}
	
}
