<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<title>draw graph</title>
		
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	    <script type="text/javascript">
	      google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawChart);
	
	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
	          ['Year', 'Sales', 'Expenses'],
	          ['2004',  1000,      400],
	          ['2005',  1170,      460],
	          ['2006',  660,       1120],
	          ['2007',  1030,      540]
	        ]);
	
	        var options = {
	          title: 'Company Performance',
	          curveType: 'function',
	          legend: { position: 'bottom' }
	        };
	
	        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
	
	        chart.draw(data, options);
	      }
	    </script>
	</head>
	
	<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">
		      Logo
		    </a>
		  </div>
		</nav>
		
		<div class="container mt-5">
			<div class="row">
			  <div class="col-sm-4">
				<h3>Column 1</h3>
				<form action="/action_page.php">
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something" checked>
				    <label class="form-check-label" for="check1">Option 1</label>
				  </div>
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check2" name="option2" value="something">
				    <label class="form-check-label" for="check2">Option 2</label>
				  </div>
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check3" name="option3" value="something">
				    <label class="form-check-label">Option 3</label>
				  </div>
				</form>
				  </div>
				  <div class="col-sm-4">
				<h3>Column 2</h3>
				<form action="/action_page.php">
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something" checked>
				    <label class="form-check-label" for="check1">Option 1</label>
				  </div>
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check2" name="option2" value="something">
				    <label class="form-check-label" for="check2">Option 2</label>
				  </div>
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check3" name="option3" value="something">
				    <label class="form-check-label">Option 3</label>
				  </div>
				</form>
				  </div>
				  <div class="col-sm-4">
				   <h3>Column 3</h3>        
				<form action="/action_page.php">
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check1" name="option1" value="something" checked>
				    <label class="form-check-label" for="check1">Option 1</label>
				  </div>
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check2" name="option2" value="something">
				    <label class="form-check-label" for="check2">Option 2</label>
				  </div>
				  <div class="form-check">
				    <input type="checkbox" class="form-check-input" id="check3" name="option3" value="something">
				    <label class="form-check-label">Option 3</label>
				  </div>
				</form>
			  </div>
			</div>
		  
			<button type="submit" class="btn btn-primary mt-3">Draw Graph</button>
			<button type="submit" class="btn btn-primary mt-3">Export CSV</button>
		  
		</div>
		안재 확인용
	    <div id="curve_chart" style="width: 40%;"></div>
		
	</body>
</html>