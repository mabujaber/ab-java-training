package ab.training.optional;

import ab.training.lambda.Person;

import java.time.LocalDate;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) throws Exception{

        Optional<String> s1 = Optional.of("Some Strings");
        Optional<String> s2 = Optional.ofNullable(null);
        Optional<String> s3 = Optional.empty();


        s1.ifPresent(System.out::println);
        System.out.println(s2.orElse("return anything"));

        System.out.println(s2.
                orElseGet(() -> "Did some logic and returned"));
//        s3.orElseThrow(IllegalArgumentException::new);
        Optional<String> rule =
                s1.filter(it -> it.startsWith("S"));
        rule.ifPresent(System.out::print);
        Optional<String> rule2 =
                s1.filter(it -> it.startsWith("M"));
        rule2.ifPresent(System.out::println);

        Optional<Person> personOptional = s1.map(it ->
                new Person(it, LocalDate.now(),
                        Person.Sex.MALE,
                        "ssss@ss.com"));





    }

}
