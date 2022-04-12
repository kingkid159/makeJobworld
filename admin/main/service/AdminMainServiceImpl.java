package com.job.jobPro.admin.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.admin.main.dao.AdminMainDAO;
import com.job.jobPro.admin.main.vo.CompanyVO;
import com.job.jobPro.member.vo.MemberVO;





@Service("adminMemberService")
public class AdminMainServiceImpl implements AdminMainService {
	
	//field
	@Autowired
	private AdminMainDAO adminMainDAO;
		
		//회원 리스트 
		@Override
		public List<MemberVO> selectMemberDetail() throws Exception{
			List<MemberVO> memberList = adminMainDAO.selectMemberDetail();
			System.out.println("서비스 memberList="+memberList);
			return memberList;
		}
		//회원 수 
		public int selectMemberNum() throws Exception{
			int result = adminMainDAO.selectMemberNum();
			return result;
		}
		
		//회사 수
		public int selectCompanyNum() throws Exception{
			int result = adminMainDAO.selectCompanyNum();
			return result;
		}
		//게시판 수
		public int selectBoardNum() throws Exception{
			int result = adminMainDAO.selectBoardNum();
			return result;
		}
		//자기소개서 수
		public int selectLetterNum() throws Exception{
			int result = adminMainDAO.selectLetterNum();
			return result;
		}
		//이력서 수
		public int selectResumeNum() throws Exception{
			int result = adminMainDAO.selectResumeNum();
			return result;
		}
		
		public int selectEduNum() throws Exception{
			int result = adminMainDAO.selectEduNum();
			return result;
		}
		//회원 삭제 
		@Override
		public void deleteMember(String id) throws Exception {
			adminMainDAO.deleteMember(id);
		}
		
		
		@Override
		public CompanyVO getCompany() throws Exception {
			CompanyVO companyVO = adminMainDAO.getCompany();
			return companyVO;
		}
	
	}
	












