
package cdg.discountstrategy;

/**
 * One of the DiscountStrategy options.
 * Item has no discount: returns 0.
 * 
 * @author cgeiser
 * @version 1.0
 */
public class NoDiscount implements DiscountStrategy {
    private String discountDesc = "No Discount";
    
    // Constructor
    public NoDiscount() {
        
    }
        
    
    /**
     * Method required by DiscountStrategy.
     * Returns the Discount amount for the item Price & Qty.
     * @return 0
     */
    @Override
    public double getDiscount(double price, int qty) {
        // does not require validation -- price & qty are unused
        return 0;
    }

    /**
     * Method required by DiscountStrategy.
     * Returns the Discount Description.
     * @return String
     */
    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }

    /**
     * Sets the Discount Description.
     * @param discountDesc 
     */
    public void setDiscountDesc(String discountDesc) {
        // validate discountDesc
        if (discountDesc != null && discountDesc.length() > 0 ) {
        this.discountDesc = discountDesc;
        }
    }
}
