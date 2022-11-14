package kr.kwangan2.springmvcboad.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
//	@Test
//	public void testInsertBoardVO() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("Service 제목");
//		boardVO.setContent("Service 내용");
//		boardVO.setWriter("Service 작성자");
//		
//		service.insertBoardVO(boardVO);
//		log.info("생성된 게시물 번호 : " + boardVO.getBno());
//	}
	
//	@Test
//	public void testBoardVOList() {
//		service.boardVOList().forEach(boardVO->log.info(boardVO));
//	}
//	
//	@Test
//	public void testBoardVO() {
//		service.selectBoardVO(7L);
//	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(2L);
		boardVO.setTitle("update 제목");
		boardVO.setContent("update 내용");
		boardVO.setWriter("update 작성자");
		service.updateBoardVO(boardVO);
		
		service.boardVOList().forEach(board->log.info(board));
	}
}
