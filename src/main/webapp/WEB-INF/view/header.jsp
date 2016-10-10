<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="assets/js/jquery.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>	
<script src="assets/js/bootstrap-dropdown.js" type="text/javascript"></script> -->
	<title>Shopping</title>
	<style type="text/css">
		.navbar-fixed-left .navbar-nav >li 
		{
			position:fixed;
			top:0px;
			margin-top:50px;
			margin-left:140px;
		}
		.navbar-login
		{
		    width: 305px;
		    padding: 10px;
		    padding-bottom: 0px;
		}
		
		.navbar-login-session
		{
		    padding: 10px;
		    padding-bottom: 0px;
		    padding-top: 0px;
		}
		
		.icon-size
		{
		    font-size: 87px;
		}
		#custom-search-input{
		    padding: 2px;
		    border: solid 1px #E4E4E4;
		    border-radius: 6px;
		    background-color: #fff;
		    width: 400px;
		    
		}
		
		#custom-search-input input{
		    border: 0;
		    box-shadow: none;
		}
		
		#custom-search-input button{
		    margin: 2px 0 0 0;
		    background: none;
		    box-shadow: none;
		    border: 0;
		    color: #666666;
		    padding: 0 8px 0 10px;
		    border-left: solid 1px #ccc;
		}
		
		#custom-search-input button:hover{
		    border: 0;
		    box-shadow: none;
		    border-left: solid 1px #ccc;
		}
		
		#custom-search-input .glyphicon-search{
		    font-size: 23px;
		}
		.dropdown-menu {
	margin: -2px 0 0;
	background:#F38F21 !important;
	border:1px solid #F7860E;
	border-radius: 0px;
}
.dropdown-menu > li > a {
	clear: both;
	color: #fff !important;
	font-weight: normal;
	line-height: 20px;
	padding: 10px 20px;
	white-space: nowrap;
	border-bottom:2px solid #F7860E;
}
.navbar .nav > li > .dropdown-menu::before, .navbar .nav > li > .dropdown-menu::after {
	border: none;
	content: none;
}
.navbar-inverse .nav li.dropdown.open > .dropdown-toggle, .navbar-inverse .nav li.dropdown.active > .dropdown-toggle, .navbar-inverse .nav li.dropdown.open.active > .dropdown-toggle {
	background-color: white;
	color: white;
}
.navbar .caret {
	border-bottom-color: #000 !important;
	border-top-color: #000 !important;
}
.dropdown-menu > li > a:hover, .dropdown-menu > li > a:focus {
	background-image:none !important;
	background-color:white;
 filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
}
.nav-collapse .nav > li > a:hover .caret {
	border-bottom-color: #000 !important;
	border-top-color: #000 !important;
}
ul.nav li.dropdown:hover ul {
	display: block;
}
.dropdown-menu .dropdown-submenu ul {
	left: 100%;
	position: absolute;
	top: 0;
	visibility: hidden;
	margin-top: -5px;
	margin-left: 1px;
	border-radius: 0px !important;
}
.dropdown-menu li:hover .dropdown-menu {
	visibility: visible;
	display: block;
}
.dropdown-menu > li > a:hover, .dropdown-menu > li > a:focus, .dropdown-submenu:hover > a, .dropdown-submenu:focus > a {
	color: white;
	background-color: white;
	background-image: none !important;
 filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc', endColorstr='#ff0077b3', GradientType=0);
}
.navbar .divider-vertical {
	border-right: 1px solid #ffffff;
	height: 40px;
	margin:0px;
}
.navbar .nav .dropdown-toggle .caret {
	margin-top: 18px;
}
.dropdown-menu .dropdown-submenu ul {
	left: 100%;
	position: absolute;
	top: 0;
	visibility: hidden;
	margin-top: -5px;
	margin-left: 1px;
	border-radius: 0px !important;
}
.dropdown-menu li:hover .dropdown-menu {
	visibility: visible;
	display: block;
}
	</style>
<script>
!function( $ ){

  "use strict"
var toggle = '[data-toggle="dropdown"]'
    , Dropdown = function ( element ) {
        var $el = $(element).on('click.dropdown.data-api', this.toggle)
        $('html').on('click.dropdown.data-api', function () {
          $el.parent().removeClass('open')
        })
      }

  Dropdown.prototype = {

    constructor: Dropdown

  , toggle: function ( e ) {
      var $this = $(this)
        , selector = $this.attr('data-target')
        , $parent
        , isActive

      if (!selector) {
        selector = $this.attr('href')
        selector = selector && selector.replace(/.*(?=#[^\s]*$)/, '') //strip for ie7
      }

      $parent = $(selector)
      $parent.length || ($parent = $this.parent())

      isActive = $parent.hasClass('open')

      clearMenus()
      !isActive && $parent.toggleClass('open')

      return false
    }

  }

  function clearMenus() {
    $(toggle).parent().removeClass('open')
  }
$.fn.dropdown = function ( option ) {
    return this.each(function () {
      var $this = $(this)
        , data = $this.data('dropdown')
      if (!data) $this.data('dropdown', (data = new Dropdown(this)))
      if (typeof option == 'string') data[option].call($this)
    })
  }

  $.fn.dropdown.Constructor = Dropdown
$(function () {
    $('html').on('click.dropdown.data-api', clearMenus)
    $('body').on('click.dropdown.data-api', toggle, Dropdown.prototype.toggle)
  })

}( window.jQuery );
</script>
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="font-size:30px;">Shoes Club</a>
    </div>
   
	<c:if test="${empty Welcome}">
		<ul class="nav navbar-nav">
      		<li class="active"><a href="home">Home</a></li>
      		<li><a href="about">About Us</a></li>
      		<li><a href="contact">Contact</a></li>
      	</ul>
		<div style="float: right; position: absolute; top: 0px; right: 90px;color:white;"><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a><br></div>
		<div style="float: right; position: absolute; top: 0px; right: 20px; color:white;"><a href="register"><span class="glyphicon glyphicon-user"></span>Register</a></div>
	</c:if>	
	
	<c:if test="${not empty Welcome}">
		<ul class="nav navbar-nav">
      		<li class="active"><a href="home">Home</a></li>
      		<li><a href="about">About Us</a></li>
      		<li><a href="contact">Contact</a></li>
      		<li><a href="viewcart"><span class="glyphicon glyphicon-shopping-cart"></span>View Your Cart</a><br></li>  
      		<li>
      			<div id="custom-search-input">
                <div class="input-group col-md-12">
                    <input type="text" class="form-control input-lg" placeholder="Search Products Here" />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="button">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>
          		</div>
      	   </li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
           <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                 <span class="glyphicon glyphicon-user"></span> 
                    <strong>Hi ${Welcome.firstname} ${Welcome.lastname}</strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                           <div class="col-lg-8">
                                <p class="text-left"><strong><a href="profile">My Profile</a></strong></p>
                           		<%-- <p class="text-left"><strong><a href="/User/edit?u=${User.uid}">Edit your Profile</a></strong></p>
								<p class="text-left"><strong><a href="User/delete?u=${User.uid}">Delete User</a></strong></p> --%>
                           </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="navbar-login navbar-login-session">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>
                                        	<div><a href="logout"><span class="glyphicon glyphicon-user"></span>Log out</a><br></div>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        </ul>
                        </li>
 				</ul>
		
	</c:if>	
	</div>		
   </nav>
</body>
</html>