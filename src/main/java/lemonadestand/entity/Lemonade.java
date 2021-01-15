package lemonadestand.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Lemonade implements Serializable, Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6858462398572875916L;
	
	private Integer id;

	private double lemonJuice;
	
	private double water;
	
	private double sugar;
	
	private int iceCubes;
	
	private final int CUP = 1;
	
	private double price;
	
	private Order order;
	
	public Lemonade() {}

	public Lemonade(double lemonJuice, double water, double sugar, int iceCubes, Order order) {
		super();
		this.lemonJuice = lemonJuice;
		this.water = water;
		this.sugar = sugar;
		this.iceCubes = iceCubes;
		this.order = order;
		price = (lemonJuice * .3) + (sugar * .15) + (CUP * .50);
	}

	public Lemonade(Integer id, double lemonJuice, double price, double sugar, int iceCubes, double water,
			Order order) {
		this.id = id;
		this.lemonJuice = lemonJuice;
		this.price = price;
		this.sugar = sugar;
		this.iceCubes = iceCubes;
		this.water = water;
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setLemonJuice(double lemonJuice) {
		this.lemonJuice = lemonJuice;
	}

	public void setWater(double water) {
		this.water = water;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public void setIceCubes(int iceCubes) {
		this.iceCubes = iceCubes;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLemonJuice() {
		return lemonJuice;
	}

	public double getWater() {
		return water;
	}

	public double getSugar() {
		return sugar;
	}

	public int getIceCubes() {
		return iceCubes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@JsonIgnore
	public int getCUP() {
		return CUP;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Lemonade {lemonJuice=" + lemonJuice + ", water=" + water + ", sugar=" + sugar + ", iceCubes=" + iceCubes
				+ ", CUP=" + CUP + ", price=" + price + "}";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CUP;
		result = prime * result + iceCubes;
		long temp;
		temp = Double.doubleToLongBits(lemonJuice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(water);
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
		Lemonade other = (Lemonade) obj;
		if (CUP != other.CUP)
			return false;
		if (iceCubes != other.iceCubes)
			return false;
		if (Double.doubleToLongBits(lemonJuice) != Double.doubleToLongBits(other.lemonJuice))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(sugar) != Double.doubleToLongBits(other.sugar))
			return false;
		if (Double.doubleToLongBits(water) != Double.doubleToLongBits(other.water))
			return false;
		return true;
	}

}
