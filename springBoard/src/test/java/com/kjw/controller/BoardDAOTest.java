package com.kjw.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjw.domain.BoardVO;
import com.kjw.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	
	@Test
	public void testCreate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setTitle("안녕~!");
		board.setContent("new content~!");
		board.setWriter("userhello");
		dao.create(board);
	}


	@Test
	public void testRead() throws Exception{
		
		logger.info(dao.read(6).toString());
	}

	@Test
	public void testUpdate() throws Exception{
		
		BoardVO board = new BoardVO();
		board.setBno(3);
		board.setTitle("수정된 글이다~");
		board.setContent("수정 테스트~");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception{
		
		dao.delete(5);
	}


}





