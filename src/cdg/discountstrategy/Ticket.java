
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Ticket extends Tax {
    
    private LineItem[] lineItems;
    private Customer customer;
    private double subtotal = 0;
    private double salesTax;
    private double totalSale;
    
    public Ticket(Customer c) {
        customer = c;
    }
    
    public void addItemToTicket(String itemId, int qty) {
        FindProductStrategy fps = new FakeDatabase();
        Product product = fps.findProduct(itemId);
        if (product != null) {
            addToArray(new LineItem(itemId, qty));
        }
    }
    
    public void addToArray(LineItem lI) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = lI;
        lineItems = temp;
        
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void findSubtotal() {
        subtotal = 0;
        for (int i= 0; i <lineItems.length; i++) {
            subtotal += lineItems[i].getExtendedPrice();
        }
    }
    public void closeTicket() {
        findSubtotal();
        findSalesTax(subtotal);
        setTotalSale();
    }
    
    public double getSalesTax() {
        return salesTax;
    }

    public void findSalesTax(double subtotal) {
        calculateSalesTax(subtotal);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale() {
        this.totalSale = subtotal + salesTax;
    }
    
    
}
