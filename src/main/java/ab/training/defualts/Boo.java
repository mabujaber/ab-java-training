package ab.training.defualts;

public interface Boo {


    default void print(){
        System.out.println("I'm Boo");
    }
}
