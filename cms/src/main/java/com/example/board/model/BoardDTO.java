package com.example.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class BoardDTO {
	
	private int board_idx;
	private String title;
	private String content;
	private String writer;
	private String writedate;
	private String modifier;
	private String modifierdate;
	private int readnum;
	private int user_idx;

}
