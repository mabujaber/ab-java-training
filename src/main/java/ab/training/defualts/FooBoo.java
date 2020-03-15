package ab.training.defualts;

public class FooBoo implements Foo,Boo {


    @Override
    public void print() {
        Foo.super.print();
    }
}
