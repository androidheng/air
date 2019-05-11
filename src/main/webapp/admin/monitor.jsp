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
	<div id="container"></div>
	
  </div>
  


<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.14&key=4f4388a14723c2fc91b750e5f9b0ce33&plugin=AMap.Geocoder"></script>
<script src="<%=basePath%>assets/layui.all.js"></script>
<script type="text/javascript">

 let layer = null
 let $ = null
 let city = ''
 layui.use('layer', function(){ layer = layui.layer,$ = layui.$ });
    var map = new AMap.Map("container", {
          resizeEnable: true,
          center: [118.802364,32.059293],
          size:11
    });
    
    getMarkers()

    //发送请求获取站点 并且 标注到地图上
    function getMarkers(){
        $.ajax({
	        url : "<%=basePath%>/city/myCity",
	        dataType : "json",
	        success : function(res) {
	        	console.log(res)
            	let requestData = res.data
            	
             //jfong 为后台返回数据
	             var marker;		
	          	 for(var i=0 ; i< requestData.length;i++){
		            	var jfong=[ +requestData[i].lat,+requestData[i].lon];	
			          	marker = new AMap.Marker({
			              position: jfong,
			              zIndex: 101,
			              map:map,
                          icon: 'http://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png',
                          draggable: false,
                          cursor: 'move'
			             });	
		                 marker.setMap(map);	
		            	 marker.city = requestData[i].city; //赋值站点名称
		                 marker.on('click', function(e){
		                	city = e.target.city
                            openDilog()
		            	 });
	           	 }	// for-end
             }
		
        }) //	Ajax结束

      }
    function getAirData(){
    	//获取空气质量接口 暂时报错 
        $.ajax({
	        url : "<%=basePath%>data/cityMonitor?city="+city,
	        dataType : "json",
            success : function(res) {
            	let requestData = res
            	$('.PM25').html(requestData.pm25)
            	$('.PM10').html(requestData.pm10)
            	$('.CO').html(requestData.co)
            	$('.NO2').html(requestData.no2)
            	$('.O3').html(requestData.o3)
            	$('.SO2').html(requestData.so2	)
           },
          	
		
        })//	Ajax结束
    }

    function openDilog(){
       let timer = 0
       layer.open({
         type: 1
        ,title: false //不显示标题栏
        ,closeBtn: true
        ,area: '800px'
        ,shade: 0.8
        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        ,btn: ['确定']
        ,btnAlign: 'c'
        ,moveType: 1 //拖拽模式，0或者1
        ,content: $("#box")
        ,yes: function(layero){
           layer.close(layero);
           clearInterval(timer)
        },
        success:function(){
        	timer = setInterval(getAirData,10000)  //1000 获取空气数据的 周期 1000表示1秒
        }
        ,end:function(layero){
            layer.close(layero) 
            $("#box").hide()
           clearInterval(timer)
        }
      });
    
    }
	


</script>
</body>
</html>