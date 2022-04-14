package geometry;

import java.util.ArrayList;
import java.util.Collection;

public class SquareSymmetries implements Symmetries<Square>{

	@Override
	public boolean areSymmetric(Square s1, Square s2) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Collection<Square> symmetriesOf(Square s) {
		
		Collection<Square> temp = new ArrayList<Square>();
		
		temp.add(identityCheck(s));
		temp.add(rc90(s));
		temp.add(rc180(s));
		temp.add(rc270(s));
		temp.add(vReflect(s));
		temp.add(hReflect(s));
		temp.add(dReflect(s));
		temp.add(cdReflect(s));
		
		return temp;
	}
	
	
	//-------------Custom Code---------------
	
	// rotate zero degrees
	private Square identityCheck(Square s1c) {
		
		Square temp = s1c.rotateBy(0);
		return temp;	
	}
	
	// 270 rotate cc == 90 rotate c
	private Square rc90(Square s1c) {
		Square temp = s1c.rotateBy(90);
		return temp;
	}
	
	private Square rc180(Square s1c) {
		Square temp = s1c.rotateBy(180);
		return temp;
	}
	
	private Square rc270(Square s1c) {
		Square temp = s1c.rotateBy(270);
		return temp;
	}
	
	// per document ilistration
	private Square vReflect(Square s1c) {
		
		Square temp = new Square(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2),s1c.vertices().get(3));
		
		Point t1 = s1c.vertices().get(0);
		temp.vertices().set(0, s1c.vertices().get(1));
		temp.vertices().set(1, t1);
		
		Point t2 = s1c.vertices().get(2);
		temp.vertices().set(2, s1c.vertices().get(3));
		temp.vertices().set(3, t2);
	
		return temp;
	}
	
	private Square hReflect(Square s1c) {
		
		Square temp = new Square(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2),s1c.vertices().get(3));
		
		Point t1 = s1c.vertices().get(0);
		temp.vertices().set(0, s1c.vertices().get(2));
		temp.vertices().set(2, t1);
		
		Point t2 = s1c.vertices().get(1);
		temp.vertices().set(1, s1c.vertices().get(3));
		temp.vertices().set(3, t2);
	
		return temp;
	}
	
	private Square dReflect(Square s1c) {
		
		Square temp = new Square(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2),s1c.vertices().get(3));
		
		Point t1 = s1c.vertices().get(1);
		temp.vertices().set(1, s1c.vertices().get(2));
		temp.vertices().set(2, t1);

	
		return temp;
		
	}
	
	private Square cdReflect(Square s1c) {
		
		Square temp = new Square(s1c.vertices().get(0),s1c.vertices().get(1),s1c.vertices().get(2),s1c.vertices().get(3));
		
		Point t1 = s1c.vertices().get(0);
		temp.vertices().set(0, s1c.vertices().get(3));
		temp.vertices().set(3, t1);

	
		return temp;
		
	}

}
