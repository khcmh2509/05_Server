package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet{
	
	// 수정 버튼 클릭 시 요청한 수정 화면 전환 GET 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 수정 화면에는 기존의 제목, 상세내용이
			// input, textarea에 채워져있는 상태여야한다!
			// -> 수정 전 제목/내용 조회 
			// == 상세조회 서비스 재호출
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			Todo todo = service.todoDetail(todoNo);
			
			if(todo == null) {
				//메인페이지 redirect
				resp.sendRedirect("/");
				return;
			}
			
			// request scope 에 todo 객체 세팅
			req.setAttribute("todo", todo);
			
			// 요청발송자를 통해 forward
			req.getRequestDispatcher("/WEB-INF/views/update.jsp")
			.forward(req, resp);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/* 요청 주소가 같을 때
	 * 데이터 제출 방식이 다르면(GET/POST)
	 * 하나의 서블릿클래스에서 각각의 메서드(doGet()/doPost()) 를
	 * 만들어 처리할 수 있다!
	 * */
	// 할 일 제목/내용 수정 POST 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		
		
		
	}
}
