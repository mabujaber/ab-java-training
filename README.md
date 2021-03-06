## 1 Lambda 
##### 1.1.  What is the lambda?
##### 1.2.  Syntax/Scope
##### 1.3.  Functional Interface
##### 1.4.  Method Reference

## 2 Functional Programming
##### 2.1 Pure Function
##### 2.2 Partial Function
##### 2.3 Higher Order Function
##### 2.4 Partial Applied Function
##### 2.5 Currying 
##### 2.6 Composition

## 3 Optional
##### 3.1.  What is Optional and Why to use it ?
##### 3.2.  How to use it and use-cases.

## 4 Static and Default

## 5 Streams
##### 5.1.  What is Streams?
##### 5.2.  Generating Streams.
##### 5.3.  Intermediate operations.
##### 5.4.  Terminal operations.
##### 5.5.  Parallel Stream (Default implementation).
##### 5.6.  Collectors and Statistics.
##### 5.6.1.    Simple Collectors.
##### 5.6.2.    Joining.
##### 5.6.3.    Statistics.
##### 5.7.  Grouping and Partitioning.



## 1 Lambda
## 1.1. What is Lambda?
can be understood as a concise representation of an anonymous function that can be passed around: it doesn’t have a name, but it has a list of parame- ters, a body, a return type.

- *Anonymous*—We say anonymous because it doesn’t have an explicit name like a method would normally have: less to write and think about!
- *Function*—We say function because a lambda isn’t associated with a particular class like a method is. But like a method, a lambda has a list of parameters, a body, a return type, and a possible list of exceptions that can be thrown.
- *Passed around*—A lambda expression can be passed as argument to a method or stored in a variable.
- *Concise*—You don’t need to write a lot of boilerplate like you do for anonymous classes.

## 1.2. Syntax/Scope 

**Syntax**
```
paramters -> body
```

- Declaring the types of the parameters is optional.
- Using parentheses around the parameter is optional if you have only one parameter.
- Using curly braces is optional (unless you need multiple statements).
- The “return” keyword is optional if you have a single expression that returns a value.

```
() -> System.out.println(this)
(String str) -> System.out.println(str)
str -> System.out.println(str)
(String s1, String s2) -> { return s2.length() - s1.length(); }
(s1, s2) -> s2.length() - s1.length()
```

**Scope**
Accessing a non-final variable inside lambda expressions will cause the compile-time error. But it doesn’t mean that you should mark every target variable as final.

According to the “effectively final” concept, a compiler treats every variable as final, as long as it is assigned only once.

what is effectively final? 
A variable or parameter whose value is never changed after it is initialized is effectively final.

if you have variable outside the lambda you can't create another variable with the same name, This same as any scope of java

Example

```
String outsideLambdaScope = "Hello I'm outside the scope";

() -> {
    String outsideLambdaScope = "You will gte compilation error here";
}
```

One of the main purposes of lambdas is use in parallel computing – which means that they're really helpful when it comes to thread-safety.

The “effectively final” paradigm helps a lot here, but not in every case. Lambdas can't change a value of an object from enclosing scope. But in the case of mutable object variables, a state could be changed inside lambda expressions.

```
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
portNumber = 31337;
```

The above code will cause a compilation error “local variables referenced from a lambda expression must be final or effectively final.”

## 1.3. Functional Interface

A functional interface is defined as an interface with exactly one abstract method. This even applies to interfaces that were created with previous versions of Java.

Java 8 comes with several new functional interfaces in the package, `java.util.function.`

- `Function<T,R>` - takes an object of type T and returns R.
- `Supplier<T>` - just returns an object of type T.
- `Predicate<T>` - returns a boolean value based on input of type T.
- `Consumer<T>` - performs an action with given object of type T.
- `BiFunction<T,>` - like Function but with two parameters.
- `BiConsumer` - like Consumer but with two parameters.
- `UnaryOperator` - takes one parameter and return a parameter both are same type
- `BinaryOperator` - takes two parameters and return a parameter both are same type

It also comes with several corresponding interfaces for primitive types, such as:

- `IntConsumer`
- `IntFunction<R>`
- `IntPredicate`
- `IntSupplier`

## 1.3. Method Reference 

- Static methods.
- Instance methods.
- Methods on particular instances.
- Constructors (ie. Object::new) 

```
    Predicate<String> predicate = String::isEmpty;

```
This equivalent to 
```
    Predicate<String> predicate = str -> str.isEmpty();
```

Let's do some code


## 2 Functional Programming 

**Functional programming is** a programming paradigm — a style of building the structure and elements of computer programs — that treats computation as the evaluation of mathematical functions and avoids changing-state and mutable data

<table>
    <tr>
        <th>Functional Programming</th>
        <th>Object Oriented Programming</th>
    </tr>
    <tr>
        <td>Follows Declarative Programming based Model.
        </td>
        <td>Follows Imperative Programming Model.</td>
    </tr>
    <tr>
        <td>Efficient Parallel Programming.</td>
        <td>Hard to make Parallel Programming.</td>
    </tr>
    <tr>
         <td>Its functions have no-side effects.</td>
         <td>Method can produce many side effects.</td>
    </tr>
    <tr>
        <td>Flow Control is performed using function calls & function calls with recursion.</td>
        <td>Flow control process is conducted using loops and conditional statements.</td>
    </tr>
    <tr>
        <td>Execution order of statements is not very important.</td>
        <td>Execution order of statements is important.</td>
    </tr>
    <tr>
    <td>Supports both "Abstraction over Data" and "Abstraction over Behavior".</td>
    <td>Supports only "Abstraction over Data".</td>
    </tr>    
</table>

## 2.1 Pure Function

- It returns the same result if given the same arguments
- It does not cause any observable side effects

**wait what is side-effects?**
- Modifying any external variable or object property (e.g., a global variable, or a variable in the parent function scope chain)
- Logging to the console
- Writing to the screen
- Writing to a file
- Writing to the network
- Triggering any external process
- Calling any other functions with side-effects

## 2.2 Partial Function
Is a pure function but there are cases become impure 

## 2.3 Higher Order Function
The function takes one or more functions as parameters.
Or
The function returns another function as result.

## 2.4 Partial Applied Function
a function that was called with a fewer number of arguments.


## 2.5 Currying Function
transformation of a function with multiple arguments into a chain of single-argument functions


## 2.6 Composition
Is a technique to combine multiple functions into a single function which uses the combined functions internally.

## 3 Optional

Optional came to help avoid the null pointer exception

 ## 4 Static and Default
 
 Default method came to help in backward compatibility when Java introduced Streams
 
 if you notice all the collection framework has this method, this used default
 
 ```
default public Stream stream() {
 	return StreamSupport.stream(spliterator());
 }
```

Also, Default method used in multiple Functional interface

```
@FunctionalInterface
interface Predicate<T>{
    boolean test(T t);
    
    default Predicate<T> or(Predicate<? super T> other) {
         Objects.requireNonNull(other);
         return (t) -> test(t) || other.test(t);
    }

...etc
} 
```


what if we need to use this by our self

let's do it


I Java 8 also allowed to add static method in Interface

```
public static<T> Stream<T> of(T... values) {
     return Arrays.stream(values);
} 
```

## 5 Streams
## 5.1.  What is Streams?

`Stream` interface is located in the `java.util.stream` package

It represents a sequence of objects somewhat like List. However, unlike the List, it supports parallel execution.

## 5.2.  Generating Streams.

The most common way to create a `Stream` by calling these two method exist in `Collection` framework

- `stream()` Returns a sequential Stream with the collection as its source.
- `parallelStream()` Returns a possibly parallel Stream with the collection as its source.

you can generate an infinite stream by calling static method `generate` and `iterate`

```
Stream.generate(() -> new Apple());
```

This similar to infinite loop you should you use with caution

another example of generating infinite random number 

```
Stream.generate(() -> Math.random());
``` 

However, the `java.util.Random` class does this for you with the following new methods: `ints()`, `longs()`, and `doubles()`. Each of those methods is overloaded with definitions similar to the following:

- `ints()`: An infinite Stream of random integers.
- `ints(int n, int m)`: An infinite Stream of random integers from n (inclusive) to m (exclusive).
- `ints(long size)`: A Stream of given size of random integers.
- `ints(long size, int n, int m)`: A Stream of given size of random integers with given bounds.

The `iterate` method is similar to `generate` except it takes an initial value and a Function that modifies that value. For example, you can iterate over the Integers using the following code:

```
Stream.iterate(1, i -> i+1)
     .forEach(System.out::print);
```

This would print out “1234…” continuously until you stop the program.

HINTS: we can always limit the infinite stream by using `filter` and `limit`

**Ranges**

Similar to functional interface, Stream has concrete type for all the primitive types

fo example we can generate a range from 1 to 10 by doing the below code

```
IntStream.range(1, 11)
         .forEach(System.out::println);
```

Similar to `IntStream`, `LongStream` has range method

Also, There is another generator for range which include the end which is `rangeClosed`

**Streaming anything**
 ```
Stream<Integer> s = Stream.of(1, 2, 3);
Stream<Object> s2 = Arrays.stream(array);
```

What is the different between the collection and streams? 

Both the existing Java notion of collections and the new notion of streams provide interfaces to data structures representing a sequenced set of values of the element type
So, What is the difference? 

- Collection is eager constructed while stream lazy constructed.
- Collection can be traversed n number while a stream can be traversed once then will be marked as consumed unlike the collection.
- Collection using external iteration while a stream using internal.
- Collection doesn't support parallel while a stream does.

now let's talk about stream operations.

## 5.3.  Intermediate operations.
Intermediate operations such as `filter` or `sorted` return another stream as the return type. This allows the operations to be connected to form a query. What’s important is that intermediate operations don’t perform any processing until a termi- nal operation is invoked on the stream pipeline—they’re lazy.

list of intermediate operations
- `filter` take a `Predicate<T>` as an argument and return `Stream<T>`
- `map` take a `Function<T,R>` as an argument and return `Stream<R>`
- `limit` take a number and return the number of elements passed to the method as  `Stream<T>`
- `sorted` take a `Comparator<T>` as an argument and return `Stream<T>`
- `distinct` doesn't take any arguments and return `Stream<T>`
...etc

## 5.4. Terminal operations.
Terminal operations produce a result from a stream pipeline. A result is any non- stream value such as a `List`, an `Integer`, or even `void`.

list of terminal operations
- `forEach` take a `Consumer<T>` as an argument and return nothing.
- `count` doesn't have any arguments and return `double`
- `collect` take a `Collector<? super T,A,R>` and return object
...etc

Summarize the working with `Stream` 
- A data source (such as a collection) to perform a query on
- A chain of intermediate operations that form a stream pipeline
- A terminal operation that executes the stream pipeline and produces a result

The remain content of the streams will be covered by code

## 5.6.  Collectors and Statistics.
## 5.6.1.    Simple Collectors.
## 5.6.2.    Joining.
## 5.6.3.    Statistics.
## 5.7.  Grouping and Partitioning.
