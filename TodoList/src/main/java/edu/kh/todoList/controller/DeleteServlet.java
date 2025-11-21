package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/delete")
public class DeleteServlet extends HttpServlet{

	// 삭제 성공 시 message = "할 일이 삭제되었습니다"
	// 삭제 실패 시 message = "todo가 존재하지 않습니다"
	// 성공, 실패 시 메인페이지로 리다이렉트
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			TodoListService service = new TodoListServiceImpl();
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			int result = service.todoDelete(todoNo);
			
			HttpSession session = req.getSession();
			
			String message = null;
			if(result > 0) message = "할 일이 삭제되었습니다";
			else		   message = "todo가 존재하지 않습니다";
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
