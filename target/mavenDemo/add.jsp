<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加成绩</title>
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
	
	//生成复选框
	$.getJSON('st_findstleall.do',function(map){
		var lst=map.lst;
        var les=map.les;
		$('#studentid').combobox({    
		    data:lst,    
		    valueField:'stuid',    
		    textField:'sname',
		    value:'--请选择--',
		    panelWidth:80,
		    width:80,
		    panelHeight:80
		}); 
		$('#lessionid').combobox({    
		    data:les,    
		    valueField:'lid',    
		    textField:'lname',
		    value:'--请选择--',
		    panelWidth:80,
		    width:80,
		    panelHeight:80
		}); 
	});
});
//提交成绩单
$(function(){
	$("#scadd").click(function(){
		$.messager.progress();// 显示进度条
		$('#scaddf').form('submit', {
			url:'sc_add.do',
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
					 window.location.href = "list.jsp";//若注册成功，页面跳转
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
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">成绩录入</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<form method="post" action="" name="scaddf" id="scaddf">
<table style="border-color:#F8F8F8" border="1px"  align="center" width="400px" height="250px" cellspacing="0" cellpadding="3">

<tr align="center">
<th>选择学生</th>
<td>
<select  name="studentid" id="studentid">
</select>
</td>
</tr>
<tr align="center">
<th>选择课程</th>
<td>
<select  name="lessionid" id="lessionid">
</select>
</td>
</tr>
<tr>
<th align="center">输入成绩</th>
<td align="center"><input type="text" name="score" id="score"/></td>
</tr>
<tr align="center">
<td colspan="2" >
<input type="button" name="scadd" id="scadd" value=" 确认 " />
</td>
</tr>
</table>
</form>
<p align="center">
<a style="text-decoration: none; color: #0D5EB7;" href="addst.jsp">添加学生</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a style="text-decoration: none; color: #0D5EB7;" href="">成绩列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a style="text-decoration: none; color: #0D5EB7;" href="login.jsp">返回登录</a>

</p>
</body>
</html>