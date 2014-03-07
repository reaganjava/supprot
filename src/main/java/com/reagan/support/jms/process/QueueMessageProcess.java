package com.reagan.support.jms.process;

import com.reagan.support.jms.dto.MessageEntity;


public interface QueueMessageProcess {
	
	public void send(MessageEntity<?> message);

}
