package geometry;

import java.util.Collection;

/**
 * @author Ritwik Banerjee
 * 
 * DO NOT CHANGE ANY CODE
 * 
 * @since Mar 2022
 */
public interface Symmetries<S extends Shape> {
    
    // compares two shapes and determine if the shapes are any of the symmetries
	boolean areSymmetric(S s1, S s2);
    
    // Returns a collection of all types of symmetries that this shape has.
    Collection<S> symmetriesOf(S s);
}
