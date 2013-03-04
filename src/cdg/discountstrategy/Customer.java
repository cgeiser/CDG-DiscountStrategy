
package cdg.discountstrategy;

/**
 * Holds a customer ID and Name for a Customer Class object.
 * @author Chris Geiser <cgeiser@my.wctc.edu>
 */
public class Customer {
    
    private String custId;
    private String custName;
    
    public Customer(String custId, String custName) {
        // validate custId
        if (custId == null || custId.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        // validate custName
        if (custName == null || custName.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        setCustId(custId);
        setCustName(custName);
    }

    /**
     * Gets the Customer ID.
     * @return String custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * Sets the Customer ID
     * @param custId 
     */
    public void setCustId(String custId) {
        // validate custId
        if (custId == null || custId.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        this.custId = custId;
    }

    /**
     * Gets the Customer Name
     * @return String custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * Sets the Customer Name
     * @param custName 
     */
    public void setCustName(String custName) {
        // validate custName
        if (custName == null || custName.length() == 0) {
            System.out.println("Invalid Customer ID");
            return;
        }
        this.custName = custName;
    }


}
