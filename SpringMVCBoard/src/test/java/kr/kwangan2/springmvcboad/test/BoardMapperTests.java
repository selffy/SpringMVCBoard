package kr.kwangan2.springmvcboad.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.boardVOList().forEach(board->log.info(board));
//	}
//	@Test
//	public void testBoardVOInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("추가한 제목");
//		board.setContent("추가한 내용");
//		board.setWriter("추가한 작성자");
//		mapper.insertBoardVO(board);
//		mapper.insertBoardVOSelectKey(board);
//		log.info(board);
//	}
	
//	@Test
//	public void testSelectBoardVO() {
//		BoardVO boardVO = mapper.selectBoardVO(4L);
//		log.info(boardVO);
//	}
//	
//	@Test
//	public void testDeleteBoardVO() {
//		mapper.deleteBoardVO(4L);
//		mapper.boardVOList().forEach(board->log.info(board));
//	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1L);
		boardVO.setTitle("업뎃 제목");
		boardVO.setContent("업뎃 내용");
		boardVO.setWriter("업뎃 작성자");
		
		mapper.updateBoardVO(boardVO);
		mapper.boardVOList().forEach(board->log.info(board));
	}
}
