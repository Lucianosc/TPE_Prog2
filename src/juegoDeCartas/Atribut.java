package juegoDeCartas;

public class Atribut {
	private String name;
	private int value;
	
	
	public Atribut(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}


	public int getValue() {
		return value;
	}
	
	//comparo atributos y verifico si son el mismo
	//y si el valor de mi atributo es mayor que el que me pasan
	//retorno true
	
	public boolean exceedAtribut(Atribut at1) {
		if(this.name.equals(at1.getName()) && 
				(this.getValue() > at1.getValue())) {
			return true;
		}
			return false;
	
	}
	
	public boolean pairsAtribut(Atribut at1) {
		if(this.name.equals(at1.getName()) && 
				(this.getValue() == at1.getValue())) {
			return true;
		}
		return false;
	}
	
	
	
	public boolean equals(Object o1) {
		try {
			Atribut at1 = (Atribut) o1;
			return name.equals(at1.getName());
			
		}catch(Exception e){
			return false;
		}
		
	}
	
	public int compareAtribut(Atribut at) {
		if (this.value > at.getValue()) {
			return 1;
		}
		else if(this.value < at.getValue()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	

}
