
package cdg.discountstrategy;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;


/**
 * One of the Receipt Output Strategies.
 * Outputs Receipt to GUI.
 * 
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class GuiReceipt extends JFrame implements ReceiptOutputStrategy {
    
    public GuiReceipt() {
        
    }

    public GuiReceipt(Ticket ticket) {
        // needs validation
        super("Receipt");
        setSize(300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));
        JPanel panelHeader = new HeaderPanel1();
        JPanel panelCustomer = new CustomerPanel(ticket.getCustomer());
        JPanel panelLineItems = new LineItemPanel(ticket);
        JPanel panelTotals = new TotalsPanel(ticket);
        
        add(panelHeader);
        panelHeader.setBackground(Color.ORANGE);
        add(panelCustomer);
        add(panelLineItems);
        add(panelTotals);
        pack();
        setVisible(true);
    }
    
    
    @Override
    public void displayReceipt (Ticket ticket) {
        new GuiReceipt(ticket);
    }

}
