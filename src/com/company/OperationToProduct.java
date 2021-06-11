package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OperationToProduct {
    static String filePath = "book1.csv";
    static String fileName = "Output.txt";

    public int index(MyList list) throws Exception {
        System.out.print("Please, enter the product ID you wanna search for its ID: ");
        Scanner scanner = new Scanner(System.in);
        String productID = scanner.next();
        int index = list.indexOfElement(list.searchID(productID));
        return index;
    }

    public Product createProduct(){
        Product x = new Product();
        x.inputData();
        return x;
    }

    public static void getAllItemsFromFile(String filePath, MyList<Product> list){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");

                /*convert String date to Date format*/
                Date importDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[5]);
                Date saleDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[6]);
                Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[7]);

                Product x = new Product(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), importDate, saleDate, expirationDate, values[8]);
                list.append(x);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public static void getAllItemsFromFile(String filePath, MyStack stack){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");

                /*convert String date to Date format*/
                Date importDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[5]);
                Date saleDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[6]);
                Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[7]);

                Product x = new Product(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), importDate, saleDate, expirationDate, values[8]);
                stack.push(x);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public static void getAllItemsFromFile(String filePath, MyQueue queue){
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");

                /*convert String date to Date format*/
                Date importDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[5]);
                Date saleDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[6]);
                Date expirationDate = new SimpleDateFormat("dd/MM/yyyy").parse(values[7]);

                Product x = new Product(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), importDate, saleDate, expirationDate, values[8]);
                queue.enqueue(x);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    //Add a new product into tail of linked list
    public void addLast(MyList list, Product x){
        list.append(x);
    }
    //Display info of all product on linked list
    public void displayAll(MyList<Product> list){
        list.printList();
    }
    //Write all product of linked list to file
    public void writeAllItemsToFile(String fileName, MyList<Product> list){
        try{
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            Node<Product> last = list.head;
            if(last == null){
                writer.write("The linked list is empty");
            }else{
                writer.write(String.format("\n%-15s %-15s %-15s %-10s %-10s %-15s %-15s %-15s %-20s",
                        "Product Cocde", "Category Code", "Product Name", "Price", "Quantity", "Import Date", "Sale Date", "Expiration Date", "Product description"));
                while(last != null){
                    writer.write("\n" + last.info.toString());
                    last = last.next;
                }
                writer.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Search first element by ID
    public void searchByCode(MyList<Product>list){
        System.out.print("Please, enter the ID of product you wanna search for: ");
        Scanner scanner = new Scanner(System.in);
        String productID = scanner.next();
        Product product = list.searchID(productID);

        while(product == null){
            System.out.print("\nThe product ID does not exists\n\n");
            System.out.print("Please, enter the ID of product again: ");
            productID = scanner.next();
            product = list.searchID(productID);
        }

        if(product != null){
            System.out.format("\n%-15s %-15s %-15s %-10s %-10s %-15s %-15s %-15s %-20s\n",
                    "Product Cocde", "Category Code", "Product Name", "Price", "Quantity", "Import Date", "Sale Date", "Expiration Date", "Product description");
            System.out.println(product.toString());
        }

    }
    //Delete first element by ID
    public void deleteByCode(MyList<Product> list) throws Exception {
        System.out.print("Please, enter the ID of product you wanna remove from the list: ");
        Scanner scanner = new Scanner(System.in);
        String productID = scanner.next();
        Product product = list.searchID(productID);
        while(product == null){
            System.out.print("\nThe product ID does not exists\n\n");
            System.out.print("Please, enter the ID of product again: ");
            productID = scanner.next();
            product = list.searchID(productID);
        }
        if(product != null){
        list.deleteElement(product);
        }
    }
    //Sort by ID
    public void sortByCode(MyList<Product> list) throws Exception {
        if (list.head == null) {
            throw new Exception("the list is empty");
        } else {
            if (list.length() == 1) {
                System.out.println("sort function can not sort because linked list has only one element");
            } else {
                ArrayList<Product> arrayList = new ArrayList<Product>();
                Node<Product> last = list.head;
                while(last != null){
                    arrayList.add(last.info);
                    last = last.next;
                }

                Collections.sort(arrayList, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.productName.compareTo(o2.productName);
                    }
                });
                list.clear();
                for (int i = 0; i < arrayList.size(); i++){
                    list.append(arrayList.get(i));
                }
            }
        }
    }
    //Add new product to head of the linked list
    public void addFirst(MyList<Product> list){
        System.out.print("Please, enter the ID of product you wanna insert it to the head of the list: ");
        Scanner scanner = new Scanner(System.in);
        String productID = scanner.next();
        Product product = list.searchID(productID);
        list.insertToHead(product);
    }
    //Convert to binary
    public int convertBinary(int quantity){
        if(quantity == 0){
            return 0;
        }
        else{
            return (quantity % 2 + 10*convertBinary(quantity/2));
        }

    }
    //Delete element at position k

}


