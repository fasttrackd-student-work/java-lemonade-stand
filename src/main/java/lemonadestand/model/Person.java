package lemonadestand.model;

public interface Person {
	
	default String getName() {
		return "John Doe";
	}

}
