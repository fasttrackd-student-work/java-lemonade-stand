package lemonadestand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import lemonadestand.model.Order;

public class ViewOrder {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			File file = new File("./orders");
			System.out.println("Which order number would you like to view?");

			int orderNumber = 0;
			try {
				orderNumber = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number between 1 and 2 billion");
			}
			

			try (FileInputStream fileInputStream = new FileInputStream(file + "/order" + orderNumber + ".txt");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
				Order order = (Order) objectInputStream.readObject();
				System.out.println(order.getLemonades());
				System.out.println("Total: " + order.getTotal());
				
			} catch (IOException e) {
				System.out.println("Order with number " + orderNumber + " does not exist");
			} catch (ClassNotFoundException e) {
				System.out.println("Tried to read in an order that isn't formatted correctly");
			} catch (ClassCastException e) {
				System.out.println("The file read does not contain an order");
			}
			
		}
	}

}
