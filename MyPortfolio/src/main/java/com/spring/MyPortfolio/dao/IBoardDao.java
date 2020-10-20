package com.spring.MyPortfolio.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.MyPortfolio.dto.BoardDto;
import com.spring.MyPortfolio.dto.PagingDto;

@Repository
public interface IBoardDao {
	
	public BoardDto selectOne(int board_num);			//게시글 단건조회
	public List<BoardDto> selectAll(PagingDto pgDto);   //게시판 다건조회
	public void insert(BoardDto boardDto);				//게시글 삽입 
	public void update(BoardDto boardDto);				//게시글 수정
	public void delete(int board_num);					//게시글 삭제
	public int getCnt();								//총 게시글 수
	
}	
