package com.company;
import java.util.Scanner;

public class Main {
    static MyList linkedList = new MyList();
    static MyQueue<Node> myQueue = new MyQueue<Node>(100);
    static MyStack<Node> myStack = new MyStack<Node>();
    static OperationToProduct function = new OperationToProduct();

    public static void main(String[] args) throws Exception {
        Menu();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("\nPlease, enter your option: ");
            choice = scanner.nextInt();
            switch (choice) {
                /*because all functions are written in OperationToProduct class*/
                case 1: {
                    function.getAllItemsFromFile(function.filePath, linkedList);
                    break;
                }
                case 2: {
                    Product product = function.createProduct();
                    function.addLast(linkedList, product);
                    function.displayAll(linkedList);
                    break;
                }
                case 3: {
                    function.displayAll(linkedList);
                    break;
                }
                case 4: {
                    //Save the linked list of products into file.
                    function.writeAllItemsToFile(function.fileName, linkedList);
                    break;
                }
                case 5: {
                    //Search information for products according to ID.
                    function.searchByCode(linkedList);
                    break;
                }
                case 6: {
                    //Delete product in the linked list according to ID.
                    System.out.println("-----------------------------------------------------------------");
                    function.deleteByCode(linkedList);
                    function.displayAll(linkedList);
                    break;
                }
                case 7: {//Sort products in the linked list based on ID.
                    function.sortByCode(linkedList);
                    break;
                }
                case 8: {/*Represent the total number of products (in 10-based digits) of the first element in the linked list
                as the binary digit using recursion method.*/
                    System.out.print("Please, enter the product ID you wanna convert for its decimal quantity to binary digit: ");
                    String productID = scanner.next();
                    Product x = linkedList.searchID(productID);
                    int quantity = x.quantity;
                    System.out.println(function.convertBinary(quantity));
                    break;
                }
                case 9: {/*Read the data from file which includes many types of products, and save into stack.
                Present products in the stack on screen.*/
                    function.getAllItemsFromFile(function.filePath, myStack);
                    break;
                }
                case 10: {/*Read the data from file which contains many types of products, and then save into queue.
                Present products in the queue on screen*/
                    System.out.format("\n%-15s %-15s %-15s %-10s %-10s %-15s %-15s %-15s %-20s\n",
                            "Product Cocde", "Category Code", "Product Name", "Price", "Quantity", "Import Date", "Sale Date", "Expiration Date", "Product description");
                    function.getAllItemsFromFile(function.filePath, myQueue);
                    break;
                }
                default: {
                    System.out.println("you entered the wrong function. Please, choose another function!");
                    break;
                }
            }
        } while (choice != 10);
    }

    public static void Menu() {
        System.out.println("1. Read available data from file, and save into the linked list, and present the list on screen.");
        System.out.println("2. Enter information of another product and that product in the end of the linked list.");
        System.out.println("3. Show the data of products in the linked list.");
        System.out.println("4. Save the linked list of products into file.");
        System.out.println("5. Search information for products according to ID.");
        System.out.println("6. Delete product in the linked list according to ID.");
        System.out.println("7. Sort products in the linked list based on name.");
        System.out.println("8. Represent the total number of products (in 10-based digits) of the first element in the linked list" +
                "as the binary digit using recursion method.");
        System.out.println("9. Read the data from file which includes many types of products, and save into stack. " +
                "Present products in the stack on screen.");
        System.out.println("10. Read the data from file which contains many types of products, and then save into queue. " +
                "Present products in the queue on screen");
    }
}
