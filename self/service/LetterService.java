package com.job.jobPro.letter.service;

import java.util.List;

import com.job.jobPro.letter.vo.LetterPage;
import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.letter.vo.MyLetterVO;





public interface LetterService {
	public List<LetterVO> letterList();
	
	public abstract LetterPage getLetterPage(int pageNum);
	
	public LetterVO getLetter(int NoticeNum);
	
	public int insertLetter(MyLetterVO myletterVO);
	
	public void letterUpdate(String userId);
}
