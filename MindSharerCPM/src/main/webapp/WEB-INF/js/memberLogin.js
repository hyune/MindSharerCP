/**
 * Created by karu on 2014-10-22.
 */

angular.module('myApp', ['onsen.directives']).controller('loginchecker', function ($scope, $http)
{
    $scope.person1 = {};

    $scope.sendLogin = function(uid, upw){
    	$http({
        	method : "POST",
        	url : "login",
        	data : { "uid" : uid  , "upw" :  upw}
        }).success(function (data, status, headers, config)
            {
        		if(data.status == 0 && data.result == "Y"){
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