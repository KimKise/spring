package com.example.spring01.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.board.dto.BoardVO;
@Repository  //현재 클래스를 dao bean으로 등록
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		sqlSession.insert("board.insertBoard", vo);

	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		return sqlSession.selectOne("board.viewBoard", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update("board.updateArticle",vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle", bno);

	}

	@Override
	public List<BoardVO> listAll(String search_option, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectList("board.listAll",map);
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		sqlSession.update("board.increaseViewcnt",bno);
		
	}

}
