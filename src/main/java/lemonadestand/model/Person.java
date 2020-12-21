package lemonadestand.model;

import java.io.Serializable;

public interface Person extends Serializable {
	
	default String getName() {
		return "John Doe";
	}

}
