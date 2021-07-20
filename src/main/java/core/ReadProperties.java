package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties(){
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getURL(){return properties.getProperty("url");}
    public String getBrowser(){return properties.getProperty("browser");}
    public String getUsername(){return properties.getProperty("username");}
    public String getPassword(){return properties.getProperty("password");}
    public int getTimeout(){return Integer.parseInt(properties.getProperty("timeout"));}
    public boolean getHeadless() {return Boolean.parseBoolean(properties.getProperty("headless"));}

    // 2 пользователь
    public String getUsername1(){return properties.getProperty("username1");}
    // 3 пользователь
    public String getUsername2(){return properties.getProperty("username2");}

    //заказ товара
    public String getFirstname(){return properties.getProperty("firstname");}
    public String getLastname(){return properties.getProperty("lastname");}
    public String getZip(){return properties.getProperty("zip");}



}
