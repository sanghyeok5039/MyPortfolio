//package com.spring.MyPortfolio.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
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
//import com.spring.MyPortfolio.dao.IBoardDao;
//import com.spring.MyPortfolio.dto.BoardDto;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//public class IBoardDaoTest {
//	
//	@Autowired
//	private IBoardDao boardDao;
//
//	@Before
//	public void setUp() throws Exception {
//		System.out.println("setUp");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		System.out.println("tearDown");
//	}
//
//	@Test
//	public void getArticleTest() {
//		BoardDto boardDto = boardDao.selectOne(1);
//		assertEquals("정상혁",boardDto.getWriter());
//	}
//	
//	@Test
//	public void insertArticleTest() {
//		
//		BoardDto bDto = new BoardDto();
//
//		bDto.setTitle("제목");
//		bDto.setWriter("정상혁");
//		bDto.setContent("내용~~~");
//		
//		
//		boardDao.insert(bDto);
//		List<BoardDto> list = boardDao.selectAll();
//		
//		for(int i=0;i<list.size();i++) {
//			BoardDto bDto2 = list.get(i);
//			System.out.println(bDto2.getBoard_num());
//			System.out.println(bDto2.getTitle());
//		}
//		
//	}
//	
//	@Test
//	public void updateArticle() {
//		BoardDto boardDto = boardDao.selectOne(1);
//		boardDto.setTitle("제목변경");
//		boardDao.update(boardDto);
//		
//		BoardDto boardDto2 = boardDao.selectOne(1);
//		assertEquals("제목변경",boardDto2.getTitle());
//	}
//	
//	@Test
//	public void deleteArticle() {
//		boardDao.delete(1);
//		
//		BoardDto boardDto = boardDao.selectOne(1);
//		assertNull(boardDto);
//	}
//
//}
