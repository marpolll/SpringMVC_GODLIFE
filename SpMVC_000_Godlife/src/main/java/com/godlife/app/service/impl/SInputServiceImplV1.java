package com.godlife.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.godlife.app.dao.SInputDao;
import com.godlife.app.model.PageDto;
import com.godlife.app.model.SInputDto;
import com.godlife.app.service.SInputService;

@Service
public class SInputServiceImplV1 implements SInputService {

	protected final SInputDao sinputDao;
	
	public SInputServiceImplV1(SInputDao sinputDao) {
		this.sinputDao = sinputDao;
	}

	public int sinsert(SInputDto sinputDto) {
		
		
		return sinputDao.sinsert(sinputDto);
	}

	public List<SInputDto> selectAll() {
		
		return sinputDao.selectAll();
	}

	@Transactional
	public SInputDto findById(long c_seq) {
		
		SInputDto sinputDto = sinputDao.findById(c_seq);
		
		return sinputDto;
	}

	public int update(SInputDto sinputdto) {
		
		int result = sinputDao.supdate(sinputdto);
		return result;
	}

	public int delete(String id) {
		int result = sinputDao.sdelete(id);
		return result;
	}

//	public List<SInputDto> selectPage(String page) {
//		
//		try {
//			int intPageNum = Integer.valueOf(page);
////			intPageNum = (intPageNum -1) * 10;
//			intPageNum = --intPageNum * 10;
//
//			int intLimit = 10;
//			return sinputDao.selectPage(intLimit, intPageNum);
//
//		} catch (Exception e) {
//			return null;
//		}
//	}

	public void selectPage(String page, Model model, String u_email) {
		
	int totalCount = sinputDao.selectCount();
		
		int intPageNum = Integer.valueOf(page);

		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();

//		int offsetCount = (intPageNum - 1) * pageDto.getLimitCount();

		List<SInputDto> sinputs = sinputDao.selectPage(pageDto.getLimitCount(), pageDto.getOffsetNum(),u_email);

		model.addAttribute("SCHAS", sinputs);
		model.addAttribute("PAGI", pageDto);
		
	}

	public void selectPage(String page, Model model, String search, String u_email) {
		
		// 검색어를 빈칸을 기준으로 분해하기
		String[] searchs = search.split(" ");
		// 배열을 리스트 만들기
		List<String> searchList = Arrays.asList(searchs);
		
		int totalCount = sinputDao.selectSearchCount(searchList);
		int intPageNum = Integer.valueOf(page);
		
		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();
		
		List<SInputDto> sinputs = sinputDao.selectSearchPage(pageDto.getLimitCount(),
				pageDto.getOffsetNum(), searchList);

		model.addAttribute("SCHAS", sinputs);
		model.addAttribute("PAGI", pageDto);
		
	}

	public List<SInputDto> findBySTitle(String stitle) {
		
		return sinputDao.findBySTitle(stitle.trim());
	}

}
