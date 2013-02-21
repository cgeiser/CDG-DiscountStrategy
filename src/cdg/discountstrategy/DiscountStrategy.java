
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public interface DiscountStrategy {

    public abstract double getDiscount(double price, int qty);
    
    public abstract String getDiscountDesc();

}
