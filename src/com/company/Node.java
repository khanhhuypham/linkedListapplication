package com.company;

public class Node <T>{
    T info;
    Node next;
    Node prev;
    public Node(T info){
        this.info = info;

    }
    @Override
    public String toString(){
        return info.toString();
    }
}
