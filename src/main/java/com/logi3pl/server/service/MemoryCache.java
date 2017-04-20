package com.logi3pl.server.service;

import com.logi3pl.server.model.Message;

import java.util.ArrayList;
import java.util.List;

// make memory save without saving database
// use singleton design pattern for memory cache
public class MemoryCache {

    private static final MemoryCache instance = new MemoryCache();

    private final List<Message> messages = new ArrayList<Message>();

    private MemoryCache() {}

    public static MemoryCache getInstance() {
        return instance;
    }

    public void putMessage(Message message) {
        messages.add(message);
    }

    public Message getMessage(int index){
        return  messages.get(index);
    }

    public int getSize(){
        return  messages.size();
    }

}
