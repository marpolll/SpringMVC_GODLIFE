<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="phone_size">
	<div class="title">
		<div>회원가입</div>
	</div>
	<div class="contain">
		<form class="main" method="POST" action="${rootPath}/member/join_save">
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="u_email"> 
						<i class="fa fa-envelope" aria-hidden="true"></i> <!-- <i class="fa fa-envelope-o" aria-hidden="true"></i> -->
					</label>
				</span> 
				<input class="login_input" id="u_email" name="u_email" placeholder="이메일" />
			</div>
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="u_password"> 
						<i class="fa fa-unlock-alt" aria-hidden="true"></i>
					</label>
				</span>
				<input class="login_input" id="u_password" name="u_password" type="password" placeholder="비밀번호" />
			</div>
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="re_password"> 
						<i class="fa fa-unlock-alt" aria-hidden="true"></i>
					</label>
				</span> 
				<input class="login_input" id="re_password" type="password" placeholder="비밀번호 확인" />
			</div>
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="u_name"> 
						<i class="fa fa-user" aria-hidden="true"></i> <!-- <i class="fa fa-mobile fa-lg" aria-hidden="true"></i> -->
					</label>
				</span> 
				<input class="login_input" id="u_name" name="u_name" placeholder="이름" />
			</div>
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="u_nickname"> 
						<i class="fa fa-user" aria-hidden="true"></i> <!-- <i class="fa fa-mobile fa-lg" aria-hidden="true"></i> -->
					</label>
				</span> 
				<input class="login_input" id="u_nickname" name="u_nickname" placeholder="닉네임" />
			</div>
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="u_tel"> <iclass="fa fa-mobile fa-lg" aria-hidden="true"></i></label>
				</span> 
				<input class="login_input" id="u_tel" name="u_tel" placeholder="전화번호 ex)010-0000-0000" />
			</div>
			<div class="msg_div checked_box"></div>
			<div class="contain_box">
				<span class="icon-box"> 
					<label for="u_birth"> 
						<i class="fa fa-birthday-cake" aria-hidden="true"></i> <!-- <i class="fa fa-calendar-o" aria-hidden="true"></i> -->
					</label>
				</span> 
				<input class="login_input" id="u_birth" name="u_birth" placeholder="생년월일 ex)1994-01-01" />
			</div>
			<div class="contain_box">
				<button class="login_button" id="login_btn" type="button">가입하기</button>
			</div>
		</form>
	</div>
</div>
