package com.example;

public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute(){
        // this === ? this points to instance of the object which execute method is being called.
        // so this points to thisReferenceExample object.
        doProcess(10, i -> {
            System.out.println("Value of i is " + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        /*
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is " + i );
                System.out.println(this); // this yukarıdaki new Process() isntance'ına point eder.
            }

            @Override
            public String toString() {
                return "This is the anonymous inner class";
            }
        });
         */

        /*
        thisReferenceExample.doProcess(10, i -> {
            System.out.println("Value of i is " + i);
//            System.out.println(this); This will not work
        });

         */

        thisReferenceExample.execute();
    }

    @Override
    public String toString() {
        return "This is the main ThisReferenceExample class instance";
    }
}
