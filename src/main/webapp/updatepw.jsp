<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="type.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改密码1核实</title>
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
	$("#updaf2").css("display","none");
	$("#upda1").click(function(){
		$.messager.progress();// 显示进度条
		$('#updaf1').form('submit', {
			url:'us_update1.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				var data = eval('(' + code + ')');//将JSON字符串转化为js对象！！！！！！必须
				if(code=="0"){
					$.messager.alert('提示','用户名或密码错误');
					
					$.messager.progress('close');	
				}else{
					$.messager.alert('提示','请修改');
					$("#updaf1").css("display","none");
					$("#updaf2").css("display","block");
					$("#uid").val(data.uid);
					}
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	$("#upda2").click(function(){
		$.messager.progress();// 显示进度条
		$('#updaf2').form('submit', {
			url:'us_update2.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				if(code=="0"){
					$.messager.alert('提示','修改失败');
					$.messager.progress('close');	
				}else{
					$.messager.alert('提示','修改成功');
					window.location.href = "login.jsp";
					}
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	});

</script>
</head>
<body>
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">修改密码</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<!--1、核实密码修改 -->
<form method="post" action="" name="updaf1" id="updaf1">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="400px" align="center" cellspacing="0px"  cellpadding="3">
<tr align="center">
<th>请输入用户名</th>
<td><input type="text" name="uname" id="uname"/></td>
</tr>
<tr align="center">
<th>请输入原密码</th>
<td><input type="password" name="upw" id="upw"/></td>
</tr>

<tr align="center">
<td colspan="2">
<input type="button" id="upda1" name="upda1" value="修改密码" />
</td>
</tr>
</table>
</form>


<!--2、执行密码修改  -->
<form method="post" action="" name="updaf2" id="updaf2">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="400px" align="center" cellspacing="0px" cellpadding="3">
<tr align="center">
<td>请输入新密码</td>
<td>
<input type="password" name="upw" id="upw"/>
</td>
</tr>
<tr align="center">
<td colspan="2">
<input type="hidden" id="uid" name="uid" value="" />
<input type="button" name="upda2" id="upda2" value="确认修改" />
</td>
</tr>
</table>
</form>
</body>
</html>