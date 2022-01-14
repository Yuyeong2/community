package com.koreait.community.board;

import com.koreait.community.UserUtils;
import com.koreait.community.model.BoardDto;
import com.koreait.community.model.BoardEntity;
import com.koreait.community.model.BoardPrevNextVo;
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

    public int insBoard(BoardEntity entity) {
        entity.setIuser(userUtils.getLoginUserPk());
        return mapper.insBoard(entity);
    }

    public List<BoardVo> selBoardList(BoardDto dto) {
        return mapper.selBoardList(dto);
    }
    public BoardVo selBoard(BoardDto dto) { //iboard, lastip
        BoardVo detail = mapper.selBoard(dto);
        if(dto.getLastip() != null && !Objects.equals(dto.getLastip(), detail.getLastip())) {
            int hitsResult = mapper.addHits(dto);
            if(hitsResult == 1) {
                detail.setHits(detail.getHits() + 1);
            }
        }
        return detail;
    }
    public BoardPrevNextVo selPrevNext(BoardVo vo) {
        return mapper.selPrevNext(vo);
    }

    public int updBoard(BoardEntity entity) {
        try {
            entity.setIuser(userUtils.getLoginUserPk());
            return mapper.updBoard(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    public int delBoard(BoardEntity entity) {  // icategory, iboard
        entity.setIuser(userUtils.getLoginUserPk());
        entity.setIsdel(1);
        return mapper.updBoard(entity); // icategory, iboard, iuser, isdel
    }
}
