# Generics
## what is Generics?
Generics was added in Java 5 to provide a **compile time checking** and removing the risk of `ClassCastException`

## Old way to achieve generics in java
before Java 5 we used to achieve the generics by using `Object` which consider the parent of all classes in java
but that sometimes cause **runtime issues** and throw `ClassCastException`

## Where we can use the Generics
- Classes 
- Interfaces
- Methods

let's do and example

## Java Generics Type and Naming Convention
Java Generic Type Naming convention helps us understanding code easily and having a naming convention is one of the best practices of Java programming language. So generics also comes with its own naming conventions. Usually, type parameter names are single, uppercase letters to make it easily distinguishable from java variables. The most commonly used type parameter names are:

- E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
- K – Key (Used in Map)
- N – Number
- T – Type
- V – Value (Used in Map)
- S,U,V etc. – 2nd, 3rd, 4th types

## Generic subtype

if you want to extend and get the parent class generic you should explicitly specify it
 
what if I want to add more generics, thats possible as well

```
MyList<E,T> extends List<E>{
}
```  

## Generics wildcards
Question mark (?) is the wildcard in generics and represent an unknown type.

## Generics upper bound
used to narrow down the generic type to be for subclasses of concrete type

`List<? extends Number> numbers`

`extends` in generics always refer to upper bound, and the above code means all types extends class `Number` will accepted

## Generics lower bound
used to narrow down the generic type to be for superclasses of concrete type
`List<? super Integer> numbers` 
`super` in generics always refer to lower bound, and the above code will accept all the parent if `Integer` class which here `Number` and Object

    
