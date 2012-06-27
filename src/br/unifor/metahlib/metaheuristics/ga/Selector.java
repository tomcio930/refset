package br.unifor.metahlib.metaheuristics.ga;

import java.util.Random;

/**
 * Class responsible to select individuals of a population.
 */
public abstract class Selector {
	
	/**
	 * Problem random number generator.
	 */
	protected Random random;
	
	/**
	 * Selects the informed quantity of individuals using a determined strategy.
	 * @param individuals
	 * @param quantity
	 * @return selected individuals
	 */
	public abstract Individual[] select(Individual[] individuals, int quantity);

	@Override
	public String toString(){
		return this.getClass().getName();		
	}
	
	/**
	 * Sets the random number generator.
	 * @param random random number generator
	 */
	protected void setRandom(Random random) {
		this.random = random;
	}

	/**
	 * Returns the random number generator.
	 * @return random number generator
	 */
	protected Random getRandom() {
		return random;
	}
}
