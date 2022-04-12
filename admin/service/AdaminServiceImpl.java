package com.job.jobPro.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.admin.dao.AdminDAO;
import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.resume.vo.ResumeVO;

@Service("adminService")
public class AdaminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adaminDAO;
	
	////////////////////////////////////////////////////////////////
	//이력서
	public int resumeRegister(ResumeVO resumeVO) {
		System.out.println("register"+resumeVO);
		int result = adaminDAO.resumeRegister(resumeVO); 
		return result;
	};
	
	public int resumeUpdate(ResumeVO resumeVO) {
		System.out.println("updateservice"+resumeVO);
		int result = adaminDAO.resumeUpdate(resumeVO); 
		return result;
	};
	
	public int resumeDelete(int resumeNo) {
		int result = adaminDAO.resumeDelete(resumeNo); 
		return result;
	};
	
	////////////////////////////////////////////////////////////////
	//자기소개서
	public int letterRegister(LetterVO letterVO) {
		int result = adaminDAO.letterRegister(letterVO); 
		return result;
	};
	
	public int letterUpdate(LetterVO letterVO) {
		int result = adaminDAO.letterUpdate(letterVO); 
		return result;
	};
	
	public int letterDelete(int letterNo) {
		int result = adaminDAO.letterDelete(letterNo); 
		return result;
	};
	
	
	
	
}
