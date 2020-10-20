package com.spring.MyPortfolio.dao;

import org.springframework.stereotype.Repository;

import com.spring.MyPortfolio.dto.MemberDto;

@Repository
public interface IMemberDao {
	
	public MemberDto selectOne(String userId);		//회원 단건조회
	public String selectId(MemberDto memberDto);	//이름과 전화번호를 조건으로한 아이디단건조회
	public String selectPw(MemberDto memberDto);	//아이디와 전화번호를 조건으로한 비밀번호단건조회
	public void insert(MemberDto memberDto);		//회원가입
	public void updateInfo(MemberDto memberDto);	//회원 기본정보 수정
	public void updatePw(MemberDto memberDto);		//회원 비밀번호 변경
	public void delete(String userId);				//회원탈퇴
	
}
