package com.koreait.community.board.cmt;

import com.koreait.community.model.BoardCmtEntity;
import com.koreait.community.model.BoardCmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardCmtMapper {
    int insBoardCmt(BoardCmtEntity entity);
    List<BoardCmtVo> selBoardCmtList(BoardCmtEntity entity);
    int delBoardCmt(BoardCmtEntity entity);
}
