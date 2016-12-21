package com.example.spring01.service.board;
//Controller는 흐름을 제어
//DAO는 데이터베이스의 자료를 처리
//Service는 그 외의 코드
import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.model.board.dto.BoardVO;

public interface BoardService {
	public void create(BoardVO vo) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<BoardVO> listAll(String search_option, String keyword) throws Exception;
	public void increaseViewcnt(int bno, HttpSession session) throws Exception;
	

}
