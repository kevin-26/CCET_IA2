package com.ccet.jsp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {
	
	@ResponseBody
	@GetMapping("/")
	public ModelAndView showLoginPage(Model model) {
        model.addAttribute("message", "JSP View Test");
        
        return new ModelAndView("welcomePage");
    }
	
	@ResponseBody
	@GetMapping("/course")
	public String getAllCourses(@RequestParam(required = false) String page,
			@RequestParam(required = false) String sort, @RequestParam(required = false) String by) {
		String a = "Sr.No&nbsp;&nbsp;&nbsp;Course Name&nbsp;&nbsp;&nbsp;Teaching Faculty&nbsp;&nbsp;&nbsp;Number of Students Enrolled<br/>&nbsp1.&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDSA&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLarry Page&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp10<br/>&nbsp2.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspWeb Dev&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSatya Nadella&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp15<br/>&nbsp3.&nbsp&nbsp&nbsp&nbsp&nbspCloud Computing&nbsp&nbsp&nbsp&nbspSundar Pichai&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp50<br>&nbsp4.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspAI&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspBill Gates&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp40<br>&nbsp5.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspGaming&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspElon Musk&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp35";
		return a;
	}
	
	@ResponseBody
	@GetMapping("/course/count")
	public String getCourseCt()
	{
		return "The total number of courses is 5";
	}
	
	@ResponseBody
	@RequestMapping(value = "/course/search", method = RequestMethod.GET)
	public String findCourseByTitle(@RequestParam(required = false) String title)
	{
		String a = "Course Name&nbsp;&nbsp;&nbsp;Teaching Faculty&nbsp;&nbsp;&nbsp;Number of Students Enrolled<br/>";
		if(title.equalsIgnoreCase("dsa"))
			return a + "DSA&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspLarry Page&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp10";
		else if(title.equalsIgnoreCase("web dev"))
			return a + "Web Dev&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSatya Nadella&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp15";
		else if(title.equalsIgnoreCase("cloud computing"))
			return a + "Cloud Computing&nbsp&nbsp&nbsp&nbspSundar Pichai&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp50";
		else if(title.equalsIgnoreCase("AI"))
			return a + "AI&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspBill Gates&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp40";
		else if(title.equalsIgnoreCase("gaming"))
			return a + "Gaming&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspElon Musk&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp35";
		else
			return "No such course exists";
	}

}
