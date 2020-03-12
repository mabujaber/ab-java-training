package ab.training.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class AppleMain {


    public static void main(String[] args) {

        processPersonsWithFunction(
                Apple.createApples(),
                apple -> apple.getColor().equals("green"),
                apple -> apple.toString(),
                System.out::println
        );
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
