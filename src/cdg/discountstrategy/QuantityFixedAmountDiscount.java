
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * One of the DiscountStrategy options.
 * Item has a fixed amount discount for a minimum quantity purchased.
 * @author cgeiser
 */
public class QuantityFixedAmountDiscount implements DiscountStrategy {
    
    private NumberFormat money = NumberFormat.getCurrencyInstance();
    private double fixedAmount = 10.00; // default value
    private int minQty = 2;             // default value
    private String discountDesc;
    
    
    // Constructors
    public QuantityFixedAmountDiscount() {
        setDiscountDesc();
    }
    public QuantityFixedAmountDiscount(int qty, double amt)  {
            // validate qty & amt
            if (qty < 1 || amt <= 0) {
                System.out.println("Invalid Quantity or Amount");
                System.exit(0);
            }
        minQty = qty;
        setFixedAmount(amt);
        setDiscountDesc();
    }
    
    /**
     * Method required by DiscountStrategy.
     * Returns the fixed amount of the discount if the minQty has been met.
     * @param price
     * @param qty
     * @return double fixedAmount, or 0 if minQty is not met
     */
    @Override
    public double getDiscount(double price, int qty) {
            // validate price and qty
            if (price <=0 || qty <= 0) {
                System.out.println("Invalid Price or Quantity");
            }
        if (qty >= minQty) {
            return Round.roundToTwoDecimals(fixedAmount);
        }
        else {
            return 0;
        }
    }

    /**
     * Method required by DiscountStrategy.
     * Returns the discount description.
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
     * Sets the fixed amount of the discount.
     * @param fixedAmount 
     */
    public void setFixedAmount(double fixedAmount) {
        // needs validation
        this.fixedAmount = fixedAmount;
        setDiscountDesc();
    }

    /**
     * Used by QuantityFixedAmountDiscount to change the discount description.
     */
    private void setDiscountDesc() {
        discountDesc = money.format(fixedAmount) + " off " + 
            minQty + " or more";
    }
    
    /**
     * Returns the minimum quantity needed for the discount.
     * @return int minQty
     */
    public int getQuantity() {
        return minQty;
    }

    /**
     * Sets the mimimum quantity needed for the discount.
     * And changes the discount description to reflect the change.
     * @param quantity 
     */
    public void setQuantity(int quantity) {
        // needs validation
        this.minQty = quantity;
        setDiscountDesc();
    }

}
