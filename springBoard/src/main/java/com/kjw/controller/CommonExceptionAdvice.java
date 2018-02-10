package com.kjw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //ȣ��Ǵ� �޼ҵ忡�� �߻��� Exception�� ��� ó���ϴ� ����!
public class CommonExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception ex){
		
//		logger.info(ex.toString());
		
		ModelAndView modelAndView = new ModelAndView(); //�ϳ��� ��ü�� model�����Ϳ� view�� ó���� ���ÿ� �� �� �ִ� ��ü
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
	}
}
