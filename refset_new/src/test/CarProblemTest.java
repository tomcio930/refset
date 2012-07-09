package test;

import java.util.ArrayList;

import ow.Problem;



public class CarProblemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Problem carProblem = new Problem();
		ArrayList<Double> vector = new ArrayList<>();
		ArrayList<Double> weights = new ArrayList<>();
		ArrayList<Double[]> bounds = new ArrayList<>();
		
		vector.add(50.0);
		weights.add(1.0);
		System.out.println(carProblem.objectiveFunction(vector, weights));
		
		System.out.println(carProblem.randInBounds(46.7, 53.3));
		
		bounds.add(new Double[]{0.0,100.0});
		System.out.println(carProblem.randomVector(bounds));
		
		System.out.println(carProblem.takeStep(bounds, vector, 3.3));
	}
}
