<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>My App</title>
<link rel="stylesheet" href="/lib/onsenui/build/css/onsenui.css">
<link rel="stylesheet" href="/lib/onsenui/build/css/topcoat-mobile-onsen-ios7.css">
<link rel="stylesheet" href="/css/app.css" />
<link rel="stylesheet" href="/css/style.css" />

<script src="/lib/angular/angular.js"></script>
<script src="/js/app.js"></script>
<script src="/lib/onsenui/build/js/onsenui.js"></script>
<script src="/js/memberLogin.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
	<ons-page> <ons-navigator title="Login" var="myNavigator">
	<div class="login-form" ng-controller="loginchecker">
		<form name="UserForm">
			<input type="text" class="topcoat-text-input" placeholder="id" name="id_input"
				value="" ng-model="user.uid"
				style="display: block; width: 100%; margin-top: 8px;"
				ng-pattern="/^[a-z0-9]+$/" />
			 <input type="password"
				class="topcoat-text-input" placeholder="Password" value="" name="pw"
				ng-model="user.upw" style="display: block; width: 100%;" 
				ng-minlength="4"  ng-maxlength="8" /> <br>
			<br>
			<ons-button modifier="large" class="login-button" 
				ng-click="sendLogin(user.uid, user.upw)" disabled={{UserForm.id_input.$error.pattern}}>로그인</ons-button>
		</form>
		<br> <br>
		<ons-button modifier="quiet">비번찾기</ons-button>
		<ons-button modifier="quiet"
			ng-click="ons.navigator.pushPage('/views/page2.html', { animation : 'slide' } )">회원가입</ons-button>
	</div>

	</ons-navigator> </ons-page>
</body>
</html>
