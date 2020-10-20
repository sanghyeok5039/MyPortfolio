//package com.spring.MyPortfolio.board;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.spring.MyPortfolio.dto.BoardDto;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//public class IBoardServiceTest {
//
//	@Autowired
//	IBoardService boardSvc;
//
//	@Before
//	public void setUp() throws Exception {}
//
//	@After
//	public void tearDown() throws Exception {}
//
//	@Test
//	public void viewArticleTestTest() throws Exception {
//		BoardDto boardDto = boardSvc.viewArticleTest("1");
//		assertEquals(1,boardDto.getBoard_num());
//	}
//
//	@Test
//	public void viewListTestTest() throws Exception{
//		List<BoardDto> list = boardSvc.viewListTest();
//		assertNotNull(list);
//	}
//
//	@Test
//	public void writeTestTest() {
//		BoardDto boardDto = new BoardDto();
//		boardDto.setTitle("제목2");
//		boardDto.setWriter("정상혁2");
//		boardDto.setContent("내용2");
//
//		int res = boardSvc.writeTest(boardDto);
//		assertEquals(0,res);
//	}
//
//	@Test
//	public void updateTestTest() {
//		//게시판에서 입력한 정보를 받아서 dto에 담아서 svc로 udpate 요청
//		BoardDto boardDto = new BoardDto();
//		boardDto.setBoard_num(1);
//		boardDto.setTitle("제목33");
//		boardDto.setWriter("정상혁33");
//		boardDto.setContent("내용33");
//
//		int res = boardSvc.updateTest(boardDto);
//		assertEquals(0,res);
//	}
//
//	@Test
//	public void deleteTestTest() {
//		int res = boardSvc.deleteTest("1");
//		assertEquals(0,res);
//	}
//}
