
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author cgeiser
 */
public class QuantityFixedAmountDiscount implements DiscountStrategy {
    
    NumberFormat money = NumberFormat.getCurrencyInstance();
    
    private double fixedAmount = 10.00;
    private int quantity = 2;
    private String discountDesc;
    
    
    // Constructors
    public QuantityFixedAmountDiscount() {
        setDiscountDesc();
    }
    
    public QuantityFixedAmountDiscount(int qty, double amt)  {
        quantity = qty;
        setFixedAmount(amt);
        setDiscountDesc();
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
        setDiscountDesc();
    }

    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }

    private void setDiscountDesc() {
        discountDesc = money.format(fixedAmount) + " off " + 
            quantity + " or more";
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setDiscountDesc();
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
