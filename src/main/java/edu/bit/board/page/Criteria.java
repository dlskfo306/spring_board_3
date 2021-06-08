package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	private int pageNum; //페이지 넘버
	private int amount; //한 페이지당 몇개의 데이터를 보여줄건지
	
	public Criteria() {
	    this(1,10);
	    //1페이지에 10개의데이터
	}
	
	public Criteria(int pageNum, int amount) {
	    this.pageNum = pageNum;
	    this.amount = amount;
	}
	
}
