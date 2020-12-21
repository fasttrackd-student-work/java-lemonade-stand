package lemonadestand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import lemonadestand.model.Customer;
import lemonadestand.model.Lemonade;
import lemonadestand.model.Order;

public class Application {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the LemonadeStand Order Application!");
		System.out.println("To make an order we need you to provide your name and phone number.");
		System.out.println("Let's get started with your name:");

		String name = scanner.nextLine();

		System.out.println("Hi " + name + ", nice to meet you.");
		System.out.println("Next we need your number so we'll be able to call you when your order is ready:");

		String phoneNumber = scanner.nextLine();

		System.out.println("Awesome! We captured your phone number as: "
				+ phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
		System.out.println("Is that correct?");

		String validation = "";

		do {
			if (validation.equals("N")) {
				System.out.println("Please re-enter your phone number:");
				validation = scanner.nextLine();
				System.out.println("Now we have: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
				System.out.println("Is that correct?");
			}
			System.out.println("Please enter Y (for yes) or N (for no)");
			validation = scanner.nextLine();
		} while (!validation.equals("Y"));

		System.out.println("Great! Let's get to your order then...");

		Customer customer = new Customer(name, phoneNumber);
		Order order = new Order(customer);

		System.out.println("How many lemonades would you like to order?");

		for (int numberOfLemonades = scanner
				.nextInt(), currentLemonade = 1; numberOfLemonades > 0; numberOfLemonades--, currentLemonade++) {
			System.out.println("How much lemon juice do you want for lemonade " + currentLemonade + "? (in cups)");
			double lemonJuice = scanner.nextDouble();
			System.out.println("How much water do you want for lemonade " + currentLemonade + "? (in cups)");
			double water = scanner.nextDouble();
			System.out.println("How much sugar do you want for lemonade " + currentLemonade + "? (in cups)");
			double sugar = scanner.nextDouble();
			System.out.println("How many ice cubes do you want for lemonade " + currentLemonade + "?");
			int iceCubes = scanner.nextInt();
			order.addLemonade(new Lemonade(lemonJuice, water, sugar, iceCubes));
		}

		// Save the order somewhere.

		File file = new File("./orders");

		File[] files = file.listFiles();

		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file + "/order" + (files.length + 1) + ".txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(order);

		} catch (IOException e) {
			System.out.println("Unable to create file. Please ensure the orders folder exists.");
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Successfully places order");
		System.out.println("Your order total is: " + order.getTotal());
		System.out.println("Please be ready to pay when you pick up your order!");
		
		scanner.close();

	}

}
