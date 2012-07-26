package ow;

public class ProblemConstrains {
	
	public final static boolean PRICE_ORDER = true;
	public final static boolean MAINTAIN_ORDER = true;
	public final static boolean DOORS_ORDER = true;
	public final static boolean PERSONS_ORDER = true;
	public final static boolean LUGGAGE_ORDER = true;
	public final static boolean SAFETY_ORDER = true;
	
	public final static int[] SETS_SIZE = {10, 20, 40, 15};
	
	//bounds for sets, first index tells which set {A0, A1, A2, A3}
	//price from i*(10 to 1000) where i = 100
	public final static double[][] PRICE_BOUNDS = {{10, 250}, {250, 500}, {500, 750}, {750, 1000}};
	//maintain from 1 to 10
	public final static double[][] MAINTAIN_BOUNDS = {{1, 2}, {2, 4}, {4, 6}, {6, 10}};
	//doors from 2 to 6
	public final static double[][] DOORS_BOUNDS = {{2, 3}, {3, 4},{4, 5}, {5, 6}};
	//persons from 2 to 7
	public final static double[][] PERSONS_BOUNDS = {{2, 4}, {4, 5}, {5, 6}, {6, 7}};
	//luggage in l. from 100 to 1000
	public final static double[][] LUGGAGE_BOUNDS = {{100, 200}, {200, 400}, {400, 600}, {600, 1000}};
	//safety from 1 to 10
	public final static double[][] SAFETY_BOUNDS = {{1, 2}, {2, 4}, {4, 6}, {6,  10}};
	
	public final static double[] WEIGHTS = {0.4, 0.1, 0.1, 0.4};
	public final static double[] P = {1, 2, 3, 4};
	public final static double[] Q = {1, 2, 3, 4};
	public final static double[] V = {1, 2, 3, 4};
	
	public ProblemConstrains(){
		
	}
	
}
