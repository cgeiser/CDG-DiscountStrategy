
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
    
    public void addLineItem(String id, int qty) {
        LineItem item = new LineItem(id, qty);
        addToArray(item);
        subtotal += item.getExtendedPrice();
    }
    
    public void addToArray(LineItem li) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = li;
        lineItems = temp;
        
    }
    
    public void closeTicket() {
        salesTax = calculateSalesTax(subtotal);
        findTotalSale();
    }
    
    

    public double getSubtotal() {
        return Round.roundToTwoDecimals(subtotal);
    }

        
    public double getSalesTax() {
        return Round.roundToTwoDecimals(salesTax);
    }

    
    public double getTotalSale() {
        return Round.roundToTwoDecimals(totalSale);
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
