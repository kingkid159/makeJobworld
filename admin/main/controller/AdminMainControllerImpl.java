package com.job.jobPro.admin.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.admin.main.service.AdminMainService;
import com.job.jobPro.admin.main.vo.CompanyVO;
import com.job.jobPro.member.vo.MemberVO;






@Controller("adminMemberController")
public class AdminMainControllerImpl implements AdminMainController {

	//field
	@Autowired
	private AdminMainService adminMainService;

	
		//회원 리스트
		@Override
		@RequestMapping(value="/admin/main.do")
		public ModelAndView adminMain(HttpServletRequest request, HttpServletResponse response)throws Exception {
			List<MemberVO> memberList = adminMainService.selectMemberDetail();
			Map<String,Integer> totalNum = new HashMap<String, Integer>();
			int memberTotal = adminMainService.selectMemberNum();
			totalNum.put("MemberTotal",memberTotal);
			int companyTotal = adminMainService.selectCompanyNum();
			totalNum.put("CompanyTotal",companyTotal);
			int boardTotal = adminMainService.selectBoardNum();
			totalNum.put("BoardTotal",boardTotal);
			int letterTotal = adminMainService.selectLetterNum();
			totalNum.put("LetterTotal",letterTotal);
			int resumeTotal = adminMainService.selectResumeNum();
			totalNum.put("ResumeTotal",resumeTotal);
			int eduTotal = adminMainService.selectEduNum();
			totalNum.put("EduTotal",eduTotal);
			CompanyVO companyVO =adminMainService.getCompany();
			
			
			
			
			ModelAndView mav = new ModelAndView();  //ModelAndView객체생성
			System.out.println(companyVO);
			mav.addObject("CompanyVO",companyVO);
			mav.addObject("TotalNum", totalNum); //Model처리-addObject(Object 속성명, Object 값)
			mav.addObject("MemberList",memberList);
			mav.setViewName("/admin/main");   //View지정
			return mav;
		}
		
		
		//회원 삭제 
		@Override
		@RequestMapping(value="/admin/memberDelete.do", method=RequestMethod.POST)
		public String memberdelete(@RequestParam String id)throws Exception {
			adminMainService.deleteMember(id);
			return "redirect:/admin/main.do"; 
		}
		
	
}



