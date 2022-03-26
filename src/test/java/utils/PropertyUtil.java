package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtil {

    private static Properties prop;

    private PropertyUtil(){
    }

    static {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("./src/test/resources/framework.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static String getProperty(String key){
        String value = prop.getProperty(key.toLowerCase());
        if(value==null){
            throw new IllegalArgumentException("Key is not present in properties file! Invalid Key!!");
        }else{
            return value;
        }
    }
}