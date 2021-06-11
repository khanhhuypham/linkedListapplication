package com.company;

public class MyStack<T>{
    private Node<Product> head;
    private Node<Product> stack[];
    private T top;
    private int capacity;

    MyStack(){}
    MyStack(int capacity){
        this.capacity = capacity;
        stack = new Node[capacity];
        Node<Product> last = head;
        while(last != null){
            last = last.next;
        }
        this.top = (T) last;

    }

    public int size(){
        Node<Product> last = head;
        int count = 0;
        if (head != null) {
            while (last != null) {
                last = last.next;
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public boolean isFull(){
        return size() == capacity;
    }

    public void push(Product x){
        Node<Product> newProduct = new Node<Product>(x);
        Node<Product> last = head;
        if(head == null){
            head = newProduct;
            newProduct.prev = null;
            newProduct.next = null;

        }else {
            if(head.next == null){
                head.next = newProduct;
                newProduct.prev = head;
            }
            else {
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newProduct;
                newProduct.prev = last;
            }
            newProduct.next = null;
        }
        System.out.println(newProduct.toString());
    }
    public Product pop(Product x) throws Exception {
        Node<Product> last = head;
        Node<Product> poppedElement = null;
        if(head == null){
            throw new Exception("The stack is empty");
        }else {
            if(last.next == null){
                head = null;
                poppedElement =  last;
            }else {
                while (last != null) {
                    last = last.next;
                }
                poppedElement = last;
                last = last.prev;
                last.next = null;
            }
        }
        System.out.println(poppedElement.toString());
        return poppedElement.info;
    }

    //utility function to return
    public T peek(){
        if (isEmpty()){
            System.exit(1);
        }
        return top;
    }

}
