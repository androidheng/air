<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
	<body>
		<div class="input-group-btn" style="text-align: center;">
			<button type="button" class="btn btn-import btn-derive">导出测试信息</button><br><br>
			<button type="button" class="btn btn-export btn-pdf">导出实时数据</button><br><br>
			<button type="button" class="btn btn-export btn-history">导出历史数据</button><br><br>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				$(".input-group-btn")
				.on("click",".btn-derive",doImprotObject) //导出Excel
				.on("click",".btn-pdf",doImportPdf) //导出实时数据
				.on("click",".btn-history",doHistorydata); //导出历史数据
		});
			
		function doImportPdf(){
			location.href="<%=basePath%>data/exportrealtime?cid=4&type=1";
		}
 
		function doImprotObject(){
			location.href='<%=basePath%>data/export';
		}
		function doHistorydata(){
			location.href='<%=basePath%>data/exporthistory?cid=4&type=1&dates=2019-05-10';
		}
		</script>
	</body>
</html>