package com.reagan.support.jms.listener;

import com.reagan.support.jms.dto.MessageEntity;


/**
 * <p>Description: 消息接收事件接口</p>
 * @date 2013年8月23日
 * @author reagan
 * @version 1.0
 * <p>Company:reagan</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public interface JmsMessageListener {

	/**
	 * 方法用途: 消息接收处理方法<br>
	 * 实现步骤: <br>
	 * @param messageEntity 消息实体
	 */
	public void receiveMsg(MessageEntity<?> messageEntity);
	
}
