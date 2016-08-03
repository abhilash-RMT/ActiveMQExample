package com.raremile.training.p2p.App;

import com.raremile.training.p2p.handler.ChatHandler;

public class App {

	public static void main(String[] args) {
		ChatHandler handler = new ChatHandler();
		handler.startChatting();
	}

}
