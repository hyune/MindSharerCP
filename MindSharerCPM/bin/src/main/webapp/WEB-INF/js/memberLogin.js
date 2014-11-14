/**
 * Created by karu on 2014-10-22.
 */

app.controller('loginchecker', function ($scope, $http)
{
	$scope.isIdChecked = false;
	$scope.isPwChecked = false;
	$scope.isIdPwChecked = false;
	
	//uid Legth 체크
	function isIdLenthgCheck (uid){
		return uid.length >=4;
	}
	
	function isIdPattern (uid){
		var regexp = "/^[a-z0-9]+$/"; 
		return /^[a-z0-9]+$/.test(uid);
	}

	function checkuIdInputValue (value){
		if (!value) return;

		if (isIdLenthgCheck(value)){
			console.log("id input success");
			 $scope.isIdChecked = true;
		}else{
			console.log("id input false");
			$scope.isIdChecked = false;
		}
		
		if ($scope.isIdChecked && $scope.isPwChecked) $scope.isIdPwChecked = true;
		else $scope.isIdPwChecked = false;
	}
	
	$scope.onIdChange = function (){
		checkuIdInputValue($scope.user.uid);
	}
	
	//upw Legth 체크
	function isPwLengthCheck (upw){
		return upw.length >=4;
	}
	
	function checkuPwInputValue (value){
		if (!value) return;
		
		if (isPwLengthCheck(value)){
			console.log("pw input success");
			 $scope.isPwChecked = true;
		}else{
			console.log("pw input false");
			$scope.isPwChecked = false;
		}
		
		if ($scope.isIdChecked && $scope.isPwChecked) $scope.isIdPwChecked = true;
		else $scope.isIdPwChecked = false;
	}
	
	$scope.onPwChange = function (){
		checkuPwInputValue($scope.user.upw);
	}

    $scope.sendLogin = function(uid, upw){
    	$http({
        	method : "POST",
        	url : "login",
        	data : { "uid" : uid  , "upw" :  upw}
        }).success(function (data, status, headers, config)
            {
        		if(data.status == 0 && data.result != null){
        			alert("로그인을 성공하셨습니다.");
        		}else{
        			alert("아이디와 비밀번호를 확인해주세여.");
        			$scope.uid = "";
        			$scope.upw = "";
        		}        		
        		
            })
            .error(function (data, status, headers, config)
            {
            	alert("로그인을 실패하였습니다.");
            });
    }
});
