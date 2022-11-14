package kr.kwangan2.springmvcboard.util;

import kr.kwangan2.springmvcboard.domain.Criteria;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter	
public class PageCalc {
	
	private int startPage;	// 블럭 내 시작페이지 번호
	private int endPage;	// 블럭 내 끝 페이지 번호
	private boolean prev, next;	// 이전, 다음 블럭이 있는지 여부
	private int total;		// 전체 게시물 수
	
	private Criteria cri;
	
	public PageCalc(Criteria cri, int total){
		this.cri = cri;
		this.total = total;
	}
	
	public PageCalc calcPage() {
		this.endPage = (int) (Math.ceil(this.cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil( (this.total * 1.0) / this.cri.getAmount() ));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		return this;
	}
}
