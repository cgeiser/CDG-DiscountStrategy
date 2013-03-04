
package cdg.discountstrategy;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * Creates a Customer JPanel for receipt output to GUI.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class CustomerPanel extends JPanel {

    public CustomerPanel(Customer customer) {
        // need validation
        setLayout(new BorderLayout());
                
        JLabel receipt = new JLabel("RECEIPT");
        add(receipt, BorderLayout.NORTH);
        JLabel id = new JLabel("Cust ID:");
        add(id, BorderLayout.WEST);
        JLabel custId = new JLabel(customer.getCustId());
        add(custId, BorderLayout.CENTER);
        JLabel custName = new JLabel(customer.getCustName());
        add(custName, BorderLayout.EAST);
    }
}
