package com.example.spring01.part1_ch06.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.part1_ch06.model.dto.MemberVO;

//중요!! 현재 클래스를 dao bean으로 등록시킴
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	//SqlSession 객체를 스프링에서 생성하여 주입시켜 줌
	//의존관계 주입(Dependency Injection, DI)
	//느슨한 결합
	//IoC(Inversion of Control, 제어의 역전)
	@Inject
	SqlSession	sqlSession; //@Inject 하면 외부에서 주소값을 던져줌
	
	@Override
	public List<MemberVO> memberList() {
		
		return sqlSession.selectList("member.memberList");//Mapper클래스에서 ("namespace.id")
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.memberInsert",vo);
	}

	@Override
	public MemberVO viewMember(String userid) {
		return sqlSession.selectOne("member.memberView",userid);
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

}
