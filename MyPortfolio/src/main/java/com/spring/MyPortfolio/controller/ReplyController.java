package com.spring.MyPortfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.MyPortfolio.dto.ReplyDto;
import com.spring.MyPortfolio.reply.IReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	IReplyService replySvc;
	
	//댓글쓰기
	@RequestMapping("writeReply")
	public String writeReply(ReplyDto replyDto) throws Exception {

		replySvc.writeReply(replyDto);
		return "redirect:/viewArticle?num="+replyDto.getBoard_num();
		
	}
	
	//댓글수정
	@RequestMapping("updateReply")
	public String updateReply(ReplyDto replyDto) {

		replySvc.updateReply(replyDto);
		return "redirect:/viewArticle?num="+replyDto.getBoard_num();
		
	}
	
	//댓글삭제
	@RequestMapping("deleteReply")
	public String deleteReply(@RequestParam("num")String num, @RequestParam("board_num")int board_num) {

		replySvc.deleteReply(num);
		return "redirect:/viewArticle?num="+board_num;
		
	}
}
