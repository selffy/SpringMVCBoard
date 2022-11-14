package kr.kwangan2.springmvcboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;	// 현재페이지 번호
	private int amount;		// 한 페이지에 보여줄 게시물 수
	private String type;	// 검색 조건
	private String keyword;	// 검색어
	
	public Criteria(){
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type==null? new String[] {} : type.split("");
	}
}
