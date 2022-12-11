/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author a2vimala
 */
public class GoldLevel extends Level{
    @Override
    public void updateLevel(Customer customer){
        if(customer.getBalance()>=20000){
            customer.setLevel(new PlatinumLevel());
        }
        if(customer.getBalance()>=0 && customer.getBalance()<10000){
            customer.setLevel(new SilverLevel());
        }
    }
    public String getState(){
        return "Gold";
    }
    public double getOnlinePurchaseFee(){
        return 10;
    }
}
