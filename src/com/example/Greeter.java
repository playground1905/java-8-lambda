package com.example;

public class Greeter {
    public void greet() {
        System.out.println("Hello world!");
    }

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        //greeter.greet();
        Greeting helloWorldGreeting = new HelloWorldGreeting(); // We created an implemented a class
        greeter.greet(helloWorldGreeting); //Passing behaviour

        // Inline values
        String name = "foo";
        double pi = 3.14;

        // Can we assign a block of code to a variables as a value?
        // !!!! Value is not execution of the block of code variable contains block of code (function as value)

        // aBlockOfCode = () -> System.out.println("Test");
        // greetingFunction = -> System.out.println("Hello World!");

        //doubleNumberFunction = (int a) -> a * 2;
        //addFunction = (int a, int b) -> a+b;

//        safeDivideFunction = (int a, int b) -> {
//            if(b==0) return 0;
//            else return a/b;
//        };

        //stringLengthCountFunction = (String s) -> s.length();

        MyLambda myLambda = () -> System.out.println("Hello World From Lambda");
        MyAdd addFunction = (int a, int b) -> a + b;

        Greeting lambdaGreeting = () -> System.out.println("Hello From Lambda Greetings"); // We just created a function

//        lambdaGreeting.perform();
        helloWorldGreeting.perform();

        Greeting innerClasGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello World from inner class");
            }
        };

//        innerClasGreeting.perform();

        greeter.greet(lambdaGreeting);
        greeter.greet(innerClasGreeting);

    }

}

interface MyLambda {
    void foo();
}

//Functional interfacelerde tek metot olur.
interface MyAdd {
    int add(int a, int b);
}