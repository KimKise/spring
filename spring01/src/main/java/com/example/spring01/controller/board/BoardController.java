package com.example.spring01.controller.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.board.dto.BoardVO;
import com.example.spring01.service.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	//의존관계 주입 Service는 Interfate이기 때문에 실제로 만들어 지는 것은  BoardServiceImpl이 만들어 진다.
	@Inject
	BoardService boardService;
	
	@RequestMapping("board_list.do")
	public ModelAndView list(Model model, @RequestParam(defaultValue="title") String search_option, 
			@RequestParam(defaultValue="") String keyword) throws Exception{
		//@RequestParam String search_option, @RequestParam String keyword 검색기능에서 넘어온 값
		List<BoardVO> list = boardService.listAll(search_option, keyword);
	/*	model.addAttribute("list", list);
		return "board_list";*/
		// 모델과 뷰
		ModelAndView mav= new ModelAndView();
		mav.setViewName("board/list"); //뷰를  list.jsp로 설정
		mav.addObject("list",list); //데이터 저장
		return mav; //list.jsp로 List가 전달됨
	}
	
	@RequestMapping(value="board_write.do", method=RequestMethod.GET)
	public String write(){
		
		return "board/write";
	}
	
	@RequestMapping(value="board_insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo) throws Exception{
		System.out.println(vo);
		boardService.create(vo);
		return "redirect:/board/board_list.do";
	}
	/*public String insert(HttpServletRequest request){
		String tilte = request.getParameter("title");
		
	}*/
	
	@RequestMapping(value="board_view.do", method=RequestMethod.GET)
	/*public ModelAndView view(HttpServletRequest request){
		int bno=Integer.parseInt(request.getParameter("bno"));
	}*/
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
		//@RequestParam은 get/post 방식으로 전달된 변수
		//@ModelAttribute 객체로 저장됨
		
		//조회수 증가 처리
		boardService.increaseViewcnt(bno, session);
		//모델(데이터)+뷰(화면)를 함꼐 전달하는 객체
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");//board/view.jsp 뷰의 이름 설정
		mav.addObject("dto", boardService.read(bno));//뷰에 전달할 데이터 (변수명, 값)
		return mav;
	}
	
	//폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
	@RequestMapping("board_update.do")
	public String update(@ModelAttribute BoardVO vo) throws Exception{//수정할 데이터가 들어옴
		boardService.update(vo);
		return "redirect:/board/board_list.do";
	}
	
	@RequestMapping("board_delete.do")
	public String delete(@RequestParam int bno) throws Exception{
		//삭제처리
		boardService.delete(bno);
		//페이지 이동
		return "redirect:/board/board_list.do";
	}
	
	
}
