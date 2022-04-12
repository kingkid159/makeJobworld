package com.job.jobPro.admin.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.job.jobPro.resume.vo.ResumeVO;


public class BaseController {

	//파일업로드
	protected String upload(MultipartHttpServletRequest request,MultipartFile fileList,String filePath) 
			throws Exception{
		
		System.out.println("UPLOAD");

		//파일의 실제이름으로  이미지파일명으로 설정
		//File file = new File("파일을 저장할 경로" +"\\"+ "파일이름");
		File file = new File(filePath);
		if(fileList.getSize()!=0){ //MultipartFile mFile참조변수가 null이 아니면
			if(file.exists()) {
			file.delete();
			}
			if(file.getParentFile().mkdirs()){ //경로에 해당하는 디렉토리들을 생성
				file.createNewFile(); //파일 생성
			}
			
			//임시로 저장된 multipartFile을 실제 파일로 전송
			//MultipartFile.transferTo(File file) - Byte형태의 데이터를 File객체에 설정한 파일 경로에 전송.
			System.out.println("file"+filePath);
			fileList.transferTo(file); 
		}
		

		return filePath;
	}
}
