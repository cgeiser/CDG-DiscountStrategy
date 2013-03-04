package cdg.discountstrategy;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * Outputs the receipt to the console.
 * formatLineItemSection uses a strategy to easily change the format, including
 * the width of the display.  The other sections do not have that flexibility
 * yet.
 * 
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class ConsoleReceipt implements ReceiptOutputStrategy {

    NumberFormat money = NumberFormat.getCurrencyInstance();
    
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");
    
    private CharSequence spaces = "                                           ";
    private StringBuilder headerSection = new StringBuilder();
    private StringBuilder customerSection = new StringBuilder();
    private StringBuilder lineItemSection = new StringBuilder();
    private StringBuilder totalsSection = new StringBuilder();
    private Ticket ticket;
    private int rowWidth = 40;
    
    
    
    /**
     * Required method from ReceiptOutputStrategy.
     * Uses private internal methods to construct each section using
     * a StringBuilder.
     * 
     * @param ticket 
     */
    @Override
    public void displayReceipt(Ticket ticket) {
        this.ticket = ticket;
        formatHeaderSection();
        formatCustomerSection();
        formatLineItemSection();
        formatTotalsSection();
        System.out.print(headerSection);
        System.out.print(customerSection);
        System.out.print(lineItemSection);
        System.out.print(totalsSection);
    }

    
    
    
    private void formatHeaderSection() {
        headerSection.append(  "****************************************");
        headerSection.append("\n*                                      *");
        headerSection.append("\n*           MOM & POP STORE            *");
        headerSection.append("\n*        Sandy Falls, Wisconsin        *");
        headerSection.append("\n*                                      *");
        headerSection.append("\n****************************************");
        headerSection.append("\n                Receipt");
        
    }
    
    private void formatCustomerSection() {
        String id = ticket.getCustomer().getCustId();
        String name = ticket.getCustomer().getCustName();
        customerSection.append("\nCustomer ID:\n");
        customerSection.append(id);
        customerSection.append(spaces, 0, rowWidth - id.length() - name.length());
        customerSection.append(name);
        customerSection.append("\n----------------------------------------");
    }
    
    private void formatLineItemSection() {
        ConsoleReceiptLineItemFormatStrategy lif = new LineItemFormat2();
        
        LineItem[] items = ticket.getLineItems();
            for (LineItem li : items) {
                lineItemSection.append(lif.formatLineItem(li, rowWidth));
        }
    }
    
    private void formatTotalsSection() {
        totalsSection.append("\n                              ----------");
        totalsSection.append("\n                      Subtotal");
        String sub = money.format(ticket.getSubtotal());
        totalsSection.append(spaces, 0, 10 - sub.length());
        totalsSection.append(sub);
        totalsSection.append("\n                           Tax");
        String tax = money.format(ticket.getSalesTax());
        totalsSection.append(spaces, 0, 10 - tax.length());
        totalsSection.append(tax);
        totalsSection.append("\n                     TOTAL DUE");
        String tot = money.format(ticket.getTotalSale());
        totalsSection.append(spaces, 0, 10 - tot.length());
        totalsSection.append(tot);
        // total saved
        totalsSection.append("\n\n    ---- Total Saved: ");
        totalsSection.append(money.format(ticket.getAmountSaved()));
        totalsSection.append(" ----");
        totalsSection.append("\n---- Thank You for shopping with us! ---");
        // date & time
        totalsSection.append("\n          ");
        totalsSection.append(sdf.format(ticket.getSaleDate()));
    }
    
}
