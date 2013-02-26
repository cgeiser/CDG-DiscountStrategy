package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * @author cgeiser
 */
public class QuantityDiscount implements DiscountStrategy {

    private NumberFormat percent = NumberFormat.getPercentInstance();
    private double discountRate = 0.10;
    private int minQty = 5;
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

    
    // returns Discount
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

    // Getters & Setters
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double rate) {
            // validate rate
            if (rate <= 0 || rate > 1) {
                System.out.println("Invalid Discount Rate");
                System.exit(0);
            }
        this.discountRate = rate;
        setDiscountDesc();
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
            // validate minQty
            if (minQty < 1) {
                System.out.println("Invalid Minimum Quantity");
                System.exit(0);
            }
        this.minQty = minQty;
        setDiscountDesc();
    }

    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }

    private void setDiscountDesc() {
        discountDesc = percent.format(discountRate) + " off "
            + minQty + " or more";
    }
    
    
    
    // test method
//    public static void main(String[] args) {
//        QuantityDiscount qd1 = new QuantityDiscount();
//        System.out.println(qd1.getDiscount(100.00, 2));
//        
//        QuantityDiscount qd2 = new QuantityDiscount(10);
//        System.out.println(qd2.getDiscount(20, 6));
//        System.out.println(qd2.getDiscount(20, 10));
//        
//        QuantityDiscount qd3 = new QuantityDiscount(8, 0.30);
//        System.out.println(qd3.getDiscount(20, 6));
//        System.out.println(qd3.getDiscount(20, 10));
//    }
}