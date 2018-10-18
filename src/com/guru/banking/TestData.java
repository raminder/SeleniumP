package com.guru.banking;

import java.util.List;

public class TestData {
    private String username;
    private String Password;
    private List<Address> address;
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String password){
        this.Password=password;
    }
    
    public List<Address> getAddress(){
    return address;
    }
    
    public void setAddress(List<Address> address){
    this.address=address;
    }
}