
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class LineItem {

    private Product item;
    private int quantity;
    
    
    private FindProductStrategy findProduct = new FakeDatabase();
    
    public LineItem(String prodId, int qty) {
            // validate prodId and qty
            if (prodId == null || prodId.length() == 0 || qty <=0) {
                System.out.println("Invalid Entry - Unable to create Line Item");
                System.exit(0);
            }
        quantity = qty;
        item = findProduct.findProduct(prodId);
    }

    
    // Getters
    public double getDiscountAmt() {
        return Round.roundToTwoDecimals(item.getProductDiscStrategy().getDiscount(
                    item.getProductPrice(), quantity));
    }

    public double getExtendedOriginalPrice() {
        return Round.roundToTwoDecimals(item.getProductPrice() * quantity);
    }
    
    
    public Product getItem() {
        return item;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
