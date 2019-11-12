<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--学生权限登录，输入姓名，  -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>您好，请输入姓名</title>
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
	$("#fsc2").css("display","none");
	$("#fbna").click(function(){
		$.messager.progress();// 显示进度条
		$('#ffbna').form('submit', {
			url:'sc_fbna.do',
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
				}
				return isValid;	// 返回false终止表单提交
			},
			success: function(code){
				var code = eval('(' + code + ')');//将JSON字符串转化为js对象！！！！！！必须(只在这种提交方式下有用！！！)
				var sc=code.lsc;
				if(code=="0"){
					$.messager.alert('提示','无此学生');
					
					$.messager.progress('close');	
				}else{
					$("#fsc2").css("display","block");
					$("#fsc1").css("display","none");
					
					  for (var i = 0; i < sc.length; i++) {
						var sc1=sc[i];
						var sc2=sc[0];
						$("#h1").html(sc2.sname+"的成绩展示：");
						$("#append").append("<tr align='center' ><td>"+sc1.sname+"</td><td>"+sc1.sclazz+"</td><td>"+sc1.lname+"</td><td>"+sc1.score+"</td></tr>"
						);
					}  
					}
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});
	});
});
	
	

</script>
</head>
<body>
<!--1、输入学生姓名  -->
<div id="fsc1">
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">学生账户：查询成绩</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<form method="post" action="" name="ffbna" id="ffbna">
<table style="border-color: #F8F8F8" border="1px" width="400px" height="150px" align="center" cellspacing="0px"  cellpadding="3">
<tr align="center">
<td>请输入学生姓名</td>
<td>
<input type="text" name="sname" id="sname"/>
</td>
</tr>
<tr align="center">
<td colspan="2">

<input type="button" value="确认查询"  name="fbna" id="fbna"/>
</td>
</tr>
</table>
</form>
</div>
<!--2、展示该姓名下学生的成绩  -->
<div id="fsc2">
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 id="h1" style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">学生账户：查询成绩</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<div >
<table id="append" style="border-color:#F8F8F8" border="1px" align="center" width="400px" height="250px" cellspacing="0" cellpadding="3">
<tr align="center" height="50px">
<th>学生姓名</th>
<th>学生班级</th>
<th>课程</th>
<th>成绩</th>
</tr>
</table>
</div>
</div>
<p align="center">
<a style="text-decoration: none; color: #0D5EB7;" href="look.jsp">返回查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a style="text-decoration: none; color: #0D5EB7;" href="login.jsp">返回登录</a>

</p>
</body>
</html>