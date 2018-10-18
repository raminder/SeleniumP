package com.guru.banking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class ReadJson {
   
public TestData getJsonData() throws FileNotFoundException{
    Gson json=new Gson();
    FileReader file=new FileReader("src/com/guru/banking/testjson1.json");
    BufferedReader bs=new BufferedReader(file);
    TestData tdObj=json.fromJson(bs, TestData.class);
    tdObj.getUsername();
    tdObj.getPassword();
    tdObj.getAddress();
    return tdObj;
    }

}