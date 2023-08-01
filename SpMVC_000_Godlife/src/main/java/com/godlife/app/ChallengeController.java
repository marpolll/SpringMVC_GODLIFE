package com.godlife.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godlife.app.model.CInputDto;
import com.godlife.app.model.SInputDto;
import com.godlife.app.model.UserDto;
import com.godlife.app.service.CInputService;
import com.godlife.app.service.SInputService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/challenge")

public class ChallengeController {
	
	protected final CInputService cinputService;
	protected final SInputService sinputService;

	public ChallengeController(CInputService cinputService, SInputService sinputService) {
		this.cinputService = cinputService;
		this.sinputService = sinputService;
	}

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		log.debug("유저정보 확인 : {}",session.getAttribute("USER_INFO"));
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
		return "/challenge/home";
	}
	
	@RequestMapping(value = "/cinsert", method = RequestMethod.GET)
	public String cinsert(@ModelAttribute("CINP")CInputDto cinputDto, @ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
		return "/challenge/cinput";
	}

	@RequestMapping(value = "/cinsert", method = RequestMethod.POST, 
			produces = "text/html;charset=UTF-8")
	public String insert(@ModelAttribute("CINP") CInputDto cinputDto, 
			Model model, 
			@ModelAttribute("USER") UserDto uDto,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		
		cinputDto.setC_uemail(uDto.getU_email());
		log.debug("데이터확인 : {}",cinputDto);
		cinputService.cinsert(cinputDto);

		return "redirect:/challenge/list";
	}
	
	@RequestMapping(value = "/sinsert", method = RequestMethod.GET)
	public String sinsert(@ModelAttribute("SINP")SInputDto sinputDto, 
			@ModelAttribute("USER") UserDto uDto, 
			Model model,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
		return "/challenge/sinput";
	}

	@RequestMapping(value = "/sinsert", method = RequestMethod.POST, 
			produces = "text/html;charset=UTF-8")
	public String sinsert(@ModelAttribute("SINP") SInputDto sinputDto, 
			Model model, 
			@ModelAttribute("USER") UserDto uDto,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		
		sinputDto.setS_uemail(uDto.getU_email());
		log.debug("데이터확인 : {}",sinputDto);
		sinputService.sinsert(sinputDto);
		
		return "redirect:/challenge/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("CINP")CInputDto cinputDto, 
			@ModelAttribute("SINP")SInputDto sinputDto,
			@RequestParam(name="page" , required = false , defaultValue = "1") String page,
			@RequestParam(name="search" , required = false , defaultValue = "-1") String search,
			@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
//		List<CInputDto> cinputList = cinputService.selectAll();
//		List<SInputDto> sinputList = sinputService.selectAll();
		
		if(search.equals("-1")) {
			cinputService.selectPage(page, model,uDto.getU_email());
			sinputService.selectPage(page, model,uDto.getU_email());
		} else {
			cinputService.selectPage(page, model, search,uDto.getU_email());
			sinputService.selectPage(page, model, search,uDto.getU_email());
		}
		
		model.addAttribute("SEARCH", search);
//		model.addAttribute("CHALLS", cinputList);
//		model.addAttribute("SCHAS", sinputList);
		
		
		
		return "/challenge/list";
		
	}
	
	@RequestMapping(value = "/slist", method = RequestMethod.GET)
	public String slist(@ModelAttribute("CINP")CInputDto cinputDto, 
			@ModelAttribute("SINP")SInputDto sinputDto,
			@RequestParam(name="page" , required = false , defaultValue = "1") String page,
			@RequestParam(name="search" , required = false , defaultValue = "-1") String search,
			@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
//		List<CInputDto> cinputList = cinputService.selectAll();
//		List<SInputDto> sinputList = sinputService.selectAll();
		
		if(search.equals("-1")) {
			cinputService.selectPage(page, model,uDto.getU_email());
			sinputService.selectPage(page, model,uDto.getU_email());
		} else {
			cinputService.selectPage(page, model, search,uDto.getU_email());
			sinputService.selectPage(page, model, search,uDto.getU_email());
		}
		
		model.addAttribute("SEARCH", search);
//		model.addAttribute("CHALLS", cinputList);
//		model.addAttribute("SCHAS", sinputList);
		

		
		return "/challenge/slist";
		
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("CINP") CInputDto cinputDto,
			@RequestParam(value="c_seq", 
			required = false, 
			defaultValue = "0") 
	long c_seq, 
	@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {

		cinputDto = cinputService.findById(c_seq);

		model.addAttribute("CINP", cinputDto);

		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
		return "/challenge/detail";
	}
	
	@RequestMapping(value = "/sdetail", method = RequestMethod.GET)
	public String sdetail(@ModelAttribute("SINP") SInputDto sinputDto,
			@RequestParam(value="s_seq", 
			required = false, 
			defaultValue = "0") 
			long s_seq, 
			@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {

		sinputDto = sinputService.findById(s_seq);

		// SELECT 된 주소를 model에 담아서 view 로 전달
		model.addAttribute("SINP", sinputDto);

		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}
		
		return "/challenge/sdetail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("CINP") CInputDto cinputdto, @RequestParam(value="c_seq", 
			required = false, 
			defaultValue = "0") 
			long c_seq,
			@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {

		// 변경할 주소 데이터 SELETE 하여 model 에 담기
		CInputDto cinputDto = cinputService.findById(c_seq);
		model.addAttribute("CINP", cinputDto);

		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}

		return "/challenge/update";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String update(@ModelAttribute("CINP") CInputDto cinputdto) {
		
		int result = cinputService.update(cinputdto);

		long c_seq = cinputdto.getC_seq();
		if (result > 0) {
			return "redirect:/challenge/detail?c_seq=" + c_seq;
		} else {
			return "redirect:/challenge/update?c_seq=" + c_seq;
		}
	}
	
	@RequestMapping(value = "/supdate", method = RequestMethod.GET)
	public String supdate(@ModelAttribute("SINP") SInputDto sinputDto,
			@RequestParam(value="s_seq", 
			required = false, 
			defaultValue = "0") 
			long s_seq,
			@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {

		// 변경할 주소 데이터 SELETE 하여 model 에 담기
		sinputDto = sinputService.findById(s_seq);
		model.addAttribute("SINP", sinputDto);

		HttpSession session = request.getSession();
		uDto = (UserDto) session.getAttribute("USER_INFO");
		if(uDto == null) {
			return "member";
		}

		return "/challenge/supdate";

	}

	@RequestMapping(value = "/supdate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String supdate(@ModelAttribute SInputDto sinputdto) {
		int result = sinputService.update(sinputdto);

		long s_seq = sinputdto.getS_seq();
			// update 가 성공하면 detail 화면을 보여서 변경 된것을 확인
		if (result > 0) {
			return "redirect:/challenge/sdetail?id=" + s_seq;
			// update 가 실패하면 다시 update 화면으로 보내서 다시 변경하기
		} else {
			return "redirect:/challenge/supdate?id=" + s_seq;
		}
	}
	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String delete(@ModelAttribute("CINP") CInputDto cinputdto, @RequestParam(value="c_seq", 
//			required = false, 
//			defaultValue = "0") 
//			long c_seq,
//			@ModelAttribute("USER") UserDto uDto, Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		uDto = (UserDto) session.getAttribute("USER_INFO");
//		if(uDto == null) {
//			return "member";
//		}
//		
//		int result = cinputService.delete(c_seq);
//		CInputDto cinputDto = cinputService.findById(c_seq);
//		model.addAttribute("CINP", cinputDto);
//
//		
//
//		return "/challenge/list";
//
//	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String c_seq) {
		
		int result = cinputService.delete(c_seq);

		if (result > 0) {
			return "redirect:/challenge/list";
		} else {
			return "redirect:/challenge/detail?id=" + c_seq;
		}

	}
	
	@RequestMapping(value = "/sdelete", method = RequestMethod.GET)
	public String sdelete(String s_seq) {

		int result = sinputService.delete(s_seq);

		if (result > 0) {
			return "redirect:/challenge/list";
		} else {
			return "redirect:/challenge/sdetail?id=" + s_seq;
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/title/search", method = RequestMethod.GET,
	produces = "application/json;charset=UTF-8")
	public List<CInputDto> cTitleSearch(
			@RequestParam(name= "c_title", required = false, defaultValue = "-1") String ctitle) {
		
		if(ctitle.equals("-1")) {
			return null;
		}
		
		log.debug("받은타이틀 {} ", ctitle);
		
		List<CInputDto> cList = cinputService.findByCTitle(ctitle);
		
		return cList;
	}
	
	
	
	
	@ModelAttribute("CINP")
	public CInputDto cinputDto() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);

		CInputDto cinputDto = CInputDto.builder()
					 	.c_uemail("")
					 	.c_title("")
					 	.c_write(strDate)
					 	.c_sdate("")
					 	.c_edate("")
					 	.c_achieve(0)
					 	.c_count(0)
					 	.c_memo("")
					 	.c_share("")
					 	.c_useyn("")
						.build();
		return cinputDto;
		
	}
	
	@ModelAttribute("SINP")
	public SInputDto sinputDto() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		String strDate = dateFormat.format(date);
		String strTime = timeFormat.format(date);

		SInputDto sinputDto = SInputDto.builder()
				.s_uemail("")
				.s_title("")
				.s_write(strDate)
				.s_sdate("")
				.s_edate("")
				.s_achieve(0)
				.s_count(0)
				.s_memo("")
				.s_share("")
				.s_useyn("")
				.build();
		return sinputDto;
		
	}
	
}
