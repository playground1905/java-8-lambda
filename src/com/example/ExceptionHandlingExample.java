package com.example;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;

//        process(someNumbers, key, (a, b) -> {
//            try {
//                System.out.println(a / b);
//            } catch (ArithmeticException e) {
//                System.out.println("An Arithmetic exception happened ");
//            }
//        });

        process(someNumbers, key, wrapperLambda((a, b) -> System.out.println(a / b)));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (a, b) -> {
            try {
                consumer.accept(a, b);
            }catch (ArithmeticException e){
                System.out.println("Exception caught in wrapper lambda " +e.getMessage());
            }
        };
    }
}
