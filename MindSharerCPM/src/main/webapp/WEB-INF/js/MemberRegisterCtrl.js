/**
 * Created by karu on 2014-10-22.
 */

app.directive('match', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        scope: {
            match: '='
        },
        link: function(scope, elem, attrs, ctrl) {
            scope.$watch(function() {
                var modelValue = ctrl.$modelValue || ctrl.$$invalidModelValue;
                return (ctrl.$pristine && angular.isUndefined(modelValue)) || scope.match === modelValue;
            }, function(currentValue) {
                ctrl.$setValidity('match', currentValue);
            });
        }
    };
});


app.controller('InputRegisterController', function ($scope, $http)
{
    $scope.person1 = {};

    $scope.redundancy = function(uid, isRedundancy){
        $http({
            method : "POST",
            url : "non/adduser/redundancy",
            data : { "uid" : uid }
        }).success(function (data, status, headers, config)
        {
            if(data.status == 0 && dㅁata.result == "Y"){
            	alert("사용 가능한 아이디 입니다.");
                $scope.isRedundancy = true;
            }else{
            	alert("중복된 아이디가 있습니다.");
            	$scope.isRedundancy = false;
            }
           
        })
            .error(function (data, status, headers, config)
            {
                $scope.isRedundancy = false;
            });
    }

    $scope.submitData = function (user, resultVarName , isRedundancy)
    {
    	if (isRedundancy){
    		 alert("아이디중복을 체크해주세요");
    		return;
    	}
    	
        $http({
            method : "POST",
            url : "non/adduser/result",
            headers : "application/json",
            data : user
        }).success(function (data, status, headers, config)
        {
        	 if(data.status == 0){
        		 alert("회원가입을 축하드립니다.");
        	 }
        })
        .error(function (data, status, headers, config)
        {
        	 alert("알수 없는 오류");
        });
    };
});
