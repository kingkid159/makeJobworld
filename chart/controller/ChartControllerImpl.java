package com.job.jobPro.chart.controller;

import java.util.List;

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

	@Autowired
	private ChartService chartService;
	
	/*메인 차트 화면*/
	@Override
	@RequestMapping(value="/job/mainChart.do")
	public ModelAndView mainChart(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("차트페이지진입");
		ModelAndView mav = new ModelAndView();
		ChartVO chartVO = chartService.selectMainChart("전체","전체","전체");
		System.out.println(chartVO);
		mav.setViewName("/job/chart");
		mav.addObject("chartVO",chartVO);
		return mav;
	}
	/*디테일 차트 화면*/
	@Override
	@RequestMapping(value="/job/detailChart.do")
	public ModelAndView detailChart(HttpServletRequest request, HttpServletResponse response) {
		String job = request.getParameter("job");
		String jobDetail = request.getParameter("jobDetail"); 
		String graphType = request.getParameter("graphType");
		/*직종별 채용공고 차트가 보여질 화면*/
		if (job !=null && jobDetail == null) {
			ChartVO chartVO = chartService.selectChart(job);
			System.out.println("controllerchartVO="+chartVO);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/job/chart");
			mav.addObject("chartVO",chartVO);
			return mav;
		/*직종파라미터값은 받고 graphType파라미터는 안받는 경우 직종별 상세 차트가 나온다*/
		}else if (jobDetail != null && graphType == null) {
			List<ChartVO> chartVO = chartService.selectDetailChart(job,jobDetail);
			System.out.println("Controller charVO="+chartVO);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/job/chartGraphType");
			mav.addObject("chartVO",chartVO);
			return mav;
		}
		return null;
	}

}
