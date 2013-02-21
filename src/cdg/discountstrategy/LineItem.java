
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class LineItem {

    private Product item;
    private int quantity;
    
    
    private FindProductStrategy findProduct = new FakeDatabase();
    
    public LineItem(String prodId, int qty) {
        quantity = qty;
        item = findProduct.findProduct(prodId);
    }

    
    // Getters
    public double getDiscountAmt() {
        return item.getProductDiscStrategy().getDiscount(
                    item.getProductPrice(), quantity);
    }

    public double getExtendedPrice() {
        return (item.getProductPrice() * quantity) - getDiscountAmt();
    }
   
    public Product getItem() {
        return item;
    }
}
