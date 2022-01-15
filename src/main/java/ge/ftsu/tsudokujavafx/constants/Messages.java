package ge.ftsu.tsudokujavafx.constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Messages {
    public static String getProperties(String key){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    //your full path here
                    ".../resources/messages.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.getProperty("key");
        return String.valueOf(properties);
    }


}