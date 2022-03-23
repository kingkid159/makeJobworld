package com.job.jobPro.chart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.chart.service.ChartService;
import com.job.jobPro.chart.vo.ChartVO;
@Controller("ChartController")
public class ChartControllerImpl implements ChartController{


	@Override
	@RequestMapping(value="/job/mainChart.do")
	public ModelAndView mainChart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("차트페이지진입");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/job/chart");
		ChartVO chartVO = new ChartVO("전체","전체","전체");
		mav.addObject("chartVO",chartVO);
		return mav;
	}

	@Override
	@RequestMapping(value="/job/detailChart.do")
	public ModelAndView detailChart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String job = request.getParameter("job");
		String jobDetail = request.getParameter("jobDetail");
		String graphType = request.getParameter("graphType");
		ChartVO chartVO = new ChartVO(job,jobDetail,graphType);
		ModelAndView mav = new ModelAndView();
		mav.addObject("chartVO",chartVO);
		mav.setViewName("/job/chart");
		return mav;
	}

}
