package geometry;

import java.util.Comparator;

public class Counterclockwise implements Comparator<Point>{

	// implement serializable for tree structures and stuff
	
	
	@Override
	public int compare(Point o1, Point o2) {
		
		if(o1.getX()>o2.getX()) {
			return 1;
		}
		
		else if(o1.getX()== o2.getX()) {
			
			if(o1.getY()>o2.getY()) {
				return 1;
			}
			
			else if(o1.getY()== o2.getY()) {
				return 0;
				
			}
			
			else if(o1.getY() < o2.getY()) {
				return -1;
			}
	
		}
		
		else if(o1.getX() < o2.getX()) {
			return -1;
		}
		
		return -1;
		
	}

}
