<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>assets/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/login.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="login-wrap">
    <div class="login-container">
        <form class="login-form layui-form"  action="">
            <div class="layui-form-item">
                <div class="input-group">
                    <input type="text" id="username" name="username" lay-verify="userName" class="input-field">
                    <label for="username" class="input-label">
                        <span class="label-title">用户名</span>
                    </label>
                </div>
            </div>
          
            <div class="input-group">
                <input type="password" name="password"  id="password" lay-verify="pass" class="input-field">
                <label for="password" class="input-label">
                    <span class="label-title">密码</span>
                </label>
            </div>
            <button type="button" class="login-button" lay-submit="" lay-filter="login">登录<i class="ai ai-enter"></i></button>
        </form>
    </div>
</body>
<script src="<%=basePath%>assets/layui.js"></script>
<script src="<%=basePath%>/js/login.js"></script>
<script>
	  layui.use(['form'], function(){
      var form = layui.form
      ,layer = layui.layer
      ,$ = layui.$
      //自定义验证规则
      form.verify({
        userName: function(value){
          if(value.length < 3){
            return '用户名至少得3个字符啊';
          }
        },
        city:function(value){
          if(!value.length){
            return '请选择站点';
          }
         }
        ,pass: [
          /^[\S]{5,12}$/
          ,'密码必须6到12位，且不能出现空格'
        ]
      });
    //重新渲染表单
      function renderForm(){
       layui.use('form', function(){
       var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
       form.render();
       });
       }
      //监听提交
      form.on('submit(login)', function(data){
    	  $.ajax({
            url:"<%=basePath%>user/login",
            type:'post',//method请求方式，get或者post
            dataType:'json',//预期服务器返回的数据类型
            data:JSON.stringify(data.field),//表格数据序列化
            contentType: "application/json; charset=utf-8",
            success:function(res){//res为相应体,function为回调函数
              if(res.success){
                layer.alert(res.message,{icon:1});
                location.href="<%=basePath%>admin/index.jsp";
              //$("#res").click();//调用重置按钮将表单数据清空
            }else{
              layer.alert(res.message,{icon: 5});
            }
          },
          error:function(){
            layer.alert('操作失败！！！',{icon:5});
          }
        });
        /*location.href = 'index.html'
        layer.alert(JSON.stringify(data.field), {
          title: '最终的提交信息'
        })*/
        return false;
      });
     });
   
    </script>
</html>