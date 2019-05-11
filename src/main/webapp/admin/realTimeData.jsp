<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
   
    <link rel="icon" href="/favicon.ico">
    <style>
      
    </style>
    <title>管理后台</title>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>历史数据</a>
                </span>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                        城市：
                      <div class="layui-inline">
                          <form class="layui-form" action="">
                             <select  id="cid" lay-verify="required"></select>
                          </form></div>
                                                                 
                        <div class="layui-inline">
                                                                          数据类型                                                
                         <div class="layui-inline">
                          <form class="layui-form" action="">
                             <select  id="datatype" lay-verify="required"></select>
                          </form>
                         
                        </div>
                        </div>
                      <button class="layui-btn" id="search">查询</button>
                    </div>
                    
                     <div id="main" style="width: 100%;height:600px;"></div>
                    
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.all.js"></script>
    <script src="<%=basePath%>assets/echarts.min.js"></script>
  
   
    <script>
    var myChart = echarts.init(document.getElementById('main'));   

    var option = {
    	    xAxis: {
    	        type: 'category',
    	        boundaryGap: false,
    	        data: []
    	    },
    	    yAxis: {
    	        type: 'value'
    	    },
    	    series: [{
    	        data: [],
    	        type: 'line',
    	        areaStyle: {}
    	    }]
    	};
   // ;
    layui.use('laydate', function(){
    	  var laydate = layui.laydate;
    	  
    	  //执行一个laydate实例
    	  laydate.render({
    	    elem: '#date' //指定元素
    	  });
    });
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	 //重新渲染表单
    	 getDataType()
    	 getCity()
         function renderForm(){
          layui.use('form', function(){
          var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
          form.render();
          });
         }
    	 function tableRender(){
    		//展示已知数据
    		  let type = $("#datatype").val()
        	  let cid = $("#cid").val()
    	       table.render({
    	           elem: '#demo'
    	          ,url:"<%=basePath%>data/realtimesearch?cid="+cid+"&type="+type
    	          ,cols: [[ //标题栏
    	             {field: 'name', title: '数据名称'}
    	            ,{field: 'nums', title: '实时数值'}
    	            ,{field: 'createtime', title:'时间'}
    	         ]]
    	        ,skin: 'line' //表格风格
    	        ,even: true
    	        ,page: true //是否显示分页
    	        ,limits: [5, 7, 10,15]
    	        ,limit: 15 //每页默认显示的数量
    	       });
    	 }
    	 //获取数据下拉框
         function getDataType(){
        	 $.ajax({
                 url:"<%=basePath%>base/findAll",
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	
                     let options = "<option value=''></option>"
                     res.forEach(item=>{
                    	 options+="<option value='" + item.id + "'>" + item.typename + "</option>";
                     })
                    
                     $("#datatype").html(options)
                     
                   
                     renderForm()
                 },
                 error:function(){
                  
                 }
             });
         }
    	 //获取城市下拉框
    	 function getCity(){
    		 $.ajax({
                 url:"<%=basePath%>city/findAll",
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	
                     let options = "<option value=''></option>"
                     res.forEach(item=>{
                    	 options+="<option value='" + item.id + "'>" + item.city + "</option>";
                     })
                    
                     $("#cid").html(options)
                     
                   
                     renderForm()
                 },
                 error:function(){
                  
                 }
             });
    	 }
         //查询
         $(document).on('click','#search',function(){
        	 getdata()
        	 tableRender()
         });
        function getdata(){
        	 let type = $("#datatype").val()
        	 let cid = $("#cid").val()
        	 $.ajax({
                 url:"<%=basePath%>data/realtime?cid="+cid+"&type="+type,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	
                	option.xAxis.data = res.data;
                 	option.series = res.series;
                 	 console.log(option)
                 	myChart.setOption(option)
                    console.log(res)
                 },
                 error:function(){
                  
                 }
             });
         }
       
});
   </script>
</body>
</html>