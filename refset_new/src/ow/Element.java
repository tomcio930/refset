package ow;

public class Element {

	private double price;
	private double maintain;
	private double doors;
	private double persons;
	private double luggage;
	private double safety;

	public Element() {
		super();
		this.price = 0.0;
		this.maintain = 0.0;
		this.doors = 0.0;
		this.persons = 0.0;
		this.luggage = 0.0;
		this.safety = 0.0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(price: " + String.valueOf(price) + " maintenance: " + String.valueOf(maintain) + " doors: "
				+ String.valueOf(doors) + " persons: " + String.valueOf(persons) + " luggage: "
				+ String.valueOf(luggage) + " safety: " + String.valueOf(safety) + ")";
	}

	public Element(double price, double maintenance, double doors, double persons, double luggage, double safety) {
		super();
		this.price = price;
		this.maintain = maintenance;
		this.doors = doors;
		this.persons = persons;
		this.luggage = luggage;
		this.safety = safety;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMaintenance() {
		return maintain;
	}

	public void setMaintenance(double maintenance) {
		this.maintain = maintenance;
	}

	public double getDoors() {
		return doors;
	}

	public void setDoors(double doors) {
		this.doors = doors;
	}

	public double getPersons() {
		return persons;
	}

	public void setPersons(double persons) {
		this.persons = persons;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}

	public double getSafety() {
		return safety;
	}

	public void setSafety(double safety) {
		this.safety = safety;
	}

}
