package ow;

public class DecisionMaker {

	private Refset refset;
	
	public DecisionMaker(){
		this.refset = new Refset();
	}
	
	public void start(){
		Generator generator = new Generator();
		ProblemConstrains pc = new ProblemConstrains();
		//generating new random refset
		generator.generateRefSet(refset, pc.SETS_SIZE);
		//computing distance between each element and center of sets
		refset.computeElementsDistance();
		System.out.println("Computed distance between each element and the center of sets.");
		ElectreIII e3 = new ElectreIII(refset, pc.WEIGHTS, pc.P, pc.Q, pc.V);
		
	}
	
}
