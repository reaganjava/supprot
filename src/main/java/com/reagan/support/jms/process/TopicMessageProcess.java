package com.reagan.support.jms.process;

import com.reagan.support.jms.dto.MessageEntity;


public interface TopicMessageProcess {
	
	public void send(MessageEntity<?> message);
}
