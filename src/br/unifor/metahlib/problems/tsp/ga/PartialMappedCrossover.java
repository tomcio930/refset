package br.unifor.metahlib.problems.tsp.ga;

import br.unifor.metahlib.metaheuristics.ga.CrossoverOperator;

/**
 * Implements the PMX crossover operator.
 */
public class PartialMappedCrossover extends CrossoverOperator {
	
	private void fillChild(Object[] child, Object[] p1, Object[] p2){
		for (int i = 0; i < child.length; ++i){
			if (child[i] == null){
				int idx = i;
				Object value = p1[i];
				while (indexOf(value, child) >= 0){
					idx = indexOf(p2[idx], p1);
					value = p2[idx];
				}
				child[i] = value;
			}
		}
	}

	@Override
	public Object[][] crossover(Object[] g1, Object[] g2) {
		assert(g1.length == g2.length);
		int len = g1.length;
		
		Object[] c1 = new Object[len];
		Object[] c2 = new Object[len];
		
		int p1 = random.nextInt(len);
		int p2 = random.nextInt(len);
		for (int i = p1; i <= p2; ++i){
			c1[i] = g2[i];
			c2[i] = g1[i];
		}
		
		fillChild(c1, g1, g2);
		fillChild(c2, g2, g1);
		
		Object[][] children = new Object[][]{c1, c2};

		return children;
	}

}
