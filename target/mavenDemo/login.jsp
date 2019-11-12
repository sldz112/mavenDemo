<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="type.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<!--引入EasyUI  -->
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
<script type="text/javascript" src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- ***************************************************************************** -->
<!--EasyUI_ajax提交  -->
<script type="text/javascript">

$(function(){
	$("#uslog").click(function(){
		$.messager.progress();// 显示进度条
		$('#ulogf').form('submit', {
			url:'us_log.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				if(code=="1"){
					$.messager.alert('提示','欢迎，学生用户');
					 window.location.href = "look.jsp";//若注册成功，页面跳转
				}else if(code=="2"){
					$.messager.alert('提示','欢迎，教师用户');
					window.location.href = "success.jsp";
					}else if(code=='3'){
					$.messager.alert('提示','欢迎，管理员');
					window.location.href = "welcome.jsp";
					}else{
						$.messager.alert('提示','用户名或密码错误');
						window.location.href = "err.jsp";
					}
				
			
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	});

</script>
</head>
<body>
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">用户登录</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">

<form method="post" action="" name="ulogf" id="ulogf">

<table style="border-color: #F8F8F8" align="center" border="1px"  width="500px" height="250px" cellspacing="0px"  cellpadding="3">
<tr align="center" >
<th width="150px">用户名</th>
<td><input type="text" name="uname" /></td>
</tr>
<tr align="center">
<th>密码</th>
<td><input type="password" name="upw" /></td>
</tr>
<tr align="center" height="20px">
<td><a style="text-decoration: none; color: #0D5EB7;" href="useradd.jsp">没有账号？请注册！！</a></td>
<td><a style="text-decoration: none; color: #0D5EB7;" href="fogotpw.jsp">忘记密码</a></td>
</tr>
<tr align="center">
<td colspan="2">
<input type="button" name="uslog" id="uslog" value="登录" />
</td>
</tr>
</table>
<p  style="margin-left: 59%"><a style="text-decoration: none; color: #A4A4A4; " href="updatepw.jsp">修改密码....</a></p>
</form>
</div>
</body>
</html>