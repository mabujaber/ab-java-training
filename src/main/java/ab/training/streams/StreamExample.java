package ab.training.streams;

import ab.training.lambda.Apple;
import ab.training.lambda.Person;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamExample {

    public static void main(String[] args) {
        List<Apple> apples = Apple.createApples();
        for(Apple apple: apples){
            System.out.println(apple);
        }


        IntStream intStream =
                IntStream.range(1,11);

        List<String> framerNames =
                Apple.createApples().stream()
                .filter(it ->
                        it.getColor().equals("green"))
                        .peek(it -> System.out.println("First peek "+ it))
                .map(Apple::getFarmerName)
                        .peek(it -> System.out.println("Second peek "+it))
                        .limit(1)
                        .peek(it -> System.out.println("Third Peek "+ it))
                .collect(Collectors.toList());


        //after the filter we need sometimes return one the first elements found
        Optional<Apple> firstApple = Apple.createApples().stream()
                .filter(apple -> apple.getWeight() > 10)
                .findFirst();

        //here after the filter we do return the any apple
        Optional<Apple> anyApple = Apple.createApples()
                .stream()
                .filter(apple -> apple.getColor().equals("green"))
                .findAny();

        //we need to check whether is non of the list match the condition
        boolean nonMatch = Apple.createApples()
                .stream().noneMatch(apple -> apple.getColor().equals("yellow"));
        System.out.println("yellow nonMatch "+ nonMatch);

        //if we need to check if any of the list meet the condition
        boolean anyMatch = Apple.createApples().stream()
                .anyMatch(apple -> apple.getColor().equals("red"));
        System.out.println("any match "+ anyApple);


        //check if all the stream element meet this condition or not
        boolean allMatch = Apple.createApples().stream()
                .allMatch(apple -> apple.getWeight() >= 10);
        System.out.println("All match the condition "+ allMatch);


                List<String> appleResult =
                        Apple.createApples()
                        .stream()
                        .filter(apple ->
                                apple.getColor()
                                        .equals("red")
                        && apple.getWeight() > 10)
                        .map(apple -> apple.getFarmerName())
                        .collect(toList());
                appleResult.forEach(farmerName
                        -> System.out
                        .println("exercise " +farmerName));

                List<Person> persons = Person.createRoster();
                Map<Person.Sex,Map<String,List<Person>>>
                        grouped = persons.stream()
                        .filter(person ->
                         person.getAge() > 20)
                        .collect(groupingBy(person
                        -> person.getGender(),
                        groupingBy(person ->
                        person.getEmailAddress())));

        System.out.println("Grouped   " +grouped);

//        Random random = new Random();
//        IntStream infinite = random.ints();
//        IntStream rangeRandom =
//                random.ints(10, 100);
//        rangeRandom.forEach(System.out::println);
//
        //even
        IntStream.range(1, 100)
                .filter(number -> number % 2 == 0)
                .limit(10)
                .forEach(it ->
                System.out.println("even number:  "+ it));

        IntStream.rangeClosed(2,100)
                .filter(it -> isPrime(it))
                .limit(10)
                .forEach(it -> System.out.println("prime: "+ it));

        IntStream.range(1, 100)
                .filter(number -> number % 2 != 0)
                .limit(10)
                .forEach(it -> System.out.println("odd number:  "+ it));
    }

    public List<String> findFarmer(){
        List<Apple> apples = Apple.createApples();
        List<String> farmerNames = new ArrayList<>();
        for(Apple apple: apples){
            if(apple.getColor().equals("green")){
                farmerNames.add(apple.getFarmerName());
            }
        }
        return farmerNames;
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2)
                .noneMatch(i -> number%i == 0);
    }
}
