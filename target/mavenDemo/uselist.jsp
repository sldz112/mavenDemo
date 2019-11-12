<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@include file="type.jsp" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>账户列表</title>
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
	 $('#dg').datagrid({    
		    url:'us_findusall.do',
		    striped:true,
		    fitcolumns:true,
		    resizeHandle:'both',
		    singleSelect:true,
		    fixed:true,
		    pagination:true,
		    pageList:[5,10,15,20],
		    pageSize:10,
		    columns:[[    
		        {field:'uname',title:'用户名称',width:300,align:'center'},
		        {field:'jur',title:'用户权限',width:300,align:'center',
		        	formatter:function(value,row,index){
		        		if(row.jur==1){
		        			return '<span>普通权限<span>'
		        		}else if(row.jur==10){
		        			return '<span>教师权限<span>'
		        		}else{
		        			return '<span>管理员权限<span>'
		        		}
		        	}
		        	},
		        
		        {field:'upw',title:'用户密码',width:300,align:'center'},
		        {field:'ques',title:'密保问题',width:300,align:'center'},
		        {field:'ans',title:'密保答案',width:300,align:'center'},
		        {field:'opt',title:'操作',width:390,align:'center',
		        	formatter:function(value,row,index){
						var bt1='<input type="button" value="删除用户" onclick="delById('+row.uid+')">';
						var bt2='<input type="button" value="修改权限" onclick="updatejur('+row.uid+')">';
						
						return bt1+'&nbsp;'+bt2;
					}	
		        }
     
		    ]]    
		});  
});

function updatejur(uid){
	 $.messager.confirm('确认','您确认要修改权限吗？',function(r){    
		    if (r){    
		        $.get('us_updatejur.do?uid='+uid,function(code){
		        	if(code=='1'){
		        		$.messager.alert('提示','修改成功');
						$('#dg').datagrid('reload');    // 重新载入当前页面数据  
		        	}else{
		        		$.messager.alert('提示','修改失败');
		        	}
		        });    
		    }    
		});  

};
function delById(uid){
	 $.messager.confirm('确认','您确认要删除吗？',function(r){    
		    if (r){    
		        $.get('us_del2.do?uid='+uid,function(code){
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

</script>

</head>
<body>
<div style="background-color:#0D5EB7;width: 100%;height: 100px;margin-bottom: 30px"><h1 style="margin: 0px;padding-top: 25px;padding-left:30px ;color: white;font-size: 600">用户管理</h1></div>
<hr style="background-color:#0D5EB7;width: 100%;margin-bottom: 20px">
<table id="dg">

</table>

<p  align="center"><a style="text-decoration: none; color: #0D5EB7;" href="login.jsp">返回登录</a></p> 
</body>
</html>