package com.example.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.model.BoardDTO;
import com.example.board.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardListPage() {
		return "board/boardList";
	}
	
	@GetMapping("/boardWrite")
	public String boardWritePage(HttpSession session, RedirectAttributes redirectAttributes) {
		String id = (String)session.getAttribute("id");

		if(id == null || id.equals("")) {
			redirectAttributes.addFlashAttribute("msg", "로그인 후 게시글을 작성하실 수 있습니다.");
			return "redirect:/loginPage"; // 로그인 페이지로 이동
		}
		return "board/boardWrite";
	}
	
	@GetMapping("/boardContent/{boardIdx}")
	public String boardContent(@PathVariable("boardIdx") int boardIdx, Model model, HttpSession session) {
	    BoardDTO board = boardService.boardContent(boardIdx);
	    
	    // 세션에 '조회한 게시글 목록' 저장
	    Set<Integer> viewed = (Set<Integer>) session.getAttribute("viewedBoards");
	    if (viewed == null) {
	        viewed = new HashSet<>();
	        session.setAttribute("viewedBoards", viewed);
	    }

	    // 아직 안 본 게시글이면 조회수 증가
	    if (!viewed.contains(boardIdx)) {
	        boardService.boardReadnum(boardIdx, board.getReadnum() + 1);
	        viewed.add(boardIdx);
	    }
	    
	    
	    int boardWriter = board.getUser_idx();
	    Integer loginUser = (Integer)session.getAttribute("user_idx");
	    String role = (String)session.getAttribute("role");
	    
	    boolean sw = false;
	    if(loginUser != null) {
	    	sw = role.equals("ADMIN") || boardWriter == loginUser;
	    }
	    
	    model.addAttribute("sw", sw);
	    
	    model.addAttribute("board", board);
	    return "board/boardContent";
	}
	
	@GetMapping("/boardUpdate/{boardIdx}")
	public String boardUpdatePage(@PathVariable int boardIdx,
	                              HttpSession session,
	                              RedirectAttributes ra,
	                              Model model) {

	    BoardDTO board = boardService.boardContent(boardIdx);

	    Integer loginUser = (Integer)session.getAttribute("user_idx");
	    String role = (String)session.getAttribute("role");

	    if(loginUser == null) {
	        ra.addFlashAttribute("msg","로그인이 필요합니다.");
	        return "redirect:/loginPage";
	    }

	    if(!role.equals("ADMIN") && board.getUser_idx() != loginUser) {
	        ra.addFlashAttribute("msg","수정 권한이 없습니다.");
	        return "redirect:/boardContent/" + boardIdx;
	    }

	    model.addAttribute("board", board);
	    return "board/boardUpdate";
	}
	
}
