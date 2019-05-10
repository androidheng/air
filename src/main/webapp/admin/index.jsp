<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/admin.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">BieJun</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">帮助中心</a></dd>
                        <dd><a href="<%=basePath%>login.jsp">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    <img src="<%=basePath%>assets/images/logo.png" alt=""/>
                    <h1>后台管理系统</h1>
                </div>
                <ul id="Nav" class="layui-nav layui-nav-tree">
                    <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon">&#xe612;</i>
                                <em>管理</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>admin/person.jsp">用户管理</a></dd>
                                <dd><a href="<%=basePath%>admin/address.jsp">站点管理</a></dd>
                                <dd><a href="<%=basePath%>admin/warning.jsp">报警管理</a></dd>
                                <dd><a href="<%=basePath%>admin/parames.jsp">参数管理</a></dd>
                            </dl>
                    </li>  
                    <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon">&#xe612;</i>
                                <em>预警</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>admin/homeWork.jsp">气体浓度</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">报警状态</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">实时变化趋势</a></dd>
                               
                            </dl>
                    </li>  
                     <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon">&#xe612;</i>
                                <em>数据</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>admin/homeWork.jsp">实时数据</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">历史数据</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">饼状图</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">柱状图</a></dd>
                            </dl>
                    </li>  
                     <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon">&#xe612;</i>
                                <em>报表</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>admin/homeWork.jsp">日报表</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">月报表</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">年报表</a></dd>
                            </dl>
                    </li>
                     <li class="layui-nav-item">
                            <a >
                                <i class="layui-icon">&#xe612;</i>
                                <em>监控</em>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="<%=basePath%>admin/homeWork.jsp">数据监控</a></dd>
                                <dd><a href="<%=basePath%>admin/jobInformation.jsp">地图场景</a></dd>
                            </dl>
                    </li>    
                   
                   
                   
                   
                </ul>
           </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>
        </div>

        <div class="layui-footer">
            <p>© 2018 DEMO</p>
        </div>

        <div class="mobile-mask"></div>
    </div>
    <script src="<%=basePath%>assets/layui.js"></script>
    <script src="<%=basePath%>js/index.js" data-main="home"></script>
</body>
</html>