package com.godlife.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.godlife.app.model.ChallengeDto;

public interface ChallengeDao {
	
	public List<ChallengeDto> selectAll();
	public List<ChallengeDto> selectSearchAll(String search);
	public int countChallenge(String u_email);
	@Select (" select "
			+ "c_seq, c_uemail,c_title,c_memo,c_write, "
			+ " c_sdate,c_edate, IFNULL(c_achieve,(TIMESTAMPDIFF(DAY , c_sdate, c_edate)+1))AS c_achieve "
			+ ",c_count,c_share,c_useyn "
			+ " from tbl_challenge "
			+ " left join tbl_user "
			+ " on c_uemail = u_email ")
	public List<ChallengeDto> selectAll2();
	

}
