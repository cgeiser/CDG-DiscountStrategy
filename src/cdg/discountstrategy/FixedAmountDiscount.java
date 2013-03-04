
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * One of the DiscountStrategy options.
 * Item has a fixed amount discount.
 * @author cgeiser
 * @version 1.0
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
    
    /**
     * Method required by DiscountStrategy.
     * Returns the discount amount for the item price & qty.
     * @return fixedAmount or (price * qty), whichever is less
     */
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
     * Returns the fixed amount of the discount.
     * @return double fixedAmount
     */
    public double getFixedAmount() {
        return fixedAmount;
    }

    /**
     * Sets the fixedAmount of the discount.
     * And changes the Discount Description to have the new fixedAmount.
     * @param fixedAmount 
     */
    public void setFixedAmount(double fixedAmount) {
        // validate fixedAmount
        if (fixedAmount <= 0) {
            System.out.println("Invalid Fixed Amount");
            System.exit(0);
        }
        this.fixedAmount = fixedAmount;
        setDiscountDesc();
    }

    /**
     * Used to change the Discount Description.
     */
    private void setDiscountDesc() {
        discountDesc = "Up to " + money.format(fixedAmount) + " off coupon";
    }
    
}
