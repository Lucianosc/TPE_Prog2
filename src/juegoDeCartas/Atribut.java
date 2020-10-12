package juegoDeCartas;

public class Atribut implements Comparable<Atribut> {
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

	public boolean equals(Object o1) {
		try {
			Atribut at1 = (Atribut) o1;
			return name.equals(at1.getName());
			
		}catch(Exception e){
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Atribut at) {
		return this.value - at.getValue();
	}
	
	@Override
	public String toString() {
		return name+" "+value;
	}

	

}
