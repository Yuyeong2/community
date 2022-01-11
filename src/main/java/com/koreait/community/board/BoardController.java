package com.koreait.community.board;

import com.koreait.community.Const;
import com.koreait.community.model.BoardDto;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list/{icategory}")
    public String  list(@PathVariable int icategory, BoardDto dto, Model model) {
        model.addAttribute(Const.I_CATEGORY, icategory);
        model.addAttribute(Const.LIST, service.selBoardList(dto));
        dto.setIcategory(icategory);
        return "board/list";
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.insBoard(entity);
        return "redirect:/board/list/" + entity.getIcategory();
    }
    @GetMapping("/detail")
    public void detail(BoardDto dto, Model model, HttpServletRequest req){
        String lastIp = req.getHeader("X-FORWARDED_FOR");
        if(lastIp == null) {
            lastIp = req.getRemoteAddr();
        }
        dto.setLastip(lastIp);
        model.addAttribute(Const.DATA, service.selBoard(dto));
    }

    @GetMapping("/del")
    public String delProc(BoardEntity entity) {
        int result = service.delBoard(entity);
        return "redirect:/board/list/" + entity.getIcategory();
    }

    @GetMapping("/mod")
    public String mod(BoardDto dto, Model model) {
        model.addAttribute(Const.DATA, service.selBoard(dto));
        return "board/write";
    }

    @PostMapping("/mod")
    public String modProc(BoardEntity entity) {
        service.updBoard(entity);
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }
}