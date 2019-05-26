<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/view.css"/>
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
    <style>
        html,body{
            height:100%;
            width:100%;
        }
	
		#container{
		  	height:100%;
            width:100%;
		}
    
     
    </style>
</head>
<body class="layui-view-body">
 <div class="wrapper">
     <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                        <div class="layui-inline" style="padding:20px;">
                                                                                数据类型                                                
                         <div class="layui-inline">
                          <form class="layui-form" action="">
                             <select  id="datatype" lay-verify="required"></select>
                          </form>
                         
                         </div>
                                                                                 
                        </div>
                      <button class="layui-btn" id="search">查询</button>
                      </div>
                      <div id="container" style="width: 100%;height:100%;"></div>
                    
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
	
	
  </div>
 <script src="<%=basePath%>assets/layui.all.js"></script>
 <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>

<script type="text/javascript">
var myChart = echarts.init(document.getElementById('container'));   



option = {
    backgroundColor: '#1b1b1b',
    title : {
        text: '热力图结合地图',
        x:'center',
        textStyle: {
            color: 'white'
        }
    },
    tooltip : {
        trigger: 'item',
        formatter: '{b}'
    },
    toolbox: {
        show : true,
        orient : 'vertical',
        x: 'right',
        y: 'center',
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
           
        }
    },
    visualMap: {
        min: 0,
        max: 300,
        splitNumber: 5,
        inRange: {
            color: ['#d94e5d','#eac736','#50a3ba'].reverse()
        },
        textStyle: {
            color: '#fff'
        }
    },
    series : [
        {
            name: '北京',
            type: 'map',
            mapType: 'china',
            roam: true,
            hoverable: false,
            data:[],
            heatmap: {
                minAlpha: 0.1,
                data: []
            },
            itemStyle: {
                normal: {
                    borderColor:'rgba(100,149,237,0.6)',
                    borderWidth:0.5,
                    areaStyle: {
                        color: '#1b1b1b'
                    }
                }
            }
        }
    ]
};
layui.use('table', function(){
	 var table = layui.table,form = layui.form,$=layui.$;
	//重新渲染表单
	 getDataType()
	
     function renderForm(){
      layui.use('form', function(){
      var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
      form.render();
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
	
     //查询
     $(document).on('click','#search',function(){
    	 getdata()
     });
     function getdata(){
    	 let datatype = $("#datatype").val()
    	
    	 $.ajax({
             url:"<%=basePath%>data/heatmap?bid="+datatype,
             type:'post',//method请求方式，get或者post
             dataType:'json',//预期服务器返回的数据类型
             contentType: "application/json; charset=utf-8",
             success:function(res){//res为相应体,function为回调函数
            	 option.series[0].heatmap.data = res
                 myChart.setOption(option)
            	
            	
             },
             error:function(){
              
             }
         });
     }
    
})
// myChart.setOption(option)
                    
                    

//var bmap = myChart.getModel().getComponent('bmap').getBMap();
//bmap.addControl(new BMap.MapTypeControl());
	


</script>
</body>
</html>