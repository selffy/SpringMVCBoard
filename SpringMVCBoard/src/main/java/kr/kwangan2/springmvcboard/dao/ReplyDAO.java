package kr.kwangan2.springmvcboard.dao;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageDTO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.service.ReplyService;

public interface ReplyDAO extends ReplyService{
	public List<ReplyVO> listReplyVO(Criteria cri, Long bno);
	
	public ReplyVO selectReplyVO(Long rno);
	
	public int replyVOListCount(Long bno);
	
	public int insertReplyVO(ReplyVO reply);
	
	public int updateReplyVO(ReplyVO reply);
	
	public int deleteReplyVO(Long rno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
