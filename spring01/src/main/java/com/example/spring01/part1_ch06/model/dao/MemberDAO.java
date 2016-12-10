package com.example.spring01.part1_ch06.model.dao;

import java.util.List;

import com.example.spring01.part1_ch06.model.dto.MemberVO;

public interface MemberDAO {//인터페이스로 method만 선언해둠 
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public MemberVO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberVO vo);
}
