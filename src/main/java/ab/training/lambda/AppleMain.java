package ab.training.lambda;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class AppleMain {


    public static void main(String[] args) {

        processPersonsWithFunction(
                Apple.createApples(),
                apple -> apple.getColor().equals("green"),
                apple -> apple.toString(),
                System.out::println
        );

//        List<Person> persons = Person.createRoster();
//        IntSummaryStatistics stats =persons.stream()
//                .mapToInt(Person::getAge)
//                .summaryStatistics();
////                .collect(groupingBy(Person::getGender,
////                        groupingBy(Person::getEmailAddress)));
//        System.out.println(stats);



        Optional<String> astra = findFarmer("Astra");

        astra.ifPresent(System.out::print);


    }

    public static Optional<String> findFarmer(String farmer){
        List<Apple> apples = Apple.createApples();
        for(Apple apple: apples){
            if(apple.getFarmerName().equals(farmer))
                return Optional.of(apple.getFarmerName());
        }
        return Optional.empty();

    }

    public static void processPersonsWithFunction(
            List<Apple> apples,
            Predicate<Apple> tester,
            Function<Apple, String> mapper,
            Consumer<String> block) {
        for (Apple apple : apples) {
            if (tester.test(apple)) {
                String data = mapper.apply(apple);
                block.accept(data);
            }
        }
    }
}
