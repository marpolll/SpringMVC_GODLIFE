package com.godlife.app.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.godlife.app.dao.MemberDao;
import com.godlife.app.model.UserDto;
import com.godlife.app.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

	private final MemberDao mDao;

	public MemberServiceImpl(MemberDao mDao) {
		this.mDao = mDao;
	}

	@Override
	public String loginCheck(UserDto uDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int result = 0;
		
		// ID 있는지 체크
		result = mDao.findById(uDto);
		if(result < 1) {
			return "EXIST";
		}
		
		// PW 맞는지 체크		
		result = mDao.pwCheck(uDto);
		if(result < 1){
			return "WRONGPW";
		}else {
			uDto = mDao.userInfo(uDto);
			session.setAttribute("USER_INFO", uDto);
			return "YES";
		}
	}

	@Override
	public UserDto findById(UserDto uDto) {
		int result = mDao.findById(uDto);
		if(result > 0) {
			uDto.setU_email("USE_EMAIL");
		}
		return uDto;
	}
	
	@Override
	public String joinSave(UserDto uDto) {
		log.debug("(서비스)세이브 데이터 체크 : {}",uDto);

		// DATA SAVE
		int result = mDao.joinSave(uDto);
		log.debug("SAVE 체크 : {}",result);
		if(result > 0) {
			return "SAVE";
		}else {
			return "ERROR";
		}
	}

	@Override
	public String findIdByTel(String tel) {
		int result = 0;
		// ID 있는지 체크
		result = mDao.findIdByTel(tel);
		if(result > 0) {
			return "EXIST";
		}
		return null;
	}



}
