
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Ticket extends Tax {
    
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private double subtotal = 0;
    private double salesTax;
    private double totalSale;
    
    public Ticket(Customer c) {
        customer = c;
    }
    
//    public void addItemToTicket(String itemId, int qty) {
//        FindProductStrategy fps = new FakeDatabase();
//        Product product = fps.findProduct(itemId);
//        if (product != null) {
//            addToArray(new LineItem(itemId, qty));
//        }
//    }
    public void addLineItem(LineItem li) {
        addToArray(li);
    }
    
    private void addToArray(LineItem lI) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = lI;
        lineItems = temp;
        
    }
    
    public void closeTicket() {
        findSubtotal();
        findSalesTax(subtotal);
        findTotalSale();
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
    
    public double getSalesTax() {
        return salesTax;
    }

    public void findSalesTax(double subtotal) {
        calculateSalesTax(subtotal);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void findTotalSale() {
        this.totalSale = subtotal + salesTax;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public LineItem[] getLineItems() {
        return lineItems;
    }
    
    
    
}
