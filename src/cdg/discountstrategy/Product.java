
package cdg.discountstrategy;

/**
 * Contains parameters for each Product...
 * ID, Description, Price, DiscountStrategy used.
 * @author cgeiser
 * @version 1.0
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

    // Getters and Setters

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
        
}
