<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>忘记密码</title>
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
	$("#ffopw2").css("display","none");
	$("#ffopw3").css("display","none");
	$("#fopw1").click(function(){
		$.messager.progress();// 显示进度条
		$('#ffopw1').form('submit', {
			url:'us_fopw1.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				var data = eval('(' + code + ')');//将JSON字符串转化为js对象！！！！！！必须(只在这种提交方式下有用！！！)
				if(code=="0"){
					$.messager.alert('提示','无此用户名');
					
					$.messager.progress('close');	
				}else{
					$.messager.alert('提示','请修改');
					$("#ffopw1").css("display","none");
					$("#ffopw2").css("display","block");
					$("#sp2").html(data.ques);
					$("#uid2").val(data.uid);
					}
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	$("#fopw2").click(function(){
		$.messager.progress();// 显示进度条
		$('#ffopw2').form('submit', {
			url:'us_fopw2.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				var data = eval('(' + code + ')');
				if(code=="0"){
					$.messager.alert('提示','密保答案错误');
					$.messager.progress('close');	
				}else{
					$.messager.alert('提示','正确');
					$("#ffopw2").css("display","none");
					$("#ffopw3").css("display","block");
					$("#uid3").val(data.uid);
					}
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	$("#fopw3").click(function(){
		$.messager.progress();// 显示进度条
		$('#ffopw3').form('submit', {
			url:'us_fopw3.do',
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
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">忘记密码</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<!--1、忘记密码1  -->
<form method="post" action="" id="ffopw1" name="ffopw1">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="200px" align="center" cellspacing="0px"  cellpadding="3">
<tr align="center">
<th>请输入用户名</th>
<td><input type="text" name="uname" id="uname"/></td>
</tr>
<tr align="center">
<td colspan="2">
<input type="button" id="fopw1" name="fopw1" value="提交" />
</td>
</tr>
</table>
</form>
<!--2、忘记密码2  -->
<form method="post" action="" id="ffopw2" name="ffopw2">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="400px" align="center" cellspacing="0px"  cellpadding="3">
<tr align="center">
<th>您的密保问题是：</th>
<th><span id="sp2"></span></th>
</tr>
<tr align="center">
<th>请输入答案：</th>
<td><input type="text" name="ans" id="ans"/></td>
</tr>
<tr align="center">
<td colspan="2">
<input type="hidden" id="uid2" name="uid" value="" />
<input type="button" id="fopw2" name="fopw2" value="提交" />
</td>
</tr>
</table>
</form>
<!--3、忘记密码3  -->
<form method="post" action="" id="ffopw3" name="ffopw3">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="200px" align="center" cellspacing="0px" cellpadding="3">
<tr align="center">
<th>请输入新密码</th>
<td>
<input type="password" name="upw" id="upw"/>
</td>
</tr>
<tr align="center">
<td colspan="2">
<input type="hidden" id="uid3" name="uid" value="" />
<input type="button" id="fopw3" name="fopw3" value="确认修改" />
</td>
</tr>
</table>
</form>
</body>
</html>