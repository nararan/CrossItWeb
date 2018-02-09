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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET) //��� �������� �̵�
	public void registGET(BoardVO board, Model model)throws Exception{
		
		logger.info("register get......");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST) //���� ��� �۾� ó��
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
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET) //��ü ��� ����
	public void listAll(Model model)throws Exception{
		
		logger.info("show all list......");
	
		model.addAttribute("list", service.listAll());
	}
	
	
	@RequestMapping(value = "/read", method = RequestMethod.GET) //�� �ϳ� ��ȸ
	public void read(@RequestParam("bno") int bno, Model model)throws Exception{
		
		model.addAttribute(service.read(bno)); //BoardVOŬ������ ��ü������ boardVO�� �����!
	}
	
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST) //�� ����
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr)throws Exception{
		
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/listAll";
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET) //
	public void modifyGET(int bno, Model model)throws Exception{
		
		logger.info("modify get......");
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST) //���� ���� �۾� ó��
	public String modifyPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		
		logger.info("modify post......");
		
		service.modify(board);
		rttr.addAttribute("msg", "success");
		
		return "redirect:/listAll";
	}
}
