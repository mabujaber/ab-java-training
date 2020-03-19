# Concurrency

## What is concurrency

Concurrency is the ability to run several programs or several parts of a program in parallel. If a time consuming task can be performed asynchronously or in parallel, this improve the throughput and the interactivity of the program.

A modern computer has several CPU’s or several cores within one CPU. The ability to leverage these multi-cores can be the key for a successful high-volume application


## Concurrency in Java
A Java program runs in its own process and by default in one thread. Java supports threads as part of the Java language via the Thread code. The Java application can create new threads via this class.

Java 1.5 also provides improved support for concurrency with the in the java.util.concurrent package.


## Threads in Java, synchronization, locks

6. Threads in Java
The base means for concurrency are is the java.lang.Threads class. 
A Thread executes an object of type java.lang.Runnable.

Runnable is an interface with defines the `run()` method. This method is called by the Thread object and contains the work which should be done. Therefore the "Runnable" is the task to perform. The Thread is the worker who is doing this task.


## Concurrent API &  Executor Framework
  Thread creation is expensive and difficult to manage.
  Executors help us to decouple task submission from execution.
 
  We have 6 types of executors:
 
  - Single Thread Executor: Uses a single worker to process tasks.
  
  - Cached Thread Pool: Unbounded thread limit, good performance for long
  running tasks.
 
  - Fixed Thread Pool: Bounded thread limit, maintains the same thread pool
  size.
 
  - Scheduled Thread Pool: Bounded thread limit, used for delayed tasks.
 
  - Single-Thread Scheduled Pool: Similar to the scheduled thread pool, but
  single-threaded, with only one active task at the time.
 
  - Work-Stealing Thread Pool: Based on Fork/Join Framework, applies the
  work-stealing algorithm for balancing tasks, with available processors as a
  paralellism level.
 
  And 2 types of tasks:
 
  - `execute`: Executes without giving feedback. Fire-and-forget.
 
  - `submit`: Returns a FutureTask.
 
  ThreadPools: Used by the executors described above. ThreadPoolExecutor can be
  used to create custom Executors.
 
  `shutdown()` -> Waits for tasks to terminate and release resources.
  `shutdownNow()` -> Try to stops all executing tasks and returns a list of not
  executed tasks.

check ``UsingExecutors``

## Completable Future
 CompletableFuture is a Future that may be manually completed. 
 It combines a Future interface with the CompletionState interface, supporting dependent actions that trigger upon its completion, similarly to a callback.


  #### API Usage 
 ```
   CompletableFuture.supplyAsync(Supplier<U>supplier);
   CompletableFuture.supplyAsync(Supplier<U> supplier, Executor executor);
   CompletableFuture.runAsync(Runnable runnable);
   CompletableFuture.runAsync(Runnable runnable, Executor executor);
   
   completableFuture.thenApply(Function<? super T,? extends U> fn);
   completableFuture.thenApplyAsync(Function<? super T,? extends U> fn);
   completableFuture.thenApplyAsync(Function<? super T,? extends U> fn, Executor executor);
   
   completableFuture.exceptionally(ex -> ex.getMessage());
   completableFuture.handle((value, ex) -> {if value != null... else {}})
   
   CompletableFuture.allOf(CompletableFuture<?>... cfs)
   CompletableFuture.anyOf(CompletableFuture<?>... cfs)
   
   CompletableFuture.get() // block
   CompletableFuture.complete() // complete future's lifecycle
   CompletableFuture.obtrudeValue() // ignores complete
   CompletableFuture.join() // same as get
   CompletableFuture.getNow(valueIfAbsent) // immediately return
   CompletableFuture.completeExceptionally() // completes throwing a exception
   CompletableFuture.completeExceptionally(ex) // completes with a exception
 ```

check ``UsingCompletableFuture`` class