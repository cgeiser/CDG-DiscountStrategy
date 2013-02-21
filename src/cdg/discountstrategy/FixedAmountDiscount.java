
package cdg.discountstrategy;

/**
 *
 * @author cgeiser
 */
public class FixedAmountDiscount implements DiscountStrategy {
    
    private double fixedAmount = 10.00;
    private String discountDesc = "Up to $" + fixedAmount + " off coupon";
    
    // Constructors
    public FixedAmountDiscount() {
    }
    
    public FixedAmountDiscount(double amt)  {
        fixedAmount = amt;
    }
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
        if (price * qty >= fixedAmount) {
            return fixedAmount;
        }
        else {
            return (price * qty);
    }
    }

    // Getters & Setters
    public double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
        discountDesc = "Up to $" + fixedAmount + " off coupon";
    }

    @Override
    public String getDiscountDesc() {
//        setDiscountDesc();
        return discountDesc;
    }

    
    
    
    
    // test method
    public static void main(String[] args) {
        FixedAmountDiscount fad = new FixedAmountDiscount(10.00);
        System.out.println(fad.getDiscount(4.50, 2));
        System.out.println(fad.getDiscountDesc());
        System.out.println(fad.getDiscount(4.50, 3));
        System.out.println(fad.getDiscountDesc());
        fad.setFixedAmount(20.00);
        System.out.println(fad.getDiscount(4.50, 5));
        System.out.println(fad.getDiscountDesc());
    }
}
