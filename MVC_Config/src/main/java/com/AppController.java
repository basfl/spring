package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import scala.annotation.meta.setter;

@Controller
public class AppController {

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello World: Spring MVC without XML configuration";
	}

	@ResponseBody
	@RequestMapping(value = "/babak", method = RequestMethod.GET)
	public String helloName() {
		return "Hello babak: Spring MVC without XML configuration";
	}

	@ResponseBody
	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	// @RequestMapping(method = RequestMethod.GET)
	public ModelAndView hello() {

		System.out.println("inside the hello()");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
		

	}
}