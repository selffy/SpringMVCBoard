package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.AttachVO;

public interface BoardAttachMapper {

	public void insert(AttachVO vo);

	public void delete(String uuid);

	public List<AttachVO> findByBno(Long bno);

	public void deleteAll(Long bno);

	public List<AttachVO> getOldFiles();

}