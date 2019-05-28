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
                          </form>
                      </div>
                                                                 
                        <div class="layui-inline">
                                                                                
                                                                                              呈现形式
                           <div class="layui-inline">
                           <form class="layui-form" action="">
                             <select  id="showType" lay-verify="required">
                                <option value="0">仪表盘</option>
                                <option value="1">雷达图</option>
                             </select>
                          </form>
                         
                        </div>
                        </div>
                      <button class="layui-btn" id="search">查询</button>
                    </div>
                    
                     <div id="meterChart" style="width: 100%;height:600px;"></div>
                     <div id="radarChart" style="width: 100%;height:600px;"></div>
                    
                    <table id="demo" lay-filter="demo" ></table>
                </div>
            </div>
        </div>
    </div>
   </div>
    <script src="<%=basePath%>assets/layui.all.js"></script>
    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
  
   
    <script>
    var meterChart = echarts.init(document.getElementById('meterChart'));   
    var radarChart = echarts.init(document.getElementById('radarChart'));   

    var meterOption = {
    	    tooltip : {
    	        formatter: "{a} <br/>{c} {b}"
    	    },
    	  
    	    series : [
    	        {
    	            name:'PM2.5',
    	            type:'gauge',
    	            center : ['25%', '30%'],    // 默认全局居中
    	            radius : '40%',
    	            axisLine: {            // 坐标轴线
    	                lineStyle: {       // 属性lineStyle控制线条样式
    	                    width: 8
    	                }
    	            },
    	            axisTick: {            // 坐标轴小标记
    	                length :12,        // 属性length控制线长
    	                lineStyle: {       // 属性lineStyle控制线条样式
    	                    color: 'auto'
    	                }
    	            },
    	            splitLine: {           // 分隔线
    	                length :20,         // 属性length控制线长
    	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
    	                    color: 'auto'
    	                }
    	            },
    	            pointer: {
    	                width:5
    	            },
    	            title : {
    	                offsetCenter: [0, '-30%'],       // x, y，单位px
    	            },
    	            detail : {
    	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
    	                    fontWeight: 'bolder'
    	                }
    	            },
    	            data:[]
    	        },
    	        {
    	            name:'PM10',
    	            type:'gauge',
    	            center : ['50%', '30%'],    // 默认全局居中
    	            radius : '40%',
    	            axisLine: {            // 坐标轴线
    	                lineStyle: {       // 属性lineStyle控制线条样式
    	                    width: 8
    	                }
    	            },
    	            axisTick: {            // 坐标轴小标记
    	                length :12,        // 属性length控制线长
    	                lineStyle: {       // 属性lineStyle控制线条样式
    	                    color: 'auto'
    	                }
    	            },
    	            splitLine: {           // 分隔线
    	                length :20,         // 属性length控制线长
    	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
    	                    color: 'auto'
    	                }
    	            },
    	            pointer: {
    	                width:5
    	            },
    	            title : {
    	                offsetCenter: [0, '-30%'],       // x, y，单位px
    	            },
    	            detail : {
    	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
    	                    fontWeight: 'bolder'
    	                }
    	            },
    	            data:[]
    	        },
    	        {
    	        	name:'SO2',
      	            type:'gauge',
      	            center : ['75%', '30%'],    // 默认全局居中
      	            radius : '40%',
      	            axisLine: {            // 坐标轴线
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    width: 8
      	                }
      	            },
      	            axisTick: {            // 坐标轴小标记
      	                length :12,        // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            splitLine: {           // 分隔线
      	                length :20,         // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            pointer: {
      	                width:5
      	            },
      	            title : {
      	                offsetCenter: [0, '-30%'],       // x, y，单位px
      	            },
      	            detail : {
      	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
      	                    fontWeight: 'bolder'
      	                }
      	            },
      	            data:[]
    	          
    	        },
    	        {
    	        	name:'CO',
      	            type:'gauge',
      	            center : ['25%', '70%'],    // 默认全局居中
      	            radius : '40%',
      	            axisLine: {            // 坐标轴线
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    width: 8
      	                }
      	            },
      	            axisTick: {            // 坐标轴小标记
      	                length :12,        // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            splitLine: {           // 分隔线
      	                length :20,         // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            pointer: {
      	                width:5
      	            },
      	            title : {
      	                offsetCenter: [0, '-30%'],       // x, y，单位px
      	            },
      	            detail : {
      	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
      	                    fontWeight: 'bolder'
      	                }
      	            },
      	            data:[]
    	          
    	        },
    	        {
    	        	name:'NO2',
      	            type:'gauge',
      	            center : ['50%', '70%'],    // 默认全局居中
      	            radius : '40%',
      	            axisLine: {            // 坐标轴线
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    width: 8
      	                }
      	            },
      	            axisTick: {            // 坐标轴小标记
      	                length :12,        // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            splitLine: {           // 分隔线
      	                length :20,         // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            pointer: {
      	                width:5
      	            },
      	            title : {
      	                offsetCenter: [0, '-30%'],       // x, y，单位px
      	            },
      	            detail : {
      	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
      	                    fontWeight: 'bolder'
      	                }
      	            },
      	            data:[{value: 1.5, name: 'NO2 m3/mg'}]
    	          
    	        },
    	        {
    	        	name:'O3',
      	            type:'gauge',
      	            center : ['75%', '70%'],    // 默认全局居中
      	            radius : '40%',
      	            axisLine: {            // 坐标轴线
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    width: 8
      	                }
      	            },
      	            axisTick: {            // 坐标轴小标记
      	                length :12,        // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            splitLine: {           // 分隔线
      	                length :20,         // 属性length控制线长
      	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
      	                    color: 'auto'
      	                }
      	            },
      	            pointer: {
      	                width:5
      	            },
      	            title : {
      	                offsetCenter: [0, '-30%'],       // x, y，单位px
      	            },
      	            detail : {
      	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
      	                    fontWeight: 'bolder'
      	                }
      	            },
      	            data:[]
    	          
    	        },
    	       
    	    ]
    	 
    	};
    let  radarOption = {
    		tooltip : {
 		         trigger: 'axis',
 		        
 		    },
 		    legend: {
 		        x : 'center',
 		        data:[]
 		    },
 		    toolbox: {
 		        show : true,
 		        feature : {
 		            mark : {show: true},
 		            dataView : {show: true, readOnly: false},
 		            restore : {show: true},
 		            saveAsImage : {show: true}
 		        }
 		    },
 		    calculable : true,
 		    polar : [
 		        {
 		            indicator : [
 		            	   {max: "250", text: "PM2.5"},
 	    	        	   {max: "250", text: "PM10"},
 	    	        	   {max: "250", text: "SO2"},
 	    	        	   {max: "250", text: "CO"},
 	    	        	   {max: "250", text: "NO2"},
 	    	        	   {max: "250", text: "O3"}
 		            ],
 		            radius : 130
 		        }
 		    ],
 		    series : [
 		        {
 		            name: '实时空气质量',
 		            type: 'radar',
 		            itemStyle: {
 		                normal: {
 		                    areaStyle: {
 		                        type: 'default'
 		                    }
 		                }
 		            },
 		            data : [
 		             
 		                {
 		                	value : [43,101, 25, 0.6,121, 106],
 		                    name : '实时空气质量',
 		                  
 		                }
 		            ]
 		        }
 		    ]
 	   
    	};
  
    
   // ;
   
    layui.use('table', function(){
    	 var table = layui.table,form = layui.form,$=layui.$;
    	  
    	 
    	 getCity()
         function renderForm(){
          layui.use('form', function(){
          var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
          form.render();
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
         let timer = 0
         $(document).on('click','#search',function(){
        	 let showType = $("#showType").val()
        	 if(showType==1){
        		 clearInterval(timer)
        		 getdata() 
        	 }else{
        		 getdata()
        		 timer = setInterval(getdata,10000)
        	 }
        	
        	
        });
        function getdata(){
        	 let showType = $("#showType").val()
        	 let cid = $("#cid").val()
        	 let method = showType==0?'dashboard':'radar'
        	 $.ajax({
                 url:"<%=basePath%>data/"+method+"?cid="+cid,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	
                	 if(showType==1){
                		 radarOption.legend.data = res.legend.data
                		 radarOption.polar = res.polar
                		 radarOption.series[0].data[0].value = res.data[0].data
                		
                		 radarChart.setOption(radarOption)
                		 $("#radarChart").show()
                		 $("#meterChart").hide()
                	 }else{
                		 meterOption.series[0].data = res.series[0].data;
                    	 meterOption.series[1].data = res.series[1].data;
                    	 meterOption.series[2].data = res.series[2].data;
                    	 meterOption.series[3].data = res.series[3].data;
                    	 meterOption.series[4].data = res.series[4].data;
                    	 meterOption.series[5].data = res.series[5].data;
                    	 meterChart.setOption(meterOption)
                    	 $("#radarChart").hide()
                		 $("#meterChart").show()
                	 }
                	
                	//option.xAxis.data = res.data;
                	
                 },
                 error:function(){
                  
                 }
             });
         }
       
});
   </script>
</body>
</html>