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
public class CInputDto {
	
	public long c_seq; //	bigint		PRIMARY KEY
	public String c_uemail; //	varchar(125)	NOT NULL	
	public String c_title; //	varchar(125)	NOT NULL	
	public String c_write; //	varchar(10)		
	public String c_sdate; //	varchar(10)		
	public String c_edate; //	varchar(10)		
	public int c_achieve; //	int		
	public int c_count; //	int		
	public String c_memo; // 	varchar(200)		
	public String c_share; //	varchar(2)	NOT NULL	
	public String c_useyn; //	varchar(2)	NOT NULL	

}
