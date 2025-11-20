package edu.kh.todoList.model.service;

import java.util.Map;

// 유지보수성과 확장성, 테스트 용이성 때문에
// Service / DAO 단은 interface와 상속받는 구현체 class로 작성한다
// -> Controller 는 ServiceImpl을 직접 사용하지 않고, 
//    Service 인터페이스를 의존하므로, 나중에 구현체가 바뀌어도
//    Controller는 큰 영향을 받지 않음
// -> ServiceImpl 대신 NewServiceImpl을 만들어서 새로운 로직을 적용하고
//    싶을 때, 손쉽게 교체 가능
public interface TodoListService {

	Map<String, Object> todoListFullView() throws Exception;
	
	
	
	
	
	
	
	
	
	
}
