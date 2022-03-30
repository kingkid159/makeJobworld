package com.job.jobPro.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.edu.dao.EduDAO;
import com.job.jobPro.edu.vo.EduVO;

@Service("EduService")
public class EduServiceImpl implements EduService {
	private int size = 10;
	@Autowired
	private EduDAO eduDAO;
	@Override
	public EduPage eduList(int pageNo) {
		int total = eduDAO.selectEduCount();
		System.out.println("시스템에total="+total);
		System.out.println(pageNo);
		List<EduVO> content = eduDAO.EduList(
										(pageNo-1)*size+1,(pageNo-1)*size+size);
		System.out.println("시스템에content="+content);
		return new EduPage(total,pageNo,size,content) ;
	}

}
