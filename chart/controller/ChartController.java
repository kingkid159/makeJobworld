package com.job.jobPro.chart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ChartController {
	//메인차트
	public ModelAndView mainChart(HttpServletRequest request, HttpServletResponse response);
	//세부차트
	public ModelAndView detailChart(HttpServletRequest request, HttpServletResponse response);
}
