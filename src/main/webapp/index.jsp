<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YC论坛</title>
<meta http-equiv="X-UA-Compatiable" content="IE=edge">
<!-- <link type="image/icon" rel="shortcut icon" href="images/yc.png"/> -->
<link type="image/icon" rel="shortcut icon" href="images/20081024114121878_2[1].jpg" />
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/banse.css">
<style type="text/css">
#showPhotoDiv{
	background: #ccc;
	border: 1px solid #666;
	width: 200px;
	height: 230px;
	position: absolute;
	z-index: 100;
	display: none;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%,-50%);
	-moz-transform: translate(-50%,-50%);
	transform: translate(-50%,-50%);
}

#showPhotoInfo{
	width: 100px;
	height: 100px;
	margin-left: 40px;
	margin-top: 10px;
}

.showphoto_title{
	width: 100%;
	line-height: 30px;
	height: 30px;
	background: #fff;
	padding-left: 5px;
}

.showphoto_title>img{
	position: absolute;
	top: 5px;
	right: 5px;
}

#showPhotoDiv>form{
	padding-left: 20px;
}

#userLogin{
	background: #ccc;
	border: 1px solid #666;
	width: 260px;
	height: 160px;
	position: absolute;
	z-index: 100;
	display: none;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%,-50%);
	-moz-transform: translate(-50%,-50%);
	transform: translate(-50%,-50%);
}

#userLogin>form>ul{
	list-style-type: none;
}

#userLogin>form>ul>li{
	margin-top: 10px;
}

#reg{
	background: #ccc;
	border: 1px solid #666;
	width: 260px;
	height: 200px;
	position: absolute;
	z-index: 100;
	display: none;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%,-50%);
	-moz-transform: translate(-50%,-50%);
	transform: translate(-50%,-50%);
}

#reg>form>ul{
	list-style-type: none;
}

#reg>form>ul>li{
	margin-top: 10px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header"> 
	            <a class="navbar-brand fontLogo" href="#"><img src="images/pic_3.jpg" height="50px" alt="好心情共享"/></a>
	        </div>
	        <ul class="nav navbar-nav navbar-left">
	        	<li><a href="#">首页</a></li>
	        	<li><a href="#">动态</a></li>
	        	<li><a href="#">收藏</a></li>
	        </ul>
	        <form action="" class="navbar-form navbar-left">
	        	<div class="form-group">
	        		<input type="text" class="form-control" placeholder="Search">
	        		<button type="submit" class="btn btn-default">搜索</button>
	        	</div>
	        </form>
	        <ul class="nav navbar-nav navbar-right">
	        	<li>
	        	<a href="javascript:showPhotoDiv()" id="showLeaguerPhoto">
	        	<c:if test="${not empty currentLoginLeaguer.photo}">
	        		<img src="${currentLoginLeaguer.photo}" id="userLoginPhoto" class="userP" />
	        	</c:if>
	        	<c:if test="${empty currentLoginLeaguer.photo}">
	        		<img src="images/user.png" id="userLoginPhoto" class="userP" />
	        	</c:if>
	        	</a>	
	        	</li>
				
				<c:if test="${not empty currentLoginLeaguer }">
					<li id="loginInfo">
						<a href="javascript:void(0)">&nbsp;${currentLoginLeaguer.lname }</a>
					</li>
				</c:if>
				<c:if test="${empty currentLoginLeaguer }">
					<li id="loginInfo">
						<a href="javascript:showLoginDiv()" id="currentloginUser">登录</a>
					</li>
				</c:if>

				<c:if test="${not empty currentLoginLeaguer }">
					<li id="addBlog">
	        			<a href="back/showAddBlogPage">写博文</a>
					</li>
					
				</c:if>
				<c:if test="${empty currentLoginLeaguer }">
					<li id="addBlog">
						<a href="javascript:showAddBlogDiv()" id="currentAddBlogUser">注册</a>
					</li>
				</c:if>
				
	        	
	        </ul>
		</div>
	</nav>
	
	<div class="container main" id="index_blog_content">
		<div class="row">
			<div class="col-md-3 col-sm-5 col-xs-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="thumbnail">
							<img src="images/user.png" alt="">
						</div>
						<div class="caption">
							<h3>Aeo</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9 col-sm-7 col-xs-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h4>Title</h4>
					</div>
					<div class="panel-body">
						<div class="content_a" style="height:138px;overflow:hidden">
							<h5 class="C_">
							我希望遇见一个如你一般的人，如山间清爽的风，如古城温暖的光，从清晨到夜晚，由山野到书房，只是这最后是你，就好。
							</h5>
						</div>
					</div>
					<div class="btnAll">
						<ul class="nav nav_a">
						<li><a href=""><span class="badge badge_a">4</span>&nbsp;收藏</a></li>
						<li><a href=""><span class="badge badge_a">4</span>&nbsp;推荐</a></li>
						<li><a href=""><span class="badge badge_b">4</span>&nbsp;反对</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<p id="showmore" onclick="showMoreArticle()">点击加载更多</p>
	<%-- <div id="userLogin">
		用户名：<input type="text" name="uname" id="index_uname" /> <br/><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" name="pwd" id="index_pwd" /> <br/><br/>
		<center><input type="button" value="登录" onclick="userLogin()"></center>
	</div> --%>
	
	<div id="userLogin">
		<div class="showphoto_title">
			好心情登录
			
			<img src="images/head.gif" style="width: 25px;height: 25px" onclick="closeLoginDiv()">
		</div>
		<form>
			<ul>
				<li><input type="text" name="account" placeholder="请输入昵称或邮箱..." id="account"/></li>
				<li><input type="password" name="pwd" placeholder="请输入密码..." id="pwd"/></li>
				<li><input type="button" value="登录" onclick="leaguerLogin()"/></li>
			</ul>
		</form>
	</div>
	
	<div id="showPhotoDiv">
		<div class="showphoto_title">
			修改图像
			
			<img src="" onclick="closePhotoDiv()"/>
		</div>
		<div id="showPhotoInfo">
		
		</div>
		<form>
			<input type="file" name="photos" id="photos" onchange="setImagePreviews(this,'showPhotoInfo')"/>
			<input type="button" value="修改" onclick="updateLeaguerPhoto()"/>
		</form>
	</div>
	
	
	<div id="reg">
		<!-- <div class="showphoto_title">
			会员注册 -->
			
			<img src="images/btn_close_down.png" onclick="closeRegDiv()" style="width: 22px; height: 22px">
		<!-- </div> -->
		<form id="leaguerReg">
			<ul>
				<!-- <li>昵称：<input type="text" name="lname" id="lname" onfocus="$('#lnamelab').text('')" onblur="checkLname(this.value)"/><label id="lnamelab"></label></li> -->
				<li>昵称：<input type="text" name="pname" id="pname" onfocus="$('#pnamelab').text('')" onblur="checkPname(this.value)"/><label id="pnamelab"></label></li>
				<li>密码：<input type="password" name="pwd" id="regpwd" placeholder="请输入您的密码"/></li>
				<li>邮箱：<input type="email" name="email" id="email"/></li>
				<li><input type="button" value="注册" onclick="leaguerReg()"/></li>
			</ul>
		</form>
	</div>
	
</body>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/showpic.js"></script>
<script type="text/javascript">
function showLoginDiv(){
	$("#userLogin").css("display","block");
}                   /* 显示块 */

function closeLoginDiv(){
	$("#userLogin").css("display","none");
	$("#userLogin>form")[0].reset();
}

function showPhotoDiv(){
	$("#showPhotoDiv").css("display","block");
}

function closePhotoDiv(){
	$("#showPhotoDiv").css("display","none");
}

function showAddBlogDiv(){
	$("#reg").css("display","block");
}                   /* 显示块 */

function closeRegDiv(){
	$("#reg").css("display","none");
	$("#reg>form")[0].reset();
}

function leaguerReg(){
	var pname=$.trim( $("#pname").val() );
	if(pname==""){
		alert("用户名不能为空...");
		return;
	}
	
	var pwd=$.trim( $("#regpwd").val() );
	if(pwd==""){
		alert("密码不能为空...");
		return;
	}
	
	var email=$.trim( $("#email").val() );
	$.post("leaguerReg",{lname:pname,pwd:pwd,email:email},function(data){
		console.info(data);
		alert("注册成功...")
		location.href="index.jsp";
	},"text");
}

function checkPname(val){
	if(val==""){
		$("#lnamelab").text("用户名不能为空...").css("color","red");
		return;
	}
}

function updateLeaguerPhoto(){
	$.ajaxFileUpload({
		url:'updatePhoto',
		secureuri:false,
		fileElementId:"photos",
		dataType:"text",
		success:function(data,status){
			data=$.trim(data);
			if(data!=null && data!=""){
				$("#showLeaguerPhoto>img").attr("src",data);
				$("#showPhotoDiv").css("display","none");
			}else{
				alert("图片修改失败...");
			}
		},
		error:function(data,status,e){
			alert("修改图片失败...");
		}
	});
}

function leaguerLogin(){
	var account=$.trim( $("#account").val() );
	var pwd=$.trim( $("#pwd").val() );
	if(account=="" || pwd==""){
		return;
	}
	
	$.post("leaguerLogin",{account:account,pwd:pwd},function(data){
		if(data!=null && data!=""){
			closeLoginDiv();
			$("#loginInfo").html('<a href="javascript:void(0)">&nbsp;'+data.lname+'></a>');
			$("#addBlog").html('<a href="back/showAddBlogPage">写博文</a>');
			if(data.photo!="" && data.photo!=null){
				$("#userLoginPhoto").attr("src",data.photo);
			}
			$("#showLeaguerPhoto").attr("href","javascript:showPhotoDiv()");
		}else{
			alert("账号或密码错误...")
		}
	},"json");
}

$(function(){
	findByPage(1,2);
});
function findByPage(pageNo,pageSize){
	$.get("findByPage",{pageNo:pageNo,pageSize:pageSize},function(data){
		var str='';
		$.each(data,function(index,item){
			str+='<div class="row"><div class="col-md-3 col-sm-5 col-xs-6"><div class="panel panel-default">';
			str+='<div class="panel-body"><div class="thumbnail">';
			if(item.leaguer.photo!=""){
				str+='<img src="'+item.leaguer.photo+'" alt="">';
			}else{
				str+='<img src="images/user.png" alt="">';
			}
			str+='</div><div class="caption"><h3>'+item.leaguer.lname+'</h3></div></div></div></div>';
			str+='<div class="col-md-9 col-sm-7 col-xs-6"><div class="panel panel-success"><div class="panel-heading">';
			str+='<h4><a href="showdetail.html#'+item.bid+'" target="_blank">['+item.blogType.tname+']'+item.title+'</a></h4>';
			str+='</div><div class="panel-body"><div class="content_a navytext" style="heigth:140px;overflow:hidden">';
			str+='<h5 class="C_">'+item.content+'</h5></div></div><div class="btnAll"><ul class="nav nav_a">';
			str+='<li><a href=""><span class="badge badge_a">'+item.views+'</span>&nbsp;浏览</a></li>'
			str+='<li><a href=""><span class="badge badge_a">4</span>&nbsp;推荐</a></li>';
			str+='<li><a href=""><span class="badge badge_b">4</span>&nbsp;反对</a></li>';
			str+='</ul></div></div></div></div>';
		})
		$("#index_blog_content").append($(str));
	},"json");
}
</script>
</html>