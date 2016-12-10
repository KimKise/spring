package com.example.spring01.part1_ch05;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("part1_ch05/doA")
	public void doA(Model model){
		logger.info("doA called...");//로그 출력
		//modeladdAttribute(key, value) 데이터 저장소 map으로 구성됨
		model.addAttribute("message","ㅋㅋㅋㅋ");//포워딩할 페이지로 model값이 이동 다른 페이지에서는 사용 X
		//리턴타입이 void이면 method가 종료된 후 doA.jsp로 포워드됨
		
		//return "doB"; 리턴타입이 String이면 
	}
	
	@RequestMapping("part1_ch05/doB")
	public void doB(){
		logger.info("doB called...");
		//method가 종료된 후 doB.jsp로 포워드됨
	}
	
//ModelAndView : model - 데이터 저장소, view - 화면
//데이터와 포워드할 페이지의 정보까지 가지고 있음
//ModelAndView는 포워딩 방식 forward : 주소 그대로, 화면 전환, 대량의 데이터 전달
//						redirect : 주소 바뀜, 화면 전환, 소량의 get 방식 데이터
	@RequestMapping("part1_ch05/doC")
	public ModelAndView doC(){
		Map<String, Object> map = new HashMap<>();
		//맵에 객체 저장
		map.put("product", new ProductVO("샤프", 1000));
		// new ModelAndView("view의 이름- doC.jsp로 보냄","맵변수명 -doC.jsp에 보낼 map의 변수명",맵 -데이터);
		return new ModelAndView("part1_ch05/doC","map",map);
	}
	
	@RequestMapping("part1_ch05/doD")
	public String doD(){
	//redirect의 경우 return type을 String으로 설정
	//doE.jsp로 리디렉트됨
		//return "part1_ch05/doE"; //이것은 포워드
		return "redirect:/part1_ch05/doE";
	}
	@RequestMapping("part1_ch05/doE")
	public void doE(){
		//doE.jsp로 포워드
	}
	
	
	
}
