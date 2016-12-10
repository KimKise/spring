package com.example.spring01.part1_ch06.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.part1_ch06.model.dao.MemberDAOImpl;
import com.example.spring01.part1_ch06.model.dto.MemberVO;

//현재 클래스를 스프링에서 관리하는 service bean으로 등록
//Service는 데이터베이스 이외의 요청들을 처리하기 위해 데이터베이스 요청은 DAO에서
//DB연동 이외의 코드는 여기에 작성하기를 권장
//Service는 DAO호출 하기 때문에 @Inject 
@Service
public class MemberServiceImpl implements MemberService {

	//MemberDAOImple 객체를 스피링에서 생성하여 주입시킴
	@Inject
	MemberDAOImpl memberDao;
	
	@Override
	public List<MemberVO> memberList() {
		
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);

	}

	@Override
	public MemberVO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);

	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);

	}

	@Override
	public boolean checkPw(String userid, String userpw) {
		// TODO Auto-generated method stub
		return memberDao.checkPw(userid, userpw);
	}

}
