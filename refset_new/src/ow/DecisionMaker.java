package ow;

import java.util.ArrayList;
import java.util.Scanner;

public class DecisionMaker {

	private final Refset refset;

	public DecisionMaker() {
		this.refset = new Refset();
	}

	public void start() {
		// System.out.println("REFSET ALGORITHM\n"+
		// "MENU:\n"+
		// "1. Show default parameters\n"+
		// "2. Change weights for criteria\n"+
		// "3. Change refset size\n"+
		// "4. Change thresholds\n" );

		Generator generator = new Generator();
		ProblemConstrains pc = new ProblemConstrains();
		// generating new random refset
		generator.generateRefSet(refset, pc.SETS_SIZE);
		// computing distance between each element and center of sets
		refset.computeElementsDistance();
		System.out.println("\nComputed distance between each element and the center of sets.\n");
		ElectreIII e3 = new ElectreIII(refset, pc.WEIGHTS, pc.P, pc.Q, pc.V);
		ArrayList<Element> elements = e3.computeFinalPreOrder();
		System.out.println("Algorithm parameters:\nrefset weights: (distance to set A0: " + pc.WEIGHTS[0]
				+ "; distance to set A1: " + pc.WEIGHTS[1] + "; distance to set A2: " + pc.WEIGHTS[2]
				+ "; distance to set A3: " + pc.WEIGHTS[3] + ")");
		System.out.println("electre thresholds: (equivalence: " + pc.Q[0] + ", " + pc.Q[1] + ", " + pc.Q[2] + ", "
				+ pc.Q[3] + "; preference: " + pc.P[0] + ", " + pc.P[1] + ", " + pc.P[2] + ", " + pc.P[3] + "; veto: "
				+ pc.V[0] + ", " + pc.V[1] + ", " + pc.V[2] + ", " + pc.V[3] + ")");
		System.out.println("electre cut threshold: " + pc.THRESHOLD + "\n");
		System.out.println("Cars ranking calculated using Electre III method:");
		for (Element e : elements) {
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
