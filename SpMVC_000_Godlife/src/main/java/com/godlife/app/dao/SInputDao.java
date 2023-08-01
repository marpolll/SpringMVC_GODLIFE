package com.godlife.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.godlife.app.model.SInputDto;

public interface SInputDao {


	public List<SInputDto> selectAll();

	
	public int sinsert(SInputDto sinputDto);

	@Select("SELECT * FROM tbl_schedule WHERE s_seq = #{c_seq}")
	public SInputDto findById(long s_seq);


	public int supdate(SInputDto sinputdto);

	@Update("UPDATE tbl_schedule SET s_useyn = 'N' WHERE s_seq = #{s_seq}")
	public int sdelete(String id);

	@Select(" SELECT * FROM tbl_schedule "
			+ " WHERE s_title LIKE CONCAT('%', #{stitle}, '%' )"
			+ " ORDER BY s_sdate ")
	public List<SInputDto> findBySTitle(String stitle);

	@Select("SELECT * FROM tbl_schedule WHERE s_useyn = 'Y' AND s_uemail = #{u_email} LIMIT #{limit} OFFSET #{offset} ")
	public List<SInputDto> selectPage(@Param("limit") int limit, 
			@Param("offset") int intPageNum,
			@Param("u_email") String u_email);

	
	@Select("SELECT COUNT(*) FROM tbl_schedule")
	public int selectCount();

	
	public int selectSearchCount(List<String> search);


	public List<SInputDto> selectSearchPage(
			@Param("limit") int limitCount,
			@Param("offset") int offsetNum,
			@Param("list") List<String> searchs);
	
	
}
