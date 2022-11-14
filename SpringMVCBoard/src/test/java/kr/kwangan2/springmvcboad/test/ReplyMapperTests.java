package kr.kwangan2.springmvcboad.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Setter(onMethod_=@Autowired)
	ReplyService service;
	
	Criteria cri = new Criteria();
	
	/* 
	@Test
	public void testListReplyVO() {
		List<ReplyVO> replies = service.listReplyVO(cri, 183L);
		replies.forEach(reply -> log.info(reply));
//		ReplyVO replyVO = new ReplyVO();
//		replyVO.setBno(182L);
//		replyVO.setReply("똑띠 받아 쓰자");
//		replyVO.setReplyer("suil");
//		service.insertReplyVO(replyVO);
//		log.info(service.listReplyVO(182L));
		log.info(service.replyVOListCount(5L));
	}*/

	@Test
	public void testList2(){
		Criteria cri = new Criteria(1, 3);
		List<ReplyVO> replies = service.listReplyVO(cri, 3L);
		replies.forEach(reply -> log.info(reply));
	}
}
