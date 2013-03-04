
package cdg.discountstrategy;

/**
 * Holds the Product and Quantity for a LineItem.
 * Uses a FindProductStrategy to tell it where to search for the product.
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

    
    /**
     * Gets the discount amount.
     * @return rounded discount amount
     */
    public double getDiscountAmt() {
        return Round.roundToTwoDecimals(item.getProductDiscStrategy().getDiscount(
                    item.getProductPrice(), quantity));
    }

    /**
     * Calculates and gets the Extended(total) original price.
     * @return rounded price * qty
     */
    public double getExtendedOriginalPrice() {
        return Round.roundToTwoDecimals(item.getProductPrice() * quantity);
    }
    
    /**
     * Gets the LineItem Product.
     * @return Product item
     */
    public Product getItem() {
        return item;
    }
    
    /**
     * Gets the LineItem's quantity
     * @return int quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
