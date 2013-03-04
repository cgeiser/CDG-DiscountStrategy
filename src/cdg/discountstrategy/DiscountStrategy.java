
package cdg.discountstrategy;

/**
 * Allows for interchangeable Discounts for Products.
 * Each must have a getDiscount and a getDiscountDesc (description) method.
 * @author cgeiser
 */
public interface DiscountStrategy {

    public abstract double getDiscount(double price, int qty);
    
    public abstract String getDiscountDesc();

}
