package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Stream streamEmpty = Stream.empty();
        streamEmpty.forEach(System.out::println);

//        Collection<String> strCollection = Arrays.asList("a","b","c");
//        Stream<String> streamOfCollection = strCollection.stream();
//        streamOfCollection.forEach(System.out::println);
//        Stream<String> generatedStream = Stream.generate(() -> "element").limit(10);
//        generatedStream.forEach(System.out::println);
//        Stream<Integer> streamIterated = Stream.iterate(40,n-> n+2).limit(20);
//        streamIterated.forEach(System.out::println);

        //Random streams
//        Random random = new Random();
//        DoubleStream doubleStream = random.doubles(10);
//        doubleStream.forEach(System.out::println);

        //Stream of Strings
//        IntStream streamOfChars = "abc".chars();
//        streamOfChars.forEach(System.out::println);
//        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a,b,c");
//        streamOfString.forEach(System.out::println);

        //Stream of file
        Path path = Paths.get("G:\\Development\\deneme.txt");
        Stream<String> fileStreamAsString = Files.lines(path);
        Stream<String> fileStreamAsCharset = Files.lines(path, StandardCharsets.UTF_8);

//        fileStreamAsString.forEach(System.out::println);
//        fileStreamAsCharset.forEach(System.out::println);

        //Lets find any line containing 'is'
//        Stream<String> filteredStream = fileStreamAsString.filter(element -> element.contains("is"));
//        List<String> anyElement = filteredStream.collect(Collectors.toList());
//        anyElement.forEach(System.out::println);

        //Warning Java 8 streams can't be reused.
//        Stream<String> filteredStream2 = fileStreamAsString.filter(element -> element.contains("is"));
//        List<String> allStrings = filteredStream2.collect(Collectors.toList());
//        Optional<String> firstString = filteredStream2.findFirst();
//        allStrings.forEach(System.out::println);
//        firstString.ifPresent(System.out::println);

        //This code will rise an exception

        //To fix it:
//        List<String> stringList = fileStreamAsString.filter(element -> element.contains("is"))
//                .collect(Collectors.toList());
//        stringList.forEach(System.out::println);
//        Optional<String> firstStringContainsIs = stringList.stream().findFirst();
//        firstStringContainsIs.ifPresent(System.out::println);

        //Stream pipeline

        //one modification
//        Stream<String> onceModifiedStream = Stream.of("First", "Second", "Third").skip(101231);
//        onceModifiedStream.forEach(System.out::println);
//        System.out.println(onceModifiedStream);

        //Multiple modifications with chaining
//        Stream<String> twiceModifiedStream = Stream.of("First","Second","Third")
//                .skip(1).map(element -> element.substring(1,3));
//        twiceModifiedStream.forEach(System.out::println);

//        List<String> list = Arrays.asList("First", "Second", "Third");
//        long size = list.stream().skip(1)
//                .map(element -> element.substring(0, 3)).sorted().count();
//        System.out.println(size);
//        Stream<String> stringStream = list.stream().skip(1)
//                .map(element -> element.substring(0, 3)).sorted();
//        stringStream.forEach(System.out::println);

        // Sort an object list By a certain field

        Random random  = new Random();
        List<Person> people = new ArrayList<>();
        for(int i = 0 ; i<10 ; i++){
            int randInd = random.nextInt(20000);

            Person person = new Person("Ali" , "Gümüş "+i , randInd);
            people.add(person);
        }

//        List<Person> personSorted = people.stream()
//                .sorted(Comparator.comparing(Person::getSalary))
//                .collect(Collectors.toList());
//
//        personSorted.forEach(System.out::println);

        //Lazy invocation

        //Intermediate operations are lazy. It will be invoked only if its necessary

        List<String> strList = Arrays.asList("First", "Second", "Third");
        Stream<String> willNotInvoked = strList.stream().filter(element -> {
            System.out.println("Filter() invoked");
            return element.contains("2");
        });
         // filter does ne invoked because there are no terminal operations

//        List<String> strList2 = Arrays.asList("First" , "Second" ,"Third");
//        Optional<String> willInvoke = strList2.stream().filter(element -> {
//            System.out.println("Filter() invoked");
//            return element.contains("Sec");
//        }).map(element -> {
//            System.out.println("Map() invoked");
//            return element.toUpperCase();
//        }).findFirst();
//        willInvoke.ifPresent(System.out::println);

        //pipeline executes vertically. Filter invoked twice to find second and when it finds
        // map invoked.

//        List<String> strList3 = Arrays.asList("First" , "Second" ,"Third", "Secondd");
//        List<String> willInvokeMore = strList3.stream().filter(element -> {
//            System.out.println("Filter() invoked");
//            return element.contains("Sec");
//        }).map(element -> {
//            System.out.println("Map() invoked");
//            return element.toUpperCase();
//        }).collect(Collectors.toList());
//        willInvokeMore.forEach(System.out::println);

        // Order of execution in chaining operations in the stream pipeline

//        long size = strList.stream().map(element ->{
//            System.out.println("Map() invoked");
//            return element.substring(0,3);
//        } ).skip(2).count();
//        System.out.println("Size: " + size);

        // Optimized
// long size = strList.stream().skip(2).map(element ->{
//            System.out.println("Map() invoked");
//            return element.substring(0,3);
//        } ).count();
//        System.out.println("Size: " + size);



        //stream Reduction

        // identity = the initial value
        // accumulator = a function that specifies the logic of the aggregation of elements.
        // combiner = A function that aggregates the results of accumulator. We only call combiner in
        //parallel mode.

//        OptionalInt reduced = IntStream.range(1,4).reduce(Integer::sum); // .reduce((a,b) -> a+b)
//        reduced.ifPresent(System.out::println);
//        // 1, 2 , 3
//
//        int reducedTwoParams = IntStream.range(1,4).reduce(10, Integer::sum);
//        System.out.println("Reduced with identity = 10 -> "+ reducedTwoParams);
//        // identity = 10 stream = 1,2,3
//
//        int reducedThreeParams = Arrays.asList(1,2,3).parallelStream()
//                .reduce(10 , Integer::sum, (a, b) -> {
//                    System.out.println("Combiner was called");
//                    return a+b;
//                });
//        System.out.println("Reduced with identity = 10 and a combiner -> " + reducedThreeParams);
//
//        // identity = 10 , stream = 1,2,3
//        // 10 + 1 = 11 , 10+2 = 12 , 10 + 3 = 13
//        // 11 + 12 + 13 = 36

        // Collect() method
//        List<String> fileLines = fileStreamAsString.collect(Collectors.toList());
//        fileLines.forEach(System.out::println);

        // list surnames of people
//        List<String> stringListOfSurnames = people.stream().map(Person::getSurname).collect(Collectors.toList());
//        stringListOfSurnames.forEach(System.out::println);
//        String listToString = people.stream().map(Person::getSurname).collect(Collectors.joining(","));
//        System.out.println(listToString); // delimiter , prefix, suffix
//
//        double averageDouble = people.stream().collect(Collectors.averagingInt(Person::getSalary));
//        System.out.println("Average salary is = " + averageDouble);

//        Map<Integer , List<Person>> collectorOfMapLists = people.stream()
//                .collect(Collectors.groupingBy(Person::getSalary));
//        collectorOfMapLists.forEach((key, value) -> {
//            System.out.println("Key :" + key );
//            System.out.println("Value : " + value);
//        });

        //Dividing elements of list according to some predicate
//        Map<Boolean , List<Person>> mapPartioned = people.stream()
//                .collect(Collectors.partitioningBy(element -> element.getSalary() > 10000));
//        mapPartioned.forEach((key, value) -> {
//            System.out.println("Key: "+ key);
//            System.out.println("Value: "+ value);
//        });

        // check if string contains any character
//        int start = 97; // 'a'
//        int end = 122; //'z'
//        int length = 15;
//
//        String randomStr = random.ints(start , end+1)
//                .limit(length)
//                // 1- Create new string builder 2- append new characters to string builder 3- if this stream works
//                // parallel combine them
//                .collect(StringBuilder::new , StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString();
//        System.out.println(randomStr);
//
//        char c = 'a';
//        OptionalInt opt = randomStr.chars().filter(x -> (char) x == c ).findAny();
//        if(opt.isPresent()){
//            System.out.println((char) opt.getAsInt() + " Char is found");
//        }else{
//            System.out.println(c +" Char not found");
//        }
    }
}
