package ow;

import java.util.Iterator;

import ow.exceptions.NoConsistency;
import ow.exceptions.NoInnerConsistency;

public class Refset {
	
	private Set[] a = new Set[4];

	public Refset(Set a0, Set a1, Set a2, Set a3) {
		super();
		this.a[0] = a0;
		this.a[1] = a1;
		this.a[2] = a2;
		this.a[3] = a3;
	}

	// sprawdza czy ka¿dy zbiór ma przynajmniej 1 element
	public boolean hasSetElements() {
		return (a[0].getSize() != 0 && a[1].getSize() != 0 && a[2].getSize() != 0 && a[3].getSize() != 0);
	}

	private boolean checkConsistency(int i, Element newEl) {
		
		Iterator<Element> itr = a[i+1].getElements().iterator();
		while(itr.hasNext()){
			Element el = itr.next();
			if(ProblemConstrains.PRICE_ORDER){
				if( !(el.getPrice() >= newEl.getPrice()) ){
					return false;
				}
			}else{
				if( !(el.getPrice() <= newEl.getPrice()) ){
					return false;
				}
			}
			if(ProblemConstrains.DOORS_ORDER){
				if( !(el.getDoors() >= newEl.getDoors()) ){
					return false;
				}
			}else{
				if( !(el.getDoors() <= newEl.getDoors()) ){
					return false;
				}
			}
			if(ProblemConstrains.LUGGAGE_ORDER){
				if( !(el.getLuggage() >= newEl.getLuggage()) ){
					return false;
				}
			}else{
				if( !(el.getLuggage() <= newEl.getLuggage()) ){
					return false;
				}
			}
			if(ProblemConstrains.MAINTAIN_ORDER){
				if( !(el.getMaintenance() >= newEl.getMaintenance()) ){
					return false;
				}
			}else{
				if( !(el.getMaintenance() <= newEl.getMaintenance()) ){
					return false;
				}
			}
			if(ProblemConstrains.PERSONS_ORDER){
				if( !(el.getPersons() >= newEl.getPersons()) ){
					return false;
				}
			}else{
				if( !(el.getPersons() <= newEl.getPersons()) ){
					return false;
				}
			}
			if(ProblemConstrains.SAFETY_ORDER){
				if( !(el.getSafety() >= newEl.getSafety()) ){
					return false;
				}
			}else{
				if( !(el.getSafety() <= newEl.getSafety()) ){
					return false;
				}
			}
		}
		return true;
	}
	
	public void addElementToA0(Element el) throws NoConsistency {
		try{
			a[0].addElement(el);
		}catch(NoInnerConsistency e){
			e.printStackTrace();
		}
		if (!checkConsistency(0, el)) {
			a[0].removeElement(el);
			throw new NoConsistency("Cannot add element: " + el + ". Sets are not consistent.");
		}
	}

	public void addElementToA1(Element el) throws NoConsistency {
		try{
			a[1].addElement(el);
		}catch(NoInnerConsistency e){
			e.printStackTrace();
		}
		if (!checkConsistency(1, el)) {
			a[1].removeElement(el);
			throw new NoConsistency("Cannot add element: " + el + ". Sets are not consistent.");
		}
	}

	public void addElementToA2(Element el) throws NoConsistency {
		try{
			a[2].addElement(el);
		}catch(NoInnerConsistency e){
			e.printStackTrace();
		}
		if (!checkConsistency(2, el)) {
			a[2].removeElement(el);
			throw new NoConsistency("Cannot add element: " + el + ". Sets are not consistent.");
		}
	}

	public void addElementToA3(Element el) throws NoConsistency {
		try{
			a[3].addElement(el);
		}catch(NoInnerConsistency e){
			e.printStackTrace();
		}
	}

	public Set getA0() {
		return a[0];
	}

//	public void setA0(Set a0) throws NoConsistency {
//		Set tmp = this.a[0];
//		this.a[0] = a0;
//		if (!checkConsistency()) {
//			this.a[0] = tmp;
//			throw new NoConsistency("Cannot change set: " + a0 + ". Sets are not consistent.");
//		}
//	}
//
//	public Set getA1() {
//		return a[1];
//	}
//
//	public void setA1(Set a1) throws NoConsistency {
//		Set tmp = this.a[1];
//		this.a[1] = a1;
//		if (!checkConsistency()) {
//			this.a[1] = tmp;
//			throw new NoConsistency("Cannot change set: " + a1 + ". Sets are not consistent.");
//		}
//	}
//
//	public Set getA2() {
//		return a[2];
//	}
//
//	public void setA2(Set a2) throws NoConsistency {
//		Set tmp = this.a[2];
//		this.a[2] = a2;
//		if (!checkConsistency()) {
//			this.a[2] = tmp;
//			throw new NoConsistency("Cannot change set: " + a2 + ". Sets are not consistent.");
//		}
//	}
//
//	public Set getA3() {
//		return a[3];
//	}
//
//	public void setA3(Set a3) throws NoConsistency {
//		Set tmp = this.a[3];
//		this.a[3] = a3;
//		if (!checkConsistency()) {
//			this.a[3] = tmp;
//			throw new NoConsistency("Cannot change set: " + a3 + ". Sets are not consistent.");
//		}
//	}

}
