package com.koreait.community.board;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardDto;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    @Autowired
    private UserUtils userUtils;

    public List<BoardVo> selBoardList(BoardDto dto) {
        return mapper.selBoardList(dto);
    }

    public int insBoard(BoardEntity entity) {
            entity.setIuser(userUtils.getLoginUserPk());
            return mapper.insBoard(entity);
    }

    public BoardVo selBoard(BoardDto dto) {
        BoardVo detail = mapper.selBoard(dto);
        if(dto.getLastip() != null && !Objects.equals(dto.getLastip(), detail.getLastip())) {
            int hitsResult = mapper.addHits(dto);
            if(hitsResult == 1) {
                detail.setHits(detail.getHits() + 1);
            }
        }
        return detail;
    }

    public int delBoard(BoardEntity entity) {
        entity.setIuser(userUtils.getLoginUserPk());
        entity.setIsdel(1);
        return mapper.updBoard(entity);
    }

    public int updBoard(BoardEntity entity) {
        entity.setIuser(userUtils.getLoginUserPk());
        return mapper.updBoard(entity);
    }
}
