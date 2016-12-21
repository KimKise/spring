package com.example.spring01.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring01.model.board.dao.BoardDAO;
import com.example.spring01.model.board.dto.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO boardDao;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		// 태그 문자 처리 ( '<' => &lt;, '>' => &gt;)
		String title = vo.getTitle();
		String writer = vo.getWriter();
		//replace(A,B) A를 B로 변경
		title = title.replace("<", "&lt;");
		title = title.replace(">", "&gt;");
		writer = writer.replace("<", "&lt;");
		writer = writer.replace(">", "&gt;");
		
		//공뱁 문자 처리(공백 => &nbsp;)
		title = title.replace("  ", "&nbsp;&nbsp;");
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		
		//줄바꿈 문자 처리 ( \n => <br> )
		String content = vo.getContent();
		content = content.replace("\n", "<br>");
		
		vo.setContent(content);
		vo.setTitle(title);
		vo.setWriter(writer);
		boardDao.create(vo);

	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		boardDao.update(vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);

	}

	@Override
	public List<BoardVO> listAll(String search_option, String keyword) throws Exception {
		
		return boardDao.listAll(search_option, keyword);
	}

	@Override
	public void increaseViewcnt(int bno, HttpSession session) throws Exception {
		long update_time=0;
		//세션에 저장된 조회시간 검색
		if(session.getAttribute("update_time_"+bno)!=null){//열람한 시간이 있다면
			update_time=(long)session.getAttribute("update_time_"+bno);//열람한 시간을 가져와서 밑의 현재시간과 비교
		}
		//시스템의 현재 시간
		long current_time=System.currentTimeMillis();
		//일정 시간이 경과 후 조회수 증가 처리 
		if(current_time - update_time > 10*1000){//10초
			boardDao.increaseViewcnt(bno);//조회수 증가
			session.setAttribute("update_time_"+bno, current_time);//열람한 시간을 현재시간으로 저장
		}
		//세션에 저장 : session.setAttribute(key,value)
		//세션에서 읽어보기 : session.getAttribute(key)
	}

}
