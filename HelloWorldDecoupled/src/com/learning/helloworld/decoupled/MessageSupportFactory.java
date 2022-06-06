package com.learning.helloworld.decoupled;
import java.util.Properties;

public class MessageSupportFactory {
	private static MessageSupportFactory instance;
	
	private Properties props;
	private MessageRenderer renderer;
	private MessageProvider provider;
	
	@SuppressWarnings("deprecation")
	private MessageSupportFactory() {
		this.props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream("msf.properties"));
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			
			this.renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
			this.provider = (MessageProvider) Class.forName(providerClass).newInstance();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static {
		instance = new MessageSupportFactory();
	}
	
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	
	public MessageRenderer getMessageRenderer() {
		return renderer;
	}
	
	public MessageProvider getMessageProvider() {
		return provider;
	}
}
