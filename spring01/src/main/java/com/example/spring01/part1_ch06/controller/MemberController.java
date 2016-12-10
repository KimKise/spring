package com.example.spring01.part1_ch06.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.part1_ch06.model.dto.MemberVO;
import com.example.spring01.part1_ch06.service.MemberService;

@Controller //현재 클래스를 controller bean으로 등록시킴
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
//MemberService 객체를 스프링에서 생성하여 주입시킴
//Controller는 Service를 호출 Service는 DAO를 호출하기 때문에 결국은 Controller도 @Inject를 시켜줌
	@Inject
	MemberService memberService;
	
	@RequestMapping("member/list.do")
	public String memberList(Model model){
//Controller => Service => DAO 요청
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list",list);
		return "member/member_list";
	}
	
//-----------------------------------------------------------------------
	//그냥  페이지 넘기기 
	//회원 등록폼으로 이동
	@RequestMapping("member/write.do")
	public String write(){
		return "member/write";
	}
	
	//write.jsp에서 넘어온 form 정보를 model에 담아야 한다. post방식으로 넘어온것을 Model로 처리
	//insert 처리
	@RequestMapping("member/insert.do")
	//----------------넘어온 form 값을 읽을 때------------------------
	//1. public String write(HttpServletRequest request){ request.getParameter로 받아올 수도 있다.
	//2. public String write(String userid, String userpw, String username, String email){ 이렇게 하나씩 받아올 수도 있다.
	//3. @ModelAttribute MemberVO vo는 request.getparameter처럼 넘어 온 form의 정보를 읽음 
	public String insert(@ModelAttribute MemberVO vo){
		//테이블에 레코드를 입력
		memberService.insertMember(vo);
		//바로 member_list.jsp로 가면 아무데이터가 없다. 
		//때문에 list.do로 가서 다시 list를 출력한 뒤 출력해야한다.
		return "redirect:/member/list.do";
		//-		/member/list.do 루트 디렉토리 기준
		//-		member/list.do	현재 디렉토리 기준
	}
//--------------------------------------------------------------------------------------
	@RequestMapping("member/view.do")
	//member_list에서 userid가 넘어옴 따라서 매개변수 설정
	public String view(String userid, Model model){
		//System.out.println("클릭한 id : "+userid);
		logger.info("클릭한 id :"+userid);
		//회원정보를 모델에 저장
		model.addAttribute("dto",memberService.viewMember(userid));
		return "member/view";
	}
	
	@RequestMapping("member/update.do")
	public String update(@ModelAttribute MemberVO vo, Model model){
		//비밀번호 체크
		boolean result=memberService.checkPw(vo.getUserid(), vo.getUserpw());
		if(result){
			memberService.updateMember(vo);
			return "redirect:/member/list.do";
		}else{
			//가입일자, 수정날짜
			MemberVO vo2=memberService.viewMember(vo.getUserid());
			vo.setRegdate(vo2.getRegdate());
			vo.setUpdatedate(vo2.getUpdatedate());
			
			model.addAttribute("dto", vo);
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "member/view";
		}
	}
	
	@RequestMapping("member/delete.do")
	//String userid 앞에 @RequestParam이 생략
	//@RequestParam: get or post 방식으로 전달된 변수 값
	public String delete(String userid, String userpw, Model model){
		//비밀번호 체크
				boolean result=memberService.checkPw(userid, userpw);
				if(result){
					//삭제 처리
					memberService.deleteMember(userid);
					//회원 목록이로 이동
					return "redirect:/member/list.do";
				}else{
					//비번이 틀렸을 때
					model.addAttribute("message","비밀번호가 일치하지 않습니다.");
					model.addAttribute("dto",memberService.viewMember(userid));//테이블에서 원래값 꺼내기
					return "member/view";//model을 쓸때는 redirect를 쓰면 안됨 바로 jsp로 가야함
				}
		
	}
}
