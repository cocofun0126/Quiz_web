<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-1.10.1.js"></script>
<script type="text/javascript">

$(function() {
//	1.상품목록 출력: goods_list.json
		load_goods_list();
	})
	function load_goods_list(){
		var url = "goods_list.json";
		$.get(url, handle_goods_list);
	}

	//	객체로 바뀐 JSON이 넘어옴
	function handle_goods_list(glist) {
		if (glist.code == "fail") {
			alert("서버 오류:" + glist.msg);
			return;
		}
		//리스트 출력 전 초기화
		$("#goods_table tr:gt(0)").remove();
		//가져오기 성공
		for (var i = 0; i < glist.data.length; i++) {
			
			var s = "<tr>";
			s += "<td><a href='#' onclick='show_goods("+glist.data[i].gno+");return false;'>"+glist.data[i].gno+"</a></td>";
			s += "<td>" + glist.data[i].brand + "</td>";
			s += "<td>" + glist.data[i].price + "</td>";
			s += "</tr>";
			$("#goods_table").append(s);
		}
	}

	//상품 상세보기 
	function show_goods(gno) {
		var url = "goods_detail.json";
		var param = {gno:gno};
		$.get(url, param, load_detail_goods);
	}
	
	function load_detail_goods(result){
		if (result.code == "fail") {
			alert("찾을 수 없습니다:" + result.msg);
			return;
		}
		$("#gno").val(result.data.gno);
		$("#brand").val(result.data.brand);
		$("#price").val(result.data.price);
		
	}
	
	function update(){
		var url = "goods_update.json";
		if($("#gno").val()=="" ||$("#brand").val()=="" ||$("#price").val()==""){
			alert("필수정보를 모두 입력하세요");
			return;
		}
		var param = $("#gform").serializeArray();
		$.post(url, param, load_goods_update);
	}
	
	function load_goods_update(result) {
		if (result.code == "fail") {
			alert("등록 실패" + result.msg);
			return;
		}
//		성공시 입력값 삭제, 목록 새로고침	
		$("#gno").val('');
		$("#brand").val('');
		$("#price").val('');
		load_goods_list();
	}
	
	function goods_remove(){
		var url = "goods_remove.json";
/* 		if($("#gno").val()=="" ||$("#brand").val()=="" ||$("#price").val()==""){
			alert("필수정보를 모두 입력하세요");
			return;
		}
 */
//		var param = $("#gform").serializeArray();
		var param = {gno:$("#gno").val()}	
		$.post(url, param, load_goods_remove);
	}

	function load_goods_remove(result) {
		if (result.code == "fail") {
			alert("등록 실패" + result.msg);
			return;
		}
//		성공시 입력값 삭제, 목록 새로고침	
		$("#gno").val('');
		$("#brand").val('');
		$("#price").val('');
		load_goods_list();
	}
	
	
	function regist() {
		var url = "goods_regist.json";
		
		if($("#gno").val()=="" ||$("#brand").val()=="" ||$("#price").val()==""){
			alert("필수정보를 모두 입력하세요");
			return;
		}
		var param = $("#gform").serializeArray();
		$.post(url, param, load_goods_regist);
	}
	
	function load_goods_regist(result) {
		if (result.code == "fail") {
			alert("등록 실패" + result.msg);
			return;
		}
//		성공시 입력값 삭제, 목록 새로고침	
		$("#gno").val('');
		$("#brand").val('');
		$("#price").val('');
		load_goods_list();
	}
	//	검색	
	function search() {
		
		var gno = $("#gno").val();
		if (gno != "") {
			search_gno(gno);
			return;
		}

		var brand = $("#brand").val();
		if (brand != "") {
			search_brand(brand);
			return;
		}
		
		var price = $("#price").val();
		if (price != "") {
			search_price(price);
			return;
		}
//		아무것도 입력 안된상태->전체검색
		load_goods_list();
	}
	
	function search_gno(gno){
		show_goods(gno);
	}	
	function search_brand(brand){
		var url = "goods_search.json";
		var param = {key:'brand', word:"%"+brand+"%"}
		$.post(url, param, load_goods_search);
	}
	
	function load_goods_search(result){
		if (result.code == "fail") {
			alert("서버 오류:" + result.msg);
			return;
		}
		
		refresh_list(result.data);
	}
	
//	목록재구성	
	function refresh_list(result){
		//리스트 출력 전 초기화
		$("#goods_table tr:gt(0)").remove();
		
		//가져오기 성공
		for (var i = 0; i < result.length; i++) {
			var s = "<tr>";
			s += "<td>" +result[i].gno+"</td>";
			s += "<td>" + result[i].brand + "</td>";
			s += "<td>" + result[i].price + "</td>";
			s += "</tr>";
			$("#goods_table").append(s);
		}
	}
	
	function search_price(price){
		var url = "goods_search.json";
		var param = {key:'price', word:price};
		$.post(url, param, load_goods_search);
	}
	
//	필수입력데이터 확인로직 필요함(3개항목 다 들어가야됨)

</script>
</head>
<body>

	<h1>상품관리화면</h1>
	<form action="" method="post" id="gform" onsubmit="return false;">
		상품번호 <input type="text" name="gno" id="gno"> <br> 
		상품이름 <input type="text" name="brand" id="brand"> <br> 
		상품가격 <input type="text" name="price" id="price"> <br>
		<button onclick="search();">검색</button>
		<button onclick="regist();">등록</button>
		<button onclick="update();">수정</button>
		<button onclick="goods_remove();">삭제</button>
		<input type="reset" value="지우기">
	</form>

	<hr>
	<table id="goods_table">
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>상품가격</th>
		</tr>
	</table>
</body>
</html>



