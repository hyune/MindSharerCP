/**
 * Created by karu on 2014-11-12.
 */
app.controller('logincheck', function ($scope, $http)
{
    $scope.person1 = {};

    $scope.redundancy = function(uid, isRedundancy){
        $http({
            method : "POST",
            url : "http://192.168.1.28:8080/mscp/adduser/redundancy",
            data : { "uid" : uid }
        }).success(function (data, status, headers, config)
        {
            if(data.status == "0"){
                confirm("로그인성공.");
            }
            $scope[isRedundancy] = true;
        })
            .error(function (data, status, headers, config)
            {
                $scope[isRedundancy] = false;
            });
    }

    $scope.submitData = function (user, resultVarName)
    {
        $http({
            method : "POST",
            url : "http://192.168.1.28:8080/mscp/adduser/result",
            headers : "application/json",
            data : user
        }).success(function (data, status, headers, config)
        {
            $scope[resultVarName] = data;
        })
            .error(function (data, status, headers, config)
            {
                $scope[resultVarName] = "SUBMIT ERROR";
            });
    };
});