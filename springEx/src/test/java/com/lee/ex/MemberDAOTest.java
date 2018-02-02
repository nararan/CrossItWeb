package com.lee.ex;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lee.domain.MemberVO;
import com.lee.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	@Inject
	private MemberDAO dao;
	
//	@Test
//	public void testTime() throws Exception {
//		System.out.println(dao.getTime());
//	}
	
//	@Test
//	public void testInsert() throws Exception {
//		MemberVO vo = new MemberVO();
//		vo.setUserid("user00");
//		vo.setUserpw("user00");
//		vo.setUsername("USER00");
//		vo.setEmail("user00@aaa.com");
//		
//		dao.insertMember(vo);
//	}
	
	@Test
	public void testRead() throws Exception {
		MemberVO vo = dao.readMember("user00");
		
		System.out.println("UserId : " + vo.getUserid());
		System.out.println("UserPw : " + vo.getUserpw());
		System.out.println("UserName : " + vo.getUsername());
		System.out.println("Email : " + vo.getEmail());
		System.out.println("RegDate : " + vo.getRegdate());
		System.out.println("UpdateDate : " + vo.getUpdatedate());
	}
	
	@Test
	public void testReadWithPW() throws Exception {
		MemberVO vo = dao.readWithPW("user00", "user00");

		System.out.println("UserId : " + vo.getUserid());
		System.out.println("UserPw : " + vo.getUserpw());
		System.out.println("UserName : " + vo.getUsername());
		System.out.println("Email : " + vo.getEmail());
		System.out.println("RegDate : " + vo.getRegdate());
		System.out.println("UpdateDate : " + vo.getUpdatedate());
	}
}
