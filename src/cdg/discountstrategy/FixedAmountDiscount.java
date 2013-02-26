
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * @author cgeiser
 */
public class FixedAmountDiscount implements DiscountStrategy {
    
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private double fixedAmount = 10.00;
    private String discountDesc;
    
    // Constructors
    public FixedAmountDiscount() {
        setDiscountDesc();
    }
    
    public FixedAmountDiscount(double amt)  {
            // validate amt
            if (amt <= 0) {
                System.out.println("Invalid Discount Amount");
                System.exit(0);
            }
        setFixedAmount(amt);
        setDiscountDesc();
    }
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
            // validate price and qty
            if (price <=0 || qty <= 0) {
                System.out.println("Invalid Price or Quantity");
            }
        if (price * qty >= fixedAmount) {
            return Round.roundToTwoDecimals(fixedAmount);
        }
        else {
            return Round.roundToTwoDecimals(price * qty);
    }
    }

    // Getters & Setters
    public double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        // validate fixedAmount
        if (fixedAmount <= 0) {
            System.out.println("Invalid Fixed Amount");
            System.exit(0);
        }
        this.fixedAmount = fixedAmount;
        setDiscountDesc();
        
    }

    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }

    private void setDiscountDesc() {
        discountDesc = "Up to " + money.format(fixedAmount) + " off coupon";
    }
    
    
    
    // test method
//    public static void main(String[] args) {
//        FixedAmountDiscount fad = new FixedAmountDiscount(10.00);
//        System.out.println(fad.getDiscount(4.50, 2));
//        System.out.println(fad.getDiscountDesc());
//        System.out.println(fad.getDiscount(4.50, 3));
//        System.out.println(fad.getDiscountDesc());
//        fad.setFixedAmount(20.00);
//        System.out.println(fad.getDiscount(4.50, 5));
//        System.out.println(fad.getDiscountDesc());
//    }
}
