package ow;

import java.util.ArrayList;
import java.util.Iterator;

import ow.exceptions.NoInnerConsistency;

public class Set {

	private final ArrayList<Element> elements;
	private Element center;

	public Set() {
		this.center = new Element();
		elements = new ArrayList<Element>();
	}

	public void addElement(Element el) throws NoInnerConsistency{
		if(checkSetConsistency(el)){
			elements.add(el);
			computeCenter();
		}else{
			throw new NoInnerConsistency("Cannot add element: " + el + ". Set are not consistent.");
		}
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
	
	//sprawdza czy zbior jest wewnetrznie spojny, tz dwa elementy tego zbioru 
	//nie moga byc porownywalne. W naszym przypadku nie mozna porownac dwoch samochodow
	//jesli maja inne wartosci na co najmniej 2 wlasciwosciach
	private final boolean checkSetConsistency(Element newEl){
		
		int count = 0;
		Iterator<Element> itr = elements.iterator();
		while(itr.hasNext()){
			Element el = itr.next();
			if(el.getDoors() == newEl.getDoors()) count++;
			if(el.getLuggage() == newEl.getLuggage())count++;
			if(el.getMaintenance() == newEl.getMaintenance())count++;
			if(el.getPersons() == newEl.getPersons())count++;
			if(el.getPrice() == newEl.getPrice())count++;
			if(el.getSafety() == newEl.getSafety())count++;
			
			if(count >= 5){
				return false;
			}else count=0;
		}
		
		return true;
	}

}
