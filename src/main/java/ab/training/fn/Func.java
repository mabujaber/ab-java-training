package ab.training.fn;

import java.util.function.*;

public class Func {


    public static void main(String[] args) {
        //pure function
        Function<Integer, Integer> pure = input -> input + 10;

        //Impure function
        Integer a = 20;
        Function<Integer,Integer> notPure = input -> input * a;

        //partial function
        Function<Integer,Integer> partial = input -> 12 / input;
//        System.out.println(partial.apply(0)); //will through an exception

        higherOrderFunc();

        //Curried
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
        System.out.println(convertCtoF.applyAsDouble(24));

        //Prediction composition
        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX   = (text) -> text.endsWith("x");

        Predicate<String> composed = startsWithA.and(endsWithX);
        Predicate<String> composed2 = startsWithA.or(endsWithX);
        System.out.println(composed.test("A hardworking person must relax"));

        // Function composition
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);
        System.out.println(addThenMultiply.apply(3));
        //then apply
        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);
        System.out.println(multiplyThenAdd.apply(3));

    }

    public static void higherOrderFunc(){
        Function<Integer, Function<Integer,Integer>> higherOrder =
                functionAInput ->  functionBInput -> functionBInput * functionAInput;

        Function<Integer, Integer> resultHigher = higherOrder.apply(10);
        System.out.println("Higher Order Function result: "+ resultHigher.apply(3)); //30
    }

    public Integer add(Integer a, Integer b){
        return a+b;
    }

    public Integer partially(Integer a){
        return add(3, a);
    }


    static DoubleUnaryOperator curriedConverter(double y, double z) {
        return (double x) -> x * y + z;
    }




}
