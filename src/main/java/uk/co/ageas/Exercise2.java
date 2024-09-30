package uk.co.ageas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Requirement
 * -----------
 * The input is a "string" containing 4 digits 0 and 1 only ex: "1101" etc.
 * Using the below formula convert the input string into a number.
 * <p>
 * Formula:
 * "1101" = 11
 * 1*2(0) + 1*2(1) + 0*2(2) + 1*2(3) = 11
 * <p>
 * 2(0) - 2 to the power of 0
 * 2(1) - 2 to the power of 1 ... etc
 * <p>
 * Ensure that input string only contains 0 and 1, return 0 if this is not the case
 * <p>
 * ====================================================
 * Please use Java 8 functional style where applicable.
 * Run the test cases to check whether all the conditions have passed.
 */


public class Exercise2 {
    private static String calculate(String input) {

        System.out.println("Input-->" + input);

        String result = "";

        Optional<String> errorMessage = validate(input);
        if(errorMessage.isPresent()) {
            return errorMessage.get();
        }

        List<String> inputBinary = Arrays.asList(input.split(""));
        Collections.reverse(inputBinary);
        //input binary is now properly big-endian
        String reversedInput = String.join("", inputBinary);
        result = "I am " + Integer.valueOf(reversedInput, 2);

        return result;
    }

    /** returns error message for given input, or empty optional if valid */
    private static Optional<String> validate(String input) {
        if(!input.matches("[0-1]+")) {
            return Optional.of("Invalid input");
        }
        return Optional.empty();
    }


    public static String check(String input) {
        return calculate(input);
    }

}