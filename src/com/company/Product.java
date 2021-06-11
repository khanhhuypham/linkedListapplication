package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Product{
    public String productCode;
    public String categoryCode;
    public String productName;
    public float price;
    public int quantity;
    public Date importDate;
    public Date saleDate;
    public Date expirationDate;
    public String productDescription;

    public Product(){}


    public Product(String productCode, String categoryCode, String productName, float price,int quantity,
                   Date importDate, Date saleDate, Date expirationDate, String productDescription){
        this.productCode = productCode;
        this.categoryCode = categoryCode;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
        this.saleDate = saleDate;
        this.expirationDate = expirationDate;
        this.productDescription = productDescription;

    }


    public String getProductCode(){return productCode;}
    public void setProductCode(String productCode){this.productCode = productCode;}

    public String getCategoryCode(){return categoryCode;}
    public void setCategoryCode(String categoryCode){this.categoryCode = categoryCode;}

    public String getProductName(){return productName;}
    public void setProductName(String productName){this.productName = productName;}

    public float getPrice(){return price;}
    public void setSalePrice(float price){this.price = price;}

    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){this.quantity = quantity;}

    public Date getImportDate(){return importDate;}
    public void setImportDate(Date importDate){this.importDate = importDate;}

    public Date getSaleDate(){return saleDate;}
    public void setSaleDate(Date saleDate){this.saleDate = saleDate;}

    public Date getExpirationDate(){return expirationDate;}
    public void setExpirationDate(Date expirationDate){this.expirationDate = expirationDate;}

    public String getProductDescription(){return productDescription;}
    public void setProductDescription(String productDescription){this.productDescription = productDescription;}

    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String import_date = formatter.format(this.importDate);
        String sale_date = formatter.format(this.saleDate);
        String expiration_date = formatter.format(this.expirationDate);

        String line = String.format("%-15s %-15s %-15s %-10s %-10s %-15s %-15s %-15s %-20s",
                this.productCode, this.categoryCode, this.productName, this.price, this.quantity, import_date, sale_date, expiration_date, this.productDescription);

        return line;
    }

    public void inputData(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the product code: ");
        productCode = scanner.nextLine();

        System.out.print("\nEnter the category code: ");
        categoryCode = scanner.nextLine();

        System.out.print("\nEnter the product name: ");
        productName = scanner.nextLine();

        System.out.print("\nEnter the price of product: ");
        price = scanner.nextFloat();

        System.out.print("\nEnter the quantity of the product: ");
        quantity = scanner.nextInt();

        System.out.print("\nEnter the import date of the product: ");
        String importDateString = scanner.next();
        if(importDateString.equals("")){
            importDate = null;
        }else{
            try{
                importDate = format.parse(importDateString); /*this function is used to parse and format date string*/
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.print("\nEnter the sale date of the product: ");
        String saleDateString = scanner.next();
        if(importDateString.equals("")){
            saleDate = null;
        }else{
            try{
                saleDate = format.parse(saleDateString); /*this function is used to parse and format date string*/
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.print("\nEnter the expiration date of the product: ");
        String expirationDateString = scanner.next();
        if(importDateString.equals("")){
            expirationDate = null;
        }else{
            try{
                expirationDate = format.parse(expirationDateString); /*this function is used to parse and format date string*/
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        System.out.print("\nEnter the description of the product: ");
        productDescription = scanner.nextLine();
    }


}

