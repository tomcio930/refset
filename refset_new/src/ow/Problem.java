package ow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Problem implements ScatterSearch {
	
	//zwraca wartosc funkcji dla danych wejsciowych i wag
	@Override
	public ArrayList<Double> objectiveFunction(ArrayList<Double> vector, ArrayList<Double> weights) {
		Double result = 0.0;
		for(int i=0; i<vector.size(); i++){
			result += vector.get(i)*weights.get(i);
		}
		ArrayList<Double> alResult = new ArrayList<Double>();
		alResult.add(result);
		return alResult;
	}
	
	//zwraca losowa wartosc z przedzialu
	@Override
	public Double randInBounds(Double min, Double max) {
		Random rand = new Random();
		Double range = max - min;
		Double randomNum =  range * rand.nextDouble() + min;
		return randomNum;
	}
	
	//zwraca losowy wektor 
	@Override
	public ArrayList<Double> randomVector(ArrayList<Double[]> bounds) {
		ArrayList<Double> randomVector = new ArrayList<Double>();
		Double min,max;
		for(int i=0; i<bounds.size(); i++)
		{
			min = bounds.get(i)[0];
			max = bounds.get(i)[1];
			randomVector.add(randInBounds(min, max));
		}
		return randomVector;
	}

	@Override
	public ArrayList<Double> takeStep(ArrayList<Double[]> minMax,
			ArrayList<Double> current, Double stepSize) {
		ArrayList<Double> position = new ArrayList<Double>();
		Double min, max;
		for(int i=0; i<current.size(); i++)
		{
			min = Math.max(minMax.get(i)[0], current.get(i) - stepSize);
			max = Math.min(minMax.get(i)[1], current.get(i) + stepSize);
			position.add(randInBounds(min, max));
		}
		return position;
	}

	@Override
	public HashMap<String, ArrayList<Double>> localSearch(HashMap<String, ArrayList<Double>> best,
			ArrayList<Double[]> bounds, ArrayList<Double> weights, int maxNoImprov, Double stepSize) {
		int count = 0;
		do{
			HashMap<String, ArrayList<Double>> candidate = new HashMap<String, ArrayList<Double>>();
			candidate.put("vector", takeStep(bounds, best.get("vector"), stepSize));
			candidate.put("cost", objectiveFunction(candidate.get("vector"), weights));
			
			if(candidate.get("cost").get(0) < best.get("cost").get(0)){
				count = 0;
				best = candidate;
			}else count++;

		}while(count <= maxNoImprov);
		
		return best;
	}

	@Override
	public ArrayList<HashMap<String, ArrayList<Double>>> constructInitialSet(
			ArrayList<Double[]> bounds, ArrayList<Double> weights, Integer setSize, Integer maxNoImprov, Double stepSize) {
		
		do{
			HashMap<String, ArrayList<Double>> cand = new HashMap<String, ArrayList<Double>>();
			cand.put("vector", randomVector(bounds));
			cand.put("cost", objectiveFunction(cand.get("vector"), weights));
			cand = localSearch(cand, bounds, weights, maxNoImprov, stepSize);
			
		}while(false);
		
		return null;
	}

	@Override
	public Double euclideanDistance(ArrayList<Double> c1, ArrayList<Double> c2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double distance(ArrayList<Double> v,
			HashMap<Double, ArrayList<Double>> set) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> search(HashMap<Double, ArrayList<Double>> bounds,
			Integer maxIter, Integer refSetSize, Integer diverseSetSize,
			Integer maxNoImprov, Double stepSize, Integer noElite) {
		// TODO Auto-generated method stub
		return null;
	}
}

	