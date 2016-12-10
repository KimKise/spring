package com.example.spring01;

import static org.junit.Assert.*;

import javax.inject.Inject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.spring01.part1_ch06.model.dao.MemberDAO;
import com.example.spring01.part1_ch06.model.dto.MemberVO;
//JUnit : 테스트 자동화 도구
// 테스트할 클래스 이름 + Test를 붙인다.
// @Test : JUnit이 테스트할 method
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	private static final Logger logger= LoggerFactory.getLogger(MemberDAOTest.class);

	// MemberDAOImpl 클래스가 생성되어 주입됨
	@Inject
	MemberDAO dao;
	
	@Test
	public void testMemberList() {
		logger.info("회원목록 : "+dao.memberList());
	}

	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("user00");
		vo.setEmail("user00@aaa.com");
		
		dao.insertMember(vo);
	}

	@Test
	public void testViewMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckPw() {
		fail("Not yet implemented");
	}

}
