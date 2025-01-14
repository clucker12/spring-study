package come.care.root.socket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketTest extends TextWebSocketHandler {
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override // 연결 후 실행되는 메소드
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		System.out.println(session.getId() + "부터 연결됨");
	}

	@Override // 메세지 받는 메소드
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = session.getId() + " 부터";
		msg += message.getPayload() + " 내용 받음";
		System.out.println(msg);
//		System.out.println(message);
		Map<String, Object> map = session.getAttributes();
		System.out.println(map);
		
		TextMessage m = new TextMessage(
				map.get("username")+"님 내용 <br>" + message.getPayload());
		
//		session.sendMessage(message);
		for(WebSocketSession s : sessionList) {
			s.sendMessage(m);
		}
	}

	@Override //연결 종료시 실행
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + " : 종료!");
	}
	
}
