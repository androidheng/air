<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-view-body">
     <div class="layui-content" id="box" style="display:none">
          <form class="layui-form" action="" lay-filter="formTest">
           <div class="layui-form-item">
               <label class="layui-form-label">起始值</label>
               <div class="layui-input-block">
                  <input type="number" name="start" id="start" required  lay-verify="required" autocomplete="off" class="layui-input">
               </div>
           </div>
           <div class="layui-form-item">
             <label class="layui-form-label">终止值</label>
                 <div class="layui-input-inline">
                   <input type="number" name="end" id="end" required lay-verify="required" autocomplete="off" class="layui-input">
                 </div>
           </div>
            <div class="layui-form-item">
             <label class="layui-form-label">level</label>
                 <div class="layui-input-inline">
                   <select name="level" id="level" lay-verify="level" >
                      <option value="0">一般</option>
                      <option value="1">重要</option>
                      <option value="2">紧急</option>
                  </select>
                 </div>
           </div>
           <div class="layui-form-item">
              <label class="layui-form-label">数据类型</label>
                <div class="layui-input-block">
                   <select name="bid" id="bid" lay-verify="bid" lay-filter="cityList">
                    
                  </select>
               </div>
           </div>
        </form>
       
     </div>
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a>首页</a>
                  <a>用户信息</a>
                </span>
                <h2 class="title">用户信息</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <table id="demo" lay-filter="demo" ></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
   </div>
  	<script src="<%=basePath%>assets/layui.all.js"></script>
     <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加参数</button>
     </div>
    </script>
    <script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
   <script type="text/html" id="levelTpl">
     {{#  if(d.level == 0){ }}
                     一般
     {{#  } else if(d.level == 1) { }}
                     重要
     {{#  } else { }}
                     紧急
     {{#  } }}
</script>
 <script type="text/html" id="bidTpl">
     {{#  if(d.bid == 1){ }}
           pm2.5
     {{#  } else if(d.bid == 2) { }}
           pm10
     {{#  } else if(d.bid == 3) { }}
                    so2
     {{#  } else if(d.bid == 4) { }}
                    co
     {{#  } else if(d.bid == 5) { }}
                     no2
     {{#  } else { }}
                   o3
     {{#  } }}
</script>
    <script>
  layui.use('table', function(){
      var table = layui.table,form = layui.form,$=layui.$;
       //展示已知数据
       table.render({
           elem: '#demo'
          ,toolbar: '#toolbarDemo'
          ,url:'<%=basePath%>params/search'
          ,cols: [[ //标题栏
             {field: 'start', title: '起始值', }
            ,{field: 'end', title: '终止值'}
            ,{field: 'level', title: '警报状态', templet: '#levelTpl'}
            ,{field: 'bid', title: '污染物',templet: '#bidTpl'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
         ]]
        ,skin: 'line' //表格风格
        ,even: true
        ,page: true //是否显示分页
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
       });
       //重新渲染表单
       function renderForm(){
        layui.use('form', function(){
        var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
        form.render();
        });
       }
     //  getoption()
       function getoption(data){
    	   
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
                   
                    $("#bid").html(options)
                    
                    if(data){
                    	$('#start').val(data.start);
      	        		$('#end').val(data.end);
      	        		$("#bid").val(data.bid)
      	        		$("#level").val(data.level)
                    }
                    renderForm()
                },
                error:function(){
                 
                }
              });
         }
       //打开添加站点弹窗
       function getCitys(data){
    	   layer.open({
  	         type: 1
  	        ,title: false //不显示标题栏
  	        ,closeBtn: true
  	        ,area: ['600px','400px']
  	        ,shade: 0.8
  	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
  	        ,btn: ['确定']
  	        ,btnAlign: 'c'
  	        ,moveType: 1 //拖拽模式，0或者1
  	        ,content: $("#box"),
  	         yes:function(index){
  	        	let parames = {
  	        		level:$('#level').val(),
  	        		start:$('#start').val(),
  	        		end:$('#end').val(),
  	        		bid:$("#bid").val()
  	        	}
  	        	data&&(parames.id=data.id)
  	        	 $.ajax({
  	                   url:"<%=basePath%>params/addOrUpdate",
  	                   type:'post',//method请求方式，get或者post
  	                   dataType:'json',//预期服务器返回的数据类型
  	                   data:JSON.stringify(parames),
  	                   contentType: "application/json; charset=utf-8",
  	                   success:function(res){//res为相应体,function为回调函数
  	                	   if(res.success){
  	                		   layer.close(index);
  	                		  $(".layui-laypage-btn")[0].click();
  	                		 }else{
  	                		   layer.alert('操作失败！！！',{icon:5});
  	                	   }
  	                    },
  	                   error:function(){
  	                       layer.alert('操作失败！！！',{icon:5});
  	                   }
  	            });
  	        },success:function(){
  	        	
  	        	getoption(data)
  	        }
  	       ,end:function(index){
  	    	    $("#box").hide()
  	        	layer.close(index)
  	        }
  	      });
  	   
       }
       //头工具栏事件
       table.on('toolbar(demo)', function(obj){
         switch(obj.event){
           case 'add':
             getCitys()
           break;
         
         };
       });
       //监听行工具事件
       table.on('tool(demo)', function(obj){
         var data = obj.data;
         //console.log(obj)
         if(obj.event === 'del'){
           layer.confirm('真的删除行么', function(index){
        	  $.ajax({
                   url:"<%=basePath%>params/delete",
                   type:'post',//method请求方式，get或者post
                   dataType:'json',//预期服务器返回的数据类型
                   data:JSON.stringify({id:data.id}),
                   contentType: "application/json; charset=utf-8",
                   success:function(res){//res为相应体,function为回调函数
                	   obj.del();
                       layer.close(index);
                    
                   },
                   error:function(){
                       layer.alert('操作失败！！！',{icon:5});
                   }
                 });
           
           });
         } else if(obj.event === 'edit'){
        	 getCitys(data)
         }
       });
     
});
   </script>
</body>
</html>