<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>个人信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	

   
    <link rel="stylesheet" href="http://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <style>
        html,body{
            height:100%;
            width:100%;
        }
		.wrapper{
			width: 100%;
			height: 100%;
			background: rgba(0, 0, 0, 0.3);
			position: fixed;
		}
		#container{
			height:50%;
            width:100%;
		}
        .btn{
            width:14em;
            margin-left:3.2rem;  
            margin-top: 0.8rem; 
        }
    </style>
</head>
<body>
<div class="wrapper">
	<div id="container"></div>
	<div class="input-card" style="position:relative;top: 20px;">
		<label style='color:grey'>请输入或点击地图获取经纬度：(经度,纬度)</label>
		<div class="input-item">
			<div class="input-item-prepend">
				<span class="input-item-text" >经纬度</span>
			</div>
			<input id='lnglat' type="text" value="">
		</div>
  </div>
  <div class="layui-form" style="padding:10px 0px;background:#fff;margin-top:50px;"></form>
      <div class="layui-form-item">
        <label class="layui-form-label">选择站点</label>
        <div class="layui-input-block">
          <select name="interest" lay-filter="aihao">
            <option value=""></option>
            <option value="0">南京</option>
            <option value="1">苏州</option>
            <option value="2">昆山</option>
          </select>
        </div>
      </div>
       <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn"  lay-filter="upload">确定</button>
        </div>
      </div>
    </div>	
</div>


<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.14&key=4f4388a14723c2fc91b750e5f9b0ce33&plugin=AMap.Geocoder"></script>
<script type="text/javascript">
    var map = new AMap.Map("container", {
        resizeEnable: true,
		center: [118.802364,32.059293],
    });

    var $ = function(elementId){
        return document.getElementById(elementId);
    };
    var lnglatInput = $('lnglat');
    var pixelInput = $('pixel');

   
    map.on( 'click',  function (e) {
        console.log(e)
        lnglatInput.value = e.lnglat.toString();
    });

	var marker = new AMap.Marker({
        position:[114.147977,30.681939],
        icon: 'http://a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-default.png',
        // offset: new AMap.Pixel(-13, -30),
        // 设置是否可拖拽
        draggable: false,
        cursor: 'move'
    });
	marker.on('click', function(e){
        console.log(e)
    });

    marker.setMap(map);

  
    
   

</script>
</body>
</html>