package com.spring.MyPortfolio.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.MyPortfolio.dao.IBoardDao;
import com.spring.MyPortfolio.dao.IReplyDao;
import com.spring.MyPortfolio.dto.BoardDto;
import com.spring.MyPortfolio.dto.PagingDto;
import com.spring.MyPortfolio.dto.ReplyDto;

@Service("boardSvc")
public class BoardServiceImpl implements IBoardService{
	
	@Autowired
	IBoardDao boardDao;
	
	@Autowired
	IReplyDao replyDao;

	//게시글 조회하는 메소드로 조회할 때 마다 조회수 증가한다.
	//새로고침할 때 조회수가 증가한다. 나중에 이 부분 해결해야함.
	@Override
	public void viewArticle(Model model, String num){

		int board_num = Integer.parseInt(num);
		int readCount;
		BoardDto boardDto = boardDao.selectOne(board_num);
		List<ReplyDto> replyList = replyDao.selectAll(board_num);
		
		//글 조회할 때마다 조회수 증가
		readCount = boardDto.getReadCount()+1;
		boardDto.setReadCount(readCount);
		boardDao.update(boardDto);
		
		//페이지에서 개행과 스페이스를 위한 변환
		String title = boardDto.getTitle();
		String content = boardDto.getContent();
		
		title = title.replace("&lt","<");
		title = title.replace("&gt",">");
		title = title.replace("&nbsp;&nbsp;"," ");
		
		content = content.replace("&gt", "<");
		content = content.replace("&gt", ">");
		content = content.replace("<br>", "\n");
		
		boardDto.setTitle(title);
		boardDto.setContent(content);
		
		model.addAttribute("boardDto", boardDto);
		model.addAttribute("replyList", replyList);
		
	}
	
	//board 테이블의 board_num를 기준으로 내림차순하여 정렬하고 각 row에 rownum를 매긴 후
	//rownum을 시작으로 pageSize만큼 게시글을 받아오는 메소드
	@Override
	public void viewAllArticles(Model model, String strPageNum) {
		
		//처음 게시판을 받아올 경우 null이 들어오는데 이 때 페이지번호 1로 처리
		if(strPageNum==null||strPageNum.isEmpty()) {
			strPageNum="1";
		}
		else {
			;
		}
		//그 외에는 받은 페이지번호를 pageNum으로 변환
		int pageNum  = Integer.parseInt(strPageNum);
		//한 페이지에 로딩할 최대 게시글 수
		int pageSize = 10;
		//한 페이지에 로딩할 최대 페이지 수
		int pageBlock= 10;
		//페이징 처리시 첫 페이지 번호.
		int startPage= 1;
		//페이징 처리시 마지막 페이지 번호
		int endPage;
		//총 페이지 수 = (총 게시글 수/페이지 크기)+1
		int pageCnt;
		//페이지 번호에서 제일 첫 데이터에 해당하는 rownum값.
		int startNo = (pageNum-1)*pageSize+1;
		//[이전] 활성화 여부
		boolean pre = false;
		//[다음] 활성화 여부
		boolean next= false;
		
		//페이징 처리했을 때 첫 페이지 번호구하는 공식.
		//요청받은 페이지 번호가 1~9, 11~19 등 pageBlock(10)으로 나누어 떨어지지 않는 경우
		if(pageNum%pageBlock !=0) {
			startPage =  (int) (pageNum/10)*10 +1;
		}
		//요청받은 페이지 번호가 10,20..등의 10으로 나누었을 때 나누어 떨어지는 경우
		else {
			startPage = (int)(((pageNum/10)-1)*10+1);
		}
		//총 게시글 수
		int cnt = boardDao.getCnt();
		
		//총 페이지 수 구하는 공식. 
		if(cnt%pageSize==0) {
			pageCnt=cnt/pageSize;
		}
		else {
			pageCnt=(cnt/pageSize)+1;
		}
		
		//한 페이지에서 마지막 페이징 번호
		endPage = startPage+pageBlock-1;
		
		//
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		//첫 페이지가 pageBlock보다 클경우에 [이전] 버튼 생성.
		if(startPage>pageBlock) {
			pre = true;
		}
		//총 페이지 수가 마지막 페이지 번호보다 클 경우 [다음] 버튼 생성
		if(endPage<pageCnt) {
			next = true;
		}
		PagingDto pgDto = new PagingDto();
		pgDto.setStartNo(startNo);
		pgDto.setPageSize(pageSize);
		
	
		List<BoardDto> list = boardDao.selectAll(pgDto);
	
		model.addAttribute("list", list);
		model.addAttribute("cnt", list.size());
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pre", pre);
		model.addAttribute("next", next);
		
	}
	
	//글쓰기 폼에서 제목과 내용, 아이디를 받아와서 게시판 table에 데이터 삽입하는 메소드.
	@Override
	public void writeArticle(BoardDto boardDto){
		
		//개행과 스페이스를 DB에 저장하기 위해 문자로 변환.
		String title = boardDto.getTitle();
		String content=boardDto.getContent();
		
		title = title.replace("<", "&lt");
		title = title.replace(">", "&gt");
		title = title.replace(" ", "&nbsp;&nbsp;");
		
		content = content.replace("<", "&gt");
		content = content.replace(">", "&gt");
		content = content.replace("\n", "<br>");
		
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDao.insert(boardDto);
		
	}

	//게시글을 수정하는 메소드.
	@Override
	public void updateArticle(BoardDto boardDto){
		
		int board_num = boardDto.getBoard_num();
		BoardDto chkDto = boardDao.selectOne(board_num);
		
		//TODO 수정하려던 글이 삭제되었을 경우 ?
		if(chkDto == null) {
			return ;
		}
		
		String title = boardDto.getTitle();
		String content=boardDto.getContent();
		
		title = title.replace("<", "&lt");
		title = title.replace(">", "&gt");
		title = title.replace(" ", "&nbsp;&nbsp;");
		
		content = content.replace("<", "&gt");
		content = content.replace(">", "&gt");
		content = content.replace("\n", "<br>");
		
		boardDto.setTitle(title);
		boardDto.setContent(content);
		boardDao.update(boardDto);
		
	}

	//게시글을 삭제하는 메소드
	@Override
	public void deleteArticle(String num){
		
		int board_num = Integer.parseInt(num);
		BoardDto chkDto = boardDao.selectOne(board_num);
		
		//TODO 삭제전에 존재하는 글인지 확인하고 삭제되었다면 error page 띄울 수 있도록 구현해보자.
		if(chkDto==null) {
			;
		}
		else {
			boardDao.delete(board_num);
		}
		
	}

}
