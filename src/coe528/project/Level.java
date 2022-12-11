/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author a2vimala
 */
public abstract class Level{
    
    public abstract void updateLevel(Customer customer);
    public abstract String getState();
    public abstract double getOnlinePurchaseFee();

}
