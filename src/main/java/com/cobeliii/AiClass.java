package com.cobeliii;

import org.springframework.ai.chat.client.ChatClient;

//This will be using Spring AI
public class AiClass {
    private final ChatClient chatClient;

    public AiClass(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String prompt(String prompt) {
        return chatClient.prompt(prompt).call().content();
    }
}
