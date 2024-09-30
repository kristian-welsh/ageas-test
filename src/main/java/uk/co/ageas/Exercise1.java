package uk.co.ageas;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Requirement :
 * 1. Input is a string: "6521714069616518831033" (provided)
 * 2. Split the string into smaller 2 character strings i.e. ["65", "21", "71", "40", "69", "61", "65", "18", "83", "10", "33"]
 * 3. Remove every second element and convert the remaining elements to integer i.e. [65, 71, 69, 65, 83, 33]
 * 4. Convert integers to ascii character and return as a single string i.e. "AGEAS!"
 * <p>
 * Ensure that input string only contains digits from 0 to 9, throw exception if this is not the case
 * <p>
 * ====================================================
 * Please use Java 8 functional style where applicable
 */

public class Exercise1 {

    protected static String result(String input) {
        System.out.println("Input/Step1-->" + input);

        validateMessage(input, 2);

        return translateMessage(input, 2);
    }

    private static void validateMessage(String input, int stepSize) {
        if(!input.matches("[0-9]+")) {
            throw new InvalidParameterException("Only digits are allowed");
        }
        if(input.length() % stepSize != 0) {
            throw new InvalidParameterException("Digits must come in " + "pairs");
        }
    }

    private static String translateMessage(String input, int stepSize) {
        AtomicInteger evenDigitIndex = new AtomicInteger();
        AtomicInteger secondCharacterIndex = new AtomicInteger();
        return IntStream.generate(() -> evenDigitIndex.getAndAdd(stepSize))
                .limit(input.length() / stepSize)// maximum value at this point is step below input length
                .mapToObj(index -> input.subSequence(index, index + stepSize).toString())
                .map(Integer::parseInt)
                .filter(it -> secondCharacterIndex.getAndAdd(1) % 2 == 0)
                .map(codePoint -> Character.toChars(codePoint)[0])
                .map(character -> "" + character)
                .reduce("", (acc, next) -> acc + next);
    }

    public static String input(String input) {
        return result(input);
    }
}