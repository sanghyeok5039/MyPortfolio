package com.spring.MyPortfolio.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.MyPortfolio.dao.IBoardDao;
import com.spring.MyPortfolio.dao.IReplyDao;
import com.spring.MyPortfolio.dto.BoardDto;
import com.spring.MyPortfolio.dto.ReplyDto;

@Service("replySvc")
public class ReplyServiceImpl implements IReplyService{

	@Autowired
	IReplyDao replyDao;
	
	@Autowired
	IBoardDao boardDao;
	
	@Override
	@Transactional
	public void writeReply(ReplyDto replyDto) throws Exception{
		
		int board_num = replyDto.getBoard_num();
		//댓글을 달려는 게시글이 삭제되었는지 확인
		BoardDto chkBoardDto = boardDao.selectOne(board_num);
		//TODO 댓글달 게시글이 삭제되었을 때
		if(chkBoardDto == null) {
			return ;
		}
		
		replyDao.insert(replyDto);
		int replyCount = chkBoardDto.getReplyCount();
		//댓글 갯수추가
		replyCount += 1;
		chkBoardDto.setReplyCount(replyCount);
		boardDao.update(chkBoardDto);

	}

	@Override
	public void updateReply(ReplyDto replyDto) {
		
		replyDao.update(replyDto);
		
	}

	@Override
	public void deleteReply(String num) {
		
		int reply_num = Integer.parseInt(num);
		ReplyDto replyDto = replyDao.selectOne(reply_num);
		
		int board_num = replyDto.getBoard_num();
		BoardDto boardDto = boardDao.selectOne(board_num);
	
		//TODO 해당 게시글이 삭제되었을 때
		if(boardDto == null) {
			return ;
		}
		else {
			if(replyDto != null) {
				replyDao.delete(reply_num);
				//삭제한 댓글빼기
				int replyCount = boardDto.getReplyCount()-1;
				boardDto.setReplyCount(replyCount);
				boardDao.update(boardDto);
			}
		}
	}

}
