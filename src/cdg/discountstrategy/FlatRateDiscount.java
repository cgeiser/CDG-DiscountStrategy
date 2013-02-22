
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class FlatRateDiscount implements DiscountStrategy {
    private double discountRate = 0.10;
    private String discountDesc = Round.roundToInteger(discountRate * 100)
            + "% off";
    
        
    // Constructors
    public FlatRateDiscount() {
        
    }
    
    public FlatRateDiscount(double rate) {
        setDiscountRate(rate);
    }
    
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
        return Round.roundToTwoDecimals(price * discountRate * qty);
    }

    
    // Getters & Setters
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double rate) {
        discountRate = rate;
        discountDesc = Round.roundToInteger(discountRate * 100)
                + "% off";
    }

    @Override
    public String getDiscountDesc() {
//        setDiscountDesc();
        return discountDesc;
    }

    
    
    
    // test method
    public static void main(String[] args) {
        FlatRateDiscount frd = new FlatRateDiscount();
        
        System.out.println(frd.getDiscount(100.00, 3));
        System.out.println(frd.getDiscountDesc());
        
        frd.setDiscountRate(0.25);
        System.out.println(frd.getDiscountRate());
        System.out.println(frd.getDiscount(100.00, 3));
        System.out.println(frd.getDiscountDesc());
    }
}
