package ow;

public class ProblemConstrains {
	
	public final static boolean PRICE_ORDER = false;
	public final static boolean MAINTAIN_ORDER = false;
	public final static boolean DOORS_ORDER = false;
	public final static boolean PERSONS_ORDER = false;
	public final static boolean LUGGAGE_ORDER = false;
	public final static boolean SAFETY_ORDER = false;
	
	public final static int[] SETS_SIZE = {3, 3, 3, 3};
	
	//bounds for sets, first index tells which set {A0, A1, A2, A3}
	//price from i*(10 to 1000) where i = 100
	public final static double[][] PRICE_BOUNDS = {{100, 70}, {70, 50}, {50, 30}, {30, 10}};
	//maintain from 1 to 10
	public final static double[][] MAINTAIN_BOUNDS = {{100, 70}, {70, 50}, {50, 30}, {30, 10}};
	//doors from 2 to 6
	public final static double[][] DOORS_BOUNDS = {{100, 70}, {70, 50}, {50, 30}, {30, 10}};
	//persons from 2 to 7
	public final static double[][] PERSONS_BOUNDS = {{100, 70}, {70, 50}, {50, 30}, {30, 10}};
	//luggage in l. from 100 to 1000
	public final static double[][] LUGGAGE_BOUNDS =  {{100, 70}, {70, 50}, {50, 30}, {30, 10}};
	//safety from 1 to 10
	public final static double[][] SAFETY_BOUNDS =  {{100, 70}, {70, 50}, {50, 30}, {30, 10}};
	
	public final static double[] WEIGHTS = {0.4, 0.1, 0.1, 0.4};
	public final static double[] Q = {3, 5, 5, 6};
	public final static double[] P = {5, 10, 10, 12};
	public final static double[] V = {10, 20, 20, 25};
	
	public final static double THRESHOLD = 0.15;
	
	public ProblemConstrains(){
		
	}
	
}
