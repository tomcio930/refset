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
		Element e1 = refset.getSet(0).getElement(0);
		Element e2 = refset.getSet(0).getElement(1);
		System.out.println(e1+" dist: "+e1.getDistance()[0]+" "+e1.getDistance()[1]+" "+e1.getDistance()[2]+" "+e1.getDistance()[3]);
		System.out.println(e2+" dist: "+e2.getDistance()[0]+" "+e2.getDistance()[1]+" "+e2.getDistance()[2]+" "+e2.getDistance()[3]);
		e3.descendingDestilation();
		System.out.println(e3.descendingElements);
	}
	
}
