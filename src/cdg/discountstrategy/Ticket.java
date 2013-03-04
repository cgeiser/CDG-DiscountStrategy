
package cdg.discountstrategy;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Ticket {
    
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private double subtotal = 0;
    private double amountSaved = 0;
    private double salesTax;
    private double totalSale;
    private Date saleDate;
    
    public Ticket(Customer c) {
        customer = c;
    }
    
    public void addLineItem(String id, int qty) {
        LineItem item = new LineItem(id, qty);
        addToArray(item);
        subtotal += item.getExtendedOriginalPrice() - item.getDiscountAmt();
        amountSaved += item.getDiscountAmt();
    }
    
    public void addToArray(LineItem li) {
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = li;
        lineItems = temp;
        
    }
    
    public void closeTicket(TaxStrategy ts) {
        saleDate = (Calendar.getInstance()).getTime();
        salesTax = ts.calculateTaxAmount(subtotal);
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

    private void findTotalSale() {
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
    
    public double getAmountSaved() {
        return amountSaved;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    
    
}
