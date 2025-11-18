<%--
	prefix : 접두사(앞에 붙는 단어)
	prefix="c"  --> <c:if></c:if>
	prefix="fn" --> <fn:..></fn:..>
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL 사용법</title>
</head>
<body>
	<h1>a태그의 Get 요청으로 응답받은 페이지</h1>
	
	<h2>EL (Expression Language) : 표현 언어</h2>
	
	<pre>
	- JSP에서 표현식을 간단하고 효율적으로 
	작성할 수 있도록 고안된 언어 (JSP 내부에 기본 내장되어 있음)
		
	- 기본 작성법 : \${key}	(실제 사용 시 백슬래시는 제거하고 사용)
	</pre>
	
	<h3>전달 받은 파라미터를 출력하는 방법</h3>
	<p>주소 뒤에 쿼리스트링(?name=홍길동&age=20) 직접 작성하여 테스트</p>
	
	<h4>1. JSP 표현식</h4>
	<div>
		name : <%= request.getParameter("name") %>
		<br>
		age : <%= request.getParameter("age") %>
	</div>
	<p style="color: red;">
		JSP 표현식에서 없는 파라미터(데이터)를 얻어오면
		null 로 출력됨
	</p>
	
	<h4>2. EL</h4>
	<div>
		<%-- EL에서 파라미터의 값 얻어오는 방법 : ${param.key값} 
			- null 을 빈칸으로 처리
			- get 이라는 단어 사용하지 않음
		--%>
		name : ${param.name}
		<br>
		age  : ${param.age}
	</div>
	
	<hr><hr>
	
	<h1>JSTL(Jsp Standard Tag Library)</h1>
	<pre>
		JSP에서 자주 사용하는 Java 코드(if, for, 변수 선언..)를 
		스크립틀릿이 아닌 HTML 태그 모양으로 작성할 수 있도록
		태그를 제공하는 라이브러리
		
		[라이브러리 추가 방법]
		1. 필요한 라이브러리(.jar) 파일을 다운 받기
		2. 프로젝트의 webapp/WEB-INF/lib 폴더에 
			다운로드 받은 라이브러리 추가(드래그앤드랍, 복붙)
		3. JSTL구문을 사용할 JSP 파일 제일 위에 taglib 추가 작성
	</pre>
	
	<h3>JSTL c:if 태그 사용해보기</h3>
	<%--  ?age=20  --%>
	
	<% 
		int age = Integer.parseInt(request.getParameter("age"));
		if(age > 20) {
	%>
		<h3>성인입니다(JSP 스클립틀릿으로 출력)</h3>
	<% } %>
	
	
	<c:if test="${param.age > 20}">
		<h3>성인입니다(JSTL 사용)</h3>
	</c:if>
	
	<c:if test="${param.age <= 20}">
		<h3>성인이 아닙니다(JSTL 사용)</h3>
	</c:if>
	
	
	
	
	
	
	<div style="height: 500px;"></div>
</body>
</html>