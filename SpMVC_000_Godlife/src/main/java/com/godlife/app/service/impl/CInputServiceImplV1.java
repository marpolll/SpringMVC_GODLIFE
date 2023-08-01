package com.godlife.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.godlife.app.dao.CInputDao;
import com.godlife.app.model.CInputDto;
import com.godlife.app.model.PageDto;
import com.godlife.app.service.CInputService;

@Service
public class CInputServiceImplV1 implements CInputService {

	protected final CInputDao cinputDao;
	
	public CInputServiceImplV1(CInputDao cinputDao) {
		this.cinputDao = cinputDao;
	}

	public int cinsert(CInputDto cinputDto) {
		
		
		return cinputDao.cinsert(cinputDto);
	}

	public List<CInputDto> selectAll() {
		
		return cinputDao.selectAll();
	}

	@Transactional
	public CInputDto findById(long c_seq) {
		
		CInputDto cinputDto = cinputDao.findById(c_seq);
		
		return cinputDto;
	}

	public int update(CInputDto cinputdto) {
		
		int result = cinputDao.update(cinputdto);
		return result;
	}

	public int delete(String c_seq) {
		int result = cinputDao.delete(c_seq);
		return result;
	}

//	public List<CInputDto> selectPage(String page) {
//		
//		try {
//			int intPageNum = Integer.valueOf(page);
////			intPageNum = (intPageNum -1) * 10;
//			intPageNum = --intPageNum * 10;
//
//			int intLimit = 10;
//			return cinputDao.selectPage(intLimit, intPageNum);
//
//		} catch (Exception e) {
//			return null;
//		}
//	}
	
	
	public void selectPage(String page, Model model, String u_email) {


		int totalCount = cinputDao.selectCount();
		
		int intPageNum = Integer.valueOf(page);

		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();

//		int offsetCount = (intPageNum - 1) * pageDto.getLimitCount();

		List<CInputDto> cinputs = cinputDao.selectPage(pageDto.getLimitCount(), pageDto.getOffsetNum(),u_email);

		model.addAttribute("CHALLS", cinputs);
		model.addAttribute("PAGI", pageDto);
		
	}

	public void selectPage(String page, Model model, String search, String u_email) {
		
		// 검색어를 빈칸을 기준으로 분해하기
				String[] searchs = search.split(" ");
				// 배열을 리스트 만들기
				List<String> searchList = Arrays.asList(searchs);
				
				int totalCount = cinputDao.selectSearchCount(searchList);
				int intPageNum = Integer.valueOf(page);
				
				PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();
				
				List<CInputDto> cinputs = cinputDao.selectSearchPage(pageDto.getLimitCount(),
						pageDto.getOffsetNum(), searchList);

				model.addAttribute("CHALLS", cinputs);
				model.addAttribute("PAGI", pageDto);
		
	}

	public List<CInputDto> findByCTitle(String ctitle) {
		
		
		return cinputDao.findByCTitle(ctitle.trim());
	}

}
