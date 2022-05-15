package com.company;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //dados do cliente
        System.out.println("Enter client data:");
        System.out.print("Name");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.println("Bith date (DD/MM/YYYY): ");
        Date birthDate =  sdf.parse(sc.next());  //converte a string em data
        Client client = new Client(name, email, birthDate); //instancia o clinte

        //dados do pedido
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), status, client); //instancia uma nova ordem de pedido

        //fazendo os pedidos
        System.out.print("How many items to this order? ");
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            System.out.println("Enter #" + N + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice); //primeiro instancia o produto.

            OrderItem orderItem = new OrderItem(quantity, productPrice, product); //depois instancia o pedido do produto.

            order.addItem(orderItem);
        }

        System.out.println(" ");
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);


        sc.close();
    }
}
