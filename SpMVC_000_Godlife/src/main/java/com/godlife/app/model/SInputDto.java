package com.godlife.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class SInputDto {
	
	public long s_seq; //	bigint		PRIMARY KEY
	public String s_uemail; //	varchar(125)	NOT NULL	
	public String s_title; //	varchar(125)	NOT NULL	
	public String s_write; //	varchar(10)		
	public String s_sdate; //	varchar(10)		
	public String s_edate; //	varchar(10)		
	public int s_achieve; //	int		
	public int s_count; //	int		
	public String s_memo; // 	varchar(200)		
	public String s_share; //	varchar(2)	NOT NULL	
	public String s_useyn; //	varchar(2)	NOT NULL	


}
