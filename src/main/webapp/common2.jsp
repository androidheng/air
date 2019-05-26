<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<base href="<%=basePath%>">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
<script src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
<%-- <script src="<%=basePath%>assets/layui.js"></script> --%>