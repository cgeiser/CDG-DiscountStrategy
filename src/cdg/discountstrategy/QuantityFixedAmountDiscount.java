
package cdg.discountstrategy;

/**
 *
 * @author cgeiser
 */
public class QuantityFixedAmountDiscount implements DiscountStrategy {
    
    private double fixedAmount = 10.00;
    private int quantity = 2;
    private String discountDesc = "Up to $" + fixedAmount + " off " + 
            quantity + " or more";
    
    // Constructors
    public QuantityFixedAmountDiscount() {
    }
    
    public QuantityFixedAmountDiscount(int qty, double amt)  {
        quantity = qty;
        setFixedAmount(amt);
    }
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
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
        this.fixedAmount = fixedAmount;
        discountDesc = "Up to $" + fixedAmount + " off " + 
            quantity + " or more";
    }

    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }

    
    
    
    
    // test method
    public static void main(String[] args) {
        QuantityFixedAmountDiscount fad = new QuantityFixedAmountDiscount(3, 10.00);
        System.out.println(fad.getDiscount(4.50, 2));
        System.out.println(fad.getDiscountDesc());
        System.out.println(fad.getDiscount(4.50, 3));
        System.out.println(fad.getDiscountDesc());
        fad.setFixedAmount(20.00);
        System.out.println(fad.getDiscount(4.50, 5));
        System.out.println(fad.getDiscountDesc());
    }
}
