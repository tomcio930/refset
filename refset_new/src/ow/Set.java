package ow;

import java.util.ArrayList;

public class Set {

	private final ArrayList<Element> elements;
	private Element center;

	public Set() {
		this.center = new Element();
		elements = new ArrayList<Element>();
	}

	public Set(ArrayList<Element> elements) {
		this.center = new Element();
		this.elements = elements;
		computeCenter();
	}

	public void addElement(Element el) {
		elements.add(el);
		computeCenter();
	}

	public void removeElement(Element el) {
		elements.remove(el);
		computeCenter();
	}

	public Element getCenter() {
		return center;
	}

	public double getDistance(Element el) {
		double distance = 0.0;
		double doors = Math.pow(center.getDoors() - el.getDoors(), 2);
		double luggage = Math.pow(center.getLuggage() - el.getLuggage(), 2);
		double maintance = Math.pow(center.getMaintenance() - el.getMaintenance(), 2);
		double persons = Math.pow(center.getPersons() - el.getPersons(), 2);
		double price = Math.pow(center.getPrice() - el.getPrice(), 2);
		double safety = Math.pow(center.getSafety() - el.getSafety(), 2);
		distance = Math.sqrt(doors + luggage + maintance + persons + price + safety);
		return distance;
	}

	private final void computeCenter() {
		Element centerTmp = new Element();
		for (int i = 0; i < elements.size(); i++) {
			centerTmp.setDoors(centerTmp.getDoors() + elements.get(i).getDoors());
			centerTmp.setLuggage(centerTmp.getLuggage() + elements.get(i).getLuggage());
			centerTmp.setMaintenance(centerTmp.getMaintenance() + elements.get(i).getMaintenance());
			centerTmp.setPersons(centerTmp.getPersons() + elements.get(i).getPersons());
			centerTmp.setPrice(centerTmp.getPrice() + elements.get(i).getPrice());
			centerTmp.setSafety(centerTmp.getSafety() + elements.get(i).getSafety());
		}
		int totalElements = elements.size();
		centerTmp.setDoors(centerTmp.getDoors() / totalElements);
		centerTmp.setLuggage(centerTmp.getLuggage() / totalElements);
		centerTmp.setMaintenance(centerTmp.getMaintenance() / totalElements);
		centerTmp.setPersons(centerTmp.getPersons() / totalElements);
		centerTmp.setPrice(centerTmp.getPrice() / totalElements);
		centerTmp.setSafety(centerTmp.getSafety() / totalElements);

		center = centerTmp;
	}

}
