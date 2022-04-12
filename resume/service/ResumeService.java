package com.job.jobPro.resume.service;

import java.util.List;

import com.job.jobPro.resume.vo.ResumePage;
import com.job.jobPro.resume.vo.ResumeVO;



public interface ResumeService {
	public List<ResumeVO> resumeList();
	
	public abstract ResumePage getResumePage(int pageNum);
	
	public ResumeVO getResume(int NoticeNum);
	
	
}
