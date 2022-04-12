package com.job.jobPro.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.jobPro.member.service.MemberService;
import com.job.jobPro.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {

	//field
	@Autowired
	private MemberService memberService;
	
	//id중복확인
		//@RequestParam("_member_id") String id는 user가 입력한 id값
		@Override 
		@RequestMapping(value="/member/overlappedId.do", method=RequestMethod.POST)
		public ResponseEntity overlappedId(@RequestParam("id") String id,
							HttpServletRequest request, 
							HttpServletResponse response) throws Exception {
			//1.파라미터받기
			//String id = request.getParameter("_member_id");
			System.out.println("MemberControllerImpl id중복확인의 id="+id);//콘솔 확인용
			 
			//2.비즈니스로직수행<->Service<->DAO<->MyBatis<->db
			//member_id컬럼의 값이  user가 입력한 id와 일치하면 'true', 그렇지않으면 'false'
			//->id가 중복되면 true리턴, 그렇지않으면 false리턴
			String result = memberService.selectOverlappedId(id);
			
			//3.Model
			//4.View
			/* HttpStatus.OK : 200(성공): 서버가 요청을 제대로 처리했다는 뜻이다. 
			                        이는 주로 서버가 요청한 페이지를 제공했다는 의미로 쓰인다.*/
			ResponseEntity resEntity = new ResponseEntity(result,HttpStatus.OK);
			return resEntity;
		}
	/*참고 ResponseEntity는 
	 * 서버가 클라이언트에게 보내주는 데이터, 상태코드,상태메세지등을 포함시켜줄 때 주로 사용
	 * HttpEntity클래스를 상속받아 구현한 클래스가 RequestEntity, ResponseEntity
	 * HttpStatus.OK : 200(성공): 서버가 요청을 제대로 처리했다는 뜻이다. 
		                        이는 주로 서버가 요청한 페이지를 제공했다는 의미로 쓰인다.*/
	//회원가입 - 반드시 POST방식으로 요청해야지만  해당요청함수가 호출된다
	@Override
	@RequestMapping(value="/member/homes.do", method=RequestMethod.POST)
	public ResponseEntity insertMember(MemberVO memberVO,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		System.out.println(memberVO.toString());
    	ResponseEntity resEntity = null;
    	String message = null; //client로 보낼 데이터가 저장될 변수 선언
    	HttpHeaders responseHeaders = new HttpHeaders();
    	responseHeaders.add("content-Type", "text/html; charset=utf-8");
    	
		//1.파라미터받기-> 여기에서는 요청함수의 매개변수를 활용
		//2.비즈니스로직수행<->Service<->DAO<->MyBatis<->db
		
		//임시용
		//System.out.println("memberVO="+memberVO.toString()); //파라미터확인
    	
    	try {
    		System.out.println("insertMember");
    		//회원가입성공시 ->로그인페이지로 이동
    		memberService.insertMember(memberVO);
    		message = "<script>";
    		message += "alert('회원가입을 축하드립니다. 로그인페이지로 이동합니다.');";
    		message += "location.href='"+request.getContextPath()+"/member/login.do';";
    		message += "</script>";   
    	}catch(Exception e) {
    		//회원가입 실패(가입처리중 오류발생등)->회원가입페이지로 이동
    		message = "<script>";
    		message += "alert('가입처리중 오류가 발생되었습니다. 다시 시도해주세요.');";
    		message += "location.href='"+request.getContextPath()+"/member/member.do';";
    		message +="</script>";
    		e.printStackTrace();
    	}
    	
    	
    	
		
		//3.Model		//4.View
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
		
	}
	
	//id중복검색 @RequestMapping(value="/member/overlapped.do", method=RequestMethod.POST)
	//로그인       @RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	//로그아웃    @RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
 	//로그인
	 @Override
	    @RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	    public ModelAndView login(@RequestParam Map<String,String> loginMap,
	    		ModelAndView mv,
	    		HttpServletRequest request,
	  			HttpServletResponse response) throws Exception{
	    
	    	MemberVO memberVO = memberService.login(loginMap);
	    	if(memberVO!=null && memberVO.getId()!=null) {
		    	
	    		HttpSession session = request.getSession(); 
	    		session.setAttribute("memberVO", memberVO); 
	    		session.setAttribute("isLogOn", true);
				session.setAttribute("LoginId",memberVO.getId());
	    		System.out.println(memberVO.getAdminok());
	    		mv.setViewName("redirect:/main/main.do"); 		

	    	}else {
	    		//로그인 실패시
	    		String message ="아이디나  비밀번호가 틀립니다. 다시 로그인해주세요";
	    		mv.addObject("message",message);    
	    		mv.setViewName("/member/login");
	    	}
	    	
	    	return mv;
	    }
	    
    
    
	//로그아웃처리
	    @Override
	    @RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	    public ModelAndView login(ModelAndView mv,HttpServletRequest request,
	  			HttpServletResponse response) throws Exception{
	    
	    	HttpSession session = request.getSession(); 
			session.removeAttribute("memberVO"); 
			session.setAttribute("isLogOn", false);
			session.setAttribute("LoginId", "");
	    	mv.setViewName("redirect:/main/main.do"); 
	    	return mv;
	    }
	
  //회원가입요청시 호출되는 요청함수
   	@Override
    	@RequestMapping(value="/member/member.do")
    	public String memberForm(HttpServletRequest request,
    			HttpServletResponse response) {
    		System.out.println("MemberControllerImpl의 main()진입");
    		return "/member/member";
    	}
    
    //로그인요청시 호출되는 함수
	@Override
  	@RequestMapping(value="/member/login.do",method =RequestMethod.GET	 )
  	public String loginform(HttpServletRequest request,
  			HttpServletResponse response) {
  		System.out.println("MemberControllerImpl의 loginForm()진입");
  		return "/member/login";
  	}
	   //로그인했을떄 이동페이지
		@Override
	  	@RequestMapping(value="/member/main2.do",method =RequestMethod.GET	 )
	  	public String main2(HttpServletRequest request,
	  			HttpServletResponse response) {
	  		System.out.println("MemberControllerImpl의 loginForm()진입");
	  		return "/member/main2";
	  	}
		//mypage
		@Override
		@RequestMapping("/member/mypage.do")
		public String myPageMain(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("MyPageController의 myPageMain()진입~~");
			return "/member/mypage";
		}
	
		
		// 회원 탈퇴 get
	
		@RequestMapping(value="/member/delete.do", method = RequestMethod.GET)
		public String memberDelete() throws Exception{
			return "/member/delete";
		}
		
		
		
		// 회원 탈퇴 post
		@RequestMapping(value="/memberDelete.do", method = RequestMethod.POST)
		public String memberDelete(MemberVO memberVO, HttpSession session, RedirectAttributes rttr) throws Exception{
			
			// 세션에 있는 member를 가져와 member변수에 넣어줍니다.
			MemberVO member = (MemberVO) session.getAttribute("member");
			// 세션에있는 비밀번호
			String sessionPass = memberVO.getPassword();
			// vo로 들어오는 비밀번호
			String voPass = memberVO.getPassword();
			
			if(!(sessionPass.equals(voPass))) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:/member/delete.do";
			}
			memberService.memberDelete(memberVO);
			session.invalidate();
			return "redirect:/member/delete2.do";
		}
		
		 //회원탈퇴했을때 이동페이지
		@Override
	  	@RequestMapping(value="/member/delete2.do",method =RequestMethod.GET	 )
	  	public String del(HttpServletRequest request,
	  			HttpServletResponse response) {
	  		return "/member/delete2";
	  	}
		
		
		
		// 아이디 찾기 폼
		@RequestMapping(value = "/member/find_id_form.do")
		public String find_id_form() throws Exception{
			return "/member/find_id_form";
		}
		

		
		// 아이디 찾기
		@RequestMapping(value = "/member/find_id.do", method = RequestMethod.POST)
		public String find_id(HttpServletResponse response, @RequestParam("email") String email, Model md) throws Exception{
			System.out.println(email);
			md.addAttribute("id", memberService.find_id(response, email));
			return "/member/find_id";
		}
		
		
		// 비밀번호 찾기 폼
			@RequestMapping(value = "/member/find_pw_form.do")
			public String find_pw_form() throws Exception{
				return "/member/find_pw_form";
			}
				

				
			// 비밀번호 찾기
			@RequestMapping(value = "/member/find_pw.do", method = RequestMethod.POST)
			public String find_pw(HttpServletResponse response, @RequestParam("id") String id, Model md) throws Exception{
				System.out.println(id);
				md.addAttribute("password", memberService.find_pw(response, id));
				return "/member/find_pw";
			}
			
			//로그인 여	부 확인
			@RequestMapping(value ="/member/sessionCheck.do",method=RequestMethod.POST)
			@ResponseBody
			public String sessionCheck(HttpSession session) {
				String sessionLogin = (String)session.getAttribute("LoginId");
				System.out.println("sessionLogin"+sessionLogin);
				return sessionLogin;
			}
}





