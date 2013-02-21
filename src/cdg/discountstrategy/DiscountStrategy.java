
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public interface DiscountStrategy {

    double getDiscount(double price, int qty);

//    double getDiscountRate();
//
//    void setDiscountRate(double rate);
    
}
