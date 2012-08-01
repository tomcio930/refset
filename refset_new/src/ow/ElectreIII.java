package ow;

import java.util.ArrayList;

import java.util.Arrays;
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
	public ArrayList<Element> descendingElements = new ArrayList<Element>();
	//private ArrayList<Element> elements = new ArrayList<Element>();
	
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
	
	private ArrayList<Double> credibilityMatrix(ArrayList<Element> tmpElements)
	{
		ArrayList<Double> tmp = new ArrayList<>();
		for(int i = 0; i < tmpElements.size(); i++) {
			for(int j=0; j < tmpElements.size(); j++) {
				Element e1 = tmpElements.get(i);
				Element e2 = tmpElements.get(j);
				tmp.add(credibility(e1, e2));
			}
		}
		return tmp;
	}
	
	private ArrayList<Integer> tMatrix(ArrayList<Element> tmpElements) {
		ArrayList<Double> credibilityMatrix = credibilityMatrix(tmpElements);
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
	
	private static int maxValueIndex(int[] values) {
        int maxValue = values[0];
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
                if (values[i] > maxValue) {
                        maxValue = values[i];
                        maxIndex = i;
                }
        }
        return maxIndex;
}
	
	public int[] qualification(ArrayList<Element> tmpElements) {
		int size = tmpElements.size();
		int[] results = new int[size];
		ArrayList<Integer> tMatrix = tMatrix(tmpElements); 
		for(int i=0; i<size; i++) {
			List<Integer> subList = tMatrix.subList(i*size, (i+1)*size);
			for(int j=0; j<subList.size(); j++){
				if(subList.get(j) == 1){
					if(i==j) continue;
					results[i] += 1;
					results[j] -= 1;
				}
			}
		}
		return results;
	}
	
	void findNextDescendingElement(ArrayList<Element> tmpElements) {
		int[] results = qualification(tmpElements);
		int maxIndex = maxValueIndex(results);
		descendingElements.add(this.elements.get(maxIndex));
		this.elements.remove(maxIndex);
	}

	
	public void descendingDestilation(){
		ArrayList<Element> tmpElements = this.elements;
		while(tmpElements.size()>1)
			findNextDescendingElement(tmpElements);
		descendingElements.add(this.elements.get(0));
	}
	
}
