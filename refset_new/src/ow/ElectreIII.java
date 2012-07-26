package ow;

import java.util.ArrayList;

public class ElectreIII {

	//wagi dla kryteriow
	private double[] weights;
	//prog preferencji
	private double[] p;
	//prog rownowazosci
	private double[] q;
	//veto
	private double[] v;
	private ArrayList<Element> elements = new ArrayList<Element>();
	
	public ElectreIII(Refset refset, double[] weights, double[] p, double[] q, double[] v) {
		super();
		elements.addAll(refset.getSet(1).getElements());
		elements.addAll(refset.getSet(2).getElements());
		this.weights = weights;
		this.p = p;
		this.q = q;
		this.v = v;
	}
	
	private double gFunction(Element e, int j){
		if(j==0){
			return -1 * e.getDistance()[j];
		}else if (j==1) {
			return -1 * e.getDistance()[j];
		}else if (j==2) {
			return -1 * e.getDistance()[j];
		}else if (j==3) {
			return 1 * e.getDistance()[j];
		}
		return 0;
	}
	
	private int compatibility(Element a, Element b, int j){
		if(gFunction(a, j) + q[j] >= gFunction(b, j)){
			return 1;
		}
		if(gFunction(a, j) + p[j] <= gFunction(b, j)){
			return 0;
		}
		return 0;
	}
	
	private int incompatibility(Element a, Element b, int j){
		if(gFunction(a, j) + p[j] >= gFunction(b, j)){
			return 0;
		}
		if(gFunction(a, j) + v[j] <= gFunction(b, j)){
			return 1;
		}
		return 0;
	}
	
}
