package JavaStreams;

import java.util.*;
import java.util.stream.Collectors;

/*
A Predicate is a functional interface that represents a function, which takes an Object and returns a boolean.
It is used in several Stream methods like filter(), which uses Predicate to filter unwanted elements.
 */
public class Predicate {
    public static void main(String[] args){
        java.util.function.Predicate<Integer> isEven = num -> num%2==0;

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);
        numbers = numbers.stream().filter(isEven).collect(Collectors.toList());
        System.out.println(numbers);
    }
}
