/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.*;
import java.nio.file.Files;
/**
 *
 * @author a2vimala
 */
public class Manager {
    private String username;
    private String password;
    private String role;
    private double balance;
    
public Manager(){
    this.username = "admin";
    this.password = "admin";
    this.role = "Manager";
}

public boolean login(String name,String pass){
    if (username.equals(name) && password.equals(pass)){
        return true;
    }
    else{
        return false;
    }
    
}

public Customer addCustomer(String username, String password){
    Customer customer = new Customer(username,password);
    try{
        File file = new File(username + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(username);
        bufferedWriter.newLine();
        bufferedWriter.write(password);
        bufferedWriter.newLine();
        bufferedWriter.write("100.00");
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileWriter.close();   
    }
    catch(IOException exception){
        return null;
    }
return customer;
}

public boolean deleteCustomer(String username){
    File file = new File(username + ".txt");
    if(file.exists()){
        file.delete();
        return true;
    }else{
        return false;    
    }       
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


public static boolean verifyCustomer(String username, String password){ 
        try{
            File file = new File(username + ".txt");
            FileReader fileReader= new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String temp1 = bufferedReader.readLine();
            String temp2 = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
            
            return ((file.isFile()) && (file!=null) && (temp1.equals(username)) && (temp2.equals(password)));
        }
        catch (IOException exception){  
           return false;  
        }

}

public Customer createTempCustomer(String username, String password){
    Customer customer = new Customer(username, password, customerBalance(username,password));
    return customer;
}

public boolean customerExists(String username){
    try{
        File file = new File(username + ".txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String temp = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        
        return ((file.isFile()) && (file!=null) && (temp.equals(username)));
    }
    catch(IOException exception){
        return false;
    }
}
public double customerBalance(String username, String password){
    try{
        File file = new File(username + ".txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for(int i=0;i<2;i++){
            bufferedReader.readLine();
        }
        String temp = bufferedReader.readLine();
        balance = Double.parseDouble(temp);
        bufferedReader.close();
        fileReader.close();
    }catch(IOException exception){
        
    }
    return balance;
}

}