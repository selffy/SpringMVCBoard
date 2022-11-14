package kr.kwangan2.springmvcboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class IndexController {
	
	@GetMapping("/")
	public String index(@RequestParam("result") int result, Model model) {
		log.info("result ==============> " + result);
		model.addAttribute("result", result);
		return "redirect : /";
	}
}