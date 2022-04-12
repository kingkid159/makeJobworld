package com.job.jobPro.admin.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.job.jobPro.admin.service.AdminService;
import com.job.jobPro.letter.service.LetterService;
import com.job.jobPro.letter.vo.LetterVO;
import com.job.jobPro.resume.service.ResumeService;
import com.job.jobPro.resume.vo.ResumeVO;



@Controller("adminController")
public class AdminControllerImpl extends BaseController implements AdminController {
	
	
	private static final String 
	CURR_IMAGE_REPO_PATH="D:\\workspace\\springWK\\jobPro\\src\\main\\webapp";
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ResumeService resumeService;
	
	@Autowired
	LetterService letterService;
	//////////////////////////////////////////////////////////////////////////
	// 이력서 입력,수정,삭제
	@Override
	@RequestMapping(value="/admin/resume/RegisterPage.do")
	public String resumeRegisterPage(
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		return "/admin/resumeRegisterPage";
	}
	
	@Override
	@RequestMapping(value="/admin/resume/Register.do",method=RequestMethod.POST)
	public ModelAndView resumeRegister(ResumeVO resumeVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		resumeVO.setR_name(resumeVO.getImage_form()+resumeVO.getR_name());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MultipartFile fileList = request.getFile("imageFile");
		String originalFileName = fileList.getOriginalFilename();
		String imagefile = "\\resources\\image\\resume\\"+originalFileName;
		String imagePath = CURR_IMAGE_REPO_PATH +imagefile;
		String imageFileName = upload(request,fileList,imagePath); // 원본 파일 명
		imagefile=imagefile.replace("\\", "/");
		resumeVO.setImagefile(imagefile);
		
		 
		MultipartFile fileList2 = request.getFile("downFile");
		String originalFileName2 = fileList2.getOriginalFilename();
		String downfile = "\\resources\\file\\resume\\"+originalFileName2;
		String downPath = CURR_IMAGE_REPO_PATH +downfile;
		String downFileName = upload(request,fileList2,downPath); // 원본 파일 명 
		downfile=downfile.replace("\\", "/");
		resumeVO.setFilename(downfile);	
		System.out.println("resumeregister");
		ModelAndView mv = new ModelAndView();

		System.out.println(resumeVO);
		
		try {
			if(downFileName!=null && imageFileName!=null) {
				int result = adminService.resumeRegister(resumeVO);
				System.out.println(resumeVO);
				System.out.println(result);
			}
				mv.addObject("result",1);
			}catch(Exception e) {
				mv.addObject("result",0);
			}
			mv.setViewName("redirect:/resume/resumeList.do");
			return mv;
	
	}
	
	@Override
	@RequestMapping(value="/admin/resume/UpdatePage.do")
	public ModelAndView resumeUpdatePage(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception {
			ResumeVO resumeVO =resumeService.getResume(no);
			ModelAndView mv = new ModelAndView();
			mv.addObject("ResumeVO",resumeVO);
			mv.setViewName("/admin/resumeUpdatePage");
		return mv;
	}
	
	@Override
	@RequestMapping(value="/admin/resume/Update.do",method=RequestMethod.POST)
	public ModelAndView resumeUpdate(ResumeVO resumeVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		resumeVO.setR_name(resumeVO.getImage_form()+resumeVO.getR_name());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MultipartFile fileList = request.getFile("imageFile");
		String originalFileName = fileList.getOriginalFilename();
		String imagefile = "\\resources\\image\\resume\\"+originalFileName;
		String imagePath = CURR_IMAGE_REPO_PATH +imagefile;
		String imageFileName = upload(request,fileList,imagePath); // 원본 파일 명
		imagefile=imagefile.replace("\\", "/");
		resumeVO.setImagefile(imagefile);
		
		 
		MultipartFile fileList2 = request.getFile("downFile");
		String originalFileName2 = fileList2.getOriginalFilename();
		String downfile = "\\resources\\file\\resume\\"+originalFileName2;
		String downPath = CURR_IMAGE_REPO_PATH +downfile;
		String downFileName = upload(request,fileList2,downPath); // 원본 파일 명 
		downfile=downfile.replace("\\", "/");
		resumeVO.setFilename(downfile);	
		System.out.println("resumeupdate");
		ModelAndView mv = new ModelAndView();

		System.out.println(resumeVO);
		
		try {
			if(downFileName!=null && imageFileName!=null) {
				int result = adminService.resumeUpdate(resumeVO);
				System.out.println(resumeVO);
				System.out.println(result);
				mv.setViewName("redirect:/resume/resumeList.do");
			}
			}catch(Exception e) {
				//고쳐야함
				mv.setViewName("redirect:/admin/resume/UpdatePage.do");
			}
			return mv;
	}
	
	@Override
	@RequestMapping(value="/admin/resume/Delete.do",method=RequestMethod.GET)
	public ModelAndView resumeDelete(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		
		int result = adminService.resumeDelete(no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",result);
		mv.setViewName("redirect:/resume/resumeList.do");
		return mv;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	//자기소개서 입력,수정,삭제
	@Override
	@RequestMapping(value="/admin/letter/RegisterPage.do")
	public String letterRegisterPage(
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception {

		return "/admin/letterRegisterPage";
	}
	
	@Override
	@RequestMapping(value="/admin/letter/Register.do",method=RequestMethod.POST)
	public ModelAndView letterRegister(LetterVO letterVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println(letterVO);
		MultipartFile fileList = request.getFile("imageFile");
		String originalFileName = fileList.getOriginalFilename();
		String imagefile = "\\resources\\image\\letter\\"+originalFileName;
		String imagePath = CURR_IMAGE_REPO_PATH +imagefile;
		String imageFileName = upload(request,fileList,imagePath); // 원본 파일 명
		imagefile=imagefile.replace("\\", "/");
		letterVO.setImagefile(imagefile);

		System.out.println(letterVO);
		ModelAndView mv = new ModelAndView();
		try {
			if(imageFileName!=null) {
				int result = adminService.letterRegister(letterVO);
				System.out.println(letterVO);
				System.out.println(result);
				mv.setViewName("redirect:/letter/letterList.do");
			}
			}catch(Exception e) {
				//고쳐야함
				mv.setViewName("redirect:/admin/letterRegisterPage");
			}
			return mv;
	}

	
	
	@Override
	@RequestMapping(value="/admin/letter/UpdatePage.do")
	public ModelAndView letterUpdatePage(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		LetterVO letterVO =letterService.getLetter(no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("LetterVO",letterVO);
		mv.setViewName("/admin/letterUpdatePage");
		return mv;

	}
	
	@Override
	@RequestMapping(value="/admin/letter/Update.do",method=RequestMethod.POST)
	public ModelAndView resumeUpdate(LetterVO letterVO,
			MultipartHttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println(letterVO);
		MultipartFile fileList = request.getFile("imageFile");
		String originalFileName = fileList.getOriginalFilename();
		String imagefile = "\\resources\\image\\letter\\"+originalFileName;
		String imagePath = CURR_IMAGE_REPO_PATH +imagefile;
		String imageFileName = upload(request,fileList,imagePath); // 원본 파일 명
		imagefile=imagefile.replace("\\", "/");
		letterVO.setImagefile(imagefile);

		System.out.println(letterVO);
		ModelAndView mv = new ModelAndView();
		try {
			if(imageFileName!=null) {
				int result = adminService.letterUpdate(letterVO);
				System.out.println(letterVO);
				System.out.println(result);
				mv.setViewName("redirect:/letter/letterList.do");
			}
			}catch(Exception e) {
				mv.setViewName("redirect:/main/main.do");
			}
			return mv;
	}
	
	@Override
	@RequestMapping(value="/admin/letter/Delete.do",method=RequestMethod.GET)
	public ModelAndView letterDelete(@RequestParam(value="no") int no,
			HttpServletRequest request,
  			HttpServletResponse response) throws Exception {
		
		int result = adminService.letterDelete(no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",result);
		mv.setViewName("redirect:/letter/letterList.do");
		return mv;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////		
}
