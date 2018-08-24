package uk.org.getwellgamers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class GwGController{

	@GetMapping("/")
	String index(Principal principal) {
		//return principal == null ? "redirect:index.html" : "redirect:admin.html";
		return "redirect:index.html";
	}
}
