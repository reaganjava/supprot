package com.reagan.support.jms.exception;


/**
 * <p>Description: </p>
 * @date 2013年8月27日
 * @author Reading.Reagan
 * @version 1.0
 * <p>Company:reagan</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class MessageException extends Exception {
	
	private static final String JMS_EXCEPTION_MSG = "(=====JMS模块异常=====):";

	private static final long serialVersionUID = 5762334258080382469L;

	public MessageException() {
		super(JMS_EXCEPTION_MSG);
	}
	
	public MessageException(String message) {
		super(JMS_EXCEPTION_MSG + message);
	}
	
	public MessageException(Throwable cause) {
		super(cause);
	}
	
	public MessageException(String message, Throwable cause) {
		super(JMS_EXCEPTION_MSG + message, cause);
	}
}
