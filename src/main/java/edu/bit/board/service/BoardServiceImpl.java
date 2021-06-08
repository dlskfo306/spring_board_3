package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	
//	@Override
//    public List<BoardVO> getList(){
//        System.out.println("getList()..");
//        return boardMapper.getList();
//    }
    
    

    @Override
    public BoardVO get(int bid) {
        log.info("get()..");
        return boardMapper.read(bid);
        //read = 선택한 bid의 모든 값 불러오기
    }

    // 수정
    @Override
    public void modify(BoardVO boardVO) {
        log.info("service:modify()..");
        boardMapper.update(boardVO);
        
    }

    // 삭제
    @Override
    public void remove(int bid) {
        log.info("service:delete()..");
        boardMapper.delete(bid);
        
    }

    // 글작성
    @Override
    public void writeBoard(BoardVO boardVO) {
        log.info("service:writeBoard()..");
        boardMapper.insertBoard(boardVO);
        
    }

    // 답변달기
    @Override
    public void writeReply(BoardVO boardVO) {
        log.info("service:writeReply()..");
        boardMapper.updateShape(boardVO);
        boardMapper.insertReply(boardVO);
    }

    // 조회수
    @Override
    public void upHit(int bid) {
        boardMapper.updateHit(bid);
        
    }

    // 페이징
    @Override
    public int getTotal(Criteria cri) {
        log.info("service:getTotal()..");
        return boardMapper.getTotalCount(cri);
    }
    
    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("getList()..");
        return boardMapper.getListWithPaging(criteria);
    }
}
