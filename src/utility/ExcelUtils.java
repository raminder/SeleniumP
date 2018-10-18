package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
        
        public ArrayList<String> getLoginData(String Testcasename) throws IOException{
            DataFormatter df=new DataFormatter();
        ArrayList<String> userdata=new ArrayList<String>();
        FileInputStream file=new FileInputStream("D://DATA//gurubankLogin.xlsx");
        
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        int sheets=workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++){
           if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
            XSSFSheet sheet=workbook.getSheetAt(i);
            Iterator<Row> row=sheet.iterator();
            Row firstRow=row.next();
            Iterator<Cell> col=firstRow.cellIterator();
            int k=0;
            int column=0;
            while(col.hasNext()){
                Cell value =col.next();
                if(value.getStringCellValue().equalsIgnoreCase("Test Cases")){
                    column=k;
                    }
                k++;
                }
            while(row.hasNext()){
                Row r=row.next();
                if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Testcasename)){
                    Iterator<Cell> cv=r.iterator();
                    while(cv.hasNext()){
                        Cell data=cv.next();
                        String formattedvalue=df.formatCellValue(data);
                        userdata.add(formattedvalue);
                         }
                }
                
            }
           }
        }
        
        return userdata; 
        
            
        }

    

public static void main(
        String[] args) throws Exception {
}
}
