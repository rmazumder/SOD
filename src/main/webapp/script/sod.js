var app = angular.module('sodApp', [], ['$httpProvider', function ($httpProvider) {
    /// $httpProvider.defaults.headers.common['X-Parse-Application-Id'] = 'CdtHCpaXixz7bwudAlWvvO12HiMaWqGOUbjDPPBC';
    /// $httpProvider.defaults.headers.common['X-Parse-REST-API-Key'] = 'IxMctPQYe9WCvRiyFL6aXEDpBpBfbLCx3Dh2oo4j';
	
	 $httpProvider.responseInterceptors.push('myHttpInterceptor');
	 $httpProvider.interceptors.push('authHttpResponseInterceptor');
	 var spinnerFunction = function spinnerFunction(data, headersGetter) {
		    $("#spinner").show();
		    return data;
		  };

	$httpProvider.defaults.transformRequest.push(spinnerFunction);
}]);

app.controller('SodAdminController', ['$scope', '$http','$filter', function ($scope, $http, $filter) {
	
		//$scope.userform_template = {userName:'',firstName:'',lastName:'', isScrumMaster:false,password:''};
		$scope.userform = {userName:'',firstName:'',lastName:'', isScrumMaster:false,password:''};
		$scope.selectedTeam = 0;
		$scope.loadAdminData =  function(){
			 $http.get('rest/admin/load').success(function (data) {
		        	$scope.teams = data;		         
		        });
		}
		
		
		$scope.addTeam = function(){
			$http.post('rest/admin/addteam', {teamName:$("#teamName").val(), description:$("#description").val()}).
	    	  success(function(data, status, headers, config) {
		    	   if(data.code == 0){
		    		   $("#AddTeamModel").modal('hide');
		    		   $("#teamName").val("");
		    		   $("#description").val("")
		    		   $scope.loadAdminData();
		    	   } else {
		    		   $("#AddTeamModel_error").show();
		    		   $("#AddTeamModel_errorText").text(data.message);
		    		   
		    	   }
	    	  }).
	    	  error(function(data, status, headers, config) {
		    	    // called asynchronously if an error occurs
		    	    // or server returns response with an error status.
	    	  });
		}
		
		$scope.addUser = function(){
			
			$http.post('rest/admin/adduser/'+$scope.teams[$scope.selectedTeam].teamName, $scope.userform).
	    	  success(function(data, status, headers, config) {
		    	   if(data.code == 0){
		   			   $scope.userform = {userName:'',firstName:'',lastName:'', isScrumMaster:false,password:''};

		    		   $("#AddUserModel").modal('hide');
		    		 
		    	   } else {
		    		  
		    		   
		    	   }
	    	  }).
	    	  error(function(data, status, headers, config) {
		    	    // called asynchronously if an error occurs
		    	    // or server returns response with an error status.
	    	  });
		}
		
		$scope.selectTeam =  function(index){
			$scope.selectedTeam = index;
		}

}]);
app.controller('SodController', ['$scope', '$http','$filter', function ($scope, $http, $filter) {
	
	
	$scope.isEditMode = true;
	$scope.showDetails = true;
	 
    var loadData = function () {
        $http.get('rest/mmapi/load').success(function (data) {
        	$scope.blockers = data.blockers;
            $scope.entries = data.others;
            $scope.userData = data.self;
          
            $scope.selection = $scope.userData;
            
            
        });
    }
    loadData();
    
    $scope.selectUser= function(key){
    	$scope.selection = $scope.entries[key];
    	$scope.isEditMode = false;
    	$scope.showDetails = false;
    }
    
    $scope.edit= function(){
    	$scope.isEditMode = true;
    	$scope.selection = $scope.userData;
    	$scope.showDetails = false;
    	
    }
    
    $scope.login = function(){
    	$http.post('rest/mmapi/login', {userName:$("#userName").val(), password:$("#password").val()}).
    	  success(function(data, status, headers, config) {
	    	    if(data.isAuthenticated){
	    	    	console.log("user authenticates");
	    	    	$scope.authenticatedUser = data.authenticatedUser;
	    	    	$("#loginModel").modal('hide');
	    	    	 loadData();
	    	    }
    	  }).
    	  error(function(data, status, headers, config) {
    	    // called asynchronously if an error occurs
    	    // or server returns response with an error status.
    	  });
    }
    
    $scope.addBlocker = function(){
    	if(angular.isUndefined($scope.blockers)){
    		$scope.blockers = [];
    	}
    	var blocker = {};
    	blocker['text'] = $('#blocker_desc').val();
    	blocker['sevirity'] = $('#blocker_sevrity').val();
    	blocker['createdBy'] =$scope.userData.userName;
    	$scope.blockers.push(blocker);
    	
    	 $('#blocker_desc').val('');
    	 $('#blocker_sevrity').val('');
    	 $("#blockerModel").modal('hide');
    	 $scope.showDetails = true;	
    }
    
    $scope.removeTask = function(index, mode){
    	if(mode == 1)
    		$scope.userData.yestardayEntry.splice(index, 1);
    	if(mode==2)
    		 $scope.userData.todaysEtries.splice(index, 1);
    }
    
    $scope.updateTask = function(){
    	$http.post('rest/mmapi/updatetask', $scope.userData).
    	success(function(data, status, headers, config) {
	    	    
  	  }).
  	  error(function(data, status, headers, config) {
  	    // called asynchronously if an error occurs
  	    // or server returns response with an error status.
  	  });
    	glitterAlert("Information!!" , "Task Updated");	
    }
    
    
    $scope.saveSettings = function(mode){
    	console.log(mode);
    	if(mode == 1){
    		var yestardayEntry =  $scope.userData.yestardayEntry;
    		if(angular.isUndefined(yestardayEntry)){
    			yestardayEntry = [];
    			
    		}
    		var entry = {};
			entry['id'] = $('#Yest_taskID').val();
			entry['desc'] = $('#Yest_task_desc').val();
			
			yestardayEntry.push(entry)
    		$scope.userData.yestardayEntry = yestardayEntry;
			 $('#Yest_taskID').val('');
			 $('#Yest_task_desc').val('');
			$("#yestardayModel").modal('hide');
    	} else {
    		var todaysEtries =  $scope.userData.todaysEtries;
    		if(angular.isUndefined(todaysEtries)){
    			todaysEtries = [];    			
    		}
    		var entry = {};
			entry['id'] = $('#today_taskID').val();
			entry['desc'] = $('#Today_task_desc').val();
			
			todaysEtries.push(entry)
    		$scope.userData.todaysEtries = todaysEtries;
			 $('#today_taskID').val('');
			 $('#Today_task_desc').val('');
			 $("#todayModel").modal('hide');
    	}
    }

   
}]);

app.factory('myHttpInterceptor', function ($q, $window) {
	  return function (promise) {
	    return promise.then(function (response) {
	      $("#spinner").hide();
	      return response;
	    }, function (response) {
	      $("#spinner").hide();
	      return $q.reject(response);
	    });
	  };
	});

app.factory('authHttpResponseInterceptor',function($q,$location){
    return {
        response: function(response){
            if (response.status === 401) {
                console.log("Response 401");
            }
            return response || $q.when(response);
        },
        responseError: function(rejection) {
            if (rejection.status === 401) {
                console.log("Response Error 401",rejection);
                $("#loginModel").modal('show');
            }
            return $q.reject(rejection);
        }
    }
});


function glitterAlert(title, message){
	$.gritter.add({
		// (string | mandatory) the heading of the notification
		title: title,
		// (string | mandatory) the text inside the notification
		text: message
		//sticky: false

		
	});

	return false;



}
