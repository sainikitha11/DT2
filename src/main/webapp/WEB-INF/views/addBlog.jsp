<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 
  <script>document.write('<base href="' + document.location + '" />');</script>
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
<title>viewblog</title>
</head>
<body>

<script src="resources/js/BlogController.js"></script>


<!-- Search Blog : <input type="text"> ng-model="searchkeyword"> -->
<div ng-app="myApp" ng-controller="dataCtrl">
Enter Product Name:  <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Blog Id</th>
    <th>Blog Title</th>
    <th>Blog Status</th>
    <th>Blog Reason</th>
    <th>Blog Content</th>
    <th>Blog User</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.blogid}}</td>
            <td>{{ resource.title}}</td>
            <td>{{ resource.status}}</td>
            <td>{{ resource.reason}}</td>
            <td>{{ resource.content}}</td>
            <td>{{ resource.user}}</td>
            <!-- <td><img src="resources/images/{{resource.product_id}}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="deleteProduct?id={{resource.product_id}}">Delete</a></td> -->
        </tr>    
    </table>
</div>
<div>
<%-- ${blogs} --%>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${blogs};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</body>
</html>
