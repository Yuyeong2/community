package com.koreait.community.board.cmt;

import com.koreait.community.model.BoardCmtEntity;
import com.koreait.community.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board/cmt")
public class BoardCmtController {

    @Autowired private BoardCmtService service;

    @PostMapping
    public Map<String, Integer> insBoardCmt(@RequestBody BoardCmtEntity entity) {
        System.out.println(entity);
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.insBoardCmt(entity));
        return result;
    }

    @GetMapping("/{iboard}")
    public List<BoardCmtVo> selBoardCmtList(@PathVariable int iboard) {
        return service.selBoardCmtList(iboard);
    }

    @DeleteMapping("/{icmt}")
    public Map<String, Integer> delBoardCmt(@PathVariable int icmt) {
        Map<String, Integer> result = new HashMap<>();
        result.put("result", service.delBoardCmt(icmt));
        return result;
    }
}
