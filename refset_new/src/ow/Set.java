package ow;

import java.util.ArrayList;
import java.util.Iterator;

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

	public int getSize() {
		return elements.size();
	}

	public double getDistance(Element el) {
		double distance = 0.0;
		distance += Math.pow(center.getDoors() - el.getDoors(), 2);
		distance += Math.pow(center.getLuggage() - el.getLuggage(), 2);
		distance += Math.pow(center.getMaintenance() - el.getMaintenance(), 2);
		distance += Math.pow(center.getPersons() - el.getPersons(), 2);
		distance += Math.pow(center.getPrice() - el.getPrice(), 2);
		distance += Math.pow(center.getSafety() - el.getSafety(), 2);
		
		return Math.sqrt(distance);
	}

	private final void computeCenter() {
		Element centerTmp = new Element();
		Iterator<Element> itr = elements.iterator();
		while(itr.hasNext()){
			Element el = itr.next();
			centerTmp.setDoors(centerTmp.getDoors() + el.getDoors());
			centerTmp.setLuggage(centerTmp.getLuggage() + el.getLuggage());
			centerTmp.setMaintenance(centerTmp.getMaintenance() + el.getMaintenance());
			centerTmp.setPersons(centerTmp.getPersons() + el.getPersons());
			centerTmp.setPrice(centerTmp.getPrice() + el.getPrice());
			centerTmp.setSafety(centerTmp.getSafety() + el.getSafety());
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
