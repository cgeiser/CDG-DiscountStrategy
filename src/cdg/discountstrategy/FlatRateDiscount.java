
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * One of the DiscountStrategy options.
 * Item has flat percentage discount.
 * @author cgeiser
 * @version 1.0
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
            // validate rate
            if (rate <= 0 || rate > 1) {
                System.out.println("Invalid Discount Rate");
            }
        setDiscountRate(rate);
        setDiscountDesc();
    }
    
    
    /**
     * Method required by DiscountStrategy.
     * Returns the discount amount for the item price & qty at the discountRate.
     * @param price
     * @param qty
     * @return double Discount Amount
     */
    @Override
    public double getDiscount(double price, int qty) {
            // validate price and qty
            if (price <=0 || qty <= 0) {
                    System.out.println("Invalid Price or Quantity");
                }
        return Round.roundToTwoDecimals(price * discountRate * qty);
    }

    /**
     * Method required by DiscountStrategy.
     * Returns the Discount Description.
     * @return String discountDesc
     */
    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }
    
    // Getters & Setters
    /**
     * Returns the Discount Rate
     * @return double discountRate
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     * Sets the Discount Rate.
     * And changes the Discount Description to reflect the new rate.
     * @param rate 
     */
    public void setDiscountRate(double rate) {
            // validate rate
            if (rate <=0 || rate >1) {
                System.out.println("Invalid Discount Rate");
                System.exit(0);
            }
        discountRate = rate;
        setDiscountDesc();
    }

    /**
     * Used to change the Discount Description.
     */
    private void setDiscountDesc() {
         discountDesc = percent.format(discountRate) + " off";
    }
    
}
