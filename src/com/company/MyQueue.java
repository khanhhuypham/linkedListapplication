package com.company;

public class MyQueue<T> {
    private Node<Product> head;
    private int front;
    private int rear;
    private Node<Product> queue[];
    private int capacity;
    private int count;

    public MyQueue(int capacity){
        this.capacity = capacity;
        queue = new Node[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public MyQueue() {
    }


    public int size(){
        Node<Product> last = head;
        if(head == null){
            return count;
        }else{
            while(last != null){
                last = last.next;
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty(){
        return (size() == 0);
    }

    public boolean isFull(){
        return (size() == capacity);
    }


    public void enqueue(Product x){
        Node<Product> newNode = new Node<Product>(x);
        if(head == null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            rear++;
        }else{
            Node<Product> last = head;
            if (last.next != null) {
                while (last.next != null) {
                    last = last.next;
                    rear++;
                }
            }
            last.next = newNode;
            newNode.prev = last;
            newNode.next = null;
        }
        System.out.println(newNode.toString());
    }

    public void dequeue(Product x) throws Exception {
        Node<Product> poppedElement;
        if(head == null){
            System.out.print("\nThe queue is empty\n");
        }else{
            Node<Product> last = head;
            while(last.next != null){
                last = last.next;
                front++;
            }
            last = last.prev;
            last.next = null;
        }
    }

    public T peek(){
        if (isEmpty()){
            System.exit(1);
        }
        Node<Product> last = head;
        while(last.next != null){
            last = last.next;
        }
        return (T)last;
    }



}
