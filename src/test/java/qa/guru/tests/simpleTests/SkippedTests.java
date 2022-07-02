package qa.guru.tests.simpleTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
@Tag("simple")
public class SkippedTests {

    @Disabled("причина")
    @Test
    void test1(){
        assertFalse(true);
    }

    @Disabled
    @Test
    void test2(){
        assertFalse(true);
    }

}
