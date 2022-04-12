package com.job.jobPro.edu.service;

import java.util.Map;

import com.job.jobPro.edu.vo.EduVO;
//취업지원 페이지 서비스 인터페이스
public interface EduService {
	//목록페이지
	public EduPage eduList(int pageNo);
	
	//상세페이지
	public EduVO eduDetail(int eno);
	
	//수정
	public void serviceModify(Map newEduMap);
	
	public void eduDelete(int eno);
	
	public void insertEdu(Map newEduMap) throws Exception;
}
