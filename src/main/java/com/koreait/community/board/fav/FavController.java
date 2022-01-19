package com.koreait.community.board.fav;

import com.koreait.community.Const;
import com.koreait.community.model.BoardFavEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/board/fav")
public class FavController {

    @Autowired private FavService service;

    @PostMapping
    public Map<String, Integer> insBoardFav(@RequestBody BoardFavEntity entity) {
        Map<String, Integer> result = new HashMap<>();
        result.put(Const.RESULT, service.insBoardFav(entity));
        return result;
    }

    @GetMapping("/{iboard}")
    public Map<String, Integer> isFav(@PathVariable int iboard) {
        BoardFavEntity dbEntity = service.selBoardFav(iboard);
        Map<String, Integer> result = new HashMap<>();
        result.put(Const.RESULT, dbEntity == null ? 0 : 1);
        return result;
    }

    @DeleteMapping("/{iboard}")
    public Map<String, Integer> delBoardFavv(@PathVariable int iboard) {
        Map<String, Integer> result = new HashMap<>();
        result.put(Const.RESULT, service.delBoardFav(iboard));
        return result;
    }
}