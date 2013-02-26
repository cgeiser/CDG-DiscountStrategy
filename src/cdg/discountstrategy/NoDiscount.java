
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class NoDiscount implements DiscountStrategy {
    private String discountDesc = "No Discount";
    
    // Constructor
    public NoDiscount() {
        
    }
        
    
    // get Discount
    @Override
    public double getDiscount(double price, int qty) {
        return 0;
    }

    @Override
    public String getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(String discountDesc) {
        // validate discountDesc
        if (discountDesc != null && discountDesc.length() > 0 ) {
        this.discountDesc = discountDesc;
        }
    }

    
        
    // test method
//    public static void main(String[] args) {
//        NoDiscount nd = new NoDiscount();
//        
//        System.out.println(nd.getDiscount(100.00, 3));
//    }
}
