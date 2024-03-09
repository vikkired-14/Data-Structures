package JavaStreams;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
The flatMap() function is an extension of the map function. Apart from transferring one object into another, it also flattens it.
Example: Consider you have a list of list data and you want to combine all elements of lists into just one list. In this case, we can use flatMap()
 */
public class FlatMap {
    public static void main(String[] args){
        List<Integer> even = List.of(2,4,6);
        List<Integer> odd = List.of(3,5,7);
        List<Integer> prime = List.of(2,3,5,7,11);
//       List<Integer> numbers= Stream.of(even,odd,prime).flatMap(list->list.stream()).collect(Collectors.toList());
        List<Integer> numbers= Stream.of(even,odd,prime).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(numbers);
    }
}
