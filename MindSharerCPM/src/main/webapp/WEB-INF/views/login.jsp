<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="/lib/onsenui/build/css/onsenui.css">
<link rel="stylesheet" href="/lib/onsenui/build/css/topcoat-mobile-onsen-ios7.css">
<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"/> -->
<link rel="stylesheet" href="/css/app.css" />
<link rel="stylesheet" href="/css/style.css" />

<script src="/lib/angular/angular.js"></script>
<script src="/lib/onsenui/build/js/onsenui.js"></script>
<script src="/js/app.js"></script>
<script src="/js/MemberRegisterCtrl.js"></script>
<script src="/js/memberLogin.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>

<body>
	<ons-screen>
	<ons-navigator title="login">
	<div class="login-form" ng-controller="loginchecker">
		<form name="UserForm">
			<input type="text" class="topcoat-text-input" placeholder="id" name="id_input"
				value="" ng-model="user.uid"
				ng-change="onIdChange()"
				style="display: block; width: 100%; margin-top: 8px;"
				/>
			 <input type="password"
				class="topcoat-text-input" placeholder="Password" value="" name="pw"
				ng-model="user.upw" style="display: block; width: 100%;" 
				ng-change="onPwChange()"/> <br>
			<br>
			<ons-button modifier="large" class="login-button" 
				ng-click="sendLogin(user.uid, user.upw)" disabled={{!isIdPwChecked}}>로그인</ons-button>
		</form>
		<ons-button modifier="quiet" class="login-button"  style="display: block; width: 100%; margin-top: 8px;"
			ng-click="ons.navigator.pushPage('/views/register.html', { animation : 'slide' } )">회원가입</ons-button>
	</div>

	</ons-navigator> 
	<ons-screen>
</body>
</html>
