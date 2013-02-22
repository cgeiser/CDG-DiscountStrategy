package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class QuantityDiscount implements DiscountStrategy {

    private double discountRate = 0.10;
    private int minQty = 5;
    private String discountDesc = Round.roundToInteger(discountRate * 100)
            + "% off " + minQty + " or more";

    // Constructors
    public QuantityDiscount() {
    }

    public QuantityDiscount(int minQty) {
        this.minQty = minQty;
    }
    
    public QuantityDiscount(int minQty, double discRate) {
        this.minQty = minQty;
        setDiscountRate(discRate);
    }

    
    // returns Discount
    @Override
    public double getDiscount(double price, int qty) {
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
        this.discountRate = rate;
        discountDesc = Round.roundToInteger(discountRate * 100) + "% off "
            + minQty + " or more";
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }

    public String getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(String discountDesc) {
        this.discountDesc = discountDesc;
    }
    
    
    
    // test method
    public static void main(String[] args) {
        QuantityDiscount qd1 = new QuantityDiscount();
        System.out.println(qd1.getDiscount(100.00, 2));
        
        QuantityDiscount qd2 = new QuantityDiscount(10);
        System.out.println(qd2.getDiscount(20, 6));
        System.out.println(qd2.getDiscount(20, 10));
        
        QuantityDiscount qd3 = new QuantityDiscount(8, 0.30);
        System.out.println(qd3.getDiscount(20, 6));
        System.out.println(qd3.getDiscount(20, 10));
    }
}