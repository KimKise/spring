package com.example.spring01.part1_ch05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//ajax처리 전용 컨트롤러(백그라운드에서 실행됨)
@RestController //스프링 4.0이상부터 사용 가능
public class Sample2Controller {
	@ResponseBody
	@RequestMapping("part1_ch05/doF")
	//@ResponseBody   : json 형식으로 데이터를 리턴
	public  ProductVO doF(){
		//doF.jsp로 json 데이터가 리턴됨
		return new ProductVO("냉장고", 500000);//페이지를 리턴하는 것이 아니라 객체를 리턴
	}
}
