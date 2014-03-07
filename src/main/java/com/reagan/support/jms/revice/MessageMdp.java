package com.reagan.support.jms.revice;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.reagan.support.jms.dto.MessageEntity;
import com.reagan.support.jms.exception.MessageException;
import com.reagan.support.jms.listener.JmsMessageListener;
import com.reagan.support.util.JSONTools;


/**
 * <p>Description: 消息接收类</p>
 * @date 2013年9月4日
 * @author reagan
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class MessageMdp implements MessageListener {
	
	/**
	 * 接收事件管理
	 */
	private List<JmsMessageListener> listeners = new ArrayList<JmsMessageListener>();
	
	/**
	 * 方法用途: 设置接收时间<br>
	 * 实现步骤: <br>
	 * @param listener 事件接口实现
	 */
	public void setListener(JmsMessageListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * 方法用途: 删除事件<br>
	 * 实现步骤: <br>
	 * @param listener
	 */
	public void removeListener(JmsMessageListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * 方法用途: 清除所有事件<br>
	 * 实现步骤: <br>
	 * @param listener
	 */
	public void clearListener() {
		listeners.clear();
	}
	
	/** 
	 * 方法用途: 接收消息方法<br>
	 * 实现步骤: <br>
	 * @param message 接收的消息
	 */
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				String objectJson = ((ObjectMessage) message).getStringProperty("JSON");
				JSONTools<MessageEntity> json = new JSONTools<MessageEntity>();
				MessageEntity messageEntity = json.readObject(objectJson, MessageEntity.class);
				for(JmsMessageListener listener : listeners) {
					listener.receiveMsg(messageEntity);
				}
			}
		} catch (Exception e) {
			try {
				new MessageException("接收消息对象 msgID:" + message.getJMSMessageID() + "出现错误");
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}
	}
}
