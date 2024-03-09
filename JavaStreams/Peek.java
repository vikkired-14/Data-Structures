package JavaStreams;


import java.util.*;
import java.util.stream.Collectors;

/*
The peek() method of the Stream class allows us to see through a Stream pipeline.
The peek() method returns a stream consisting of the elements of the stream after performing the provided action on each element. This is useful when we want to print values after each intermediate operation
We can peek through each step and print meaningful messages on the console. It is generally used for debugging issues related to lambda expression and Stream processing.
 */
public class Peek {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        list = list.stream().filter(n->n%2==0).peek(n->System.out.println("filtered value : "+n)).collect(Collectors.toList());
        System.out.println(list);

    }
}
