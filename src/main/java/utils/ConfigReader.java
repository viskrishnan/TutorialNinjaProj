package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties initializeConfigProperties()  {
        Properties properties = new Properties();
        File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\features\\config\\config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        }
        catch (Throwable throwable){
            throwable.printStackTrace();
        }

        return properties;
    }
}
