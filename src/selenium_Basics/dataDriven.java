package selenium_Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

    public ArrayList<String> getData(String TestcaseName) throws IOException {
        
        ArrayList<String> a=new ArrayList<String>();
        FileInputStream file=new FileInputStream("D://DATA//sampled.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        
        int sheets=workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Testdata")){
               XSSFSheet sheet= workbook.getSheetAt(i);
               Iterator<Row> row=sheet.iterator();
               Row firstrow=row.next();
                   Iterator<Cell> col=firstrow.cellIterator();
                   int k=0;
                   int column=0;
                   while(col.hasNext()){
                 Cell value=col.next();
                if(value.getStringCellValue().equalsIgnoreCase("Testcase")){
                    column=k;
                }
                k++;        
             }
                   System.out.println(column);
                   while(row.hasNext()){
                      Row r= row.next();
                      if(r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)){
                          Iterator<Cell> cv=r.cellIterator();
                          while(cv.hasNext()){
                             Cell c=cv.next();
                             if(c.getCellTypeEnum()==CellType.STRING){
                                 a.add(c.getStringCellValue());
                             }
                             else
                                 a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                             System.out.println(a);
                          }
                      }
                   }
            }
            }
        return a;
        
    }
    
public static void main(String[] args) throws IOException {
 // TODO Auto-generated method stub

 }

 }
