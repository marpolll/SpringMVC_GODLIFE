use godlifeDB;

CREATE TABLE tbl_user(
	u_email	varchar(125)			PRIMARY KEY,
	u_password	varchar(125)	NOT NULL,	
	u_name	varchar(20)		,
	u_nickname	varchar(20)		,
	u_tel	varchar(13)		NOT NULL	,
	u_birth	varchar(10)		,
	u_auth	varchar(2)		NOT NULL	,
	u_useyn	varchar(2)		NOT NULL	
);

CREATE TABLE tbl_plan(
	p_code	varchar(6)		PRIMARY KEY,
	p_name	varchar(50)	NOT NULL	,
	p_useyn	varchar(2)	NOT NULL	
);

CREATE TABLE tbl_log(
	l_seq	bigint		PRIMARY KEY,
	l_sDate	varchar(10)		,
	l_eDate	varchar(10)		,
	l_count	int		
);

DROP TABLE tbl_challenge;
CREATE TABLE tbl_challenge(
	c_seq		bigint			PRIMARY KEY AUTO_INCREMENT,
	c_pcode		varchar(6)		NOT NULL	,
	c_uemail	varchar(125)	NOT NULL	,
	c_title		varchar(50)	NOT NULL	,
	c_write		varchar(10)		,
	c_sdate		varchar(10)		,
	c_edate		varchar(10)		,
	c_achieve	int		,
	c_count		int		,
	c_memo      varchar(200)	,	
	c_share		varchar(2)		NOT NULL	,
	c_useyn		varchar(2)		NOT NULL	
);

DROP TABLE tbl_schedule;
CREATE TABLE tbl_schedule(
	s_seq		bigint			PRIMARY KEY AUTO_INCREMENT,
	s_pcode		varchar(6)		NOT NULL	,
	s_uemail	varchar(125)	NOT NULL	,
	s_title		varchar(50)	NOT NULL	,
	s_write		varchar(10)		,
	s_sdate		varchar(10)		,
	s_edate		varchar(10)		,
	s_achieve	int		,
	s_count		int		,
	s_memo      varchar(200)	,
	s_share		varchar(2)		NOT NULL	,
	s_useyn		varchar(2)		NOT NULL	

);