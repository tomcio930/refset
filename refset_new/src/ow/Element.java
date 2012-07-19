package ow;

public class Element {

	private double price;
	private double maintenance;
	private double doors;
	private double persons;
	private double luggage;
	private double safety;

	public Element() {
		super();
		this.price = 0;
		this.maintenance = 0;
		this.doors = new Float(0);
		this.persons = new Float(0);
		this.luggage = new Float(0);
		this.safety = new Float(0);
	}

	public Element(double price, double maintenance, double doors, double persons, double luggage, double safety) {
		super();
		this.price = price;
		this.maintenance = maintenance;
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
		return maintenance;
	}

	public void setMaintenance(double maintenance) {
		this.maintenance = maintenance;
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
