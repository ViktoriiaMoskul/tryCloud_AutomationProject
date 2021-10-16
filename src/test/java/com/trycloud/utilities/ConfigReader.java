package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A Utility class that load the keyvalue pair inside config.properties file
 * into Properties object and provide single method called
 * read to get the value out of the properties file we created.
 */
public class ConfigReader {

    // declare Properties object at class level so it can be accessible in static method
    private  static  Properties properties = new Properties();

    // we want to only load the file once , so we can use static block
    static {
        try {
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the value of key according to the key provided
     * @param key the key you want to get the value from
     * @return the value of the key
     */
    public static String read(String key){
        return properties.getProperty(key) ;
    }

}
