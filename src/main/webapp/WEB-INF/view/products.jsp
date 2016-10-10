<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<body>
<div id="tour" class="bg-1">
<div style="background-color: white;height: 30px;">
  	<form>
			<input type="text" ng-model="search" style="height: 30px;width: 30%;outline: none;"/>&nbsp&nbsp
			<span class="glyphicon glyphicon-search"></span> Search
	</form>
	</div>
	<br/> 
  <div class="container" ng-app="myApp" ng-controller="namesCtrl">
<div class="col-md-2 column productbox">
		<div class="columns" ng-repeat="resource in names | filter:search">
		<img src="<c:url value="/resources/images/{{resource.pname}}.jpg"/>" style="width:200px;height:200px;"/>
		<div class="producttitle">{{resource.pname}}</div>
		<div class="productprice">
			<div class="pricetext">{{resource.price}}</div>
		</div>
		<div class="pull-left">
			<a href="proddetails?p={{resource.pid}}" class="btn btn-info btn-sm" role="button">MoreDetails</a>
		</div>
		<div class="pull-right">
			<a href="buy" class="btn btn-info btn-sm" role="button">BUY</a>
		</div>
	</div>
	</div>
	</div>    </div>
  </div>
</div>
   <script>
    angular.module('myApp', []).controller('namesCtrl', function($scope) {
        $scope.names = ${sproducts};
        $scope.orderByMe = function(x) {
            $scope.myOrderBy = x;
        }
    });
    alert('hi');
   </script>
</body>
</html>

