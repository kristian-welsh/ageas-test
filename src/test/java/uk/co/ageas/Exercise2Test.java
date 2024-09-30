package uk.co.ageas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise2Test {
    private static final String TEST_INPUT_1 = "1111";
    private static final String TEST_INPUT_2 = "0101";
    private static final String TEST_INPUT_3 = "1101";
    private static final String TEST_INPUT_4 = "0001";
    private static final String TEST_INPUT_5 = "00-10";

    @Test
    public void testCase1() {
        Exercise2 ex = new Exercise2();

        assertEquals("I am 15", ex.check(TEST_INPUT_1));
    }

    @Test
    public void testCase2() {
        Exercise2 ex = new Exercise2();

        assertEquals("I am 10", ex.check(TEST_INPUT_2));
    }

    @Test
    public void testCase3() {
        Exercise2 ex = new Exercise2();

        assertEquals("I am 11", ex.check(TEST_INPUT_3));
    }

    @Test
    public void testCase4() {
        Exercise2 ex = new Exercise2();

        assertEquals("I am default", ex.check(TEST_INPUT_4));
    }

    @Test
    public void testCase5() {
        Exercise2 ex = new Exercise2();

        assertEquals("Invalid input", ex.check(TEST_INPUT_5));
    }

}