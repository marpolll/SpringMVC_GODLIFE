package com.godlife.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private String u_email;//	varchar(125)		PRIMARY KEY
	private String u_password;//	varchar(125)	NOT NULL	
	private String u_name;//	varchar(20)		
	private String u_nickname;//	varchar(20)		
	private String u_tel;//	varchar(13)	NOT NULL	
	private String u_birth;//	varchar(10)		
	private String u_auth;//	varchar(2)	NOT NULL	
	private String u_useyn;//	varchar(2)	NOT NULL	
}
