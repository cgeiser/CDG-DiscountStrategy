
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public interface TaxStrategy {
    
    public abstract double calculateTaxAmount(double subtotal);
    
}
