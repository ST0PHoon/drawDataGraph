<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>
	최대값 : ${max.contractPrice}
	</td>
	<td>
	최소값 : ${min.contractPrice}
	</td>
진짜 
	</tr>
	<c:forEach var="item" items="${contractPriceMaxMin}">
		
			<tr>
				<td width=200px height=30px><b>${item.minYear}</b></td>
				<td width=200px height=30px><b>${item.maxYear}</b></td>
				<td width=200px height=30px><b>${item.contractYear}</b></td>
			
<%-- 				<th width=200px height=30px>${item.gu}</th> --%>
<%-- 				<td width=200px height=30px><b>${item.dong}</b></td> --%>
<%-- 				<td width=200px height=30px><b>${item.danji}</b></td> --%>
<%-- 				<td width=200px height=30px><b>${item.area}</b></td> --%>
<%-- 				<td width=200px height=30px><b>${item.contractPrice}</b></td> --%>
<%-- 				<td width=200px height=30px><b>${item.contractYear}</b></td> --%>
<%-- 				<td width=200px height=30px><b>${item.contractMonth}</b></td> --%>
			</tr>
	</c:forEach>
	
	<c:forEach var="item" items="${gus}">
		
			<tr>
				<th width=200px height=30px>${item}</th>
			</tr>
	</c:forEach>
	
	</table>
</body>
</html>