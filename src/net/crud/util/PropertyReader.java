package crud.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties p = new Properties();


    public static String getProperty(String prop) {

        String result = null;

        try {
            p.load(PropertyReader.class.getClassLoader()
                    .getResourceAsStream("my.properties"));

            result = p.getProperty(prop);


        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл my.p отсуствует!");
        }
        return result;
    }
}
