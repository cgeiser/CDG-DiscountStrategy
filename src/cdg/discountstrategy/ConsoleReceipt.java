
package cdg.discountstrategy;

/**
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class ConsoleReceipt implements ReceiptStrategy {

    private CharSequence spaces = "                                       ";
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
        headerSection.append("****************************************");
        headerSection.append("\n*                                      *");
        headerSection.append("\n*           MOM & POP STORE            *");
        headerSection.append("\n*        Sandy Falls, Wisconsin        *");
        headerSection.append("\n*                                      *");
        headerSection.append("\n****************************************");
        headerSection.append("\n\n                Receipt");
        
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
        String sp3 = "   ";
        LineItem[] items = ticket.getLineItems();
            for (int x=0; x<items.length; x++) {
                int spCount = 0;
                lineItemSection.append("\n");
                lineItemSection.append(items[x].getItem().getProductId());
                spCount += items[x].getItem().getProductId().length();
                lineItemSection.append(sp3);
                spCount += 3;
                lineItemSection.append(items[x].getItem().getProductDesc());
                spCount += items[x].getItem().getProductDesc().length();
                double pr = items[x].getExtendedPrice();
                spCount += Double.toString(pr).length();
//                Chris =  fgvftcygtf uyk6rfv ut==
                lineItemSection.append(spaces, 0, 39-spCount);
                lineItemSection.append("$");
                lineItemSection.append(pr);
                lineItemSection.append("\n");
                DiscountStrategy ds = items[x].getItem()
                        .getProductDiscStrategy();
                if (!ds.getDiscountDesc().equals("No Discount") ) {
                    lineItemSection.append(items[x].getItem()
                        .getProductDiscStrategy().getDiscountDesc());
                }
        }
        
    }
    
    private void formatTotalsSection() {
        totalsSection.append("\n                              ----------");
        totalsSection.append("\n                      Subtotal $");
        double sub = ticket.getSubtotal();
        totalsSection.append(spaces, 0, 8 - Double.toString(sub).length());
        totalsSection.append(sub);
        totalsSection.append("\n                           Tax $");
        double tax = ticket.getSalesTax();
        totalsSection.append(spaces, 0, 8 - Double.toString(tax).length());
        totalsSection.append(tax);
        totalsSection.append("\n                     TOTAL DUE $");
        double tot = ticket.getTotalSale();
        totalsSection.append(spaces, 0, 8 - Double.toString(tot).length());
        totalsSection.append(tot);
    }
    
    
}
