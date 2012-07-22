package test;

import ow.Element;
import ow.Refset;
import ow.Set;
import ow.exceptions.NoConsistency;
import ow.exceptions.NoInnerConsistency;

public class RefsetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Element e1 = new Element(10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
		Element e2 = new Element(15.0, 15.0, 15.0, 15.0, 15.0, 15.0);
		Element e3 = new Element(25.0, 25.0, 25.0, 25.0, 25.0, 25.0);

		Refset rs = new Refset();

		try {
			rs.addElementToA1(e3);
			rs.addElementToA0(e1);
			rs.addElementToA0(e2);
		} catch (NoConsistency e) {
			e.printStackTrace();
		}

//		System.out.println(rs.getA0().getCenter().getDoors());
//		System.out.println(rs.getA0().getDistance(e3));
		
//		Set set = new Set();
//		try{
//			set.addElement(e1);
//			set.addElement(e2);
//			set.addElement(e3);
//		}catch(NoInnerConsistency e){
//			e.printStackTrace();
//		}
		
		
	}

}
