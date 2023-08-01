package com.godlife.app.dao;


import org.apache.ibatis.annotations.Select;

import com.godlife.app.model.UserDto;

public interface MemberDao {
	public int pwCheck(UserDto uDto);
	public int joinSave(UserDto uDto);
	public int findById(UserDto bDto);
	public int findIdByTel(String tel);

	@Select(" SELECT * FROM tbl_user WHERE u_email = #{u_email} ")
	public UserDto userInfo(UserDto bDto);
}
