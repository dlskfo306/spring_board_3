<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
          <table width="500" cellpadding="0" cellspacing="0" border="1">
      <tr>
         <td>번호</td>
         <td>이름</td>
         <td>제목</td>
         <td>날짜</td>
         <td>히트</td>
      <tr/>
      <c:forEach var="vo" items="${list}">
         <tr>
            <td>${vo.bid}</td>
            <td>${vo.bname}</td>
            <td>
               <c:forEach begin="1" end="${vo.bindent}">-[RE]</c:forEach>
               <a href="content_view?bid=${vo.bid}">${vo.btitle}</a></td>
            <td>${vo.bdate}</td>
            <td>${vo.bhit}</td>
         <tr/>
      </c:forEach>
      <tr>
         <td colspan="5"> <a href="write_view">글작성</a> </td>
      </tr>
      
   </table>

		<c:if test="${pageMaker.prev}">
		<!-- list?pageNum=3&amount=10 -->
			<a href="list${pageMaker.makeQuery(pageMaker.startPage -1) }"> 이전 </a>
		</c:if>
		
		<c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			<a href="list${pageMaker.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		
		<!-- 페이징1,2..,10 하나하나 링크 걸기 -->
		<!-- 링크 탈때마다 controller가서 실행됨 -->
		<c:if test="${pageMaker.next && pageMaker.endPage  > 0}">
			<a href="list${pageMaker.makeQuery(pageMaker.endPage+1)}"> 다음 </a>
		</c:if>
		<br>
		
</body>
</html>
