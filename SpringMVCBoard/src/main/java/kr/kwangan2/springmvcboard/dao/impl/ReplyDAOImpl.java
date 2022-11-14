package kr.kwangan2.springmvcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageDTO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import kr.kwangan2.springmvcboard.mapper.ReplyMapper;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;

@Service
public class ReplyDAOImpl implements ReplyService{

	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;

	@Override
	public List<ReplyVO> listReplyVO(Criteria cri, Long bno) {
		return replyMapper.listReplyVO(cri, bno);
	}

	@Override
	public ReplyVO selectReplyVO(Long rno) {
		return replyMapper.selectReplyVO(rno);
	}

	@Override
	public int replyVOListCount(Long bno) {
		return replyMapper.replyVOListCount(bno);
	}

	@Override
	public int insertReplyVO(ReplyVO replyVO) {
		boardMapper.updateReplycnt(replyVO.getBno(), 1);
		return replyMapper.insertReplyVO(replyVO);
	}

	@Override
	public int updateReplyVO(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyMapper.updateReplyVO(replyVO);
	}

	@Transactional
	@Override
	public int deleteReplyVO(Long rno) {
		ReplyVO replyVO = replyMapper.selectReplyVO(rno);
		boardMapper.updateReplycnt(replyVO.getBno(), -1);
		return replyMapper.deleteReplyVO(rno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new ReplyPageDTO(replyMapper.replyVOListCount(bno), replyMapper.listReplyVO(cri, bno));
	}
	
	

}
