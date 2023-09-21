<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>penguin gram 회원가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style2.css"  type="text/css">
</head>
<body>

	<div id="wrap">
		<header id="head" class="bg-secondary">
			<div>penguingram</div>
		</header>
		
		
		<section class="d-flex">
				
					<div class=" col-4"></div>
					<div class="bg-success col-4">
						<div class="input-box my-5">
							<h1 class="text-center">회원 가입</h1>
							
								<div class="d-flex">
									<input type="text" placeholder="아이디" class="form-control mt-4" id="loginInput">
									<button type="button" class="btn btn-xs btn-info ml-3">중복확인</button>
								</div>
								
								
							<input type="password" placeholder="비밀번호" class="form-control mt-4" id="passwordInput">
							<input type="password" placeholder="비밀번호 확인" class="form-control mt-4" id="passwordConfirmInput">
							<input type="text" placeholder="이름" class="form-control mt-4" id="nameInput">
							<input type="text" placeholder="이메일" class="form-control mt-4" id="emailInput">
							<button type="button" class="btn btn-secondary btn-block mt-4" id="joinBtn">가입</button>
						</div>
					
					</div>
					<div class=" col-4"></div>
				
		
		</section>
		
		
		
		<footer class="bg-warning">
			<div>Copyright © penguin gram 2023</div>
		</footer>
	
	</div>









	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	


</body>
</html>