package com.lee.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lee.domain.BoardVO;
import com.lee.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
//	@Test
//	public void testCreate() throws Exception {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("테스트1 제목");
//		vo.setContent("테스트1 내용");
//		vo.setWriter("user00");
//		dao.create(vo);
//	}
//	@Test
//	public void testRead() throws Exception {
//		logger.info(dao.read(2).toString());
//	}
//	
//	@Test
//	public void testUpdate() throws Exception {
//		BoardVO vo = new BoardVO();
//		
//		vo.setBno(1);
//		vo.setTitle("수정된 제목1");
//		vo.setContent("수정된 내용1");
//		dao.update(vo);
//	}
//	@Test
//	public void testDelete() throws Exception {
//		dao.delete(1);
//	}
	@Test
	public void testListAll() throws Exception {
		logger.info(dao.listAll().toString());
	}
 }
