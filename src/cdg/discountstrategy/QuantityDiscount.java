package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * One of the DiscountStrategy options.
 * Item has a percentage discount for a minimum quantity purchased.
 * @author cgeiser
 * @version 1.0
 */
public class QuantityDiscount implements DiscountStrategy {

    private NumberFormat percent = NumberFormat.getPercentInstance();
    private double discountRate = 0.10; // default value
    private int minQty = 5;             // default value
    private String discountDesc;

    // Constructors
    public QuantityDiscount() {
        setDiscountDesc();
    }
    public QuantityDiscount(int minQty) {
            // validate minQty
            if (minQty < 1) {
                System.out.println("Invalid Minimum Quantity");
                System.exit(0);
            }
        this.minQty = minQty;
        setDiscountDesc();
    }
    public QuantityDiscount(int minQty, double discRate) {
            // validate minQty
            if (minQty < 1) {
                System.out.println("Invalid Minimum Quantity");
                System.exit(0);
            }
            // validate discRate
            if (discRate <= 0 || discRate > 1) {
                System.out.println("Invalid Discount Rate");
                System.exit(0);
            }
        this.minQty = minQty;
        setDiscountRate(discRate);
        setDiscountDesc();
    }

    
    /**
     * Method required by DiscountStrategy.
     * Returns the discount amount for the item price & qty.
     * @param price
     * @param qty
     * @return double Discount, 0 if minQty is not met
     */
    @Override
    public double getDiscount(double price, int qty) {
            // validate price and qty
            if (price <=0 || qty <= 0) {
                System.out.println("Invalid Price or Quantity");
            }
        if (qty >= minQty) {
            return Round.roundToTwoDecimals(price * discountRate * qty);
        }
        else {return 0;}
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
     * Returns the percentage rate of the discount.
     * @return double discountRate
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     * Sets the discount percentage rate.
     * And changes the discount description to reflect the change.
     * @param rate 
     */
    public void setDiscountRate(double rate) {
            // validate rate
            if (rate <= 0 || rate > 1) {
                System.out.println("Invalid Discount Rate");
                System.exit(0);
            }
        this.discountRate = rate;
        setDiscountDesc();
    }

    /**
     * Returns the Minimum Quantity needed to get the discount.
     * @return int minQty
     */
    public int getMinQty() {
        return minQty;
    }

    /**
     * Sets the Minimum Quantity needed to get the discount.
     * And changes the discount description to reflect the change.
     * @param minQty 
     */
    public void setMinQty(int minQty) {
            // validate minQty
            if (minQty < 1) {
                System.out.println("Invalid Minimum Quantity");
                System.exit(0);
            }
        this.minQty = minQty;
        setDiscountDesc();
    }

    /**
     * Used by QuantityDiscount to change the Discount Description.
     */
    private void setDiscountDesc() {
        discountDesc = percent.format(discountRate) + " off "
            + minQty + " or more";
    }
    
}