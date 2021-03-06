package com.ucardstore.api;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		return "welcome";
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseStatus(value= HttpStatus.OK)
	public void save(@PathVariable("str") String str) throws IOException {
		System.out.println(str);
	}
	
}
