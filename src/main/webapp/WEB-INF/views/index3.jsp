<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
         // 구글 차트
         google.charts.load('current', {'packages':['bar']});
         google.charts.setOnLoadCallback(drawChart);

         function drawChart() {
           var data = google.visualization.arrayToDataTable([
             ['Year', 'Maximum', 'Minimum'],
             ['2014', 37000, 33300],
             ['2015', 34300, 31270],
             ['2016', 35000, 32000],
             ['2017', 41000, 39750]
           ]);

           var options1 = {
            	title: '년도별 계약금 최고가 최저가' ,
            	legend: 'none'
           };

           var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

           chart.draw(data, options1);
         }
         
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawChart2);

		function drawChart2() {
			var data = google.visualization.arrayToDataTable([
				['Year', 'Average'],
				['2014',  35000],
				['2015',  32900],
				['2016',  33500],
				['2017',  40010]
			]);

			var options2 = {
				title: '년도별 평균 계약금 추이',
				legend: 'none'
			};

			var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

			chart.draw(data, options2);
		}
         
		google.charts.setOnLoadCallback(drawChart3);

		function drawChart3() {
			let dataArray = new Array();
			
			var data = google.visualization.arrayToDataTable([
				['year', 'price'],
				[2014,  33300],
				[2014,  38000],
				[2014,  37000],
				[2014,  35000],
				[2015,  34300]
			]);

			var options3 = {
				title: '년도별 거래내역 추이',
				legend: 'none'
			};

			var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));

			chart.draw(data, options3);
		}
		
        ///////////////////////////////////////// 기능 구현
		/* function guSelect(event)  {
			// 선택된 목록 가져오기
			const query = 'input[name="gu"]:checked';
			const selectedEls = document.querySelectorAll(query);

			// 선택된 목록에서 value 찾기
			let result = '';
			selectedEls.forEach((el) => {
				result += el.value + ' ';
			});

			console.log(result);
		}
          */
		function dongChange(e) { 
			let gangNamArray = new Array();
			
			<c:forEach var="gu" items="${gu0}">
				gangNamArray.push('${gu}');
			</c:forEach> 	
			
			let gangDongArray = new Array();
			
			<c:forEach var="gu" items="${gu1}">
				gangDongArray.push('${gu}');
			</c:forEach> 
			
			let gangBukArray = new Array();
			
			<c:forEach var="gu" items="${gu2}">
				gangBukArray.push('${gu}');
			</c:forEach> 
			
			/* guArray.splice(i, 0, inputArray); */
			
			
			// 구 선택 안 했을 때, 동의 선택지
			if(e.value == -1) {
				var d = ["-- 동 선택 --"];  
			}
			
		
			// 구에 따라 동 세팅
			
			if(e.value == 0){ 
        	 	var d = gangNamArray; 
         	} else if(e.value == 1){ 
        	 	var d = gangDongArray; 
         	} else if(e.value == 2){ 
        	 	var d = gangBukArray; 
         	}

			
			var target = document.getElementById("dong");   
			 
			target.options.length = 0;
				
			for (x in d) {    
				var opt = document.createElement("option");    
				opt.value = d[x];    
				opt.innerHTML = d[x];    
				target.appendChild(opt);  
			} 
		}
          
          function danjiChange(e) { 
  			let gaepoArray = new Array();
  			
  			<c:forEach var="dong" items="${dong0}">
  				gaepoArray.push('${dong}');
  			</c:forEach> 	
  			
  			let nonhyeonArray = new Array();
  			
  			<c:forEach var="dong" items="${dong1}">
  				nonhyeonArray.push('${dong}');
  			</c:forEach> 
  			
  			let daechiArray = new Array();
  			
  			<c:forEach var="dong" items="${dong2}">
  				daechiArray.push('${dong}');
  			</c:forEach> 
  			
  			/* guArray.splice(i, 0, inputArray); */
  			
  			
  			// 구 선택 안 했을 때, 동의 선택지
  			if(e.value == -1) {
  				var d = ["-- 동 선택 --"];  
  			}
  			
  		
  			// 구에 따라 동 세팅
  			
  			if(e.value == "개포동"){ 
          	 	var d = gaepoArray; 
           	} else if(e.value == "논현동"){ 
          	 	var d = nonhyeonArray; 
           	} else if(e.value == "대치동"){ 
          	 	var d = daechiArray; 
           	}

  			
  			var target = document.getElementById("danji");   
  			 
  			target.options.length = 0;
  				
  			for (x in d) {    
  				var opt = document.createElement("option");    
  				opt.value = d[x];    
  				opt.innerHTML = d[x];    
  				target.appendChild(opt);  
  			} 
  		}
          
          
		</script>
      
		<style>
      		body {
     			background-image:url("images/back.jpg")
     			opacity:10%
			}
		</style>
       
	</head>
   
	<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div class="container-fluid">
				<a class="navbar-brand">
					서울특별시 아파트 매매 현황 (2012 ~ 2021)
				</a>
			</div>
		</nav>
		<form method="post" id=conditions>
			<div class="container-fluid">   
				<div class="container mt-5" id=gudong style={border-color:black}>
					<div class="row">
						<div class="col-sm-2" id="gu">
							<h3>구</h3>
							<select onchange=dongChange(this) style="width:auto;" aria-label="Default select example">
								<option value=-1 selected>-- 구 선택 --</option>
								<c:forEach var="gu" items="${gus}" varStatus="status">
									<option value="${status.index}">${gu}</option>
								</c:forEach> 
							</select>
						</div>
						<div class="col-sm-2" id="dongdiv" >
			            <h3>동</h3>
							<select onchange=danjiChange(this) id="dong" style="width:auto;" aria-label="Default select example">
								<option selected>-- 동 선택 --</option>
							</select>
						</div>
	
						<div class="col-sm-2" id="danJidiv">
				            <h3>단지명</h3>        
							<select id="danji" style="width:auto;" aria-label="Default select example">
								<option selected>-- 단지 선택 --</option>
				            	<%-- <c:forEach var="gu" items="${guList}">
					              <option value="${gu.gu}">${gu.gu}</option>
				                </c:forEach> --%>
							</select>
						</div>
					</div>
	        	</div>
				<div class="container mt-5">
					<div class="row">
						<div class="col-sm-3" id="year">
							<h3>년도 선택</h3>
							<select id=startYear style="width:auto;" aria-label="Default select example">
								<c:forEach  varStatus="status" begin="2012" end="2021" step="1">
									<option value="${status.index}">${status.index}</option>
								</c:forEach> 
							</select>
			   
							<span> ~ </span>
			   
							<select id=endYear style="width:auto;" aria-label="Default select example">
								<c:forEach  varStatus="status" begin="2012" end="2021" step="1">
									<option value="${status.index}">${status.index}</option>
								</c:forEach> 
							</select>
		             	</div>
						<div class="col-sm-3" id="area">
		             		<h3>면적 선택</h3>
							<input type="number" id=startArea>
							<span> ㎡ ~ </span>             
		            		<input type="number" id=endArea> ㎡
						</div>
						<div class="col-sm-6" id="buttons">
							<span><button type="submit" class="btn btn-primary mt-3">Load Data</button></span>
				            <span style=margin-left:20px><button type="submit" class="btn btn-primary mt-3">Draw Graph</button></span>
							<span style=margin-left:20px><button action="index" type="submit" class="btn btn-primary mt-3">Export CSV</button></span>
						</div>
					</div>
				</div>
			</div>
		</form>  
		  
		<br>
		<br>
		<br>
	
	 	<div>
			<c:forEach var="item" items="${all}">
				<tr>
				<%-- 	<td width=200px height=30px><b>${item.min}</b></td>
					<td width=200px height=30px><b>${item.max}</b></td>
					<td width=200px height=30px><b>${item.contractYear}</b></td> --%>
				
					<th width=200px height=30px>${item.gu}</th>
					<td width=200px height=30px><b>${item.dong}</b></td>
					<td width=200px height=30px><b>${item.danji}</b></td>
					<td width=200px height=30px><b>${item.area}</b></td>
					<td width=200px height=30px><b>${item.contractPrice}</b></td>
					<td width=200px height=30px><b>${item.contractYear}</b></td>
					<td width=200px height=30px><b>${item.contractMonth}</b></td>
				</tr>
			</c:forEach>
		</div> 
		<div>
			<c:forEach var="item" items="${contractPriceMaxMin}">
				<tr>
				 	<td width=200px height=30px><b>${item.min}</b></td>
					<td width=200px height=30px><b>${item.max}</b></td>
					<td width=200px height=30px><b>${item.contractYear}</b></td>  
			
					
				</tr>
			 </c:forEach> 
		</div> 
			
		<div class="d-flex justify-content-center">
			<span id="columnchart_material" style="width: 1000px; height: 380px"></span>
		</div>
	        
		<div class="d-flex justify-content-center">
			<span id="curve_chart" style="width: 600px; height: 500px"></span>
			<span id="chart_div" style="width: 1000px; height: 500px"></span>
		</div>
	</body>
</html>