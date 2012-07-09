package test;

import java.util.ArrayList;
import java.util.HashMap;

import ow.Problem;



public class CarProblemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem carProblem = new Problem();
		ArrayList<Double> vector = new ArrayList<Double>();
		ArrayList<Double> weights = new ArrayList<Double>();
		ArrayList<Double[]> bounds = new ArrayList<Double[]>();
		
		vector.add(50.0);
		vector.add(52.0);
		weights.add(1.0);
		weights.add(5.0);
		System.out.println(carProblem.objectiveFunction(vector, weights));
		
		System.out.println(carProblem.randInBounds(46.7, 53.3));
		
		bounds.add(new Double[]{43.0,60.0});
		bounds.add(new Double[]{30.0,55.0});
		System.out.println(carProblem.randomVector(bounds));
		
		System.out.println(carProblem.takeStep(bounds, vector, 3.3));
		
		HashMap<String, ArrayList<Double>> best = new HashMap<String, ArrayList<Double>>();
		best.put("vector", vector);
		best.put("cost", carProblem.objectiveFunction(vector, weights));
		System.out.println(carProblem.localSearch(best, bounds, weights, 30, 0.5));
		
	}
}
