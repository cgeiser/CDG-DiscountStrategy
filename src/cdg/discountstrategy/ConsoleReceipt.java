
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
        System.out.print(headerSection);
        System.out.print(customerSection);
    }

    
    
    
    private void formatHeaderSection() {
        headerSection.append("****************************************");
        headerSection.append("\n*                                      *");
        headerSection.append("\n*           MOM & POP STORE            *");
        headerSection.append("\n*        Sandy Falls, Wisconsin        *");
        headerSection.append("\n*                                      *");
        headerSection.append("\n****************************************");
        headerSection.append("\n\n              Receipt for");
        
    }
    
    private void formatCustomerSection() {
        String id = ticket.getCustomer().getCustId();
        String name = ticket.getCustomer().getCustName();
        customerSection.append("\nCustomer ID:\n");
        customerSection.append(id);
        customerSection.append(spaces, 0, 40 - id.length() - name.length());
        customerSection.append(name);
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
//                spCount += (items[x].getExtendedPrice());
//                Chris =  fgvftcygtf uyk6rfv ut==
                lineItemSection.append(spaces, 0, 40-spCount);
        }
        
    }
    
    private void formatTotalsSection() {
        
    }
    
    
}
