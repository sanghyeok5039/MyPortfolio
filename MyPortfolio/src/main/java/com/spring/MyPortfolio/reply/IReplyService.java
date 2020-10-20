package com.spring.MyPortfolio.reply;

import com.spring.MyPortfolio.dto.ReplyDto;

public interface IReplyService {

	void writeReply(ReplyDto replyDto) throws RuntimeException, Exception;	//댓글 쓰기
	void updateReply(ReplyDto replyDto);//댓글 수정
	void deleteReply(String num);		//댓글 삭제
	
}
