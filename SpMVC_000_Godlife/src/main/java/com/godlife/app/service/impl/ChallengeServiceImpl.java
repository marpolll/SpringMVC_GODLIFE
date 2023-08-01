package com.godlife.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.godlife.app.dao.ChallengeDao;
import com.godlife.app.model.ChallengeDto;
import com.godlife.app.service.ChallengeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChallengeServiceImpl implements ChallengeService{

	protected final ChallengeDao cDao;
	public ChallengeServiceImpl(ChallengeDao cDao) {
		this.cDao = cDao;
	}

	@Override
	public List<ChallengeDto> selectAll() {
		return cDao.selectAll();
	}
	

	@Override
	public List<ChallengeDto> selectAll(String search) {
		return cDao.selectSearchAll(search);
	}

	@Override
	public int countChallenge(String u_email) {
		return cDao.countChallenge(u_email);
	}

	@Override
	public List<ChallengeDto> selectAll2() {
		return cDao.selectAll2();
	}
	
}
