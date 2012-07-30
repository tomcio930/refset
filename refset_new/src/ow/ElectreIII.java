package ow;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.regexp.internal.RESyntaxException;

import sun.text.normalizer.UBiDiProps;


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
			return 1 * e.getDistance()[j];
		}else if (j==3) {
			return 1 * e.getDistance()[j];
		}
		return 0;
	}
	
	private double compatibility(Element a, Element b, int j){
		if(gFunction(a, j) + q[j] >= gFunction(b, j)){
			return 1;
		}
		else if(gFunction(a, j) + p[j] <= gFunction(b, j)){
			return 0;
		}
		else {
			return (p[j]+gFunction(a, j)-gFunction(b, j))/(p[j]-q[j]);
		}
		
	}
	
	private double incompatibility(Element a, Element b, int j){
		if(gFunction(a, j) + p[j] >= gFunction(b, j)){
			return 0;
		}
		else if(gFunction(a, j) + v[j] <= gFunction(b, j)){
			return 1;
		}
		else {
			return (gFunction(b, j)-gFunction(a, j)-p[j])/(v[j]-p[j]);
		}
	}
	
	private double compatibilitySum(Element a, Element b){
		double result = 0.0;
		double weightSum = 0.0;
		for(int i=0; i < weights.length; i++){
			weightSum += weights[i];
		}
		for(int i=0; i < weights.length; i++){
			result += weights[i]*compatibility(a, b, i);
		}		
		return result/weightSum;
	}
	
	private double credibility(Element a, Element b){
		double result = 1.0;
		double comSum = compatibilitySum(a, b);
		for(int i=0; i < weights.length; i++){
			if(comSum < incompatibility(a, b, i))
				break;
			else if(weights.length-1 == i)
				return comSum;
		}
		for(int i=0; i < weights.length; i++){
			double incompatibility = incompatibility(a, b, i);
			if(incompatibility > comSum)
				result *= (1-incompatibility)/(1-comSum);
		}
		return result*comSum;

	}
	
	private ArrayList<Double> credibilityMatrix()
	{
		ArrayList<Double> tmp = new ArrayList<Double>();
		for(int i = 0; i < elements.size(); i++) {
			for(int j=0; j < elements.size(); j++) {
				Element e1 = elements.get(i);
				Element e2 = elements.get(j);
				tmp.add(credibility(e1, e2));
			}
		}
		return tmp;
	}
	
	private ArrayList<Integer> tMatrix() {
		ArrayList<Double> credibilityMatrix = credibilityMatrix();
		double lambda = Collections.max(credibilityMatrix);
		ArrayList<Integer> tMatrix = new ArrayList<Integer>();
		Iterator<Double> itr = credibilityMatrix.iterator();
		while(itr.hasNext()){
			Double value = itr.next();
			if(value > lambda - ProblemConstrains.THRESHOLD)
				tMatrix.add(1);
			else tMatrix.add(0);
		}
		return tMatrix;
	}
	
	public int[] qualification() {
		int size = elements.size();
		int[] result = new int[size];
		ArrayList<Integer> tMatrix = tMatrix(); 
		for(int i=0; i<size; i++) {
			List<Integer> subList = tMatrix.subList(i*size, (i+1)*size);
			for(int j=0; j<subList.size(); j++){
				if(subList.get(j) == 1){
					if(i==j) continue;
					result[i] += 1;
					result[j] -= 1;
				}
			}
		}
		return result;
	}
	
}
