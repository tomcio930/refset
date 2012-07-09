package ow;

import java.util.ArrayList;
import java.util.HashMap;

public interface ScatterSearch {
	Double objectiveFunction(ArrayList<Double> vector);
	Double randInBounds(Double min, Double max);
	ArrayList<Double> randomVector(HashMap<Integer, ArrayList<Integer>> bounds);
	ArrayList<Double> takeStep(HashMap<Integer, ArrayList<Integer>> minMax, ArrayList<Integer> current, Double stepSize);
	HashMap<String, Double> localSearch(HashMap<String, Double> best, HashMap<Integer, ArrayList<Integer>> bounds, Integer maxNoImprov, Double stepSize);
	ArrayList<HashMap<String, Double>> constructInitialSet(HashMap<Integer, ArrayList<Integer>> bounds, Integer setSize, Integer maxNoImprov, Double stepSize);
	
	ArrayList<Object> search(HashMap<Integer, ArrayList<Integer>> bounds, Integer maxIter, Integer refSetSize, Integer diverseSetSize, Integer maxNoImprov, Integer stepSize, Integer noElite);
}
