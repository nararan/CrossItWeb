 package com.lee.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.domain.ProductVO;

@Controller
public class SampleController2 {
	
	@RequestMapping("doJSON")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("���û�ǰ", 30000);
		
		return vo;
	}
}
