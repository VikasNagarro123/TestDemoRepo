package in.redbus.utilities;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;


public class Utility {

    static Workbook book;
    static Sheet sheet;


    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            String path=System.getProperty("user.dir");
            file = new FileInputStream(path+getProperties("testDataFilePath"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//                 System.out.println(data[i][k]);
            }
        }
        return data;
    }


    public static String getProperties(String key) {
        Properties prop = null;
        try {
            prop = new Properties();
//			String propFilePath="./src/main/resources/config.properties";
            String propFilePath=System.getProperty("user.dir")+"/src/main/resources/config.properties";
            FileInputStream fis = new FileInputStream(propFilePath);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
