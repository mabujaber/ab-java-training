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

        Function<Double, Function<Double,Double>> curryingTax
                = productPrice -> taxCalc ->
                (productPrice * taxCalc) + productPrice;

        //currying
        System.out.println("Currying " + curryingTax.apply(5d).
                apply(0.16d));

        //Composition
        Function<Integer,Integer> multi = a -> a * 2;
        Function<Integer, Integer> add = b -> b + 3;
        Function<Integer, Integer> composition = multi.compose(add);
        System.out.println("Composition "+ composition.apply(2));

    }


    //Pure Function
    public Integer add(int a, int b){
        return a+b;
    }

    //Partial Function
    public Integer division(Integer a, Integer b){
        return a /b;
    }

    public Double taxAndServiceCalcuation
            (Double price, Double service, Double tax){
        return ((price * tax) + (price * service)) + price;
    }

    //Partial Applied function
    public Double jordanianTax(Double price, Double service){
        return taxAndServiceCalcuation(price,service,0.16d);
    }





}
