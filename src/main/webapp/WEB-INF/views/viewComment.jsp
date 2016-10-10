<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment box</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
<style>
#div1 {
	border: 1px solid #DBDCE9;
	margin-left: auto;
	margin-right: auto;
	width: 550px;
	border-radius: 7px;
	padding: 25px;
}

div {
	width: 200px;
}

h2 {
	font: 400 40px/1.5 Helvetica, Verdana, sans-serif;
	margin: 0;
	padding: 0;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li {
	font: 200 20px/1.5 Helvetica, Verdana, sans-serif;
	border-bottom: 1px solid #ccc;
}

li:last-child {
	border: none;
}

li a {
	text-decoration: none;
	color: #000;
	display: block;
}
</style>
</head>
<body>
<div id='div1'>
		<form ng-controller="FromController">Post your Comment
			<form ng-controller="FromController">
				<textarea ng-model="textcomment" placeholder="Your Comment" style='width: 550px'></textarea>
				<button ng-click='btn_add();' style='margin-top: 10px;'>Post Comment</button>
				<h4>Comments</h4>
				<ul>
					<li ng-repeat="comnt in comment">{{ comnt }} <a
						style="float: right;" href="" ng-click="removeItem($index)">x</a></li>
				</ul>
			</form>
	</div>

	<script type="text/javascript">
		function FromController($scope)
		{
			$scope.comment = [];
			$scope.btn_add = function()
			{
				if ($scope.textcomment != '') 
				{
					$scope.comment.push($scope.textcomment);
					$scope.textcomment = "";
				}
			}
/* splice() adds/removes items to/from an array and returns the removed items */
			$scope.removeItem = function($index) 
			{
				$scope.comment.splice($index, 1);
			}
		}
	</script>
</body>
</html>