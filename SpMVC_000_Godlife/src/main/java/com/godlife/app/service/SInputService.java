package com.godlife.app.service;

import java.util.List;

import org.springframework.ui.Model;

import com.godlife.app.model.SInputDto;

public interface SInputService {

	public int sinsert(SInputDto sinputDto);

	public List<SInputDto> selectAll();
	
//	public List<SInputDto> selectPage(String page);

	public void selectPage(String page, Model model, String u_email);
	public void selectPage(String page, Model model, String search, String u_email);
	
	public List<SInputDto> findBySTitle(String stitle);

	
	public SInputDto findById(long s_seq);

	public int update(SInputDto sinputdto);

	public int delete(String id);

}
