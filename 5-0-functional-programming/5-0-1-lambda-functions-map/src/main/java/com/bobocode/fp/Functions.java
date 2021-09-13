package com.bobocode.fp;

import java.util.function.Function;

public class Functions {
    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();

        Function<Integer, Integer> abs = Math::abs; //t -> Math.abs(t);
        Function<Integer, Integer> sgn = number -> (int) Math.signum(number);
        Function<Integer, Integer> increment = Math::incrementExact; //number -> number+1;
        Function<Integer, Integer> decrement = Math::decrementExact; // number -> number -1;
        Function<Integer, Integer> square = number -> number*number;

        intFunctionMap.addFunction("abs", abs);
        intFunctionMap.addFunction("sgn", sgn);
        intFunctionMap.addFunction("increment", increment);
        intFunctionMap.addFunction("decrement", decrement);
        intFunctionMap.addFunction("square", square);

        return intFunctionMap;
    }
}
