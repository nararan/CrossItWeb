package com.kjw.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjw.domain.BoardVO;
import com.kjw.service.BoardService;

@Controller
/*@RequestMapping("/board/*")*/
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(BoardVO board, Model model)throws Exception{
		
		logger.info("register get......");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String registPOST(BoardVO board, Model model)throws Exception{
	public String registPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		
		logger.info("regist post......");
		logger.info(board.toString());
		
		service.regist(board);
		
//		model.addAttribute("result", "success"); //modelŬ������ ������ mvc���� �����ϴ� ������ ���޿� ��ü!(uri�� ����)
		rttr.addFlashAttribute("msg", "success"); //�����̷�Ʈ ������ �� ���� ���Ǵ� ������ ����!(uri�� ������ ����)
		
		
//		return "/success";
		return "redirect:/listAll";
	}
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		
		logger.info("show all list......");
	
		model.addAttribute("list", service.listAll());
	}
	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model)throws Exception{
		
		model.addAttribute(service.read(bno)); //BoardVOŬ������ ��ü������ boardVO�� �����!
	}
}
