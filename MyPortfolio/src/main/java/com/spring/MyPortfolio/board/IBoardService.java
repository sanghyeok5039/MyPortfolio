package com.spring.MyPortfolio.board;

import org.springframework.ui.Model;

import com.spring.MyPortfolio.dto.BoardDto;

public interface IBoardService {
		
	void viewArticle(Model model,String num);			//게시글 보기
	void viewAllArticles(Model model,String strPageNum);//게시판 리스트
	void writeArticle(BoardDto boardDto);				//게시글 쓰기
	void updateArticle(BoardDto boardDto);				//게시글 수정
	void deleteArticle(String num);						//게시글 삭제

}
