/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.*;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
/**
 *
 * @author a2vimala
 */

public class Customer {
    private String username;
    private String password;
    private String role;
    private Level level;
    private double balance = 100.00;
    
public Customer(){
    this.role = "Customer";
    setLevel(new SilverLevel());
}
public Customer(String username){
    this.username = username;
    this.role = "Customer";
    setLevel(new SilverLevel());
    }
public Customer(String username, String password){// username could be anything inputted by client but its usually their name
    
    this.username = username;
    this.password = password;
    this.role = "Customer";
    setLevel(new SilverLevel());
    setBalance(username, password, balance);
} 
public Customer(String username, String password, double value){
    this.username = username;
    this.password = password;
    balance = value;
    int temp = verifyLevel(value);
    if(temp==0){
        setLevel(new SilverLevel());
    }
    if(temp==1){
        setLevel(new GoldLevel());
    }
    if(temp==2){
        setLevel(new PlatinumLevel());
    }
}

//assuming there can never be negative balances
public boolean depositMoney(String username, String password, double value){
    
    if(value>0){
        this.balance = balance + value;
        level.updateLevel(this);
        setBalance(username, password, balance);
        return true;
    }else{
       //throw new IllegalArgumentException("Action: Unable to withdraw amount requested.")
       return false; 
    } 
}
//asuming there can never be negative balances
public boolean withdrawMoney(String username, String password, double value){
     if((value>0) && (balance>=value)){
        this.balance = balance - value;
        level.updateLevel(this);
        setBalance(username, password, balance);
        return true;
    }else{
       //throw new IllegalArgumentException("Action: Unable to withdraw amount requested."); 
       return false;
     }
}

public boolean login(String name,String pass){
    if (username.equals(name) && password.equals(pass)){
        return true;
    }
    else{
        return false;
    }   
}


public void setLevel(Level level){
    this.level = level;
}

public Level getLevel(){
    return level;
}

public void updateLevel(){
    level.updateLevel(this);
}

public String getUsername(){
    return this.username;
}

public String getPassword(){
    return this.password;
}

public String getRole(){
    return this.role;
}

public double getBalance(){
    return balance;
}

public double getBalance(String username, String password){ // can also do with just one parameter as username bc no other account can be made. but for more security using password as well.
    try{
        File file = new File( username + ".txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for(int i=0;i<2;i++){
            bufferedReader.readLine();
        }
        String store = bufferedReader.readLine();
        this.balance = Double.parseDouble(store);
    }
    catch(IOException exception){
        
    }
    
    return balance;
}
public void setBalance(String username, String password, double balance){
    try{
        File file = new File(username + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(username);
        bufferedWriter.newLine();
        bufferedWriter.write(password);
        bufferedWriter.newLine();
        bufferedWriter.write(Double.toString(balance));
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileWriter.close();
    }
    catch(IOException exception){
    
}
}

public boolean onlinePurchase(String username, String password, double amount){
    if(amount>=50.00){
        this.withdrawMoney(username, password, (amount + level.getOnlinePurchaseFee()));
        return true;        
    }else{
        return false;
    }
}

public int verifyLevel(double balance){
    if(balance<10000){
        return 0;
    }
    else if(balance>=10000 && balance<20000){
        return 1;
}else{
        return 2;
        }
    
}

}
