package ab.training.defualts;

public interface Foo {


    static String staticMethod(){
        return "String";
    }

    default void print(){
        System.out.println("I'm Foo");
    }
}
