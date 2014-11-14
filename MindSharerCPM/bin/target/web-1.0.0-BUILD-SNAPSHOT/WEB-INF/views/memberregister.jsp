<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="MemeberRegisterApp">
<head lang="en">
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.min.js"></script>
<script src="/js/MemberRegisterCtrl.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div ng-controller="InputRegisterController">
		<form name="UserForm">
			<div>
				ID : <input type="text" ng-model="user.uid" name="id_input"
					ng-pattern="/^[a-z0-9]+$/" placeholder=" Enter a name ID"
					ng-minlength="3" ng-maxlength="8" required="true"
					ng-disabled="isRedundancy"> {{id}}
				<button ng-disabled="UserForm.id_input.$invalid"
					ng-click="redundancy(user.uid, isRedundancy)">중복체크</button>
				<span class="error" ng-show="UserForm.id_input.$error.pattern">
					영어와 숫자만 입력하세요.</span>
			</div>
			<div>
				NickName : <input type="text" ng-model="user.nickName"
					placeholder=" Enter The NickName">
			</div>
			<div>
				PassWord : <input type="password" ng-model="user.upw" name="pw"
					placeholder=" Enter The passWord" ng-minlength="4"  ng-maxlength="8"
					data-ng-class="{'ng-invalid':UserForm.repw.$error.match}">
			<span ng-show="UserForm.pw.$dirty && UserForm.pw.$invalid">비밀번호 4자 이상</span>
			</div>
			<div>
				RePassWord : <input type="password"
					placeholder=" Enter The RePassWord" ng-model="reupw"
					data-match="user.upw"
					name="repw" ng-minlength="4"  ng-maxlength="8">

			 <span ng-show="UserForm.repw.$error.match">Passwords do not match!</span>
			</div>
			<button type="submit" ng-disabled="!isRedundancy || UserForm.repw.$error.match" ng-click="submitData(user, 'submitResult')">comfirm</button>
		</form>

		<br>
		<textarea id="submitDebugText1">{{isRedundancy}}</textarea>
		<textarea id="submitDebugText2">{{submitResult | json}}</textarea>
	</div>
</body>
</html>
