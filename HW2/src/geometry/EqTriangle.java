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
    	
    	SideAB = Math.sqrt((Math.pow(vertices.get(1).getX() - vertices.get(0).getX(), 2)) + (Math.pow(vertices.get(1).getY() - vertices.get(0).getY(), 2)));
    	
    	SideAB = (double)Math.round(SideAB *1000d) / 1000d;
    	
    	
    	SideBC = Math.sqrt((Math.pow(vertices.get(2).getX() - vertices.get(1).getX(), 2)) + (Math.pow(vertices.get(2).getY() - vertices.get(1).getY(), 2)));
        
    	SideBC = (double)Math.round(SideBC *1000d) / 1000d;
    	
    	
    	SideCA = Math.sqrt((Math.pow(vertices.get(2).getX() - vertices.get(0).getX(), 2)) + (Math.pow(vertices.get(2).getY() - vertices.get(0).getY(), 2)));
        
    	SideCA = (double)Math.round(SideCA *1000d) / 1000d;
    	
    	
    	//System.out.println(SideAB + "\t" +SideBC + "\t" +SideCA);
    	
    	
    	// check if all sides are equal
    	
    	if(SideAB == SideBC && SideBC == SideCA) {
    		System.out.println("TRUE");
    		return true;
    	} else {
    		throw new IllegalArgumentException();
    		
    		//return false;// Not valid triagle
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
        
    	//get Center of a shape
    	
    	//translate that shape using center to origin
    	
    	//apply roatation at origin using formual given
    	
    	// move back to original position.

    	
    	return null; 
        
        
    }
}
