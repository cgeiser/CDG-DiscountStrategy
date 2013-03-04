
package cdg.discountstrategy;

import java.util.Calendar;
import java.util.Date;

/**
 * Ticket item holds the details of the sale...
 * Customer, an array of LineItems, subtotal, tax, total, amount saved, date.
 * 
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 * @version 1.0
 */
public class Ticket {
    
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private double subtotal = 0;
    private double amountSaved = 0;
    private double salesTax;
    private double totalSale;
    private Date saleDate;
    
    /**
     * Constructor - a Ticket is created by passing a customer in.
     * @param c 
     */
    public Ticket(Customer c) {
        // needs validation
        customer = c;
    }
    
    /**
     * Creates a LineItem for product with the Id = id and Quantity = qty.
     * Adds it to the LineItem array, updates subtotal & amountSaved.
     * @param id
     * @param qty 
     */
    public void addLineItem(String id, int qty) {
        // needs validation
        LineItem item = new LineItem(id, qty);
        addToArray(item);
        subtotal += item.getExtendedOriginalPrice() - item.getDiscountAmt();
        amountSaved += item.getDiscountAmt();
    }
    
    /**
     * Adds LineItem li to the LineItem array.
     * @param li 
     */
    private void addToArray(LineItem li) {
        // needs validation
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = li;
        lineItems = temp;
        
    }
    
    /**
     * Closes the Ticket by getting the date, getting the tax using the
     * tax strategy passed in, finding the total.
     * @param ts 
     */
    public void closeTicket(TaxStrategy ts) {
        // needs validation
        saleDate = (Calendar.getInstance()).getTime();
        salesTax = ts.calculateTaxAmount(subtotal);
        findTotalSale();
    }
    
    
    /**
     * Getters and Setters
     */
    
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
        // needs validation
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
        // needs validation
        this.saleDate = saleDate;
    }
    
    
}
