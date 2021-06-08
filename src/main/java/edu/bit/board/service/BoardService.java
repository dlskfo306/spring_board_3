package edu.bit.board.service;

import java.util.List;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardService {
    //List<BoardVO> getList();
	
    BoardVO get(int bid);

    void modify(BoardVO boardVO);

    void remove(int bid);

    //댓글
    void writeBoard(BoardVO boardVO);
    void writeReply(BoardVO boardVO);

    //조회수
    public void upHit(int bid);
    
    //페이징 처리
    List<BoardVO> getList(Criteria criteria);
    public int getTotal(Criteria cri);

    
}
