package lemonadestand.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Order implements Serializable, Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4546622142954731428L;
	
	private Integer id;

	private Customer customer;
	
	private LemonadeStand lemonadeStand;

	private List<Lemonade> lemonades;

	private double total;

	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new ArrayList<>();
		total = 0.0;
	}
	
	public Order(Integer id, double total, Customer customer, LemonadeStand lemonadeStand) {
		this.id = id;
		this.total = total;
		this.customer = customer;
		this.lemonadeStand = lemonadeStand;
	}
	
	public Order() {}

	public Order(Customer customer, LemonadeStand lemonadeStand) {
		this.customer = customer;
		this.lemonadeStand = lemonadeStand;
	}

	public Order(int id, double total) {
		this.id = id;
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setLemonades(List<Lemonade> lemonades) {
		this.lemonades = lemonades;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void addLemonade(Lemonade lemonade) {
		if (lemonades == null) {
			lemonades = new ArrayList<>();
		}
		lemonades.add(lemonade);
		total += lemonade.getPrice();
	}

	public void addLemonades(List<Lemonade> lemonades) {
		if (lemonades == null) {
			lemonades = new ArrayList<>();
		}
		this.lemonades.addAll(lemonades);
		for (Lemonade l : lemonades) {
			total += l.getPrice();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Lemonade> getLemonades() {
		if (lemonades == null) {
			lemonades = new ArrayList<>();
		}
		return lemonades;
	}

	public double getTotal() {
		return total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LemonadeStand getLemonadeStand() {
		return lemonadeStand;
	}

	public void setLemonadeStand(LemonadeStand lemonadeStand) {
		this.lemonadeStand = lemonadeStand;
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
