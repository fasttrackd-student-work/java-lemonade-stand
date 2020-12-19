package lemonadestand.model;

public class LemonadeStand {

	String name;

	public LemonadeStand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LemonadeStand {name=" + name + "}";
	}

}
