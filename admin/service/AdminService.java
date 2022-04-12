package com.job.jobPro.admin.service;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.resume.vo.ResumeVO;

public interface AdminService {
	
	public int resumeRegister(ResumeVO resumeVO);
	public int resumeUpdate(ResumeVO resumeVO);
	public int resumeDelete(int resumeNo);
	
	public int letterRegister(LetterVO letterVO);
	public int letterUpdate(LetterVO letterVO);
	public int letterDelete(int letterNo);
}
