package com.job.jobPro.edu.dao;

import java.util.List;

import com.job.jobPro.edu.vo.EduVO;

public interface EduDAO {
	public int selectEduCount();
	public List<EduVO> EduList(int startPage, int size);
}
