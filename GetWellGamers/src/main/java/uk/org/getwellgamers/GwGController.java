package uk.org.getwellgamers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
class GwGController{

	@RequestMapping(method = RequestMethod.GET)
	  public String root(Locale locale, ModelMap model) {
		   return   "redirect:index.html";		 
	}
}
