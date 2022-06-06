package com.learning.helloworld.decoupled;

public class StandardMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;
	
	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
	
	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
	
	@Override
	public void render() {
		if(this.messageProvider == null) {
			throw new RuntimeException("You must set the messageProvider property of class :"+StandardMessageRenderer.class.getName());
		}else {
			System.out.println(this.messageProvider.getMessage());
		}
	}
}
