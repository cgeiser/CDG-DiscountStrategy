
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class LineItem {

    private Product item;
    private String searchId;
    private String discountDesc;
    private double discountAmt;
    private int quantity;
    
    private FindProductStrategy findProduct = new FakeDatabase();
    
    public LineItem(String prodId, int qty) {
        searchId = prodId;
        quantity = qty;
        item = findProduct.getProductMatch(searchId);
        if (item != null) {
            discountDesc = item.getProductDiscStrategy().getDiscountDesc();
            discountAmt = item.getProductDiscStrategy().getDiscount(
                    item.getProductPrice(), qty);
        }
        
        
        
        
    }
    
    
// test method
        public static void main(String[] args) {
            LineItem li = new LineItem("1111", 2);
            System.out.println(li.discountAmt);
            System.out.println(li.discountDesc);
            System.out.println(li.quantity);
            System.out.println(li.item.getProductDesc());
            System.out.println(li.item.getProductPrice());
    }
    
    
    
}
