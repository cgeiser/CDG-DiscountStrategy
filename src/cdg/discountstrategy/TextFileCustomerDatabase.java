
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class TextFileCustomerDatabase implements FindProductStrategy {
    
    
    
    
    @Override
    public  Product findProduct (final String prodId) {
	        // validation is needed
	        Product product = null;
//	        for(Product p : products) {
//	            if(prodId.equals(p.getProductId())) {
//	                product = p;
//	                break;
//	            }
//	        }
	        return product;
    }
	
    
    
    // test method
    public static void main(String[] args) {
        TextFileCustomerDatabase fd = new TextFileCustomerDatabase();
        Product p = fd.findProduct("2222");
        System.out.println(p.getProductId() + "  " + p.getProductDesc() + "  "
                + p.getProductPrice());
        
        Product f = fd.findProduct("6699");
        if (f == null) {
            System.out.println("No Match found");
        }
        else {
            System.out.println(f.getProductId() + "  " + f.getProductDesc() + "  "
                + f.getProductPrice());
        }
    }
}
