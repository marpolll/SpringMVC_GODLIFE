package com.godlife.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {
	private long l_seq;//	bigint		PRIMARY KEY
	private String l_sDate;//	varchar(10)		
	private String l_eDate;//	varchar(10)		
	private long l_count;//	bigint		
}
