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
   <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
       <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=DDLwA2CBFGHRpxFzFx3K5KnBQtHP4hte"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
  
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
    .btn{
            width:14em;
            margin-left:3.2rem;  
            margin-top: 0.8rem; 
        }
        .circalOut{
           width: 100px;
           height: 100px;
           border-radius: 50%;
           background: orange;
           position: relative;
           margin:auto;
          
       }
       .circalInner{
           width: 80px;
           height: 80px;
           border-radius: 50%;
           background: #999;
           text-align: center;
           padding-top:25px;
           box-sizing:border-box;
           position: absolute;
           top: 50%;
           left: 50%;
           transform: translate(-50%,-50%);
       }
       .air_top,.air_bottom{
            display: flex;
           text-align: center
       }
     
    </style>
</head>
<body class="layui-view-body">
    <div class="layui-content" id="box" style="display:none">
       <div class="layui-content" id="AirDetail" style="width:60%;margin:auto;padding:10px 0px">
         <div class="air_top">
                <div class="circalOut">
                    <div class="circalInner">
                          PM2.5 
                         <div class="PM25">
                            
                         </div>
                    </div>
                </div>
                <div class="circalOut">
                    <div class="circalInner">
                         PM10
                         <div class="PM10">
                            
                         </div>
                    </div>
                 </div>
                 <div class="circalOut" >
                     <div class="circalInner">
                          CO
                        <div class="CO">
                            
                         </div>
                      </div>
                 </div>
         </div>
          <div class="air_bottom" style="margin-top:10%">
                <div class="circalOut">
                    <div class="circalInner">
                         NO2
                        <div class="NO2">
                            
                         </div>
                    </div>
                </div>
                <div class="circalOut">
                    <div class="circalInner">
                       O3
                      <div class="O3">
                            
                         </div>
                    </div>
                </div>
                <div class="circalOut">
                    <div class="circalInner">
                       SO2
                       <div class="SO2">
                            
                         </div>
                    </div>
                </div>
          </div>
         </div>
     </div>
 <div class="wrapper">
	<div id="container" style="width: 100%;height:100%;"></div>
	
  </div>
  





 

 
 

<script src="<%=basePath%>assets/layui.all.js"></script>

<script type="text/javascript">
var myChart = echarts.init(document.getElementById('container'));   
let hotData = [
    [120.865048,32.015055,273,'南通'],
    [119.942196,31.767865,100,'常州'],
    [118.798244,32.067442,80,'南京'],
    [119.418972,32.3811142,180,'扬州'],
    [120.297878,31.558637,110,'无锡'],
    [119.449184,32.201174,90,'镇江'],
    [108.987453,34.292389,200,'西安'],
]

	option = {
	   /* title: {
	        text: '全国主要城市空气质量',
	        subtext: 'data from PM25.in',
	        sublink: 'http://www.pm25.in',
	        left: 'center',
	        textStyle: {
	            color: '#fff'
	        }
	    },*/
	    backgroundColor: '#404a59',
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
	    geo: {
	        map: 'china',
	        zoom:1, 
	        roam: false,
	        label: {
	            normal: {
	              show: true,
	              textStyle: {
	              //  color: "#F0F8FB"
	              }
	            },
	           
	          },
	         
	    },
	    series: [{
	        name: 'AQI',
	        type: 'heatmap',
	        coordinateSystem: 'geo',
	        data:hotData
	    }]
	};
                    
                    
myChart.setOption(option)
var bmap = myChart.getModel().getComponent('bmap').getBMap();
bmap.addControl(new BMap.MapTypeControl());
	


</script>
</body>
</html>