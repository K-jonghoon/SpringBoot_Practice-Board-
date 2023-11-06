<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style type="text/css">

	body {
		margin: 0px;
		padding: 0px;
	}

	table {
		border: 2px solid black;	
		border-collapse: collapse;
		width: 400px;
		margin: 50px auto;
	}
	
	th, td {
		border: 1px solid black;
		padding: 5px;
		width: 100px;
	}
	
	ul{
		text-align: center;
		padding: 0px;
	}
	li {
		display:inline-block;
	    margin-right: 10px;
	}
	
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th colspan="4">
					<select id="teameSelect">
						<option>--팀 번호(조회)--</option>
						<option value="K01">K01</option>
						<option value="K02">K02</option>
						<option value="K03">K03</option>
						<option value="K04">K04</option>
						<option value="K05">K05</option>
						<option value="K06">K06</option>
						<option value="K07">K07</option>
						<option value="K08">K08</option>
						<option value="K09">K09</option>
						<option value="K10">K10</option>
						<option value="K11">K11</option>
						<option value="K12">K12</option>
						<option value="K13">K13</option>
						<option value="K14">K14</option>
						<option value="K15">K15</option>
					</select>
					<button onclick="teamSearch()">조회</button>
				</th>
			</tr>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>등번호</th>
				<th>팀번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${lists}">
				<tr>
					<td>${list.player_id}</td>
					<td>${list.player_name}</td>
					<td>${list.back_no}</td>
					<td>${list.team_id}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					<ul>
								<c:if test="${page.stagePage > 1}">
								<li><a href="#" onclick="pageFirst('${teamVal}')">◁◁</a></li>
								<c:if test="${page.stagePage - page.countPage >= 0}">
									<li><a href="#" onclick="pagePrev(${page.stagePage}, ${page.countPage},'${teamVal}')">◀</a></li>
								</c:if>
								</c:if>
								
								<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}" step="1">
									<li ${page.page == i ? 'class=active':''}><a href="javascript:page(${i}, '${teamVal}')">${i}</a></li>
								</c:forEach>
							
								
								<c:if test="${page.page < page.totalPage}">
									<c:if test="${page.stagePage+page.countPage < page.totalCount}">
										<li><a href="#" onclick="pageNext(${page.stagePage}, ${page.countPage}, '${teamVal}')">▶</a></li>
									</c:if>
									<li><a href="#" onclick="pageLast(${page.totalPage}, '${teamVal}')">▷▷</a></li>
								</c:if>
					</ul>
				</td>
			</tr>
		</tfoot>
	</table>
	<script type="text/javascript" src="./js/player.js"></script>
</body>
</html>