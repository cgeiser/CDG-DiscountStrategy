
package cdg.discountstrategy;

/**
 * Allows for finding Products in different ways.
 * Each must have a findProduct method.
 * @author cgeiser
 */
public interface FindProductStrategy  {
    
    public abstract Product findProduct(String productId);


    
}