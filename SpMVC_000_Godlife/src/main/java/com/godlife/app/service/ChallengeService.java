package com.godlife.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.godlife.app.model.ChallengeDto;

public interface ChallengeService {

	public List<ChallengeDto> selectAll();
	public List<ChallengeDto> selectAll(String search);
	public int countChallenge(String u_email);
	
	public List<ChallengeDto> selectAll2();

}
