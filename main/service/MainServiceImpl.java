package com.job.jobPro.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.main.dao.MainDAO;
import com.job.jobPro.main.model.CList;
import com.job.jobPro.main.model.Cmain;
import com.job.jobPro.main.service.MainService;
@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Autowired
	public MainDAO maindao;
	@Override
	public List<Cmain> cmainList() {//추천기업
		List<Cmain> cmainList=maindao.selectCmain();
		return cmainList;
	}
	@Override
	public List<CList> cList() {//일반기업
		List<CList> cList=maindao.selectCList();
		return cList;
	}
}
