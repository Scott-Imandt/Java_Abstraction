package geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class implementing squares.
 * Note: you can add more methods if you want, but additional methods must be <code>private</code> or <code>protected</code>.
 *
 * @author Scott Imandt
 */
public class Square implements Shape {
	
	// added code
	private List<Point> vertices = new ArrayList<Point>();
    
    /**
     * The constructor accepts an array of <code>Point</code>s to form the vertices of the square. If more than four
     * points are provided, only the first four are considered by this constructor. If less than four points are
     * provided, or if the points do not form a valid square, the constructor throws <code>java.lang.IllegalArgumentException</code>.
     *
     * @param vertices the array of vertices (i.e., <code>Point</code> instances) provided to the constructor.
     */
    public Square(Point... vertices) {
    	
    	//more then four only accepts first four or not valid throw exception
    	
    	if(vertices.length >= 4) {
    		this.vertices.add(0, vertices[0]);
    		this.vertices.add(1, vertices[1]);
    		this.vertices.add(2, vertices[2]);
    		this.vertices.add(3, vertices[3]);
    		
    		//Professor stated that this is ok due to code in Geometry test error
    		Collections.sort(this.vertices, new Counterclockwise());
    		
    	
    		try {
    			isMember(this.vertices); // return exception if false 
    		}catch(IllegalArgumentException e) {
    			System.out.println(e);
    		}	
    	}
    	
    	//less then four are provided 
 
		else {
			throw new IllegalArgumentException(); // if not 4 or more
		} 	
    	
    }
    
    /**
     * Checks if the series of <code>Point</code> instances form a valid square if the first four form the vertices of
     * the square. This method considers the points in a counterclockwise manner starting with the vertex with the least
     * x-value. If multiple vertices have the same x-value, the counterclockwise ordering starts at the vertex with the
     * least y-value amongst them.
     *
     * @param vertices the list of specified vertices.
     * @return <code>true</code> if the first four vertices in the argument form a valid square, and <code>false</code>
     * otherwise.
     */
    @Override
    public boolean isMember(List<Point> vertices) {
    	
    	//Do distance formula on diagonals
    	
    	//diagonal 1 & 4
    	double D1 = threeDecimal(Math.sqrt((Math.pow(vertices.get(3).getX() - vertices.get(0).getX(), 2)) + (Math.pow(vertices.get(3).getY() - vertices.get(0).getY(), 2))));
    	
    	double D2 = threeDecimal(Math.sqrt((Math.pow(vertices.get(2).getX() - vertices.get(1).getX(), 2)) + (Math.pow(vertices.get(2).getY() - vertices.get(1).getY(), 2))));
    
    	if(D1 != D2) return false;
    	
    	
    	// do slope formula and determine opposite reciprocal
        
    	double S1 = threeDecimal((vertices.get(3).getY() - vertices.get(0).getY())/(vertices.get(3).getX() - vertices.get(0).getX()));
    	
    	double S2 = threeDecimal((vertices.get(2).getY() - vertices.get(1).getY())/(vertices.get(2).getX() - vertices.get(1).getX()));
    	
 	
    	if(S1 !=  -(1/S2)) return false;
    	
    	return true; // TODO
    }
    
    @Override
    public int numberOfSides() {
        return 4;
    }
    
    @Override
    public List<Point> vertices() {
        return this.vertices; // TODO
    }
    
    @Override
    public Square rotateBy(int degrees) {
       
    	Square temp = new Square(vertices.get(0),vertices.get(1),vertices.get(2), vertices.get(3));
    	
    	double radians = Math.toRadians(degrees);  // check that this is what I want?
    
    	Point center;
        
    	//-------------------get Center of shape-----------

    	double xc = (vertices.get(0).getX() + vertices.get(3).getX())/2;
    	
    	double yc = (vertices.get(1).getY() + vertices.get(2).getY())/2;
        
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
    
    @Override
    public String toString() {   // need to fix format of to String
    	String points = "";
    	
    	for(int i = 0; i<vertices.size(); i++) {
    		points += "( " + threeDecimal(vertices.get(i).getX()) + " , " + threeDecimal(vertices.get(i).getY())+ ")";
    	}
		
    	return this.getClass().getName() + "\t" + points;
    	
    	
		/*	
    	return this.getClass().getName() + "\t" +"[ "+
    	"("+ threeDecimal(this.vertices().get(0).getX()) +" , "+ threeDecimal(this.vertices().get(0).getY()) +")"+
    	"("+ threeDecimal(this.vertices().get(2).getX()) +" , "+ threeDecimal(this.vertices().get(2).getY()) +")"+
    	"("+ threeDecimal(this.vertices().get(3).getX()) +" , "+ threeDecimal(this.vertices().get(3).getY()) +")"+
    	"("+ threeDecimal(this.vertices().get(1).getX()) +" , "+ threeDecimal(this.vertices().get(1).getY())+ ") ]";
    	*/
    }
    
// --------------- Custom Methods added ------------------------
    
    private double threeDecimal(double x) {
    	
    	return (double)Math.round(x *1000d) / 1000d;
    }
    
    private Point translate(Point p , double x,double y) {
    	Point temp = new Point(p.getX() + x, p.getY() + y);
    	return temp;
    }
}
