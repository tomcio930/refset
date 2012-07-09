package ow;

import java.util.ArrayList;
import java.util.HashMap;

public interface ScatterSearch {
	//dodalem liste wag do tej funkcji
	Double objectiveFunction(ArrayList<Double> vector, ArrayList<Double> weights);
	Double randInBounds(Double min, Double max);
	ArrayList<Double> randomVector(ArrayList<Double[]> bounds);
	ArrayList<Double> takeStep(ArrayList<Double[]> minMax, ArrayList<Double> current, Double stepSize);
	HashMap<String, Double> localSearch(HashMap<String, ArrayList<Double>> best, ArrayList<Double[]> bounds, int maxNoImprov, Double stepSize);
	ArrayList<HashMap<String, Double>> constructInitialSet(HashMap<Double, ArrayList<Double>> bounds, Integer setSize, Integer maxNoImprov, Double stepSize);
	Double euclideanDistance(ArrayList<Double> c1, ArrayList<Double> c2);
	Double distance(ArrayList<Double> v, HashMap<Double, ArrayList<Double>> set);
	ArrayList<Object> search(HashMap<Double, ArrayList<Double>> bounds, Integer maxIter, Integer refSetSize, Integer diverseSetSize, Integer maxNoImprov, Double stepSize, Integer noElite);
}
