package ow;

public class Refset {
	private Set a0;
	private Set a1;
	private Set a2;
	private Set a3;

	private boolean checkCohesion() {
		// TO DO
		return true;
	}

	public Refset() {
		a0 = new Set();
		a1 = new Set();
		a2 = new Set();
		a3 = new Set();
	}

	public Refset(Set a0, Set a1, Set a2, Set a3) {
		super();
		this.a0 = a0;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}

	// sprawdza czy ka¿dy zbiór ma przynajmniej 1 element
	public boolean hasElementSets() {
		return (a0.getSize() != 0 && a1.getSize() != 0 && a2.getSize() != 0 && a3.getSize() != 0);
	}

	public boolean addElementToA0(Element el) {
		a0.addElement(el);
		if (checkCohesion())
			return true;
		else {
			a0.removeElement(el);
			return false;
		}
	}

	public boolean addElementToA1(Element el) {
		a1.addElement(el);
		if (checkCohesion())
			return true;
		else {
			a1.removeElement(el);
			return false;
		}
	}

	public boolean addElementToA2(Element el) {
		a2.addElement(el);
		if (checkCohesion())
			return true;
		else {
			a2.removeElement(el);
			return false;
		}
	}

	public boolean addElementToA3(Element el) {
		a3.addElement(el);
		if (checkCohesion())
			return true;
		else {
			a3.removeElement(el);
			return false;
		}
	}

	public Set getA0() {
		return a0;
	}

	public boolean setA0(Set a0) {
		Set tmp = this.a0;
		this.a0 = a0;
		if (checkCohesion())
			return true;
		else {
			this.a0 = tmp;
			return false;
		}
	}

	public Set getA1() {
		return a1;
	}

	public boolean setA1(Set a1) {
		Set tmp = this.a1;
		this.a1 = a1;
		if (checkCohesion())
			return true;
		else {
			this.a1 = tmp;
			return false;
		}
	}

	public Set getA2() {
		return a2;
	}

	public boolean setA2(Set a2) {
		Set tmp = this.a2;
		this.a2 = a2;
		if (checkCohesion())
			return true;
		else {
			this.a2 = tmp;
			return false;
		}
	}

	public Set getA3() {
		return a3;
	}

	public boolean setA3(Set a3) {
		Set tmp = this.a3;
		this.a3 = a3;
		if (checkCohesion())
			return true;
		else {
			this.a3 = tmp;
			return false;
		}
	}

}
