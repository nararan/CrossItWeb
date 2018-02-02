package com.lee.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lee.domain.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA called.............................");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called.............................");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called.............................");
		
		return "result";
	}
	
	@RequestMapping("doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("Sample Product", 10000);
		
		logger.info("doD");
		
		model.addAttribute("pd", product);
		
		return "productDetail";
	}
	
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called but redirect to /doF.............");
		
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected");
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(@ModelAttribute("msg") String msg) {
		logger.info("doF called......................");
	}
	
	@RequestMapping("doJ")
	public @ResponseBody ProductVO doJ() {
		ProductVO vo = new ProductVO("Sample", 30000);
		
		return vo;
	}
}
