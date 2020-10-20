package com.spring.MyPortfolio.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.MyPortfolio.dto.MemberDto;
import com.spring.MyPortfolio.member.IMemberService;

@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberSvc;
	
	//회원가입 페이지로 이동
	@RequestMapping("signUpForm")
	public String registerForm(MemberDto memberDto) {
		
		return "member/signUp";
		
	}
	
	//회원가입
	@RequestMapping(value="signUp", method=RequestMethod.POST)
	public String signUp(MemberDto memberDto) {
		
		memberSvc.signUp(memberDto);
		return "redirect:/";
		
	}
	
	//아이디 중복체크
	@RequestMapping(value="idDplctcheck", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> idDplctcheck(@RequestBody String userId) {

		Map<String, Object> map = memberSvc.idDplCheck(userId);
		return map;
		
	}
	
	//로그인 페이지로 이동
	@RequestMapping("loginForm")
	public String loginForm(MemberDto memberDto) {
		
		return "member/login";
		
	}
	
	//로그인 팝업페이지로 띄우기
	@RequestMapping("loginPopForm")
	public String loginPopForm(MemberDto memberDto) {
		
		return "member/loginPopup";
		
	}
	
	//로그인
	@RequestMapping(value="login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(@RequestBody MemberDto memberDto, HttpSession session) {
		
		Map<String, Object> map = memberSvc.login(memberDto, session);
		return map;
		
	}
	
	
	//팝업 로그인이 성공했을 때의 요청
	@RequestMapping("loginSuccess")
	public String loginSuccessPage(MemberDto memberDto) {
		
		return "member/loginSuccess";
		
	}
	
	//로그아웃
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		
		session.setAttribute("loginCheck",null);
        session.setAttribute("userId",null);
        
		return "redirect:/";
		
	}
	
	//마이페이지로 이동
	@RequestMapping("myPage")
	public String myPage(Model model, HttpSession session) {
		
		memberSvc.getUser(model, session);
		return "member/myInfo";
		
	}
	
	//개인정보수정
	@RequestMapping("updateInfo")
	public String updateInfo(MemberDto memberDto) {
		
		memberSvc.updateInfo(memberDto);
		return "redirect:/myPage";
		
	}
	
	//마이페이지에서 비밀번호 변경을 위해 비밀번호 재확인 페이지로 이동.
	@RequestMapping("pwConfirmForm")
	public String pwConfirmForm() {
		
		return "member/pwConfirm";
		
	}
	
	//비밀번호 재확인
	@RequestMapping(value="pwConfirm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> pwConfirm(@RequestBody MemberDto memberDto) {
		
		Map<String, Object> map = memberSvc.pwConfirm(memberDto);
		return map;
		
	}
	
	//비번번호 변경 페이지로 이동
	@RequestMapping("pwChangeForm")
	public String pwChangeForm() {
		
		return "member/pwChange";
		
	}
	
	//비밀번호 변경
	@RequestMapping(value="pwChange", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> pwChange(@RequestBody MemberDto memberDto) {
		
		Map<String, Object> map = memberSvc.pwChange(memberDto);
		return map;
		
	}
	
	//회원 탈퇴페이지로 이동
	@RequestMapping("memberSecsnForm")
	public String memberSecsnForm() {
		
		return "member/memberSecsn";
		
	}
	
	//회원 탈퇴
	@RequestMapping(value="memberSecsn", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> memberSecsn(@RequestBody MemberDto memberDto,HttpSession session) {
		
		Map<String, Object> map = memberSvc.memberSecsn(memberDto, session);
		return map;
		
	}
	
	//계정 찾는 페이지로 이동
	@RequestMapping("findAccount")
	public String findAccount() {
		
		return "member/findAccount";
		
	}
	
	//아이디 찾기
	@RequestMapping(value="findId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findId(@RequestBody MemberDto memberDto) {
		
		Map<String, Object> map = memberSvc.findId(memberDto);
		return map;
		
	}
	
	//비밀번호 찾기
	@RequestMapping(value="findPw", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findPw(@RequestBody MemberDto memberDto,HttpSession session) {
		
		Map<String, Object> map = memberSvc.findPw(memberDto,session);
		return map;
		
	}
	
	//비밀번호 찾기 성공 후 새 비밀번호 변경 페이지로 이동
	@RequestMapping("findPwChangeForm")
	public String findPwChangeForm() {
		
		return "member/findPwChange";
		
	}
}
