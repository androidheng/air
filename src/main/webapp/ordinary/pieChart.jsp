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
                  <a>饼状图</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                                                                    
                                                                   日期：
                      <div class="layui-inline">
                         <input type="text" id="date"  class="layui-input">  
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
    	    title : {
    	        text: '',
    	        subtext: '',
    	        x:'center'
    	    },
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },
    	    
    	    series : [
    	        {
    	           // name: '访问来源',
    	            type: 'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[
    	               
    	            ],
    	            itemStyle: {
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};
    //myChart.setOption(option)
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
    	
    	
         function renderForm(){
          layui.use('form', function(){
          var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
          form.render();
          });
         }
    	 
    	 //获取城市下拉框
    	
         //查询
         $(document).on('click','#search',function(){
        	 getdata()
         });
         function getdata(){
        	 let type = $("#datatype").val()
        
        	 let dates = $("#date").val()
        	
        	 $.ajax({
                 url:"<%=basePath%>data/findBingData?dates="+dates,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	//option.xAxis.data = res.xdata;
                	option.series[0].data = res.data;
                	myChart.setOption(option)
                  
                 },
                 error:function(){
                  
                 }
             });
         }
       
});
   </script>
</body>
</html>