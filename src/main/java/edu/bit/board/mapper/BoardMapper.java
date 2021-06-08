package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//List<BoardVO> getList();

    BoardVO read(int bid);

    void update(BoardVO boardVO);

    void delete(int bid);

    void insertBoard(BoardVO boardVO);

    //댓글 관련
    void updateShape(BoardVO boardVO);
    void insertReply(BoardVO boardVO);

    void updateHit(int bid);

    //페이징처리
    List<BoardVO> getListWithPaging(Criteria criteria);
    int getTotalCount(Criteria cri);
}
