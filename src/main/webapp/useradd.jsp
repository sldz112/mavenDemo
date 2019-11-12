<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="type.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
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
	$("#usadd").click(function(){
		$.messager.progress();// 显示进度条
		$('#usaddf').form('submit', {
			url:'us_add.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				if(code=="1"){
					$.messager.alert('提示','提交成功');
					 window.location.href = "login.jsp";//若注册成功，页面跳转
				}else{
					$.messager.alert('提示','提交失败');
				
					}
				
			
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	});

</script>
</head>
<body>
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">用户注册</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<form method="post" action="" id="usaddf">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="400px" align="center" cellspacing="0px"  cellpadding="3">
<tr align="center">
<th>请输入用户名</th>
<td><input type="text" name="uname" id="uname"/></td>
</tr>
<tr align="center">
<th>请输入密码</th>
<td><input type="password" name="upw" id="upw"/></td>
</tr>
<tr align="center">
<th>密保问题</th>
<td><input type="text" name="ques" id="ques"/></td>
</tr>
<tr align="center">
<th>密保答案</th>
<td><input type="password" name="ans" id="ans"/></td>
</tr>
<tr align="center">
<td colspan="2">
<input type="button" name="usadd" id="usadd"  value="注册" />
</td>
</tr>
</table>
</form>
</body>
</html>