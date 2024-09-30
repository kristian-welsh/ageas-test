package uk.co.ageas;

import java.util.concurrent.atomic.AtomicInteger;
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

        String result = "";

        // number of digits to consider at a time
        final int stepSize = 4;

        AtomicInteger nextIndex = new AtomicInteger();
        Stream<CharSequence> charPairs = IntStream.generate(() -> nextIndex.getAndAdd(stepSize))
            .filter(it -> it < input.length())
            .mapToObj(index -> input.subSequence(index, index + stepSize));
        //.collect(Collectors.joining());
        System.out.println("debug value: " + charPairs.findFirst().get());

        return result;
    }

    public static String input(String input) {
        return result(input);
    }
}