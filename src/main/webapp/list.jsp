<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>展示成绩单</title>
<!-- 引入EasyUI -->
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
<script type="text/javascript" src="easyui/jquery-1.9.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- ***************************************************************************** -->
<!--EasyUI_ajax提交  -->
<script type="text/javascript">
$(function(){
	$("#fdg2").css("display","none");
	  $('#dg').datagrid({    
		    url:'sc_page.do',
		    striped:true,
		    singleSelect:true,
		    fixed:true,
		    pagination:true,
		    pageList:[5,10,15,20],
		    pageSize:5,
		    columns:[[    
		    	{field:'sname',title:'学生姓名',width:300,align:'center'},
		        {field:'spicture',title:'学生照片',width:280,align:'center',
		        	formatter:function(value,row,index){
		        		return '<img src=picture/'+row.spicture+' width="120" height="90">';
		        	}
		        	},
		        {field:'sclazz',title:'学生班级',width:300,align:'center'},
		        {field:'lname',title:'课程',width:300,align:'center'},
		        {field:'score',title:'成绩',width:300,align:'center'},
		        {field:'opt',title:'操作',width:400,align:'center',
		        	formatter:function(value,row,index){
						var bt1='<input type="button" value="删除成绩" onclick="delscById('+row.scoid+')">';
						var bt2='<input type="button" value="修改成绩" onclick="findscById('+row.scoid+')">';
						
						return bt1+'&nbsp;'+bt2;
					}	
		        }
     
		    ]]  
		});   

});
//删除
function delscById(scoid){
	 $.messager.confirm('确认','您确认要删除吗？',function(r){    
		    if (r){    
		        $.get('sc_delSc.do?scoid='+scoid,function(code){
		        	if(code=='1'){
		        		$.messager.alert('提示','删除成功');
						$('#dg').datagrid('reload');    // 重新载入当前页面数据  
		        	}else{
		        		$.messager.alert('提示','删除失败');
		        	}
		        });    
		    }    
		});  

};
//查一个
function findscById(scoid){
	$("#fdg").css("display","none");
	$("#fdg2").css("display","block");
	$.getJSON('sc_findsc.do?scoid='+scoid,function(emp){
		        	$("#sname").html(emp.sname);
		        	$("#lession").html(emp.lname);
					$("#score").val(emp.score);
					$("#scoid").val(emp.scoid);
		        });    		 
};
//修改
$(function(){
	$("#updatesc").click(function(){
		$.messager.progress();// 显示进度条
		$('#fupdatesc').form('submit', {
			url:'sc_up.do',
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
					window.location.href = "list.jsp";
					}
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
			}
		});

	});
});
</script>
</head>
<body>
<div id="fdg">
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">成绩展示</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<!-- 1、成绩列表 -->
<table id="dg">
</table>
</div>

<!--2、修改成绩  -->
<div id="fdg2">
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">修改</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<form method="post" action="" id="fupdatesc" name="fupdatesc">
<table style="border-color:#F8F8F8" border="1px" width="400px" height="400px" align="center" cellspacing="0px"  cellpadding="3">
<tr align="center">
<th>姓名：</th>
<th><span id="sname"></span></th>
</tr>
<tr align="center">
<th>课程：</th>
<th><span id="lession"></span></th>
</tr>
<tr align="center">
<th>成绩：</th>
<td><input type="text" name="score" id="score" value=""/></td>
</tr>
<tr align="center">
<td colspan="2">
<input type="hidden" id="scoid" name="scoid" value="" />
<input type="button" id="updatesc" name="updatesc" value="提交" />
</td>
</tr>
</table>
</form>
</div>
<p align="center">
<a style="text-decoration: none; color: #0D5EB7;" href="add.jsp">返回添加成绩</a>
</p>
</body>
</html>