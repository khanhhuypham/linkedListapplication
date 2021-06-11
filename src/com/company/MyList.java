package com.company;

import java.util.*;

public class MyList <T>{
    Node<Product> head;
    public MyList(){
    }

    public boolean isEmpty(){ return head == null;}
    //size of Linked list
    public int length(){
        int length = 0;
        if(head == null){
            return 0;
        }else{
            length = 1;
            Node<Product> last = head;
            while(last.next != null){
                last = last.next;
                length++;
            }
        }
        return length;
    }
    //insert to head of linked list
    public void insertToHead(T x){
        Node newNode = new Node(x);
        if(head == null){
            newNode.next = null;
            newNode.prev = null;
        }else{
            newNode.prev = null;
            newNode.next = head;
            newNode.next.prev = newNode;
        }
        head = newNode;
    }

    public void append(T x){
        Node<T> newNode = new Node<T>(x);
        if(head == null){
            insertToHead(x);
        }else{
            Node<Product> last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
            newNode.next = null;
        }
        System.out.println(newNode.toString());
    }

    public void printList(){
        if(head == null){
            System.out.println("The linked list is empty");
        }
        else{
            Node<Product> last = head;
            while(last.next != null){
                System.out.println(last.toString());
                last = last.next;
            }
            System.out.println(last.toString());
        }
    }

    //insert after of position k
    public void insertIntoPosition(int position, T x){
        Node<T> newNode = new Node<T>(x);
        if(head == null){
            insertToHead(x);
        }
        else if (head != null){
            /*
             * if position = 0 and the linked list has only one node
             * if position is at the end of the list
             * if position is in the middle of the list
             * */
            int count = 0;
            Node<Product> traverse = head;
            if(position == 0){
                insertToHead(x);
            }
            else if(position > 0 && position < length()) {
                while (count < (position - 1) && traverse != null) {
                    traverse = traverse.next;
                    count++;
                }
                newNode.prev = traverse;
                newNode.next = traverse.next;
                traverse.next = newNode;
            }else{
                append(x);
            }
        }

    }

    //Delete element at tail of linked list
    public void pop(){
        if(head == null){
            return;
        }else{
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            /*traverse forward to the second last item in the list, and then assign the value of null to it*/
            last.prev.next = null;
        }

    }

    public int indexOfElement(T x) throws Exception {
        Node<T> node = new Node<T>(x);
        int index = 0;
        if(head == null){
            System.out.print("\nThe list is empty\n");
            System.out.print("\nEnd program\n\n");
            System.exit(1);
        }else{
            Node<Product> last = head;
            if(last.info.equals(node.info)){//in this case 1: the linked list has only one node
                return index;
            }else {
                while (last.next != null) {
                    last = last.next;
                    index++;
                    if (last.info.equals(node.info)) {
                        break;
                    }
                }
            }
           if(!(last.info).equals(node.info)){
               System.out.print("Not Found");
               index = -1;
           }
        }
        return index;
    }

    //Delete element
    public void deleteElement(T x) throws Exception {
        Node<T> deleteNode = new Node<T>(x);
        int index = indexOfElement(x);


        Node traverse = head;
        int count = 0;
        if (head == null) {
            return;
        } else {
            while (count < index && traverse != null) {
                count += 1;
                traverse = traverse.next;
            }
            /*from hear we will have 4 cases
             * case 1: if the linked list only has one node = head, and then we delete it, the list becomes empty.
             * case 2: if the number of node in the list > 1:
             *       -> case 1: if the delete node lie at head
             *       -> case 2: if the delete node lie in middle of the the list
             *       -> case 3: if the delete node lie at the end of the list
             * */
            if(length() == 1 && traverse.equals(head)){
                head = null;
            }else if(length()>1){
                if (traverse.equals(head)) {
                    traverse.next.prev = null;
                    head = traverse.next;
                }else if(traverse.next != null){
                    traverse.next.prev = traverse.prev;
                    traverse.prev.next = traverse.next;
                    traverse = null;
                }else{
                    traverse.prev.next = null;
                    traverse = null;
                }
            }
        }
    }

    //Swap 2 elements
    public void swap(T x1, T x2) throws Exception {
        int indexOfNode1 = indexOfElement(x1);
        int indexOfNode2 = indexOfElement(x2);

        deleteElement(x1);
        insertIntoPosition(indexOfNode1,x2);

        deleteElement(x2);
        insertIntoPosition(indexOfNode2, x1);
    }

    //Delete all linked list
    public void clear(){head = null;}

    public Product searchID(String productID){
        Node<Product> last = head;
        Product product = null;
        if(head == null){
            return null;
        }else{
            while(last != null){
                if(last.info.productCode.equals(productID)){
                    product = last.info;
                    break;
                }else if(!last.info.productCode.equals(productID)){
                    product = null;
                }
                last = last.next;
            }
        }
        return product;
    }




}
