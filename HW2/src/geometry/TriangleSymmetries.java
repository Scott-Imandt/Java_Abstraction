package geometry;

import java.util.ArrayList;
import java.util.Collection;

public class TriangleSymmetries implements Symmetries<EqTriangle>{

	
	@Override
	public boolean areSymmetric(EqTriangle s1, EqTriangle s2) {
		
		// check equals here instead;		
		if(identityCheck(s1).equals(s2)) return true;
		if(r1(s1).equals(s2)) return true;
		if(r2(s1).equals(s2)) return true;
		if(reflectTop(s1).equals(s2)) return true;
		if(reflectLeft(s1).equals(s2)) return true;
		if(reflectRight(s1).equals(s2)) return true;
		
		return false;
	}

	@Override
	public Collection<EqTriangle> symmetriesOf(EqTriangle s) {

		Collection<EqTriangle> temp = new ArrayList<EqTriangle>();
		temp.add(identityCheck(s));
		temp.add(r1(s));
		temp.add(r2(s));
		temp.add(reflectTop(s));
		temp.add(reflectLeft(s));
		temp.add(reflectRight(s));
		
		return temp;
	}
	
	//-------------- Custom Code -----------------------------
	
	//identity check
	private EqTriangle identityCheck(EqTriangle s1c) {
		

		EqTriangle temp2 = s1c.rotateBy(0);
		
		return temp2;
		
	}
	
	// 120 rotation
	private EqTriangle r1(EqTriangle s1c) {
		

		EqTriangle temp2 = s1c.rotateBy(120);
		
		return temp2;
		
	}
	
	// 240 rotaion
	private EqTriangle r2(EqTriangle s1c) {		
		
		EqTriangle temp2 = s1c.rotateBy(240);
		
		return temp2;
	}
	
	// top down reflection  A/0 = left corner B/1 = right corner c/2 = top FIX top point
	private EqTriangle reflectTop(EqTriangle s1c) {
		
		EqTriangle temp1 = new EqTriangle(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2));
		
		Point temp = temp1.vertices().get(0);
		
		temp1.vertices().set(0, s1c.vertices().get(1));
		temp1.vertices().set(1, temp);
		
//		EqTriangle temp2 = new EqTriangle(temp1.vertices().get(0),temp1.vertices().get(1),temp1.vertices().get(2));
		
		return temp1;
		
	}
	
	// left reflection  A/0 = left corner B/1 = right corner c/2 = top FIX left point
	private EqTriangle reflectLeft(EqTriangle s1c) {
		
		EqTriangle temp1 = new EqTriangle(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2));
		
		Point temp = s1c.vertices().get(1);
		
		temp1.vertices().set(1, s1c.vertices().get(2));
		temp1.vertices().set(2, temp);
		
//		EqTriangle temp2 = new EqTriangle(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2));
		
		return temp1;
	}
	
	// right  reflection A/0 = left corner B/1 = right corner c/2 = top FIX right point
	private EqTriangle reflectRight(EqTriangle s1c) {
		
		EqTriangle temp1 = new EqTriangle(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2));
		
		Point temp = s1c.vertices().get(2);
		
		temp1.vertices().set(2, s1c.vertices().get(0));
		temp1.vertices().set(0, temp);
		
		//EqTriangle temp2 = new EqTriangle(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2));
		
		return temp1;
	}
	
}
