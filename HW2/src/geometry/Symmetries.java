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
    
    boolean areSymmetric(S s1, S s2);
    
    //fix Collections from Collections<s> to Collections
    Collection symmetriesOf(S s);
}
