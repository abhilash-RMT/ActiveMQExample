package com.raremile.training.App;

import com.raremile.training.handler.ChatHandler;

public class App {

	public static void main(String[] args) {
		ChatHandler handler = new ChatHandler();
		handler.startChatting();
	}

}
