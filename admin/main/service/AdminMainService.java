package com.job.jobPro.admin.main.service;

import java.util.List;

import com.job.jobPro.admin.main.vo.CompanyVO;
import com.job.jobPro.member.vo.MemberVO;





public interface AdminMainService {

	//회원 리스트
	public List<MemberVO> selectMemberDetail() throws Exception;

	//회원 삭제 
	public void deleteMember(String id)throws Exception;
	
	//회원 수
	public int selectMemberNum() throws Exception;
	//회사 수
	public int selectCompanyNum() throws Exception;
	//게시판 수
	public int selectBoardNum() throws Exception;
	//자기소개서 수
	public int selectLetterNum() throws Exception;
	//이력서 수
	public int selectResumeNum() throws Exception;
	//교육 수
	public int selectEduNum() throws Exception;
	
	//회사수
	public CompanyVO getCompany() throws Exception;

	


}
