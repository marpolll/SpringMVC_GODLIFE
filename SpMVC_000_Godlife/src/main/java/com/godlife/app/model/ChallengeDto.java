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
public class ChallengeDto {
	private long c_seq;//		bigint			PRIMARY KEY auto_increment,
	private String c_pcode;//		varchar(6)		,
	private String c_uemail;//	varchar(125)	NOT NULL	,
	private String c_title;//
	private String c_memo;//		varchar(125)	NOT NULL	,
	private String c_sdate;//		varchar(10)		,
	private String c_edate;//		varchar(10)		,
	private int c_achieve;//	int		,
	private int c_count;//		int		,
	private String c_share;//		varchar(2)		NOT NULL	,
	private String c_useyn;//		varchar(2)		NOT NULL	
	
	private String u_nickname;// 유저Table의 닉네임
	private String star;// 공유하기 star 갯수
}
