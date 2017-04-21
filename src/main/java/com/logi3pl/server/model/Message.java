package com.logi3pl.server.model;


public class Message {

    private String messageNumber;
    private String text;


    public Message(String text,String messageNumber) {
        this.messageNumber = messageNumber;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getMessageNumber() {
        return messageNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageNumber='" + messageNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
