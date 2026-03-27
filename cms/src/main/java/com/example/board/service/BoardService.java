package com.example.board.service;

import com.example.board.model.BoardDTO;
import java.util.*;

public interface BoardService {
	
	public int boardWrite(BoardDTO dto);
	public List<BoardDTO> boardList(Map<String, Integer> map);
	public int boardTotalCnt();
	public BoardDTO boardContent(int board_idx);
	public void boardReadnum(int board_idx, int readnum);
	public int boardDelete(int board_idx);
	public int boardUpdate(Map map);

}
