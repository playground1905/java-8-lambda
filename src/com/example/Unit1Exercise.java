package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1Exercise {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 60)
        );

        //Step 1: Sort list by last name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getLastName().compareTo(person2.getLastName());
            }
        });
        for (Person p : people) {
            System.out.println(p);
        }

        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println("Printing all persons.");
        printingAllPersons(people);

        System.out.println("--------------------");

        people.stream()
                .sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
                .forEach(a -> System.out.println(a));

        //Step 2: Create a method that prints all the elements in the list

        //Step 3: Create a method that prints all people that have last name beginning with C

        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().charAt(0) == 'C';
            }
        });

        System.out.println("Printing conditionally");

        Condition condition = p -> p.getLastName().charAt(0) == 'C';
        printConditionally(people, condition);

        System.out.println("-----------------------");

        for (Person person : people) {
            if (person.getLastName().charAt(0) == 'C') {
                System.out.println(person);
            }
        }


        System.out.println("-----------------------");

        people.stream()
                .filter(a -> a.getLastName().charAt(0) == 'C')
                .forEach(a -> System.out.println(a));

    }

    static void printConditionally(List<Person> personList, Condition c) {
        for (Person p : personList) {
            if (c.test(p)) {
                System.out.println(p);
            }
        }
    }

    static void printConditionally(List<Person> personList, Predicate predicate) {
        for (Person p : personList) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

    static void printingAllPersons(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}

//java.util.function paketi altındaki interfacelerden birini kullanıp bu interface i yaratmak zorunda değiliz.
interface Condition {
    boolean test(Person p);
}





