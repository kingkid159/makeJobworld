package com.job.jobPro.member.service;

import java.io.PrintWriter;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.member.dao.MemberDAO;
import com.job.jobPro.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO manager;
	//field
	@Autowired
	private MemberDAO memberDAO;
	

	
	
	
	//id중복확인
	@Override
	public String selectOverlappedId(String id) throws Exception  {
		return memberDAO.selectOverlappedId(id);
	}
	
		//회원가입
		@Override
		public void insertMember(MemberVO memberVO) throws Exception {
			memberDAO.insertMember(memberVO);
		}
		
		//로그인처리
		@Override
		public MemberVO login(Map<String, String> loginMap) throws Exception {
			return memberDAO.login(loginMap);
		}
		
		//회원탈퇴
		@Override
		public void memberDelete(MemberVO memberVO) throws Exception {
			memberDAO.memberDelete(memberVO);
		}
		
		// 아이디 찾기
		@Override
		public String find_id(HttpServletResponse response, String email) throws Exception {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String id = manager.find_id(email);
			System.out.println(email);
			if (id == null) {
				out.println("<script>");
				out.println("alert('가입된 아이디가 없습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			} else {
				return id;
			}
		}
	
		// 비밀번호 찾기
				@Override
				public String find_pw(HttpServletResponse response, String id) throws Exception {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					String password = manager.find_pw(id);
					System.out.println(id);
					if (password == null) {
						out.println("<script>");
						out.println("alert('가입된 아이디가 없습니다.');");
						out.println("history.go(-1);");
						out.println("</script>");
						out.close();
						return null;
					} else {
						return password;
					}
				}
				
		
	}
	












