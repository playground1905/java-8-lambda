package com.example;

public class TypeInferenceExample {
    public static void main(String[] args) {
//        StringLengthLambda myLambda = (String s) -> s.length(); // Valid Lambda
//        StringLengthLambda myLambda = (s) -> s.length(); // Valid Lambda
        StringLengthLambda myLambda = s -> s.length(); // Valid Lambda

//        int length = myLambda.getLength("Hello Lambda");
//        System.out.println(length);

        printLambda(s -> s.length());

    }

    public static void printLambda(StringLengthLambda stringLengthLambda) {
        System.out.println(stringLengthLambda.getLength("Hello Lambda"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
