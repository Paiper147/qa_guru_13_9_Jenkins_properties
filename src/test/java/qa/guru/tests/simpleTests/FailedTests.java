package qa.guru.tests.simpleTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FailedTests {

    @Test
    void test1(){
        assertFalse(true);
    }

    @Test
    void test2(){
        assertFalse(true);
    }

    @Test
    void test3(){
        assertFalse(true);
    }
}
