package kr.kwangan2.springmvcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.kwangan2.springmvcboard.dao.ReplyDAO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageDTO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.mapper.ReplyMapper;
import lombok.Setter;

public class AbstractReplyDAO implements ReplyDAO {

	@Override
	public List<ReplyVO> listReplyVO(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplyVO selectReplyVO(Long rno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int replyVOListCount(Long bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReplyVO(ReplyVO reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReplyVO(ReplyVO reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReplyVO(Long rno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
