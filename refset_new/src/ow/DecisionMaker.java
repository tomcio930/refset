package ow;

public class DecisionMaker {

	private Refset refset;
	
	public DecisionMaker(){
		this.refset = new Refset();
	}
	
	public void start(){
		Generator generator = new Generator();
		//generating new random refset
		generator.generateRefSet(refset, ProblemConstrains.SETS_SIZE);
		//computing distance between each element and center of sets
		refset.computeElementsDistance();
		System.out.println("Computed distance between each element and the center of sets.");
	}
	
}
