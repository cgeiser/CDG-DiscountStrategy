
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class NoDiscount implements DiscountStrategy {
    
    // Constructor
    public NoDiscount() {
        
    }
        
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
        return 0;
    }

        
    // test method
    public static void main(String[] args) {
        NoDiscount nd = new NoDiscount();
        
        System.out.println(nd.getDiscount(100.00, 3));
    }
}
