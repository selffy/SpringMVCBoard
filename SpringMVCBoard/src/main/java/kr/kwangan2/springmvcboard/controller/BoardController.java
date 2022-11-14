package kr.kwangan2.springmvcboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.service.BoardService;
import kr.kwangan2.springmvcboard.util.PageCalc;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;

	/*
	@GetMapping("/list")
	public String BoardVOList(Model model) {
		log.info("list");
		model.addAttribute("boardVOList", service.boardVOList());
		log.info("리스트 이동");
		return "boardList";
	}
	*/
	@GetMapping("/list")
	public String BoardVOList(Criteria criteria, Model model) {
		log.info("list");
		model.addAttribute("boardVOList", service.boardVOList(criteria));
		model.addAttribute("pageCalc", new PageCalc(criteria, service.boardVOListCount(criteria)).calcPage());
		log.info("리스트 이동");
		return "boardList";
	}
	
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "boardInsert";
	}
	
	@PostMapping("/boardInsertProc")
	public String insertBoardProc(BoardVO boardVO, RedirectAttributes redirectAttributes) {
		int num = service.insertBoardVO(boardVO);
		if(num > 0) {
			redirectAttributes.addFlashAttribute("result", num);
			log.info("결과 : "+num);
		}
		return "redirect:/";
	}
	
	@GetMapping("/select")
	public String selectBoardVO(@RequestParam("bno")Long bno, Model model) {
		model.addAttribute("boardVO", service.selectBoardVO(bno));
		return "boardSelect";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("bno")Long bno, Model model) {
		model.addAttribute("boardVO", service.selectBoardVO(bno));
		return "boardUpdate";
	}
	
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("register: " + boardVO);
		service.insertBoardVO(boardVO);
		rttr.addFlashAttribute("result", boardVO.getBno());
		
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/boardUpdateProc")
	public String updateBoardVO(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("update : " + boardVO);
		if(service.updateBoardVO(boardVO) > 0) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteBoardVO(@RequestParam("bno")Long bno, RedirectAttributes rttr) {
		if(service.deleteBoardVO(bno) > 0) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/";
	}
}
