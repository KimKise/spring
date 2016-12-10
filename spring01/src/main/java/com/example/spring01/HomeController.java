package com.example.spring01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
//컨트롤러 어노테이션(컨트롤러 객체를 자동으로 생성)
@Controller
public class HomeController {
	//로킹툴 설정
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//시작 페이지로 이동
	@RequestMapping("/")
	public String main(Model model){
		model.addAttribute("message","홈페이지 방문을 환영합니다.");
		return "main";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//url mapping
	//루트 페이지 => home method
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//모델 (서블릿의 request 객체 대체) jsp에서 ${serverTime}으로 가져올 수 있다.
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
