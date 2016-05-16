<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KDN Spring MVC Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<div id="head">
   <article id="logo"><img src="images/logo.gif"/></article>
<article id="content"> 
	<aside>
		<nav id="menu">		
		 <a href="goods_list.do">상품목록</a><br/>
		</nav>
	</aside>
	<article id="mainContent">
  	    <jsp:include page="/jsp/goods/list.jsp"/>
   </article>
</article>		
<footer id="copyright">
<jsp:include page="copyright.jsp"/>
</footer>	
</div>  
</body>
</html>




