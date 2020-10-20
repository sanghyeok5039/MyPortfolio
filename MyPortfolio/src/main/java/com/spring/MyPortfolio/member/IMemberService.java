package com.spring.MyPortfolio.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.MyPortfolio.dto.MemberDto;

public interface IMemberService {
	
	//회원가입을 처리하는 메소드
	public void signUp(MemberDto memberDto);
	
	//아이디 중복확인을 위한 메소드
	public Map<String, Object> idDplCheck(String userId);
	
	//로그인 처리를 하는 메소드
	public Map<String, Object> login(MemberDto memberDto, HttpSession session);
	
	//마이페이지에서 개인정보수정페이지에서 띄울 정보를 받는 메소드
	public void getUser(Model model, HttpSession session);
	
	//마이 페이지의 기본정보 수정
	public void updateInfo(MemberDto memberDto);
	
	//비밀번호가 일치하는지 확인하는 메소드
	public Map<String, Object> pwConfirm(MemberDto memberDto);
	
	//비밀번호 변경
	public Map<String, Object> pwChange(MemberDto memberDto);
	
	//회원 탈퇴처리하는 메소드
	public Map<String, Object> memberSecsn(MemberDto memberDto, HttpSession session);
	
	//이름과 전화번호를 이용해서 ID 찾는 메서드
	public Map<String, Object> findId(MemberDto memberDto);
	
	//아이디와 전화번호를 이용해서 ID 찾는 메서드
	public Map<String, Object> findPw(MemberDto memberDto,HttpSession session);
	
}

