package java.qa.guru.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void someTest1(){
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
}
