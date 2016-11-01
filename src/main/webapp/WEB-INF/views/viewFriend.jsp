<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Users</title>
<style>
body{
    background:#eee;    
}
.main-box.no-header {
    padding-top: 20px;
}
.main-box {
    background: #FFFFFF;
    -webkit-box-shadow: 1px 1px 2px 0 #CCCCCC;
    -moz-box-shadow: 1px 1px 2px 0 #CCCCCC;
    -o-box-shadow: 1px 1px 2px 0 #CCCCCC;
    -ms-box-shadow: 1px 1px 2px 0 #CCCCCC;
    box-shadow: 1px 1px 2px 0 #CCCCCC;
    margin-bottom: 16px;
    -webikt-border-radius: 3px;
    -moz-border-radius: 3px;
    border-radius: 3px;
}
.table a.table-link.danger {
    color: #e74c3c;
}
.label {
    border-radius: 3px;
    font-size: 0.875em;
    font-weight: 600;
}
.user-list tbody td .user-subhead {
    font-size: 0.875em;
    font-style: italic;
}
.user-list tbody td .user-link {
    display: block;
    font-size: 1.25em;
    padding-top: 3px;
    margin-left: 60px;
}
a {
    color: #3498db;
    outline: none!important;
}
.user-list tbody td>img {
    position: relative;
    max-width: 50px;
    float: left;
    margin-right: 15px;
}

.table thead tr th {
    text-transform: uppercase;
    font-size: 0.875em;
}
.table thead tr th {
    border-bottom: 2px solid #e7ebee;
}
.table tbody tr td:first-child {
    font-size: 1.125em;
    font-weight: 300;
}
.table tbody tr td {
    font-size: 0.875em;
    vertical-align: middle;
    border-top: 1px solid #e7ebee;
    padding: 12px 8px;
}
</style>
</head>
<body ng-app="myApp" ng-controller="dataCtrl">

<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<hr>
<div class="container bootstrap snippet">
   <div class="row">
   <div class="col-lg-12">3
   <div class="main-box no-header clearfix">
   <div class="main-box-body clearfix">
   <div class="table-responsive">
     <table class="table user-list">
        <thead>
          <tr>
            <th><span>User</span></th>
            <th><span>Created</span></th>
            <th class="text-center"><span>Status</span></th>
            <th><span>Email</span></th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="f" items="${friends}">
  			<label class="name">
        		<c:if test="${f.friend.userFriend.userid==user.userid}">
         				${f.friend.user.name}<br>
         		</c:if>
        	</label>
  		</c:forEach>
        
           <tr ng-repeat="resource in names | filter:search">
             <td>
               <img src="http://bootdey.com/img/Content/{{resource.userid}}.jpg" alt="">
                <a href="#" class="user-link">{{resource.name}}</a>
             </td>
             <td>2013/08/12</td>
             <td class="text-center">
               <span class="label label-default">{{resource.status}}</span>
             </td>
             <td>
               <a href="#">{{resource.mail}}</a>
             </td>
            <td style="width: 20%;">
               <a href="#" class="table-link">
               <span class="fa-stack">
               <i class="fa fa-square fa-stack-2x"></i>
               <i class="fa fa-search-plus fa-stack-1x fa-inverse"></i>
      
               </span>
               </a>
               <a href="#" class="table-link">
               <span class="fa-stack">
               <i class="fa fa-square fa-stack-2x"></i>
               <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
               </span>
               </a>
               <a href="#" class="table-link danger">
               <span class="fa-stack">
               <i class="fa fa-square fa-stack-2x"></i>
               <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
               </span>
               </a>
               </td>
               <td><a href="addFriend?u={{resource.userid}}" class="btn btn-info" role="button">Add Friend</a></td>

            </tr>
         </tbody>
       </table>
       <c:forEach var="frd" items= "${friendRequests}">
        <tr>
            
            <td>${frd.getFriend().user.name}</td>
            <td><a href="acceptfriend?f=${frd.getReqid()}" class="button" role="button">Accept</a>
            <td>${frd.getStatus()}</td>
            
        </tr> 
        </c:forEach>
      </div>
     </div>
    </div>
   </div>
  </div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${users};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</body>
</html>
