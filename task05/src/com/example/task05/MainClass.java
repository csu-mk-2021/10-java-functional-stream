package com.example.task05;

public class MainClass<T> {
    private final String from, to;
    private final T content;

    public MainClass(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }
}