package com.godlife.app;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.godlife.app.model.ChallengeDto;
import com.godlife.app.model.UserDto;
import com.godlife.app.service.ChallengeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/challengeTest")
public class ChallengeTestController {
	
	protected final ChallengeService cService;
	public ChallengeTestController(ChallengeService cService) {
		this.cService = cService;
	}


	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		log.debug("유저정보 확인 : {}",session.getAttribute("USER_INFO"));
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
		int count = cService.countChallenge(uDto.getU_email());
		log.debug("(컨트롤러) 챌린지 카운트 : {}",count);
		if(count > 0){
			List<ChallengeDto> cList = cService.selectAll2();
			model.addAttribute("CHALLENGES" ,cList);
			return "challengeTest/main";
		}
		
		
		return "challengeTest/recommend";
	}
	
	
	@RequestMapping(value = {"/main"}, method = RequestMethod.GET)
	public String main(@ModelAttribute("CHALLENGE")ChallengeDto cDto, Model model) {
		
		
		

		return "challengeTest/main";
		
	}
	
	
//	@RequestMapping(value = {"/main"}, method = RequestMethod.POST)
//	public String main(@ModelAttribute("CHALLENGE")ChallengeDto cDto, Model model) {
//		
//		model.addAttribute("CHALLENGE" ,cDto);
//		List<ChallengeDto> cList = cService.selectAll();
//		model.addAttribute("CHALLENGES" ,cList);
//		
//
//		
//		return "challengeTest/main";
//		
//	}
//	

	@RequestMapping(value = {"/share"}, method = RequestMethod.GET)
	public String share(@RequestParam(name="search", required = false, defaultValue = "-1") String search, Model model) {
		List<ChallengeDto> cList = new ArrayList<ChallengeDto>();
		if(search.equals("-1")) {
			cList = cService.selectAll();
			search = "";
		} else {
			cList = cService.selectAll(search);
		}

//		log.debug("(컨트롤러) LIST DATA : {}",cList);
		model.addAttribute("SEARCH",search);
		model.addAttribute("CLIST",cList);
		return "challengeTest/share";
	}
	

}
