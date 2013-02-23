
package cdg.discountstrategy;

import java.text.NumberFormat;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class ConsoleReceipt implements ReceiptStrategy {

    NumberFormat money = NumberFormat.getCurrencyInstance();
    
    private CharSequence spaces = "                                 ";
    private StringBuilder headerSection = new StringBuilder();
    private StringBuilder customerSection = new StringBuilder();
    private StringBuilder lineItemSection = new StringBuilder();
    private StringBuilder totalsSection = new StringBuilder();
    private Ticket ticket;
    
    
    
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
        customerSection.append(spaces, 0, 40 - id.length() - name.length());
        customerSection.append(name);
        customerSection.append("\n----------------------------------------");
    }
    
    private void formatLineItemSection() {
        
        LineItem[] items = ticket.getLineItems();
            for (int x=0; x<items.length; x++) {
                int spCount = 0;
                lineItemSection.append("\n");
                // Item Line 1
                lineItemSection.append(items[x].getItem().getProductId());
                spCount += items[x].getItem().getProductId().length();
                lineItemSection.append(spaces, 0, 3);
                spCount += 3;
                lineItemSection.append(items[x].getItem().getProductDesc());
                spCount += items[x].getItem().getProductDesc().length();
                String pr = money.format(items[x].getExtendedPrice());
                spCount += pr.length();
//                Chris =  fgvftcygtf uyk6rfv ut==
                lineItemSection.append(spaces, 0, 40-spCount);
                lineItemSection.append(pr);
                lineItemSection.append("\n");
                // Item Line 2
                lineItemSection.append(items[x].getQuantity());
                lineItemSection.append(" @ ");
                lineItemSection.append(money.format(items[x].getItem().getProductPrice()));
                lineItemSection.append("\n");
                // Discount Desc Line
                DiscountStrategy ds = items[x].getItem()
                        .getProductDiscStrategy();
                if (items[x].getDiscountAmt() > 0) {
                    lineItemSection.append(items[x].getItem()
                        .getProductDiscStrategy().getDiscountDesc());
                }
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
    }
    
}
