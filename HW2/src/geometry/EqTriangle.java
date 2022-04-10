package geometry;

import java.util.List;

/**
 * The class implementing equilateral triangles, i.e., triangles in which all three sides have the same length.
 * Note: you can add more methods if you want, but additional methods must be <code>private</code> or <code>protected</code>.
 *
 * @author {add your full name here}
 */
public class EqTriangle implements Shape {
    
    /**
     * The constructor accepts an array of <code>Point</code>s to form the vertices of the equilateral triangle. If more
     * than three points are provided, only the first three are considered by this constructor. If less than three
     * points are provided, or if the points do not form a valid equilateral triangle, the constructor throws
     * <code>java.lang.IllegalArgumentException</code>.
     *
     * @param vertices the array of vertices (i.e., <code>Point</code> instances) provided to the constructor.
     */
    public EqTriangle(Point... vertices) {
        // TODO
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
        return false; // TODO
    }
    
    @Override
    public int numberOfSides() {
        return 3;
    }
    
    @Override
    public List<Point> vertices() {
        return null; // TODO
    }
    
    @Override
    public EqTriangle rotateBy(int degrees) {
        return null; // TODO
    }
}
