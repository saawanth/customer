<!DOCTYPE html>
<html lang="en">

<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
<script src="http://code.angularjs.org/1.4.4/angular-resource.js"></script>
<script
	src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

  <script src="js/app/app.js"></script>

<!-- Controllers -->
<!-- <script src="js/app/MainController.js"></script> -->


<!-- Services -->
<!-- <script src="js/app/FlightService.js"></script> -->
<!-- <script src="js/app/SharedData.js"></script> -->
<!-- <script src="js/Services/AuthService.js"></script> -->
<!-- jQuery -->
<script src="js/lib/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/lib/bootstrap.min.js"></script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>${ title }</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">


</head>

<body ng-app="myApp">

	<!-- Header -->
	<header id="top" class="header">
		<div class="text-vertical-center">
			<h1>SkyKey</h1>
			<h3>Search. Book. Bon Voyage.</h3>
			<br>
			<div class="col-md-4 col-md-offset-4">
				<div ng-view></div>
			</div>
		</div>
	</header>
</body>

</html>
