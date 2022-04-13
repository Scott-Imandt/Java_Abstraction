package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * The class implementing equilateral triangles, i.e., triangles in which all three sides have the same length.
 * Note: you can add more methods if you want, but additional methods must be <code>private</code> or <code>protected</code>.
 *
 * @author Scott Imandt
 */
public class EqTriangle implements Shape {
	
	// added code
	private List<Point> vertices = new ArrayList<Point>();
    
    /**
     * The constructor accepts an array of <code>Point</code>s to form the vertices of the equilateral triangle. If more
     * than three points are provided, only the first three are considered by this constructor. If less than three
     * points are provided, or if the points do not form a valid equilateral triangle, the constructor throws
     * <code>java.lang.IllegalArgumentException</code>.
     *
     * @param vertices the array of vertices (i.e., <code>Point</code> instances) provided to the constructor.
     */
    public EqTriangle(Point... vertices) {
        
    	if(vertices.length >= 3) {
    		
    		this.vertices.add(0, vertices[0]);
    		this.vertices.add(1, vertices[1]);
    		this.vertices.add(2, vertices[2]);
    		
    		try {
    			isMember(this.vertices); // return exception if false 
    		}catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}	
    	}
    	else {
    		throw new IllegalArgumentException(); // if not 3 or more
    	} 	
    }
    
    /**
     * Checks if the series of <code>Point</code> instances form a valid equilateral triangle if first three form the
     * vertices of the triangle.
     *
     * @param vertices the list of specified vertices.
     * @return <code>true</code> if the first three vertices in the argument form a valid equilateral triangle, and
     * <code>false</code> otherwise.
     */
    @Override
    public boolean isMember(List<Point> vertices) {
    	
    	//calculate three sides length of triangle
    	double SideAB;  // distance of A->B  0 -> 1
    	double SideBC;  // distance of B->C  1 -> 2
    	double SideCA;  // distance of A->C  2 -> 0
    	
    	// length formula
    	
    	SideAB = threeDecimal(Math.sqrt((Math.pow(vertices.get(1).getX() - vertices.get(0).getX(), 2)) + (Math.pow(vertices.get(1).getY() - vertices.get(0).getY(), 2))));
    		
    	SideBC = threeDecimal(Math.sqrt((Math.pow(vertices.get(2).getX() - vertices.get(1).getX(), 2)) + (Math.pow(vertices.get(2).getY() - vertices.get(1).getY(), 2))));
    	
    	SideCA = threeDecimal(Math.sqrt((Math.pow(vertices.get(2).getX() - vertices.get(0).getX(), 2)) + (Math.pow(vertices.get(2).getY() - vertices.get(0).getY(), 2))));
   	
    	// check if all sides are equal
    	
    	if(SideAB == SideBC && SideBC == SideCA) {    		
    		return true;
    	} else {
    		throw new IllegalArgumentException();
      		//return false;// Not valid triangle
    	}
     
    }
    
    @Override
    public int numberOfSides() {
        return 3;
    }
    
    @Override
    public List<Point> vertices() {
        return this.vertices; 
    }
    
    @Override
    public EqTriangle rotateBy(int degrees) {
    	
    	EqTriangle temp = new EqTriangle(vertices.get(0),vertices.get(1),vertices.get(2));
    	
    	double radians = degrees * (Math.PI/180);
        
    	Point center;
    	
    	//----------get Center of a shape---------
    	
    	double xc = (vertices.get(0).getX()+vertices.get(1).getX()+vertices.get(2).getX())/3.0;
    	
    	double yc = (vertices.get(0).getY()+vertices.get(1).getY()+vertices.get(2).getY())/3.0;
    		
    	center = new Point(xc, yc);
    	   	
  	
    	//----------translate that shape using center to origin------------
    		
    	temp.vertices.replaceAll(n -> translate(n, -(center.getX()), -(center.getY())));
    	
    	
    	//-----------apply rotation at origin using formal given------------
    	
    	temp.vertices.replaceAll(n -> n = new Point( ((n.getX() * Math.cos(radians)) - (n.getY() * Math.sin(radians))),  ((n.getX() * Math.sin(radians)) + (n.getY() * Math.cos(radians)))));
    
    	
    	//-------------- move back to original position.-----------------
 	
    	temp.vertices.replaceAll(n -> translate(n, (center.getX()), (center.getY())));
    	temp.vertices.replaceAll(n -> n = new Point((n.getX()), (n.getY())));
	
    	return temp; 
     
    }
    
    // --------------- Custom Methods added ------------------------
    
    private double threeDecimal(double x) {
    	
    	return (double)Math.round(x *1000d) / 1000d;
    }
    
    
    private Point translate(Point p , double x,double y) {
    	Point temp = new Point(p.getX() + x, p.getY() + y);
    	return temp;
    }
    
    
    @Override
    public String toString() {
    	String points = "";
    	
    	for(int i = 0; i<vertices.size(); i++) {
    		points += "( " + threeDecimal(vertices.get(i).getX()) + " , " + threeDecimal(vertices.get(i).getY())+ ")";
    	}
		
    	return this.getClass().getName() + "\t" + points;
    	
    }
    
}
