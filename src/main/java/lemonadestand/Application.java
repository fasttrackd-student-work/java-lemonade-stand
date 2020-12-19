package lemonadestand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lemonadestand.model.Customer;
import lemonadestand.model.Lemonade;
import lemonadestand.model.LemonadeStand;
import lemonadestand.model.Order;

public class Application {

	public static void main(String[] args) {

		Customer customer1 = new Customer("Will", "(999)999-9999");
		Customer customer2 = new Customer("Frank", "(901)999-9999");

		Order order1 = new Order(customer1);

		order1.addLemonade(new Lemonade(1, .5, 1, 5));
		order1.addLemonade(new Lemonade(1, .5, 1, 5));
		order1.addLemonade(new Lemonade(1, .5, 1, 5));
		order1.addLemonade(new Lemonade(1, .5, 1, 5));

		for (Lemonade l : order1.getLemonades()) {
			System.out.println(l.getPrice());
		}

		System.out.println(order1.getCustomer().getName());
		System.out.println(order1.getTotal());

		Order order2 = new Order(customer2);

		order2.addLemonade(new Lemonade(1, 2.5, 1, 5));
		order2.addLemonade(new Lemonade(3, .5, 1, 5));
		order2.addLemonade(new Lemonade(1, .5, 4, 5));
		order2.addLemonade(new Lemonade(2, 1.5, 1.75, 5));

		for (Lemonade l : order2.getLemonades()) {
			System.out.println(l.getPrice());
		}

		System.out.println(order2.getCustomer().getName());
		System.out.println(order2.getTotal());

		order1.equals(order2);
		order2.equals(null);
		order2.equals(null);
		order2.equals(null);
		order2.equals(null);
		order2.equals(null);

		System.out.println(order1.toString());

//		Box<Order> b1 = new Box<Order>(order1);
//		Box<Customer> b2 = new Box<Customer>(customer2);
//		
//		b1.setObj(order2);
//		
//		b1.getObj().addLemonade(new Lemonade(2, 1.5, 1.75, 5));
//		
//		b2.setObj(customer1);
//		
//		System.out.println(b1.getObj());
//		System.out.println(b2.getObj());
//		
//		b2.printValue(customer2, order1);

		LemonadeStand lemonadeStand1 = new LemonadeStand("Brad's First Stand");
		LemonadeStand lemonadeStand2 = new LemonadeStand("Brad's Second Stand");

		Map<LemonadeStand, List<Order>> lemonadeStandOrders = new HashMap<>();

		lemonadeStandOrders.put(lemonadeStand1, Arrays.asList(new Order[] { order1, order2 }));

		lemonadeStandOrders.put(lemonadeStand2, Arrays.asList(new Order[] { order2 }));

		lemonadeStandOrders.put(lemonadeStand1, Arrays.asList(new Order[] { order1 }));

		System.out.println(lemonadeStandOrders.get(lemonadeStand1));

		System.out.println(lemonadeStandOrders.keySet());

	}

}
