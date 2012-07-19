package test;

import ow.Element;
import ow.Refset;
import ow.Set;

public class RefsetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Element e1 = new Element(10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
		Element e2 = new Element(15.0, 15.0, 15.0, 15.0, 15.0, 15.0);
		Element e3 = new Element(25.0, 25.0, 25.0, 25.0, 25.0, 25.0);

		Set a0 = new Set();
		a0.addElement(e1);
		a0.addElement(e2);
		System.out.println(a0.getDistance(e3));
		Refset rs = new Refset();
		rs.getA0().addElement(e1);
		System.out.println(rs.getA0().getCenter().getDoors());
	}

}
