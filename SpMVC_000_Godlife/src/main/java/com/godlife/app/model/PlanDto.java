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
public class PlanDto {
	private String p_code;//	varchar(6)		PRIMARY KEY
	private String p_name;//	varchar(50)	NOT NULL	
	private String p_useyn;//	varchar(2)	NOT NULL	
}
