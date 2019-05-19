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
       .container{
          width:100%;
          display:flex;
          padding:20px;
          margin-top:20px;
       }
       .dataItem{
          flex:1;
         
          text-align:center;
          border:1px solid #999;
          border-radius:5px;
          margin-right:10px;
       }
       .dataItem p{
           line-height:30px;
           padding-left:10px;
           background:#999;
           text-align:left
       }
       .dataItem div{
           line-height:100px;
       }
    </style>
    <title>管理后台</title>
</head>
<body class="layui-view-body">
    <div class="layui-content" id="box" style="display:none">
        <div class="container">
             <div class="dataItem">
                   <p>pm25</p>
                   <div class="pm25"><span>0</span>mg/m<sup>3</sup></div>
             </div>
             <div class="dataItem">
                   <p>pm10</p>
                   <div class="pm10"><span>0</span>mg/m<sup>3</sup></div>
             </div>
             <div class="dataItem">
                   <p>co</p>
                   <div class="co"><span>0</span>mg/m<sup>3</sup></div>
              </div>
              <div class="dataItem">
                  <p>o3</p>
                  <div class="o3"><span>0</span>mg/m<sup>3</sup></div>
              </div>
              <div class="dataItem">
                   <p>so2</p>
                   <div class="so2"><span>0</span>mg/m<sup>3</sup></div>
              </div>
              <div class="dataItem">
                   <p>no2</p>
                   <div class="no2"><span>0</span>mg/m<sup>3</sup></div>
             </div>
         </div>
    </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>数据监控</a>
                </span>
                
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                     <div class="demoTable">
                        <div class="layui-inline">
                                                                              数据类型
                         <div class="layui-inline">
                          <form class="layui-form" action="">
                            <select  id="cid" lay-verify="required"></select>
                         </form>
                        </div>
                        </div>
                      <button class="layui-btn" id="search">查询</button>
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
    	 //重新渲染表单
    	 getDataType()
         function renderForm(){
          layui.use('form', function(){
          var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
          form.render();
          });
         }
         function getDataType(){
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
        	 let cid = $("#cid").val()
        	 if(!cid) return alert('请先选择城市');
        	 openDilog()
         });
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
              	timer = setInterval(getdata,10000)  //1000 获取空气数据的 周期 1000表示1秒
              }
              ,end:function(layero){
                  layer.close(layero) 
                  $("#box").hide()
                  clearInterval(timer)
              }
            });
          
          }
         function getdata(){
        	 let cid = $("#cid").val()	
        	 $.ajax({
                 url:"<%=basePath%>data/cityMonitor?cid="+cid,
                 type:'post',//method请求方式，get或者post
                 dataType:'json',//预期服务器返回的数据类型
                 contentType: "application/json; charset=utf-8",
                 success:function(res){//res为相应体,function为回调函数
                	$(".pm25>span").html(res.pm25)
                	$(".pm10>span").html(res.pm10)
                	$(".no2>span").html(res.no2)
                	$(".co>span").html(res.co)
                	$(".o3>span").html(res.o3)
                	$(".so2>span").html(res.so2)
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