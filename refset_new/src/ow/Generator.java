package ow;

import java.util.Random;

public class Generator {

	public Generator(){
		
	}
	
	private static double randomDouble(double[] bounds){
		if ( bounds[0] > bounds[1] ) {
		  throw new IllegalArgumentException("Start cannot exceed End.");
		}
		Random random = new Random();
		//get the range, casting to long to avoid overflow problems
		double range = bounds[1] - bounds[0] + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long)(range * random.nextDouble());
		int randomNumber =  (int)(fraction + bounds[0]);    
		return (double)randomNumber;
	}
	
	public final Element generateElementint(int setNumber){
		return new Element(
				randomDouble(ProblemConstrains.PRICE_BOUNDS[setNumber]) * 100,
				randomDouble(ProblemConstrains.MAINTAIN_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.DOORS_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.PERSONS_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.LUGGAGE_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.SAFETY_BOUNDS[setNumber]));
	}
	
}
