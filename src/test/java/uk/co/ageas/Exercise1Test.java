package uk.co.ageas;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise1Test {
    private static final String TEST_INPUT_1 = "6521714069616518831033";
    private static final String TEST_INPUT_2 = "6121114-06961651-983103";
    private static final String TEST_INPUT_3 = "ABCDEFGHijklMN";


    @Test
    public void testCase1() {
        Exercise1 ex = new Exercise1();

        assertEquals("AGEAS!", ex.input(TEST_INPUT_1));
    }


    @Test
    public void testCase2() {
        Exercise1 ex = new Exercise1();
        InvalidParameterException thrown = assertThrows(InvalidParameterException.class,
                () -> ex.input(TEST_INPUT_2));

        assertEquals("Only digits are allowed", thrown.getMessage());
    }


    @Test
    public void testCase3() {
        Exercise1 ex = new Exercise1();
        InvalidParameterException thrown = assertThrows(InvalidParameterException.class,
                () -> ex.input(TEST_INPUT_3));

        assertEquals("Only digits are allowed", thrown.getMessage());
    }
}
