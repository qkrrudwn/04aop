package spring.service.aop.impl;

import spring.service.aop.Message;

/*
 * FileName : MessageImpl.java
 * :: Message Interface ���� Bean 
 */
public class MessageImpl implements Message {
	
	///Field
	private String message;
	
	///Constructor
	public MessageImpl(){
	}
	
	///Method
	public String getMessage() throws Exception {
		System.out.println("\n:: "+getClass()+".getMessage() start / end ...\n ");
		return "Hi2 "+message;
	}
	
	public void setMessage(String message) throws Exception {
		
		this.message = message;
		
		System.out.println("\n:: "+getClass()+".setMessage() start... ");
		
		//==> ���޹��� message �� null �� ��� NullPointerException �߻�...
		if(message ==null ){
			System.out.println(":: NullPointerException �߻�");
			throw new NullPointerException();
		}
		
		System.out.println(":: "+getClass()+".setMessage() end...\n");
	}
	
}//end of class