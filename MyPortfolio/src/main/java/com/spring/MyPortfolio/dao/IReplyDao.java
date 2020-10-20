package com.spring.MyPortfolio.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.MyPortfolio.dto.ReplyDto;

@Repository
public interface IReplyDao {
	
	public ReplyDto selectOne(int reply_num);		//댓글 단건조회
	public List<ReplyDto> selectAll(int board_num); //게시글의 댓글 다건조회
	public void insert(ReplyDto replyDto);			//댓글 쓰기
	public void update(ReplyDto replyDto);			//댓글 수정
	public void delete(int reply_num);				//댓글 삭제

}
