package com.spring.MyPortfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.MyPortfolio.board.IBoardService;
import com.spring.MyPortfolio.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	IBoardService boardSvc;
	
	//게시글 조회
	//게시글 조회 후 목록버튼을 눌렀을 때 게시글이 존재했던 페이지로 돌아가기 위해서 strPageNum저장.
	@RequestMapping("viewArticle")
	public String viewArticle(Model model, @RequestParam("num")String num, @RequestParam(value="pageNum",required = false)String strPageNum) {

		boardSvc.viewArticle(model, num);
		model.addAttribute("pageNum", strPageNum);
		return "board/post";
		
	}
	
	//게시글 리스트 보기
	@RequestMapping("viewAllArticles")
	public String viewAllArticles(Model model, @RequestParam(value="pageNum",required = false)String strPageNum){
		
		boardSvc.viewAllArticles(model,strPageNum);
		return "board/boardList";
		
	}
	
	//게시글 쓰기 페이지로 이동
	@RequestMapping("writeForm")
	public String writeForm() {
		
		return "board/writeForm";
		
	}
	
	//게시글 등록
	@RequestMapping("writeArticle")
	public String writeArticle(Model model, BoardDto boardDto, @RequestParam(value="pageNum",required = false)String strPageNum) {
		
		//글 등록하고
		boardSvc.writeArticle(boardDto);
		//다시 전체게시판으로 돌아감
		boardSvc.viewAllArticles(model,strPageNum);	
		return "board/boardList";
		
	}
	
	//게시글 수정 페이지로 이동
	@RequestMapping("rewriteForm")
	public String rewriteForm(Model model, BoardDto boardDto) {
		
		//수정 페이지로 갈 때 해당 게시글의 정보를 가지고 수정페이지로 넘어감
		model.addAttribute("boardDto", boardDto);
		return "board/rewriteForm";
		
	}
	
	//게시글 수정
	@RequestMapping("rewriteArticle")
	public String rewriteArticle(Model model, BoardDto boardDto) {
		
		//글 수정하고 해당 게시글로 돌아감
		boardSvc.updateArticle(boardDto);
		return "redirect:/viewArticle?num="+boardDto.getBoard_num();
		
	}
	
	//게시글 삭제
	@RequestMapping("deleteArticle")
	public String deleteArticle(@RequestParam("num")String num) {
		
		boardSvc.deleteArticle(num);
		return "redirect:/viewAllArticles";
		
	}
	


}
