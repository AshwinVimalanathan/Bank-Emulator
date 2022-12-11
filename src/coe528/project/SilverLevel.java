/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author a2vimala
 */
/*
OVERVIEW: The SilverLevel class which extends an Abstract Level class is used to provide parameters
for customers' membership level. The class is responsible for changing between membership levels,
include online purchase fee based on current level and state the current level of the customer.
The silverLevel class is immutable.

ABSTRACTION FUNCTION: AF(c) = state A, for instance, represents the customer's membership level as
getState(). There is also update the customer's membership status, updateLevel() and also a method for 
the bank fee to conduct online transactions, getOnlinePurchaseFee(). I had a instance variable A.state
but I removed it as I just returned string "Silver"
A.OnlinePurchaseFee = c.fee;
A.state = c.state;

REP INVARIANT: level cannot equal null (level != null), in this case state is equal to "Silver", and online purchase fee must be 20 dollars (fee == 20)
c.state == Silver
c.fee == 20
*/
public class SilverLevel extends Level{
    
    private String state;
    private double fee;
    /**
     *Effects:  the customer's membership level/status gets updated/changed in this method
     *Requires: object Customer customer and a current initial level 
     *Modifies: the customer's current level
     *
     */
    @Override
    public void updateLevel(Customer customer){
        if(customer.getBalance()>=20000){
            customer.setLevel(new PlatinumLevel());
        }
        if(customer.getBalance() >= 10000 && customer.getBalance()<20000){
            customer.setLevel(new GoldLevel());
        }
    }
    /**
     *Effects: returns level "Silver"
     *Requires: none
     *Modifies: none
     * 
     */
    public String getState(){
        state = "Silver";
        return state;

    }
     /**
     *Effects: returns OnlinePurchaseFee "20"
     *Requires: none
     *Modifies: none
     * 
     */
    public double getOnlinePurchaseFee(){
        fee = 20;
        return fee;
    }
    
     /**
     *Effects: returns a string representation of the customer's level and online purchase fee dependent on the level
     *Requires: none
     *Modifies: none
     * 
     */
    @Override
    public String toString(){
        return ("State: " + state + ", Online Purchase Fee: " + fee);
    }
    
     /**
     *Effects: returns true if the customers representation is correct for SilverLevel() else it will return false
     *Requires: none
     *Modifies: none
     * 
     */
    public boolean repOk(){
        if(state.equals("Silver") && fee==0){
            return true;
    }else{
        return false;
        }
    }    
}

