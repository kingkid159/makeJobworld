package com.job.jobPro.admin.main.dao;

import java.util.List;

import com.job.jobPro.admin.main.vo.CompanyVO;
import com.job.jobPro.member.vo.MemberVO;







public interface AdminMainDAO {
	
	//회원 리스트
	public List<MemberVO> selectMemberDetail() throws Exception;

	//회원 삭제 
	public void deleteMember(String id)throws Exception;
	public int selectMemberNum() throws Exception;
	public int selectCompanyNum() throws Exception;
	public int selectBoardNum() throws Exception;
	public int selectLetterNum() throws Exception;
	public int selectResumeNum() throws Exception;
	public int selectEduNum() throws Exception;
	public CompanyVO getCompany() throws Exception;
	

}
