package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet 관련 코드를 작성하기 위해서는 HttpServlet 클래스 상속 받아야함
// 상속받았다고해서 바로 Servlet 등록이 되는것은 아님!
// -> 방법1. web.xml 작성하기 
//    방법2. @WebServlet() 어노테이션 사용하기

/* 어노테이션 : 컴파일러가 읽는 주석
 * 
 * @WebServlet 어노테이션
 * -> 해당 클래스를 Servlet으로 등록하고 () 안에 작성된 주소와
 * 매핑하라고(연결하라고) 지시하는 어노테이션
 * 
 * -> 서버 실행 시 자동으로 web.xml
 *    <servlet> <serlet-mapping> 를 작성하는 효과
 * 
 * */

@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{
	
	// Post 요청 처리 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
											throws ServletException, IOException {
		
		// 요청 시 제출받은 데이터 얻어오기
		String userId = req.getParameter("inputId");
		String userPw = req.getParameter("inputPw");
		String userName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(userName);
		System.out.println(intro);
		
		// 응답화면 만들기
		// -> Java(Servlet)에서 응답화면을 작성하기 번거롭고 힘들다..
		// -> JSP가 대신 화면을 만들어달라!
		// -> Servlet이 JSP에게 요청/응답을 위임
		// JSP가 대신 응답화면을 만들어주기 위해서는
		// Servlet이 어떤 요청을 받았는지 알아야한다(req, resp)
		
		RequestDispatcher dispatcher 
			= req.getRequestDispatcher("/WEB-INF/views/result.jsp");
									// webapp 폴더 기준으로 작성
		
		dispatcher.forward(req, resp);
		
		
		
		
		
		
	}
	
	
	
}
