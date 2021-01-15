package lemonadestand.entity;

public class LemonadeStand implements Entity {
	
	private Integer id;

	private String name;

	public LemonadeStand(String name) {
		this.name = name;
	}

	public LemonadeStand(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LemonadeStand {name=" + name + "}";
	}

}
