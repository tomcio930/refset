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

		bounds.add(new Double[] { 43.0, 60.0 });
		bounds.add(new Double[] { 30.0, 55.0 });
		System.out.println(carProblem.randomVector(bounds));

		System.out.println(carProblem.takeStep(bounds, vector, 3.3));

		HashMap<String, ArrayList<Double>> best = new HashMap<String, ArrayList<Double>>();
		best.put("vector", vector);
		best.put("cost", carProblem.objectiveFunction(vector, weights));
		System.out.println(carProblem.localSearch(best, bounds, weights, 30, 0.5));
		/*
		 * ArrayList<HashMap<String, Double[]>> set = new
		 * ArrayList<HashMap<String, Double[]>>(); HashMap<String, Double[]> hm1
		 * = new HashMap<String, Double[]>(); hm1.put("vector", new Double[] {
		 * 1.0, 1.0 }); hm1.put("cost", new Double[] { 1.0 }); HashMap<String,
		 * Double[]> hm2 = new HashMap<String, Double[]>(); hm2.put("vector",
		 * new Double[] { 1.0, 1.0 }); hm2.put("cost", new Double[] { 10.0 });
		 * HashMap<String, Double[]> hm3 = new HashMap<String, Double[]>();
		 * hm3.put("vector", new Double[] { 1.0, 1.0 }); hm3.put("cost", new
		 * Double[] { 8.0 }); HashMap<String, Double[]> hm4 = new
		 * HashMap<String, Double[]>(); hm4.put("vector", new Double[] { 1.0,
		 * 1.0 }); hm4.put("cost", new Double[] { 0.0 }); HashMap<String,
		 * Double[]> hm5 = new HashMap<String, Double[]>(); hm5.put("vector",
		 * new Double[] { 1.0, 1.0 }); hm5.put("cost", new Double[] { 1.0 });
		 * 
		 * set.add(hm1); set.add(hm2); set.add(hm3); set.add(hm4); set.add(hm5);
		 * set.add(hm5); set.add(hm5); set = carProblem.diversify(set, 1, 1);
		 * for (int i = 0; i < set.size(); i++)
		 * System.out.println(set.get(i).get("cost")[0]);
		 */
	}
}
