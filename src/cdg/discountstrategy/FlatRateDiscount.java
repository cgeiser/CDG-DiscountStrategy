
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class FlatRateDiscount implements DiscountStrategy {
    private double discountRate = 0.10;
        
    // Constructors
    public FlatRateDiscount() {
        
    }
    
    public FlatRateDiscount(double rate) {
        discountRate = rate;
    }
    
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
        return price * discountRate * qty;
    }

    
    // Getters & Setters
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double rate) {
        this.discountRate = rate;
    }
    
    
    // test method
    public static void main(String[] args) {
        FlatRateDiscount frd = new FlatRateDiscount();
        
        System.out.println(frd.getDiscount(100.00, 3));
        
        frd.setDiscountRate(0.25);
        System.out.println(frd.getDiscount(100.00, 3));
    }
}
