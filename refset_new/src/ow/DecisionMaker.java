package ow;

import java.util.ArrayList;
import java.util.Scanner;

public class DecisionMaker {

	private Refset refset;
	
	public DecisionMaker(){
		this.refset = new Refset();
	}
	
	public void start(){
//		System.out.println("REFSET ALGORITHM\n"+
//							"MENU:\n"+
//							"1. Show default parameters\n"+
//							"2. Change weights for criteria\n"+
//							"3. Change refset size\n"+
//							"4. Change thresholds\n"	);
					
		
		Generator generator = new Generator();
		ProblemConstrains pc = new ProblemConstrains();
		//generating new random refset
		generator.generateRefSet(refset, pc.SETS_SIZE);
		
		//computing distance between each element and center of sets
		refset.computeElementsDistance();
		System.out.println("Computed distance between each element and the center of sets.");
		ElectreIII e3 = new ElectreIII(refset, pc.WEIGHTS, pc.P, pc.Q, pc.V);
		ArrayList<Element> elements = e3.computeFinalPreOrder();
		System.out.println("Cars ranking:");
		for(Element e : elements) {
			System.out.println(e);
		}

	}
	
	public String readInput() {
		Scanner in = new Scanner(System.in);
	    String line = in.nextLine();
        in.close();   
        return line;
	}
	
}
