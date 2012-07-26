package ow;

import java.util.Random;

import ow.exceptions.NoConsistency;
import ow.exceptions.NoInnerConsistency;

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
	
	private final Element generateElementint(int setNumber){
		return new Element(
				randomDouble(ProblemConstrains.PRICE_BOUNDS[setNumber]) * 100,
				randomDouble(ProblemConstrains.MAINTAIN_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.DOORS_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.PERSONS_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.LUGGAGE_BOUNDS[setNumber]),
				randomDouble(ProblemConstrains.SAFETY_BOUNDS[setNumber]));
	}
	
	public final void generateSet(int setNumber, int setSize){
		Set set = new Set();
		int badElements = 0;
		do{
			try {
				set.addElement(generateElementint(setNumber));
			} catch (NoInnerConsistency e) {
				badElements++;
			}
		}while(set.getSize() != setSize);
		System.out.println(badElements);
	}
	
	public final void generateRefSet(Refset refset, int[] setsSize){
		for(int i=3; i>=0; i--){
			int badElement = 0;
			do{
				try {
					refset.addElementToA(i, generateElementint(i));
				} catch (NoConsistency e) {
					badElement++;
				}
			}while(refset.getSet(i).getSize() != setsSize[i]);
			refset.getSet(i).computeCenter();
			System.out.println("Generated set " + i + " with " + refset.getSet(i).getSize() + " elements. " + badElement + " elements wasn't consistent.");
		}
	}
	
}
