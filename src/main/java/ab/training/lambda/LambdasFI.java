package ab.training.lambda;


import java.util.function.*;

public class LambdasFI {

    public static void main(String[] args) {
        Function<Integer, Integer> function =
                input -> input + 10;
        System.out.println(function.apply(10)); //20

        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());

        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test("ssss"));

        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Print inside ");

        BiFunction<String, String, String> biFunction
                = (str1, str2) -> str1 + str2;


        UnaryOperator<String> unaryOperator =
                str -> str + " inside unary";
        BinaryOperator<String> binaryOperator
                = (str1, str2) -> str2 + str1;

    }


}
