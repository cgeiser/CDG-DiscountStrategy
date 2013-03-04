
package cdg.discountstrategy;

/**
 * Allows for various tax strategy classes to be used.
 * Each one needs a calculateTaxAmount method.
 * @author cgeiser
 * @version 1.0
 */
public interface TaxStrategy {
    
    public abstract double calculateTaxAmount(double subtotal);
    
}
