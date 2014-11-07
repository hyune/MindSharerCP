<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="MemeberRegisterApp">
<head lang="en">
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.min.js"></script>
<script src="/mscp/js/memberregister.js"></script>
<script type="text/javascript">
	var isRedundancy = false;
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div ng-controller="InputRegisterController">
		<form name="UserForm">
			<div>
				ID : <input type="text" ng-model="user.uid"
					placeholder=" Enter a name ID"> {{id}}
				<button ng-click="redundancy(user.uid, isRedundancy)">click</button>
			</div>
			<div>
				NickName : <input type="text" ng-model="user.nickName"
					placeholder=" Enter The NickName">
			</div>
			<div>
				PassWord : <input type="password" ng-model="user.upw"
					placeholder=" Enter The passWord">
			</div>
			<div>
				RePassWord : <input type="password" 
					placeholder=" Enter The RePassWord">
			</div>
			<button type="submit" ng-click="submitData(user, 'submitResult')">comfirm</button>
		</form>

		<br>
		<textarea id="submitDebugText1">{{redundancyResult | json}}</textarea>
		<textarea id="submitDebugText2">{{submitResult | json}}</textarea>
	</div>
</body>
</html>