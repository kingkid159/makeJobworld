package com.job.jobPro.main.service;

import java.util.List;

import com.job.jobPro.main.model.CList;
import com.job.jobPro.main.model.Cmain;

public interface MainService {
	public List<Cmain>cmainList();//추천기업

	public List<CList> cList();//일반기업

}
