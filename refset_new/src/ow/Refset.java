package ow;

public class Refset {
	private Set a0;
	private Set a1;
	private Set a2;
	private Set a3;

	private boolean checkCohesion() {
		return false;
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

	public Set getA0() {
		return a0;
	}

	public void setA0(Set a0) {
		this.a0 = a0;
	}

	public Set getA1() {
		return a1;
	}

	public void setA1(Set a1) {
		this.a1 = a1;
	}

	public Set getA2() {
		return a2;
	}

	public void setA2(Set a2) {
		this.a2 = a2;
	}

	public Set getA3() {
		return a3;
	}

	public void setA3(Set a3) {
		this.a3 = a3;
	}

}
