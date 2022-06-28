package qa.guru.properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemProperties {

    @Test
    @Tag("test1")
    void someTest1(){
        String browser = System.getProperty("browser");
        System.out.println(browser);//null
    }

    @Test
    void someTest2(){
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser");
        System.out.println(browser);//safari
    }

    @Test
    void someTest3(){
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);//opera
    }

    @Test
    void someTest4(){
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);//safari
    }

    @Test
    void someTest5(){
        System.setProperty("anyValue", "anyText");
        String text = System.getProperty("anyValue", "someText");
        System.out.println(text);//anyText
    }

    @Test
    @Tag("test6")
    void someTest6(){
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "101");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

        /*
        From IDEA
            chrome
            101
            1920x1080

        gradle clean properties_test6
            chrome
            101
            1920x1080

        gradle clean properties_test6 -Dbrowser=opera
            opera
            101
            1920x1080

        gradle clean properties_test6 -Dbrowser=opera -Dversion=102
            opera
            102
            1920x1080
         */
    }

    @Test
    @Tag("hello")
    void someTest7(){
        String text = System.getProperty("anyValue");
        System.out.println("Hello " + text);

        /*
        gradle clean hello_test -DanyValue=world!

        Hello world!
         */
    }
}
