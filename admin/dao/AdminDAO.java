package com.job.jobPro.admin.dao;

import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.resume.vo.ResumeVO;

public interface AdminDAO {

	public int resumeRegister(ResumeVO resumeVO);
	public int resumeUpdate(ResumeVO resumeVO);
	public int resumeDelete(int resumeNo);
	public int letterRegister(LetterVO letterVO);
	public int letterUpdate(LetterVO letterVO);
	public int letterDelete(int letterNo);
	
	
}
