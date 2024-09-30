package uk.co.ageas;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private static final String IS_DIGIT = "[0-9]+";

    public static String input(String input) {
        return result(input);
    }

    protected static String result(String input) {
        System.out.println("Input/Step1-->" + input);

        validateMessage(input, 2);

        return translateMessage(input, 2);
    }

    private static void validateMessage(String input, int stepSize) {
        if(!containsOnlyDigits(input)) {
            throw new InvalidParameterException("Only digits are allowed");
        }
        if(!containsValidCodepoints(input, stepSize)) {
            throw new InvalidParameterException("Digits must come in " + "pairs");
        }
    }

    private static boolean containsOnlyDigits(String input) {
        return input.matches(IS_DIGIT);
    }

    private static boolean containsValidCodepoints(String input, int stepSize) {
        return input.length() % stepSize == 0;
    }

    private static String translateMessage(String input, int stepSize) {
        // assessor, revert the exercise 1 refactoring commit if you prefer a single stream chain
        List<Integer> codePoints = integersFromString(input, stepSize);
        List<Integer> everySecondCodePoint = everySecondElement(codePoints);
        List<Character> messageCharacters = codePointsAsCharacters(everySecondCodePoint);
        return charsToString(messageCharacters);
    }

    /** unpacks an integer sequence from the input string 123456 -> 12,34,56 */
    private static List<Integer> integersFromString(String input, int integerLength) {
        AtomicInteger startIndex = new AtomicInteger();
        return IntStream.generate(() -> startIndex.getAndAdd(integerLength))
                .boxed()
                .limit(input.length() / integerLength)// maximum value at this point is step below input length
                .map(index -> input.subSequence(index, index + integerLength).toString())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static <T> List<T> everySecondElement(List<T> list) {
        AtomicInteger secondElementIndex = new AtomicInteger();
        return list.stream()
                .filter(it -> secondElementIndex.getAndAdd(1) % 2 == 0)
                .collect(Collectors.<T>toList());
    }

    private static List<Character> codePointsAsCharacters(List<Integer> codePoints) {
        return codePoints.stream()
                .map(codePoint -> Character.toChars(codePoint)[0])
                .collect(Collectors.toList());
    }

    private static String charsToString(List<Character> characters) {
        return characters.stream()
                .map(character -> "" + character)
                .reduce("", (acc, next) -> acc + next);
    }
}