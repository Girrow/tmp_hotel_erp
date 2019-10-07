package me.girrow.hotel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("LogoUT");
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping({ "/", "*" })
	public String home() {
		System.out.println("" + Math.random() * 10);
		return "index";
	}

}
