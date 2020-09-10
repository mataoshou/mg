package com.mg.compose.service.message.service;

import com.mg.compose.service.message.client.MataoMessageClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MataoMessageClient.class)
@Slf4j
public class MataoMessageService {
	@StreamListener(MataoMessageClient.INPUTNAME)
	public void receive(String message)
	{
		log.info("收到消息，请处理："+message);
	}

}
