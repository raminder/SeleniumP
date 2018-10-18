package selenium_Basics;
import java.io.IOException;
import java.util.ArrayList;

import selenium_Basics.dataDriven;
public class testExcel {

    public static void main(
            String[] args) throws IOException {
        dataDriven d=new dataDriven();
        ArrayList<String> data=d.getData("Pwd");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        
        
         }

}
