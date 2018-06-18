package hu.gaborbalazs.practice.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class EndpointConfig {

	@Bean
	public ServerEndpointExporter endpointExporter() {
		return new ServerEndpointExporter();
	}
}
