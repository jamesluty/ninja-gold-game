package com.jamesluty.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NinjaController {
	ArrayList<String> activities = new ArrayList<>();
	
	@GetMapping("/")
	public String index(HttpSession session, Model model, @ModelAttribute("activity") String flash) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		String activity = flash;
		activities.add(activity);
		model.addAttribute("activities", activities);
		return "index.jsp";
	}
	
	@GetMapping("/farm")
	public String farm(HttpSession session, RedirectAttributes activity) {
		String format = "EEEEE dd MMMMM yyyy hh:mm a";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String date = dateFormat.format(new Date());
		Random randInt = new Random();
		Integer gold = randInt.nextInt(11);
		gold += 10;
		String output = "You entered a farm and earned " + gold + " gold. (" + date + ")";
		
		session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
		activity.addFlashAttribute("activity", output);
		
		return "redirect:/";
	}
	
	@GetMapping("/cave")
	public String cave(HttpSession session, RedirectAttributes activity) {
		String format = "EEEEE dd MMMMM yyyy hh:mm a";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String date = dateFormat.format(new Date());
		Random randInt = new Random();
		Integer gold = randInt.nextInt(6);
		gold += 5;
		String output = "You entered a cave and earned " + gold + " gold. (" + date + ")";
		
		session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
		activity.addFlashAttribute("activity", output);
		
		return "redirect:/";
	}
	
	@GetMapping("/house")
	public String house(HttpSession session, RedirectAttributes activity) {
		String format = "EEEEE dd MMMMM yyyy hh:mm a";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String date = dateFormat.format(new Date());
		Random randInt = new Random();
		Integer gold = randInt.nextInt(4);
		gold += 2;
		String output = "You entered a house and earned " + gold + " gold. (" + date + ")";
		
		session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
		activity.addFlashAttribute("activity", output);
		
		return "redirect:/";
	}
	
	@GetMapping("/quest")
	public String quest(HttpSession session, RedirectAttributes activity) {
		String format = "EEEEE dd MMMMM yyyy hh:mm a";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		String date = dateFormat.format(new Date());
		Random randInt = new Random();
		Random randBool = new Random();
		Integer gold = randInt.nextInt(51);
		boolean questBool = randBool.nextBoolean();
		String output = "";
		
		if(questBool) {
			output = "You completed a quest and earned " + gold + " gold. (" + date + ")";
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
		} else {
			if((Integer) session.getAttribute("gold") > gold && (Integer) session.getAttribute("gold") > 0) {
				output = "You failed a quest and lost " + gold + " gold. Ouch. (" + date + ")";
				session.setAttribute("gold", (Integer) session.getAttribute("gold") - gold);
			} else {
				output = "You failed a quest and lost all your gold. Ouch. (" + date + ")";
				session.setAttribute("gold", 0);
			}
		}
		
		activity.addFlashAttribute("activity", output);
		
		return "redirect:/";
	}
	
	@GetMapping("/clear")
	public String clear(HttpSession session) {
		session.removeAttribute("gold");
		activities.removeAll(activities);
		return "redirect:/";
	}
}
