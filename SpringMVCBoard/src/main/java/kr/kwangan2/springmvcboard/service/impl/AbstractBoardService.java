package kr.kwangan2.springmvcboard.service.impl;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.service.BoardService;

public class AbstractBoardService implements BoardService {

	
	@Override
	public List<BoardVO> boardVOList() {
		return null;
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		return 0;

	}
	
	public int boardVOListCount(Criteria criteria) {
		return 0;
	}

	@Override
	public int insertBoardVOSelectKey(BoardVO boardVO) {
		return 0;
	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		return null;
	}

	@Override
	public int deleteBoardVO(Long bno) {
		return 0;
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		return 0;
	}

	@Override
	public List<BoardVO> boardVOList(Criteria criteria) {
		return null;
	}

	@Override
	public void updateReplycnt(long bno, int amount) {
		
	}

}
