package com.koreait.community.board.fav;

import com.koreait.community.model.BoardFavEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavMapper {
    int insBoardFav(BoardFavEntity entity);
    BoardFavEntity selBoardFav(BoardFavEntity entity);
    int delBoardFav(BoardFavEntity entity);
}