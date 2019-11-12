<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加学生</title>
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
alert("111");
$(function(){
	$("#stadd").click(function(){
		$.messager.progress();// 显示进度条
		$('#staddf').form('submit', {
			url:'st_add.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				if(code=="1"){
					$.messager.alert('提示','添加成功');
					 window.location.href = "add.jsp";//若注册成功，页面跳转
				}else{
					$.messager.alert('提示','添加失败');
				
					}
				
			
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
	});

</script>
</head>
<body>
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">学生添加</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<form action="" enctype="multipart/form-data" method="post" name="staddf" id="staddf">
学生姓名:<input type="text" id="sname" name="sname"><br>
学生班级:<input type="text" id="sclazz" name="sclazz"><br>
学生照片：<input type="file" id="pic" name="pic" /> <br><!--学生照片  -->
<input type="button" id="stadd" name="stadd" value="确定">

</form>
</body>
</html>