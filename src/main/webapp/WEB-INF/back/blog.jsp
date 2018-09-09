<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="../images/yc.png"/>
<title>写博文</title>
<style type="text/css">
ul{
	list-style-type: none;
}

ul>li{
	margin-top: 10px;
}
</style>
</head>
<body>
<form id="myform">
	<ul>
		<li>类型：
			<select id="tid">
			
			</select>
		</li>
		<li>标题：<input type="text" id="title"/></li>
		<li>日期：<input type="date" id="bdate" class="sang_Calender"/></li>
		<li>正文：<br></br>
			<textarea id="content" rows="6" cols="160"></textarea>
		</li>
		<li>日期：<input type="button" value="发表" onclick="addBlog()"/></li>
	</ul>
</form>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" src="../js/datetime.js"></script>
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("content"); 
	
	$.get("../findAllBlogType",{},function(data){
		var str="";
		$.each(data,function(index,item){
			str+="<option value='"+item.tid+"'>"+item.tname+"</option>";
		});
		if(str!=""){
			$("#tid").append($(str));
		}
	},"json");
});

function addBlog(){
	var tid=$.trim($("#tid").val());
	var title=$.trim($("#title").val());
	var bdate=$.trim($("#bdate").val());
	var content=CKEDITOR.instances.content.getData();
	
	$.ajaxFileUpload({
		url:'../addBlog',
		secureuri:false,
		dataType:"json",
		data:{tid:tid,title:title,bdate:bdate,content:content},
		success:function(data,stuts){
			data=$.trim(data);
			alert(data);
			if(data=="1"){
				$("#myform")[0].reset();
				CKEDITOR.instances.content.setData("");
				alert("博文信息发表成功...");
			}else{
				alert("博文信息发表失败...");
			}
		},
		error:function(data,status,e){
			alert("博文信息添加失败...\n"+e);
		}
	});
}
</script>
</body>
</html>