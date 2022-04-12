package com.job.jobPro.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobPro.edu.dao.EduDAO;
import com.job.jobPro.edu.vo.EduVO;
//취업지원 페이지 서비스
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

	//상세조회
	@Override
	public EduVO eduDetail(int eno) {
		System.out.println("서비스의 eno="+eno);
		EduVO eduVO= eduDAO.selectEduDetail(eno);
		return eduVO;
	}
	//수정
	@Override
	public void serviceModify(Map newEduMap) {
		eduDAO.eduModify(newEduMap);
	}
	
	//삭제
	public void eduDelete(int eno) {
		eduDAO.eduDelete(eno);
	}
	//등록
	   @Override
	   public void insertEdu(Map newEduMap) throws Exception {
	      eduDAO.insertEdu(newEduMap);
	   }
}
