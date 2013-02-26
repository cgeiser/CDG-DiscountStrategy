
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
            // validate prodId
            if (prodId == null || prodId.length() <= 0) {
                System.out.println("Invalid Product ID");
                System.exit(0);
            }
            // validate prodDesc
            if (prodDesc == null || prodDesc.length() <= 0) {
                System.out.println("Invalid Product Description");
                System.exit(0);
            }
            // validate prodPrice
            if (prodPrice <= 0) {
                System.out.println("Invalid Product Price");
                System.exit(0);
            }
        this.prodId = prodId;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodDiscStrategy = discStrat;
    }

    

    public String getProductId() {
        return prodId;
    }

    public void setProductId(String prodId) {
        // validate prodId
            if (prodId == null || prodId.length() <= 0) {
                System.out.println("Invalid Product ID");
                System.exit(0);
            }
        this.prodId = prodId;
    }

    public String getProductDesc() {
        return prodDesc;
    }

    public void setProductDesc(String prodDesc) {
        // validate prodDesc
            if (prodDesc == null || prodDesc.length() <= 0) {
                System.out.println("Invalid Product Description");
                System.exit(0);
            }
        this.prodDesc = prodDesc;
    }

    public double getProductPrice() {
        return prodPrice;
    }

    public void setProductPrice(double prodPrice) {
        // validate prodPrice
            if (prodPrice <= 0) {
                System.out.println("Invalid Product Price");
                System.exit(0);
            }
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
