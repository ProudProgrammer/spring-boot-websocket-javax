package hu.gaborbalazs.practice.springboot.web;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/echo")
public class EchoWebSocket {

	private static final Logger logger = LoggerFactory.getLogger(EchoWebSocket.class);

	@OnOpen
	public void onOpen(Session session) {
		logger.info("onOpen> Session: {}", session.getId());
	}

	@OnClose
	public void onClose(Session session) {
		logger.info("onClose> Session: {}", session.getId());
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		logger.info("onMessage> Session: {}, Message: {}", session.getId(), message);

		try {
			session.getBasicRemote().sendText(message.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnError
	public void onError(Throwable t) {
		logger.info("onError> Error Message: {}", t.getMessage());
	}
}