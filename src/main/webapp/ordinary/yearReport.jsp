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
                  <a>年报表</a>
                </span>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                        <div class="layui-inline">
                                                                    
                                                                            时间
                         <div class="layui-inline" >
                            <input type="text" id="date" class="layui-input">  
                         </div>
                        </div>
                      <button class="layui-btn"  data-type="reload">查询</button>
                       <button class="layui-btn" id="importExcel">导出Excel</button>
                    </div>
                  <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.all.js"></script>
   
  
   
    <script>
    

   
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	
    	
         function renderForm(){
          layui.use('form', function(){
          var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
          form.render();
          });
         }
    	 layui.use('laydate', function(){
	     	  var laydate = layui.laydate;
	          //执行一个laydate实例
	     	  laydate.render({
	     	    elem: '#date', //指定元素
	     	    type:'year',
	     	   value: new Date()
	     	  });
         });
    	//展示已知数据
         table.render({
            elem: '#demo'
           ,url:" <%=basePath%>data/baobiao?type=2"
           ,cols: [[ //标题栏
        	  {field: 'city', title: '城市名'}
        	 ,{field: 'aqi', title: 'aqi' }
             ,{field: 'co', title: 'co'}
             ,{field: 'no2', title: 'no2'}
             ,{field: 'o3', title: 'o3'}
             ,{field: 'pm2', title: 'pm2'}
             ,{field: 'pm10', title: 'pm10'}
             ,{field: 'so2', title: 'so2'}
             ,{field: 'quality', title: '空气质量'}
             ,{field: 'createtime', title: '创建时间'}
          ]]
          
         ,id:'testReload'
         ,skin: 'line' //表格风格
         ,even: true
         ,page: true //是否显示分页
         ,limits: [5, 7, 10]
         ,limit: 5 //每页默认显示的数量
        });
         var  active = {
      	       reload: function(){
      	       
      	        var date = $('#date');
      	        //执行重载
      	         table.reload('testReload', {
      	           page: {
      	             curr: 1 //重新从第 1 页开始
      	           }
      	           ,where: {
      	             type: 2,
      	             date: date.val(),
      	           
      	           }
      	         });
      	       }
      	     };
      	     
        $('.demoTable .layui-btn').on('click', function(){
      	    var type = $(this).data('type');
      	    active[type] ? active[type].call(this) : '';
      	});
         $(document).on('click','#importExcel',function(){
        	
        	 let date = $("#date").val()
            
        	 if(!date) return alert('请先选日期');
        	 location.href="<%=basePath%>data/exportbaobiao?date="+date+"&type=2";
         });
    	
    	
         //查询
         $(document).on('click','#search',function(){
        	 getdata()
         });
        function getdata(){
        	 let date = $("#date").val()
        	 $.ajax({
                 url:" <%=basePath%>data/baobiao?date="+date+"&type=0",
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	
                 },
                 error:function(){
                  
                 }
             });
         }
       
});
   </script>
</body>
</html>