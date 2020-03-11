package ab.training.fn;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

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
