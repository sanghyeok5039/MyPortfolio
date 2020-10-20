package com.spring.MyPortfolio.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.MyPortfolio.dao.IMemberDao;
import com.spring.MyPortfolio.dto.MemberDto;

@Service("memberSvc")
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	IMemberDao memberDao;

	//회원가입
	@Override
	public void signUp(MemberDto memberDto) {

		memberDao.insert(memberDto);
		
	}

	//아이디 중복체크
	@Override
	public Map<String, Object> idDplCheck(String userId) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		MemberDto chkDto = memberDao.selectOne(userId);
		boolean result;
		
		//아이디가 존재하지 않는다면 
		if(chkDto==null) {
			result = true;
		}
		//아이디가 존재한다면
		else {
			result = false;
		}
		map.put("result", result);
		
		return map;
	}

	//로그인
	@Override
	public Map<String, Object> login(MemberDto memberDto, HttpSession session) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
		String msg;
		
		String userId = memberDto.getUserId();
		String password = memberDto.getPassword();
		
		MemberDto memDto = memberDao.selectOne(userId);
		
		//해당 아이디가 존재하는지 확인하고
		if(memDto == null) {
			result=false;
			msg = "존재하지 않는 아이디입니다.";
		}
		//아이디가 존재한다면 비밀번호의 일치여부를 확인한다.
		else {
			//아이디가 존재하고 비밀번호가 일치할 때
			if(memDto.getPassword().equals(password)) {
				result = true;
				msg = memDto.getUserId()+"님 환영합니다 !";
				
				session.setAttribute("loginCheck",true);
	            session.setAttribute("userId",userId);
			}
			
			//아이디가 존재하지만 비밀번호가 틀렸을 때
			else {
				result = false;
				msg = "잘못된 비밀번호입니다.";
			}
		}
		
		map.put("result", result);
		map.put("msg", msg);

		return map;
		
	}

	//마이페이지의 개인정보에서 띄울 정보 받아오는 메소드
	@Override
	public void getUser(Model model, HttpSession session) {
		
		Object objId = session.getAttribute("userId");
		String userId = String.valueOf(objId);
		
		MemberDto memberDto = memberDao.selectOne(userId);
		
		//Mypage에서 표시할 생년월일 형식
		String brthdy = memberDto.getBrthdy();
		String yyyy = brthdy.substring(0, 4);
		String mm = brthdy.substring(4, 6);
		String dd = brthdy.substring(6, 8);
		brthdy = yyyy+"년 "+mm+"월 "+dd+"일";
		
		memberDto.setBrthdy(brthdy);
		
		model.addAttribute("memberDto", memberDto);

	}
	
	//개인 정보 수정
	@Override
	public void updateInfo(MemberDto memberDto) {
		
		memberDao.updateInfo(memberDto);
		
	}
	
	//비밀번호 변경 전 확인
	public Map<String, Object> pwConfirm(MemberDto memberDto){
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
		
		String userId = memberDto.getUserId();
		String password = memberDto.getPassword();
		
		MemberDto memDto = memberDao.selectOne(userId);

		//비밀번호가 일치할 때
		if(memDto.getPassword().equals(password)) {
			result = true;
			
		}	
		// 비밀번호가 틀렸을 때
		else {
			result = false;
		}
		map.put("result", result);
		
		return map;
		
	}
	
	//비밀번호 변경하는 메소드
	public Map<String, Object> pwChange(MemberDto memberDto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
	
		try {
			memberDao.updatePw(memberDto);
			result = true;
		}catch(Exception e) {
			result = false;
		}
		
		map.put("result", result);
		
		return map;
		
	}
	
	//회원탈퇴 후 세션 삭제
	public Map<String, Object> memberSecsn(MemberDto memberDto, HttpSession session){
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
		String msg;
		
		String userId = memberDto.getUserId();
		String password = memberDto.getPassword();
		
		try {
			MemberDto memDto = memberDao.selectOne(userId);
			
			//비밀번호가 일치할 때 
			if(memDto.getPassword().equals(password)) {
				memberDao.delete(userId);
				result = true;
				msg = "탈퇴완료 되었습니다.";
				//탈퇴후 세션도 삭제
				session.setAttribute("loginCheck",null);
		        session.setAttribute("userId",null);
			}	
			// 비밀번호가 틀렸을 때
			else {
				result = false;
				msg = "본인인증에 실패했습니다.";
			}
			
		}catch(Exception e) {
			result = false;
			msg = "오류가 발생했습니다.";
		}
		map.put("result", result);
		map.put("msg", msg);
		
		return map;
		
	}
	
	//이름과 전화번호를 이용해서 ID 찾는 메서드
	public Map<String, Object> findId(MemberDto memberDto){
		
		Map<String, Object> map = new HashMap<String, Object>();
		String msg;
		
		String userId = memberDao.selectId(memberDto);
		
		if(userId==null) {
			msg="아이디를 찾지 못했습니다. \n이름과 전화번호를 확인해주세요.";
		}
		else {
			msg="아이디를 찾았습니다. \n찾은 아이디 : "+userId;
		}
		
		map.put("msg", msg);
		
		return map;
		
	}
	
	//PW 찾기에 성공하면 새로운 비밀번호로 변경하는 페이지에서 비밀번호 변경을 위해 아이디를 session 에 저장.
	public Map<String, Object> findPw(MemberDto memberDto,HttpSession session){
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = false;
		String msg;
		
		session.setAttribute("userId",memberDto.getUserId());
		String pw = memberDao.selectPw(memberDto);
		
		if(pw==null) {
			msg="아이디와 전화번호를 확인해주세요.";
			result=false;
		}
		else {
			msg="비밀번호 변경페이지로 이동합니다.";
			result=true;
		}
		
		map.put("msg", msg);
		map.put("result", result);
		
		return map;
		
	}
	
}
