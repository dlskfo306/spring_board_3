package edu.bit.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageVO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 첫 페이지 리스트

    /*
    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()..");
        log.info(boardService.getList()); // System.out.println("list().."); //
        System.out.println(boardService.getList());

        model.addAttribute("list", boardService.getList());
        return "list";
    }
    */
    

    // 페이징 처리 첫 페이지 리스트
    @GetMapping("/list")
    public String list(Criteria cri, Model model) {
        log.info("list()..");
        log.info(cri);

        model.addAttribute("list", boardService.getList(cri)); // list.jsp 만들고 나서

        int total = boardService.getTotal(cri);
        log.info("total" + total);
        model.addAttribute("pageMaker", new PageVO(cri, total));

        return "list";// view의 이름을 결정 (.jsp)
    }

    // 글제목 누르면 보이는 view
    @GetMapping("/content_view")
    public String content_view(BoardVO boardVO, Model model) {
        log.info("content_view()..");

        // 조회수
        boardService.upHit(boardVO.getBid());

        model.addAttribute("content_view", boardService.get(boardVO.getBid()));

        return "content_view";
    }

    // 수정
    @PostMapping("/modify")
    public String modify(BoardVO boardVO, Model model) {
        log.info("modify()..");

        boardService.modify(boardVO);

        return "redirect:list";
    }

    // 삭제
    @GetMapping("/delete")
    public String delete(BoardVO boardVO, Model model) {
        log.info("delete()..");

        boardService.remove(boardVO.getBid());

        return "redirect:list";
    }

    // 글작성 페이지 폼
    @GetMapping("/write_view")
    public String write_view() {
        log.info("write_view()..");

        return "write_view";
    }

    // 글작성 후 입력
    @PostMapping("/write")
    public String write(BoardVO boardVO) {
        log.info("write()..");

        boardService.writeBoard(boardVO);

        return "redirect:list";
    }

    // 답변 작성 페이지 폼
    @GetMapping("/reply_view")
    public String reply_view(BoardVO boardVO, Model model) {
        log.info("reply_view()..");

        model.addAttribute("reply_view", boardService.get(boardVO.getBid()));

        return "reply_view";
    }

    // 답변 작성 후 입력(답변 버튼)
    @PostMapping("/reply")
    public String reply(BoardVO boardVO) {
        log.info("reply()..");

        boardService.writeReply(boardVO);

        return "redirect:list";
    }

    // tables 템플릿 적용
    @RequestMapping("/tables")
    public String tables(Criteria cri, Model model) {
        log.info("tables()..");
        log.info(cri);

        model.addAttribute("list", boardService.getList(cri)); // list.jsp 만들고 나서

        int total = boardService.getTotal(cri);
        log.info("total" + total);
        model.addAttribute("pageMaker", new PageVO(cri, total));

        return "tables";
    }
    
}
