package com.learning.helloworld.decoupled;

public class HelloWorldDecoupled {

	public static void main(String[] args) {
		
		MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
		MessageRenderer messageRenderer = MessageSupportFactory.getInstance().getMessageRenderer();
		messageRenderer.setMessageProvider(messageProvider);
		messageRenderer.render();
	}

}
