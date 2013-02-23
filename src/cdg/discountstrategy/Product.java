
package cdg.discountstrategy;

/**
 * @author cgeiser
 */
public class Product  {
            
    private String prodId;
    private String prodDesc;
    private double prodPrice;
    private DiscountStrategy prodDiscStrategy;
    
    public Product () {
    }
    
    public Product(String prodId, String prodDesc,
            double prodPrice, DiscountStrategy discStrat) {
        this.prodId = prodId;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodDiscStrategy = discStrat;
    }

    

    public String getProductId() {
        return prodId;
    }

    public void setProductId(String prodId) {
        this.prodId = prodId;
    }

    public String getProductDesc() {
        return prodDesc;
    }

    public void setProductDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public double getProductPrice() {
        return prodPrice;
    }

    public void setProductPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public DiscountStrategy getProductDiscStrategy() {
        return prodDiscStrategy;
    }

    public void setProductDiscStrategy(DiscountStrategy prodDisc) {
        this.prodDiscStrategy = prodDisc;
    }
    
    

    // test method
//    public static void main(String[] args) {
//        Product p1 = new Product("3344", "Men's Black Socks", 7.89, new FixedAmountDiscount(4));
//        System.out.println(p1.getProductId());
//        System.out.println(p1.getProductDesc());
//        System.out.println(p1.getProductPrice());
//        System.out.println(p1.getProductDiscStrategy().getDiscount(p1.getProductPrice(), 1));
//    }
    
}
