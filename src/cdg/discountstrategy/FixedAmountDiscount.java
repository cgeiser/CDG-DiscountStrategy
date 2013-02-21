/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cdg.discountstrategy;

/**
 *
 * @author cgeiser
 */
public class FixedAmountDiscount implements DiscountStrategy {

    private double fixedAmount = 10.00;
    
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
    public double getFixedAmountDiscount() {
        return fixedAmount;
    }

    public void setFixedAmountDiscount(double amt) {
        fixedAmount = amt;
    }
    
    
    
    // test method
    public static void main(String[] args) {
        FixedAmountDiscount fad = new FixedAmountDiscount(10.00);
        System.out.println(fad.getDiscount(4.50, 2));
        System.out.println(fad.getDiscount(4.50, 3));
    }
}
