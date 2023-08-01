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
public class ScheduleDto {
	private long s_seq;//		bigint			PRIMARY KEY auto_increment,
	private String s_pcode;//		varchar(6)		,
	private String s_uemail;//	varchar(125)	NOT NULL	,
	private String s_title;//
	private String s_memo;//		varchar(125)	NOT NULL	,
	private String s_sdate;//		varchar(10)		,
	private String s_edate;//		varchar(10)		,
	private int s_achieve;//	int		,
	private int s_count;//		int		,
	private String s_share;//		varchar(2)		NOT NULL	,
	private String s_useyn;//		varchar(2)		NOT NULL	
	
	private String u_nickname;// 유저Table의 닉네임
	private String star;// 공유하기 star 갯수
}
