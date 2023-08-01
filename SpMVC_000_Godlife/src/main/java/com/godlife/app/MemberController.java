package com.godlife.app;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.godlife.app.dao.MemberDao;
import com.godlife.app.model.UserDto;
import com.godlife.app.service.MailService;
import com.godlife.app.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/member")
@SessionAttributes("USER")
public class MemberController {
	@Autowired
	private MailService mailService;
	private final MemberService memberService;

	public MemberController(MemberDao mDao, MemberService memberService) {
		this.memberService = memberService;
	}

	@ResponseBody
	@RequestMapping(value = "/login_check", method = RequestMethod.GET)
	public String login_check(UserDto uDto, Model model, HttpServletRequest request) {
		log.debug("(컨트롤러)USER CHECK : {}",uDto);
		String result = memberService.loginCheck(uDto,request);
		return result;
	}	

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY","JOIN");
		return "member";
	}
	
	@ResponseBody
	@RequestMapping(value = "/id_check", method = RequestMethod.GET)
	public UserDto idCheck(@ModelAttribute("USER") UserDto uDto, Model model) {
		log.debug("(컨트롤러)ID CHECK : {}",uDto);
		uDto = memberService.findById(uDto);
		return uDto;
	}

	@RequestMapping(value = "/join_save", method = RequestMethod.POST)
	public String join_save(@ModelAttribute("USER") UserDto uDto, Model model) {
		log.debug("(컨트롤러)세이브 데이터 체크 : {}",uDto);
		String result = memberService.joinSave(uDto);
		return "member";
	}
	
	
	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findId(Model model) {
		model.addAttribute("BODY","FINDID");
		return "member";
	}
	
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPw(Model model) {
		model.addAttribute("BODY","FINDPW");
		return "member";
	}

	@RequestMapping("/findId/search")
	@ResponseBody
	public String searchId(String tel) throws Exception {
//		log.debug("확인 : {}",tel);
		String result = memberService.findIdByTel(tel);
		
		return result;
	}
	

	
	@RequestMapping("/findId/sendMail")
	@ResponseBody
	public String sendEmail(String tel, String email) throws Exception {
		ModelAndView mv = new ModelAndView();
//		String id, 
		log.debug("확인 : {}",tel);
		String addr = email;
		String subject = "[😀😀] 알림메일 입니다.";
		String body = "안녕하세요 SMTP메일 테스트입니다.";
		
		mailService.sendEmail(email, addr, subject, body);
		
		mv.setViewName("/");
		String result = "FAIL";
		return result;
	}
	
	
	
	@ModelAttribute("USER")
	public UserDto uDto() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);
		int intYear = Integer.valueOf(strDate);
		return UserDto.builder().build();
	}
	
}
