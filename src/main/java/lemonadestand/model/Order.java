package lemonadestand.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4546622142954731428L;

	private Customer customer;

	private List<Lemonade> lemonades;

	private double total;

	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new ArrayList<>();
		total = 0.0;
	}

	public void addLemonade(Lemonade lemonade) {
		lemonades.add(lemonade);
		total += lemonade.getPrice();
	}

	public void addLemonades(List<Lemonade> lemonades) {
		this.lemonades.addAll(lemonades);
		for (Lemonade l : lemonades) {
			total += l.getPrice();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Lemonade> getLemonades() {
		return lemonades;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + lemonades.hashCode();
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (lemonades.equals(other.getLemonades()))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order {customer=" + customer + ", lemonades=" + lemonades.toString() + ", total=" + total + "}";
	}

}
