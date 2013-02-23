
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * @author cgeiser
 */
public class FlatRateDiscount implements DiscountStrategy {
    
    private NumberFormat percent = NumberFormat.getPercentInstance();
    private double discountRate = 0.10;
    private String discountDesc;
    
        
    // Constructors
    public FlatRateDiscount() {
        setDiscountDesc();
    }
    
    public FlatRateDiscount(double rate) {
        setDiscountRate(rate);
        setDiscountDesc();
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
        setDiscountDesc();
    }

    @Override
    public String getDiscountDesc() {
//        setDiscountDesc();
        return discountDesc;
    }

    private void setDiscountDesc() {
         discountDesc = percent.format(discountRate) + " off";
    }
    
    
    // test method
//    public static void main(String[] args) {
//        FlatRateDiscount frd = new FlatRateDiscount();
//        
//        System.out.println(frd.getDiscount(100.00, 3));
//        System.out.println(frd.getDiscountDesc());
//        
//        frd.setDiscountRate(0.25);
//        System.out.println(frd.getDiscountRate());
//        System.out.println(frd.getDiscount(100.00, 3));
//        System.out.println(frd.getDiscountDesc());
//    }
}
