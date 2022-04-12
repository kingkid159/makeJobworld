package com.job.jobPro.main.dao;

import java.util.List;

import com.job.jobPro.main.model.CList;
import com.job.jobPro.main.model.Cmain;

public interface MainDAO {
	public List<Cmain> selectCmain(); //추천기업
	
	public List<CList> selectCList(); //일반기업
}
