package com.guru.bankingutils;
import org.testng.annotations.DataProvider;

public class ReusableMethods {

        @DataProvider(name="getValidData")
         public static Object[][] getValidLoginData(){
            Object[][] data=new Object[1][2];
            data[0][0]="mngr143005";
            data[0][1]="azyjUnA";
            return data; 
}
        @DataProvider(name="getInvalidData")
        public static Object[][] getLoginData(){
            Object[][] data=new Object[3][2];
            data[0][0]="mngr143005";
            data[0][1]="azyjUnAAAAA";
            data[1][0]="mngr143";
            data[1][1]="azyjUnA";
            data[2][0]="mngr1";
            data[2][1]="azyjUnAAAAA";
            return data;
}
}
